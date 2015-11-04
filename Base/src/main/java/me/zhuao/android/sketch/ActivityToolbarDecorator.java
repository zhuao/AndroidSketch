package me.zhuao.android.sketch;

import android.support.v7.widget.Toolbar;
import android.view.View;

class ActivityToolbarDecorator extends ActivityDecorator {
    private BlankActivity activity;

    public ActivityToolbarDecorator(BlankActivity toolbarActivity) {
        this.activity = toolbarActivity;
    }

    @Override
    public void onCreate() {
        inflateToolbar();
    }

    @Override
    public void onPostCreate() {

    }

    private void inflateToolbar() {
        Toolbar toolbar = (Toolbar) activity.findViewById(R.id.toolbar);
        if (toolbar != null) {
            activity.setSupportActionBar(toolbar);
            activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onBackPressed();
                }
            });
        }
    }
}
