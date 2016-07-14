package com.aftarobot.datamigrator.util;

import android.os.AsyncTask;
import android.util.Log;

import com.aftarobot.datamigrator.olddata.ResponseDTO;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.util.concurrent.TimeUnit;

/**
 * Created by aubreymalabie on 6/3/16.
 */
public class OldUtil {

    public interface OldListener {
        void onResponse(ResponseDTO response);
        void onError(String message);
    }

    static OldListener listener;
    static final String PREFIX = "http://192.168.1.233:40405/ar/";
    static String url;

    public static void getOldData(OldListener oldListener) {

        listener = oldListener;
        url = PREFIX + "migrate";
        new Mtask().execute();
    }
    public static void getOldLandmarks(OldListener oldListener) {

        listener = oldListener;
        url = PREFIX + "landmarks";
        new Mtask().execute();
    }

    static class Mtask extends AsyncTask<Void,Void, ResponseDTO> {

        @Override
        protected ResponseDTO doInBackground(Void... params) {
            Log.d("OldUtil", "starting data grab ........");
            ResponseDTO resp = new ResponseDTO();
            OkHttpClient client = new OkHttpClient();
            client.setConnectTimeout(60, TimeUnit.SECONDS);
            client.setReadTimeout(60,TimeUnit.SECONDS);
            Request.Builder builder = new Request.Builder();
            builder.url(url);
            try {
                Response oresp = client.newCall(builder.build()).execute();
                if (oresp.isSuccessful()) {
                    String json = oresp.body().string();
                    Gson g = new Gson();
                    resp = g.fromJson(json, ResponseDTO.class);
                    Log.e("OldUtil", "doInBackground: Yeahh! data for migration is here, length: " + json.length() );
                } else {
                    resp.setStatusCode(8);
                    resp.setMessage("Network call is not OK: url: " + url + "\n"
                    + oresp.message());
                    Log.e("OldUtil", "doInBackground: " + resp.getMessage() );
                }
            } catch (Exception e) {
                resp.setStatusCode(8);
                resp.setMessage("ERROR: " + e.getMessage());
                e.printStackTrace();
            }
            return resp;
        }
        @Override
        protected void onPostExecute(ResponseDTO resp) {

            if (resp.getStatusCode() == 0) {
                listener.onResponse(resp);
            } else {
                listener.onError(resp.getMessage());
            }
        }
    }
}
