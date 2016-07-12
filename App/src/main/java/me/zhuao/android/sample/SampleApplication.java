package me.zhuao.android.sample;

import android.app.Application;

import me.zhuao.android.controller.Navigator;
import me.zhuao.android.sample.activity.TodoActivity;

public class SampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Navigator.init(getApplicationContext());
        Navigator.map("/todo", TodoActivity.class);
    }
}
