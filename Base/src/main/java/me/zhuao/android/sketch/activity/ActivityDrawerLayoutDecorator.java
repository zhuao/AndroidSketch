package me.zhuao.android.sketch.activity;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.ViewStub;

import me.zhuao.android.sketch.R;

public class ActivityDrawerLayoutDecorator extends ActivityDecorator {
    private BlankActivity activity;
    private NavigationView.OnNavigationItemSelectedListener listener;
    private int drawerLayoutResId;

    public ActivityDrawerLayoutDecorator(BlankActivity activity, NavigationView.OnNavigationItemSelectedListener listener, int drawerLayoutResId) {
        this.activity = activity;
        this.listener = listener;
        this.drawerLayoutResId = drawerLayoutResId;
    }

    @Override
    public void onCreate(int containerResId) {
        ViewStub view = (ViewStub) activity.findViewById(containerResId);
        view.setLayoutResource(R.layout.activity_drawer_layout);
        view.inflate();
    }

    @Override
    public void setContentView(int layoutResID) {
        ViewStub navigationView = ((ViewStub) activity.findViewById(R.id.drawer_navigation));
        navigationView.setLayoutResource(drawerLayoutResId);
        navigationView.inflate();

        ViewStub content = ((ViewStub) activity.findViewById(R.id.drawer_content));
        content.setLayoutResource(layoutResID);
        content.inflate();
    }

    @Override
    public void onPostCreate() {

//        NavigationView navigateView = ((NavigationView) navigationView.inflate());
//        navigateView.setNavigationItemSelectedListener(listener);
//        navigateView.setVisibility(View.VISIBLE);

//        Toolbar toolbar = (Toolbar) activity.findViewById(R.id.toolbar);
//        DrawerLayout drawerLayout = (DrawerLayout) activity.findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(activity, drawerLayout, toolbar, 0, 0);
//        drawerToggle.syncState();
//        drawerLayout.setDrawerListener(drawerToggle);
    }
}
