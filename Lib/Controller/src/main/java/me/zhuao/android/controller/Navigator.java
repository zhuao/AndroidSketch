package me.zhuao.android.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.util.HashMap;
import java.util.Map;

public class Navigator {
    private static Context context;
    private static HashMap<String, Class> uriMapping;

    public static Class<Activity> dispatchTo(String path) {
        for (Map.Entry<String, Class> entry : uriMapping.entrySet()) {
            if (entry.getKey().equals(path)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public static <T extends Activity> void map(String path, Class<T> clazz) {
        uriMapping.put(path, clazz);
    }

    public static void goTo(String urlWithSchema) {
        context.sendBroadcast(new Intent(Intent.ACTION_VIEW, Uri.parse(urlWithSchema)));
    }

    public static void init(Context context) {
        Navigator.context = context;
        uriMapping = new HashMap<>();
    }
}
