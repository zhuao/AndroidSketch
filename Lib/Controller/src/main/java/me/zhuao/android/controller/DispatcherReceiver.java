package me.zhuao.android.controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class DispatcherReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Uri uri = intent.getData();
        if (uri == null) {
            return;
        }

        Class view = findViewController(uri);
        if (view == null) {
            return;
        }

        Intent destinationIntent = new Intent(context, view);
        destinationIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Bundle extras = intent.getExtras();
        if (extras != null) {
            destinationIntent.putExtras(extras);
        }
        context.startActivity(destinationIntent);

    }

    private Class findViewController(Uri uri) {
        return Navigator.dispatchTo(uri.getPath());
    }
}
