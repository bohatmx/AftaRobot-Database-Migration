package com.aftarobot.library.util;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.aftarobot.library.App;
import com.aftarobot.library.data.Bag;
import com.aftarobot.library.data.RouteDTO;
import com.google.gson.Gson;
import com.snappydb.DB;

import java.util.List;

/**
 * Created by aubreymalabie on 7/13/16.
 */

public class Snappy {

    public interface SnappyWriteListener {
        void onDataWritten();

        void onError(String message);
    }

    public interface SnappyDeleteListener {
        void onDataDeleted();

        void onError(String message);
    }

    public interface SnappyReadListener {
        void onDataRead(Bag response);

        void onError(String message);
    }

    static int type;
    static DB snappydb;

    static void setSnappyDB(Context ctx) {
        snappydb = App.getSnappyDB(ctx);
    }

    public static final int SAVE_ROUTES = 1, GET_ROUTES = 2;
    public static final String ROUTES_KEY = "routes";

    public static void saveRoutes(List<RouteDTO> list, SnappyWriteListener listener) {
        MTask task = new MTask(list,listener);
        task.execute();
    }
    public static void getRoutes(SnappyReadListener listener) {
        MTask task = new MTask(listener);
        task.execute();
    }

    static class MTask extends AsyncTask<Void, Void, Integer> {

        private List<RouteDTO> routes;
        private SnappyWriteListener writeListener;
        private SnappyReadListener readListener;
        private int type;
        private Bag bag;

        public MTask(List<RouteDTO> routes, SnappyWriteListener listener) {
            this.routes = routes;
            this.writeListener = listener;
            this.type = SAVE_ROUTES;

        }

        public MTask(SnappyReadListener listener) {
            this.readListener = listener;
            this.type = GET_ROUTES;
        }

        @Override
        protected Integer doInBackground(Void... params) {
            try {

                switch (type) {
                    case SAVE_ROUTES:
                        Bag b1 = new Bag();
                        b1.setRoutes(routes);
                        String json = gson.toJson(b1);
                        snappydb.put(ROUTES_KEY, json);
                        writeListener.onDataWritten();
                        break;
                    case GET_ROUTES:
                        String x = snappydb.get(ROUTES_KEY);
                        if (x != null) {
                            bag = gson.fromJson(x, Bag.class);

                        }
                        break;
                }


            } catch (Exception e) {
                Log.e(TAG, "doInBackground: ", e);
                return 9;
            }
            return 0;
        }

        @Override
        protected void onPostExecute(Integer p) {
            if (p > 0)
                if (writeListener != null) {
                    writeListener.onError("Unable to write data");
                    return;
                }
            if (readListener != null) {
                readListener.onError("unable to reade data");
                return;
            }
            switch (type) {
                case GET_ROUTES:
                    readListener.onDataRead(bag);
                    break;
                case SAVE_ROUTES:
                    writeListener.onDataWritten();
                    break;
            }
        }
    }

    public static final Gson gson = new Gson();
    public static final String TAG = Snappy.class.getSimpleName();
}
