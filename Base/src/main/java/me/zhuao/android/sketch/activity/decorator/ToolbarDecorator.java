package me.zhuao.android.sketch.activity.decorator;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewStub;

import me.zhuao.android.sketch.R;
import me.zhuao.android.sketch.activity.BlankActivity;

public class ToolbarDecorator implements ActivityDecorator {
    private BlankActivity activity;

    public ToolbarDecorator(BlankActivity toolbarActivity) {
        this.activity = toolbarActivity;
    }

    @Override
    public void onCreate(int containerResId) {
        ViewStub container = (ViewStub) activity.findViewById(containerResId);
        container.setLayoutResource(R.layout.decorator_toolbar);
        container.inflate();

    }

    @Override
    public void setContentView(int contentResId) {
        ViewStub content = (ViewStub) activity.findViewById(R.id.toolbar_below);
        content.setLayoutResource(contentResId);
        content.inflate();
    }

    @Override
    public void onPostCreate() {
        inflateToolbar();
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
