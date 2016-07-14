package com.aftarobot.library.data.google;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by aubreymalabie on 6/11/16.
 */
public class Bag  implements Serializable {

        private ArrayList<Beacon> beacons;

        public ArrayList<Beacon> getBeacons() { return this.beacons; }

        public void setBeacons(ArrayList<Beacon> beacons) { this.beacons = beacons; }

        private String nextPageToken;

        public String getNextPageToken() { return this.nextPageToken; }

        public void setNextPageToken(String nextPageToken) { this.nextPageToken = nextPageToken; }

        private String totalCount;

        public String getTotalCount() { return this.totalCount; }

        public void setTotalCount(String totalCount) { this.totalCount = totalCount; }

}
