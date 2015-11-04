package me.zhuao.android.sketch.activity;

import android.support.design.widget.NavigationView;

import me.zhuao.android.sketch.activity.decorator.ActivityDecorator;
import me.zhuao.android.sketch.activity.decorator.DrawerLayoutDecorator;
import me.zhuao.android.sketch.activity.decorator.DrawerLayoutToolbarOutsideDecorator;
import me.zhuao.android.sketch.activity.decorator.ToolbarDecorator;

public abstract class FullDrawerLayoutActivity extends BlankActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected ActivityDecorator getActivityDecorator() {
        DrawerLayoutDecorator drawerLayoutDecorator = new DrawerLayoutDecorator(this, getDrawerLayoutResId());
        ToolbarDecorator toolbarDecorator = new ToolbarDecorator(this);
        return new DrawerLayoutToolbarOutsideDecorator(this, drawerLayoutDecorator, toolbarDecorator);
    }

    protected abstract int getDrawerLayoutResId();


}
