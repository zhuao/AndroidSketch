package me.zhuao.android.sketch.activity;

public abstract class ActivityDecorator {
    public abstract void onCreate(int containerResId);

    public abstract void setContentView(int layoutResID);

    public abstract void onPostCreate();

    static class ActivityEmptyDecorator extends ActivityDecorator {
        @Override
        public void onCreate(int containerResId) {

        }

        @Override
        public void setContentView(int layoutResID) {

        }

        @Override
        public void onPostCreate() {

        }
    }
}
