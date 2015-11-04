package me.zhuao.android.sketch.activity;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import me.zhuao.android.sketch.R;

public class DrawerLayoutWrapToolbarDecorator extends ActivityDecorator {

    private BlankActivity activity;
    private final ActivityDrawerLayoutDecorator drawerLayoutDecorator;
    private final ActivityToolbarDecorator toolbarDecorator;

    public DrawerLayoutWrapToolbarDecorator(BlankActivity activity, ActivityDrawerLayoutDecorator drawerLayoutDecorator, ActivityToolbarDecorator toolbarDecorator) {
        this.activity = activity;
        this.drawerLayoutDecorator = drawerLayoutDecorator;
        this.toolbarDecorator = toolbarDecorator;
    }
    @Override
    public void onCreate(int containerResId) {
        drawerLayoutDecorator.onCreate(containerResId);
        toolbarDecorator.onCreate(R.id.drawer_content);
    }

    @Override
    public void setContentView(int layoutResID) {
        toolbarDecorator.setContentView(layoutResID);
    }

    @Override
    public void onPostCreate() {
        Toolbar toolbar = (Toolbar) activity.findViewById(R.id.toolbar);
        DrawerLayout drawerLayout = (DrawerLayout) activity.findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(activity, drawerLayout, toolbar, 0, 0);
        drawerToggle.syncState();
        drawerLayout.setDrawerListener(drawerToggle);

    }
}
