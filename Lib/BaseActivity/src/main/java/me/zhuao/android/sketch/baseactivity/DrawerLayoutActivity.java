package me.zhuao.android.sketch.baseactivity;

import android.support.design.widget.NavigationView;

import me.zhuao.android.sketch.baseactivity.decorator.ActivityDecorator;
import me.zhuao.android.sketch.baseactivity.decorator.DrawerLayoutDecorator;
import me.zhuao.android.sketch.baseactivity.decorator.RootDecorator;
import me.zhuao.android.sketch.baseactivity.decorator.ToolbarDecorator;

public abstract class DrawerLayoutActivity extends BlankActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected ActivityDecorator getActivityDecorator() {
        return new DrawerLayoutDecorator(new ToolbarDecorator(new RootDecorator(this)), getDrawerLayoutResId());
    }

    protected abstract int getDrawerLayoutResId();

}
