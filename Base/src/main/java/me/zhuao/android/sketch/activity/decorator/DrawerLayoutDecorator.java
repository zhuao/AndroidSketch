package me.zhuao.android.sketch.activity.decorator;

import android.view.ViewStub;

import me.zhuao.android.sketch.R;
import me.zhuao.android.sketch.activity.BlankActivity;

public class DrawerLayoutDecorator implements ActivityDecorator {
    private BlankActivity activity;
    private int drawerLayoutResId;

    public DrawerLayoutDecorator(BlankActivity activity, int drawerLayoutResId) {
        this.activity = activity;
        this.drawerLayoutResId = drawerLayoutResId;
    }

    @Override
    public void onCreate(int containerResId) {
        ViewStub view = (ViewStub) activity.findViewById(containerResId);
        view.setLayoutResource(R.layout.activity_drawer_layout);
        view.inflate();

        ViewStub navigationView = ((ViewStub) activity.findViewById(R.id.drawer_navigation));
        navigationView.setLayoutResource(drawerLayoutResId);
        navigationView.inflate();
    }

    @Override
    public void setContentView(int layoutResID) {
        ViewStub content = ((ViewStub) activity.findViewById(R.id.drawer_content));
        content.setLayoutResource(layoutResID);
        content.inflate();
    }

    @Override
    public void onPostCreate() { }
}
