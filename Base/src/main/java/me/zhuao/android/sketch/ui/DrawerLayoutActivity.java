package me.zhuao.android.sketch.ui;

import android.support.design.widget.NavigationView;

import me.zhuao.android.sketch.ui.decorator.ActivityDecorator;
import me.zhuao.android.sketch.ui.decorator.DrawerLayoutDecorator;
import me.zhuao.android.sketch.ui.decorator.RootDecorator;
import me.zhuao.android.sketch.ui.decorator.ToolbarDecorator;

public abstract class DrawerLayoutActivity extends BlankActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected ActivityDecorator getActivityDecorator() {
        return new DrawerLayoutDecorator(new ToolbarDecorator(new RootDecorator(this)), getDrawerLayoutResId());
    }

    protected abstract int getDrawerLayoutResId();

}
