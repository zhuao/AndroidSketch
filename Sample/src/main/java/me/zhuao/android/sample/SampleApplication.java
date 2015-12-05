package me.zhuao.android.sample;

import android.app.Application;

import me.zhuao.android.controller.Navigator;
import me.zhuao.android.sample.activity.AudioRecorderActivity;
import me.zhuao.android.sample.activity.ButtonActivity;
import me.zhuao.android.sample.activity.EditTextActivity;
import me.zhuao.android.sample.activity.MomentsActivity;
import me.zhuao.android.sample.activity.SpinnerActivity;
import me.zhuao.android.sample.activity.StepIndicatorActivity;

public class SampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Navigator.init(getApplicationContext());
        Navigator.map("/spinner", SpinnerActivity.class);
        Navigator.map("/button", ButtonActivity.class);
        Navigator.map("/text", EditTextActivity.class);
        Navigator.map("/audio", AudioRecorderActivity.class);
        Navigator.map("/moments", MomentsActivity.class);
        Navigator.map("/step-indicator", StepIndicatorActivity.class);
    }
}
