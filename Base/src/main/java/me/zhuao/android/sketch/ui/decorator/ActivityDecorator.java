package me.zhuao.android.sketch.ui.decorator;

import me.zhuao.android.sketch.ui.BlankActivity;

public interface ActivityDecorator {
    void onCreate(int containerResId);

    void setContentView(int layoutResID);

    void onPostCreate();

    int getContentElementId();

    BlankActivity getActivity();
}
