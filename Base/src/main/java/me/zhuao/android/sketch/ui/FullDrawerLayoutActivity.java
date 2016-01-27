package me.zhuao.android.sketch.ui;

import android.support.design.widget.NavigationView;

import me.zhuao.android.sketch.ui.decorator.ActivityDecorator;
import me.zhuao.android.sketch.ui.decorator.DrawerLayoutDecorator;
import me.zhuao.android.sketch.ui.decorator.RootDecorator;
import me.zhuao.android.sketch.ui.decorator.ToolbarDecorator;

public abstract class FullDrawerLayoutActivity extends BlankActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected ActivityDecorator getActivityDecorator() {
        return new ToolbarDecorator(new DrawerLayoutDecorator(new RootDecorator(this), getDrawerLayoutResId()));
    }

    protected abstract int getDrawerLayoutResId();


}
