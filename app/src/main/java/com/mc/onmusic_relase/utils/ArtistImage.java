package com.mc.onmusic_relase.utils;

import android.util.Log;

import com.mc.onmusic_relase.AppInterface;

import java.net.URLEncoder;

public class ArtistImage implements AppInterface {
    String query;
    private static final String TAG = "ArtistImage";
    String imageLocation = null;

    public String getImageUri() {
        return imageLocation;
    }

    public ArtistImage(String query) {
        this.query = query;

        YTSearch ytSearch = new YTSearch(query+" channel");
        if (ytSearch.channelImages.size()>0) {
            imageLocation = ytSearch.channelImages.get(0);
            Log.e(TAG, "ArtistImage: ImageLocation: "+imageLocation );
        }else Log.e(TAG, "ArtistImage: Failed: "+query);
       /* int i=0;
        int apiLength = API_KEYS.length;
        String json;
        do {
            json = jsonResponse(i);
            i++;
        }while (json.contains("\"error\":") && i<apiLength);

        if (!json.contains("\"error\":")) {
            try {
                JSONObject jsonObject = new JSONObject(json);
                JSONArray array = jsonObject.getJSONArray("items");
                imageLocation = array.getJSONObject(0).getJSONObject("snippet")
                        .getJSONObject("thumbnails").getJSONObject("medium").getString("url");
            }catch (Exception e) {}
        }*/
    }

    String jsonResponse(int apinumber) {
        HttpHandler httpHandler = new HttpHandler();
        String link = "https://www.googleapis.com/youtube/v3/search?part=snippet&q="
                + URLEncoder.encode(query) +"&type=channel&key="+API_KEYS[apinumber];
        return httpHandler.makeServiceCall(link);
    }
}
