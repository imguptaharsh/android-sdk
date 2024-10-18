// MySDK.java

package com.example.myandroidsdk;

import android.os.Build;
import android.util.Log;

public class MySDK {
    private static final String TAG = "MySDK";

    public static void printAndroidVersion() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String androidVersion = Build.VERSION.RELEASE;
                Log.d(TAG, "Android version: " + androidVersion);
            }
        });
        thread.start();
    }

    public static String getAndroidVersion() {
        return Build.VERSION.RELEASE;
    }
}
