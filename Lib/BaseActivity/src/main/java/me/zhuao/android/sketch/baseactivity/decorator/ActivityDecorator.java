package me.zhuao.android.sketch.baseactivity.decorator;

import me.zhuao.android.sketch.baseactivity.BlankActivity;

public interface ActivityDecorator {
    void onCreate(int containerResId);

    void setContentView(int layoutResID);

    void onPostCreate();

    int getContentElementId();

    BlankActivity getActivity();
}
