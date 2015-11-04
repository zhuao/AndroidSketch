package me.zhuao.android.sketch.activity.decorator;

public interface ActivityDecorator {
    void onCreate(int containerResId);

    void setContentView(int layoutResID);

    void onPostCreate();

}
