package me.zhuao.android.sketch.activity;

import android.support.design.widget.NavigationView;

import me.zhuao.android.sketch.activity.decorator.ActivityDecorator;
import me.zhuao.android.sketch.activity.decorator.DrawerLayoutDecorator;
import me.zhuao.android.sketch.activity.decorator.ToolbarDecorator;
import me.zhuao.android.sketch.activity.decorator.DrawerLayoutToolbarInsideDecorator;

public abstract class DrawerLayoutActivity extends BlankActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected ActivityDecorator getActivityDecorator() {
        DrawerLayoutDecorator drawerLayoutDecorator = new DrawerLayoutDecorator(this, getDrawerLayoutResId());
        return new DrawerLayoutToolbarInsideDecorator(this, drawerLayoutDecorator, new ToolbarDecorator(this));
    }

    protected abstract int getDrawerLayoutResId();

}
