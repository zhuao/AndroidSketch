package me.zhuao.android.sketch.activity;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewStub;

import me.zhuao.android.sketch.R;

class ActivityDrawerLayoutDecorator extends ActivityDecorator {
    private DrawerLayoutActivity drawerLayoutActivity;
    private BlankActivity activity;
    private NavigationView.OnNavigationItemSelectedListener listener;
    private int drawerLayoutResId;

    public ActivityDrawerLayoutDecorator(DrawerLayoutActivity drawerLayoutActivity, BlankActivity activity, NavigationView.OnNavigationItemSelectedListener listener, int drawerLayoutResId) {
        this.drawerLayoutActivity = drawerLayoutActivity;
        this.activity = activity;
        this.listener = listener;
        this.drawerLayoutResId = drawerLayoutResId;
    }

    @Override
    public void onCreate(int containerResId) {
        ViewStub navigationView = ((ViewStub) drawerLayoutActivity.findViewById(R.id.navigation));
        navigationView.setLayoutResource(drawerLayoutResId);
        NavigationView navigateView = ((NavigationView) navigationView.inflate());
        navigateView.setNavigationItemSelectedListener(listener);
        navigateView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setContentView(int layoutResID) {

    }

    @Override
    public void onPostCreate() {
        Toolbar toolbar = (Toolbar) drawerLayoutActivity.findViewById(R.id.toolbar);
        DrawerLayout drawerLayout = (DrawerLayout) drawerLayoutActivity.findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(activity, drawerLayout, toolbar, 0, 0);
        drawerToggle.syncState();
        drawerLayout.setDrawerListener(drawerToggle);
    }
}
