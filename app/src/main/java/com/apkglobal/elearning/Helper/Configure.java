package com.apkglobal.elearning.Helper;

/**
 * Created by Mayank on 9/1/2017.
 */

public class Configure {
    public static String apikey="AIzaSyDvrOEtY2k0d5L5HPQ_Vq6Elr0e-j4Y_0Q\n";
    public static String[] videokey;
    public static String fetch_url;

    public static String getFetch_url() {
        return fetch_url;
    }

    public static void setFetch_url(String fetch_url) {
        Configure.fetch_url = fetch_url;
    }

    public static String[] getVideokey() {
        return videokey;
    }

    public static void setVideokey(String[] videokey) {
        Configure.videokey = videokey;
    }
}
