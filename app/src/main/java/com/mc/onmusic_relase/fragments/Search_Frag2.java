package com.mc.onmusic_relase.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.mc.onmusic_relase.MainActivity;
import com.mc.onmusic_relase.R;
import com.mc.onmusic_relase.fragments.basedOnApi.PopularFragment2;
import com.mc.onmusic_relase.utils.YTutils;


public class Search_Frag2 extends Fragment implements View.OnClickListener {
    /////////////////////

    FragmentActivity activity;
    CardView searchCard,soulCard,focusCard,creativeCard,studyCard,readingCard,relaxCard,coffeCard,softPopCard,camlCard,deepCard,bookCard,chilloutCard,sweetsoulCard,s80sCard,electroCard,girlsNightCard,teenCard,edmCard,indieCard,regattonCard;
    private Fragment Search_Frag2;
    View v;



    //////////////////////
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_search2, container, false);

        activity = getActivity();
        searchCard = (CardView) v.findViewById(R.id.cardView_search);
        soulCard = (CardView) v.findViewById(R.id.soul_card);
        focusCard = (CardView) v.findViewById(R.id.focus_card);
        creativeCard = (CardView) v.findViewById(R.id.creative_card);
        studyCard = (CardView) v.findViewById(R.id.study_card);
        readingCard = (CardView) v.findViewById(R.id.reading_card);
        relaxCard = (CardView) v.findViewById(R.id.relax_card);
        coffeCard = (CardView) v.findViewById(R.id.coffe_card);
        softPopCard = (CardView) v.findViewById(R.id.softpop_card);
        camlCard = (CardView) v.findViewById(R.id.caml_card);
        deepCard = (CardView) v.findViewById(R.id.deephouse_card);
        bookCard = (CardView) v.findViewById(R.id.booklover_card);
        chilloutCard = (CardView) v.findViewById(R.id.chillout_card);
        sweetsoulCard = (CardView) v.findViewById(R.id.sweetsoul_card);
        s80sCard = (CardView) v.findViewById(R.id.s80s_card);
        electroCard = (CardView) v.findViewById(R.id.electro_card);
        girlsNightCard = (CardView) v.findViewById(R.id.girls_night_card);
        teenCard = (CardView) v.findViewById(R.id.teen_party_card);
        edmCard = (CardView) v.findViewById(R.id.edm_card);
        indieCard = (CardView) v.findViewById(R.id.indie_card);
        regattonCard = (CardView) v.findViewById(R.id.regatton_card);

        soulCard.setOnClickListener(view -> {
            if (!YTutils.isInternetAvailable()) {
                Toast.makeText(activity, "No active connection is found!", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                MainActivity.popularFrag2.onDestroy();
            }catch (Exception e){}
            MainActivity.popularFrag2 = new PopularFragment2();
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            ft.replace(R.id.fragment_container, MainActivity.popularFrag2,"soul");
            ft.commit();
        });

        focusCard.setOnClickListener(view -> {
            if (!YTutils.isInternetAvailable()) {
                Toast.makeText(activity, "No active connection is found!", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                MainActivity.popularFrag2.onDestroy();
            }catch (Exception e){}
            MainActivity.popularFrag2 = new PopularFragment2();
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            ft.replace(R.id.fragment_container, MainActivity.popularFrag2,"focus");
            ft.commit();
        });

        creativeCard.setOnClickListener(view -> {
            if (!YTutils.isInternetAvailable()) {
                Toast.makeText(activity, "No active connection is found!", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                MainActivity.popularFrag2.onDestroy();
            }catch (Exception e){}
            MainActivity.popularFrag2 = new PopularFragment2();
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            ft.replace(R.id.fragment_container, MainActivity.popularFrag2,"creative");
            ft.commit();
        });

        studyCard.setOnClickListener(view -> {
            if (!YTutils.isInternetAvailable()) {
                Toast.makeText(activity, "No active connection is found!", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                MainActivity.popularFrag2.onDestroy();
            }catch (Exception e){}
            MainActivity.popularFrag2 = new PopularFragment2();
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            ft.replace(R.id.fragment_container, MainActivity.popularFrag2,"study");
            ft.commit();
        });

        readingCard.setOnClickListener(view -> {
            if (!YTutils.isInternetAvailable()) {
                Toast.makeText(activity, "No active connection is found!", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                MainActivity.popularFrag2.onDestroy();
            }catch (Exception e){}
            MainActivity.popularFrag2 = new PopularFragment2();
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            ft.replace(R.id.fragment_container, MainActivity.popularFrag2,"reading");
            ft.commit();
        });

        relaxCard.setOnClickListener(view -> {
            if (!YTutils.isInternetAvailable()) {
                Toast.makeText(activity, "No active connection is found!", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                MainActivity.popularFrag2.onDestroy();
            }catch (Exception e){}
            MainActivity.popularFrag2 = new PopularFragment2();
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            ft.replace(R.id.fragment_container, MainActivity.popularFrag2,"relax");
            ft.commit();
        });

        coffeCard.setOnClickListener(view -> {
            if (!YTutils.isInternetAvailable()) {
                Toast.makeText(activity, "No active connection is found!", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                MainActivity.popularFrag2.onDestroy();
            }catch (Exception e){}
            MainActivity.popularFrag2 = new PopularFragment2();
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            ft.replace(R.id.fragment_container, MainActivity.popularFrag2,"coffe");
            ft.commit();
        });

        softPopCard.setOnClickListener(view -> {
            if (!YTutils.isInternetAvailable()) {
                Toast.makeText(activity, "No active connection is found!", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                MainActivity.popularFrag2.onDestroy();
            }catch (Exception e){}
            MainActivity.popularFrag2 = new PopularFragment2();
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            ft.replace(R.id.fragment_container, MainActivity.popularFrag2,"spop");
            ft.commit();
        });

        camlCard.setOnClickListener(view -> {
            if (!YTutils.isInternetAvailable()) {
                Toast.makeText(activity, "No active connection is found!", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                MainActivity.popularFrag2.onDestroy();
            }catch (Exception e){}
            MainActivity.popularFrag2 = new PopularFragment2();
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            ft.replace(R.id.fragment_container, MainActivity.popularFrag2,"caml");
            ft.commit();
        });

        deepCard.setOnClickListener(view -> {
            if (!YTutils.isInternetAvailable()) {
                Toast.makeText(activity, "No active connection is found!", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                MainActivity.popularFrag2.onDestroy();
            }catch (Exception e){}
            MainActivity.popularFrag2 = new PopularFragment2();
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            ft.replace(R.id.fragment_container, MainActivity.popularFrag2,"deeph");
            ft.commit();
        });

        bookCard.setOnClickListener(view -> {
            if (!YTutils.isInternetAvailable()) {
                Toast.makeText(activity, "No active connection is found!", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                MainActivity.popularFrag2.onDestroy();
            }catch (Exception e){}
            MainActivity.popularFrag2 = new PopularFragment2();
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            ft.replace(R.id.fragment_container, MainActivity.popularFrag2,"book");
            ft.commit();
        });
        chilloutCard.setOnClickListener(view -> {
            if (!YTutils.isInternetAvailable()) {
                Toast.makeText(activity, "No active connection is found!", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                MainActivity.popularFrag2.onDestroy();
            }catch (Exception e){}
            MainActivity.popularFrag2 = new PopularFragment2();
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            ft.replace(R.id.fragment_container, MainActivity.popularFrag2,"chillout");
            ft.commit();
        });

        sweetsoulCard.setOnClickListener(view -> {
            if (!YTutils.isInternetAvailable()) {
                Toast.makeText(activity, "No active connection is found!", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                MainActivity.popularFrag2.onDestroy();
            }catch (Exception e){}
            MainActivity.popularFrag2 = new PopularFragment2();
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            ft.replace(R.id.fragment_container, MainActivity.popularFrag2,"sweetsl");
            ft.commit();
        });

        s80sCard.setOnClickListener(view -> {
            if (!YTutils.isInternetAvailable()) {
                Toast.makeText(activity, "No active connection is found!", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                MainActivity.popularFrag2.onDestroy();
            }catch (Exception e){}
            MainActivity.popularFrag2 = new PopularFragment2();
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            ft.replace(R.id.fragment_container, MainActivity.popularFrag2,"s80s");
            ft.commit();
        });

        electroCard.setOnClickListener(view -> {
            if (!YTutils.isInternetAvailable()) {
                Toast.makeText(activity, "No active connection is found!", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                MainActivity.popularFrag2.onDestroy();
            }catch (Exception e){}
            MainActivity.popularFrag2 = new PopularFragment2();
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            ft.replace(R.id.fragment_container, MainActivity.popularFrag2,"electro");
            ft.commit();
        });

        girlsNightCard.setOnClickListener(view -> {
            if (!YTutils.isInternetAvailable()) {
                Toast.makeText(activity, "No active connection is found!", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                MainActivity.popularFrag2.onDestroy();
            }catch (Exception e){}
            MainActivity.popularFrag2 = new PopularFragment2();
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            ft.replace(R.id.fragment_container, MainActivity.popularFrag2,"girl_night");
            ft.commit();
        });

        teenCard.setOnClickListener(view -> {
            if (!YTutils.isInternetAvailable()) {
                Toast.makeText(activity, "No active connection is found!", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                MainActivity.popularFrag2.onDestroy();
            }catch (Exception e){}
            MainActivity.popularFrag2 = new PopularFragment2();
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            ft.replace(R.id.fragment_container, MainActivity.popularFrag2,"teen_party");
            ft.commit();
        });

        edmCard.setOnClickListener(view -> {
            if (!YTutils.isInternetAvailable()) {
                Toast.makeText(activity, "No active connection is found!", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                MainActivity.popularFrag2.onDestroy();
            }catch (Exception e){}
            MainActivity.popularFrag2 = new PopularFragment2();
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            ft.replace(R.id.fragment_container, MainActivity.popularFrag2,"edm");
            ft.commit();
        });

        indieCard.setOnClickListener(view -> {
            if (!YTutils.isInternetAvailable()) {
                Toast.makeText(activity, "No active connection is found!", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                MainActivity.popularFrag2.onDestroy();
            }catch (Exception e){}
            MainActivity.popularFrag2 = new PopularFragment2();
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            ft.replace(R.id.fragment_container, MainActivity.popularFrag2,"indie");
            ft.commit();
        });

        regattonCard.setOnClickListener(view -> {
            if (!YTutils.isInternetAvailable()) {
                Toast.makeText(activity, "No active connection is found!", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                MainActivity.popularFrag2.onDestroy();
            }catch (Exception e){}
            MainActivity.popularFrag2 = new PopularFragment2();
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            ft.replace(R.id.fragment_container, MainActivity.popularFrag2,"regatton");
            ft.commit();
        });

















        searchCard.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (!YTutils.isInternetAvailable()) {
                    Toast.makeText(activity, getString(R.string.error), Toast.LENGTH_SHORT).show();
                    return;
                }


                FrameLayout layout = activity.findViewById(R.id.fragment_container);
                if (layout!=null) {
                    loadSearchViewFrag();
                }


            }
        });


        return v;
    }

    public void loadSearchViewFrag(){
        Search_Frag2 = new SFragment();
        Bundle args = new Bundle();
        Search_Frag2.setArguments(args);
        FragmentManager manager = activity.getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(R.anim.fade_in,
                R.anim.fade_out);
        ft.replace(R.id.fragment_container, Search_Frag2);
        ft.commit();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100) {
            loadSearchViewFrag();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
    }


    @Override
    public void onClick(View view) {

    }
}
