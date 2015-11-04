package me.zhuao.android.sketch;

abstract class ActivityDecorator {
    public abstract void onCreate();

    public abstract void onPostCreate();

    static class ActivityEmptyDecorator extends ActivityDecorator {
        @Override
        public void onCreate() {

        }

        @Override
        public void onPostCreate() {

        }
    }
}
