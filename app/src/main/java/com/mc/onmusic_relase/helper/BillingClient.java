package com.mc.onmusic_relase.helper;


import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.mc.onmusic_relase.utils.YTutils;
import com.razorpay.Checkout;
import com.razorpay.PaymentData;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONException;
import org.json.JSONObject;

public class BillingClient {
    /* access modifiers changed from: private */
    public static String Id = null;
    private static final String TAG = "BillingClient";
    /* access modifiers changed from: private */
    public static Activity activity = null;
    /* access modifiers changed from: private */
    public static OrderRequest orderRequest = null;
    /* access modifiers changed from: private */
    public static boolean processComplete = false;
    /* access modifiers changed from: private */
    public static RazorpayClient razorpay = null;
    private static DatabaseReference reference = null;
    /* access modifiers changed from: private */
    public static boolean verified = false;
    private String keyId;
    private String keySecret;

    public BillingClient(Activity activity2) {
        activity = activity2;
    }

    public static class OrderRequest {
        int amount;
        String currency;
        String description;
        String email;
        String orderName;

        public OrderRequest(String str, int r2, String str2, String str3, String str4) {
            this.orderName = str;
            this.currency = str2;
            this.description = str3;
            this.email = str4;
            this.amount = r2;
        }

        public String getOrderName() {
            return this.orderName;
        }

        public String getCurrency() {
            return this.currency;
        }

        public String getDescription() {
            return this.description;
        }

        public String getUID() {
            return this.email;
        }

        public int getAmount() {
            return this.amount;
        }
    }

    public void setCurrentOrder(OrderRequest orderRequest2) {
        orderRequest = orderRequest2;
    }

    public void setDatabase(DatabaseReference databaseReference) {
        reference = databaseReference;
    }

    public BillingClient getInstance(String str, String str2) {
        this.keyId = str;
        this.keySecret = str2;
        try {
            razorpay = new RazorpayClient(str, str2);
            return this;
        } catch (RazorpayException unused) {
            return null;
        }
    }

    public int processSuccess(String str, PaymentData paymentData) {
        try {
            if (!razorpay.Payments.fetch(str).toJson().getString("status").equals("authorized")) {
                return 1;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("amount", orderRequest.getAmount());
            jSONObject.put(FirebaseAnalytics.Param.CURRENCY, (Object) orderRequest.getCurrency());
            if (!razorpay.Payments.capture(str, jSONObject).toJson().getString("status").equals("captured")) {
                return 3;
            }
            try {
                reference.child(orderRequest.getUID()).setValue(str);
                YTutils.writeContent(activity, YTutils.getFile("YTPlayer/payment_detail.json").getPath(), paymentData.getData().toString());
                YTutils.writeContent(activity, YTutils.getFile("YTPlayer_payment_detail.json").getPath(), paymentData.getData().toString());
                return 0;
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return 2;
        }
    }

    public void verify(final VerificationListener verificationListener) {
        verificationListener.execute(new Void[0]);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    if (dataSnapshot.child(BillingClient.orderRequest.getUID()).exists()) {
                        boolean unused = BillingClient.verified = true;
                        String unused2 = BillingClient.Id = (String) dataSnapshot.child(BillingClient.orderRequest.getUID()).getValue();
                    }
                } catch (Exception unused3) {
                    verificationListener.onVerficationFailed(BillingClient.razorpay, 2);
                }
                boolean unused4 = BillingClient.processComplete = true;
                Log.e(BillingClient.TAG, "onDataChange: Process Complete");
            }

            public void onCancelled(@NonNull DatabaseError databaseError) {
                verificationListener.onVerficationFailed(BillingClient.razorpay, 2);
                boolean unused = BillingClient.processComplete = true;
            }
        });
    }

    public static abstract class VerificationListener extends AsyncTask<Void, Void, Void> {
        ProgressDialog dialog = new ProgressDialog(BillingClient.activity);

        public abstract void onVerficationFailed(RazorpayClient razorpayClient, int r2);

        public abstract void onVerficationSuccess(RazorpayClient razorpayClient, String str);

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.dialog.setMessage("Processing...");
            this.dialog.setCancelable(false);
            this.dialog.show();
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... voidArr) {
            do {
            } while (!BillingClient.processComplete);
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void voidR) {
            this.dialog.dismiss();
            if (BillingClient.verified) {
                onVerficationSuccess(BillingClient.razorpay, BillingClient.Id);
            } else {
                onVerficationFailed(BillingClient.razorpay, 1);
            }
            super.onPostExecute(voidR);
        }
    }

    public void quickCheckout() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("amount", orderRequest.getAmount());
            jSONObject.put(FirebaseAnalytics.Param.CURRENCY, (Object) orderRequest.getCurrency());
            jSONObject.put("receipt", (Object) orderRequest.getOrderName());
            jSONObject.put("payment_capture", false);
            JSONObject json = razorpay.Orders.create(jSONObject).toJson();
            if (json.getString("status").equals("created")) {
                String string = json.getString("id");
                Checkout checkout = new Checkout();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(AppMeasurementSdk.ConditionalUserProperty.NAME, (Object) "KP'S TV Inc.");
                jSONObject2.put("description", (Object) orderRequest.getDescription());
                jSONObject2.put("order_id", (Object) string);
                jSONObject2.put(FirebaseAnalytics.Param.CURRENCY, (Object) "INR");
                checkout.open(activity, jSONObject2);
                return;
            }
            Log.e(TAG, "Failed to create order");
        } catch (RazorpayException e) {
            System.out.println(e.getMessage());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
