package com.mc.onmusic_relase.helper;

import com.mc.onmusic_relase.AppSettings;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class BillingUtils {
    private static final String HEX = "0123456789ABCDEF";
    private static final byte[] keyValue = {99, 111, 100, 105, 110, 103, 97, 102, 102, 97, 105, 114, 115, 99, 111, 109};

    public static void publishPremium() {
        AppSettings.showAds = false;
        AppSettings.contentActivated = true;
        AppSettings.setDownloads = false;
        AppSettings.enableEqualizer = true;
    }

    public static String encrypt(String str) throws Exception {
        return toHex(encrypt(getRawKey(), str.getBytes()));
    }

    public static String decrypt(String str) throws Exception {
        return new String(decrypt(toByte(str)));
    }

    private static byte[] getRawKey() throws Exception {
        return new SecretKeySpec(keyValue, "AES").getEncoded();
    }

    private static byte[] encrypt(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES");
        instance.init(1, secretKeySpec);
        return instance.doFinal(bArr2);
    }

    private static byte[] decrypt(byte[] bArr) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyValue, "AES");
        Cipher instance = Cipher.getInstance("AES");
        instance.init(2, secretKeySpec);
        return instance.doFinal(bArr);
    }

    public static byte[] toByte(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int r2 = 0; r2 < length; r2++) {
            int r3 = r2 * 2;
            bArr[r2] = Integer.valueOf(str.substring(r3, r3 + 2), 16).byteValue();
        }
        return bArr;
    }

    public static String toHex(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte appendHex : bArr) {
            appendHex(stringBuffer, appendHex);
        }
        return stringBuffer.toString();
    }

    private static void appendHex(StringBuffer stringBuffer, byte b) {
        stringBuffer.append(HEX.charAt((b >> 4) & 15));
        stringBuffer.append(HEX.charAt(b & 15));
    }
}
