package me.zhuao.android.sketch.activity;

import android.support.design.widget.NavigationView;

public abstract class DrawerLayoutActivity extends BlankActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected ActivityDecorator getActivityDecorator() {
        ActivityDrawerLayoutDecorator drawerLayoutDecorator = new ActivityDrawerLayoutDecorator(this, getDrawerLayoutResId());
        return new DrawerLayoutWrapToolbarDecorator(this, drawerLayoutDecorator, new ActivityToolbarDecorator(this));
    }

    protected abstract int getDrawerLayoutResId();

}
