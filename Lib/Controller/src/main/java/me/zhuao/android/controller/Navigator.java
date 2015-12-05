package me.zhuao.android.controller;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class Navigator {
    private static final String TAG = Navigator.class.getName();
    private static Context context;
    private static HashMap<String, Class> uriMapping;
    private static String schema;

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

    public static void goTo(String urlWithoutSchema) {
        if (schema == null) {
            try {
                ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, DispatcherReceiver.class), PackageManager.GET_META_DATA);
                schema = receiverInfo.metaData.getString("me.zhuao.android.controller.URI_SCHEME");
            } catch (PackageManager.NameNotFoundException e) {
                Log.e(TAG, "Don't forget to set uri schema as an meta data");
                return;
            }
        }
        context.sendBroadcast(new Intent(Intent.ACTION_VIEW, Uri.parse(schema + "://" + urlWithoutSchema)));
    }

    public static void init(Context context) {
        Navigator.context = context;
        uriMapping = new HashMap<>();
    }
}
