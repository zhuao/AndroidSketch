package me.zhuao.android.sketch.activity.decorator;

import me.zhuao.android.sketch.R;
import me.zhuao.android.sketch.activity.BlankActivity;

public class DrawerLayoutToolbarOutsideDecorator extends DrawerLayoutToolbarInsideDecorator {

    public DrawerLayoutToolbarOutsideDecorator(BlankActivity activity, DrawerLayoutDecorator drawerLayoutDecorator, ToolbarDecorator toolbarDecorator) {
        super(activity, drawerLayoutDecorator, toolbarDecorator);
    }

    @Override
    public void onCreate(int containerResId) {
        toolbarDecorator.onCreate(containerResId);
        drawerLayoutDecorator.onCreate(R.id.toolbar_below);
    }

    @Override
    public void setContentView(int layoutResID) {
        drawerLayoutDecorator.setContentView(layoutResID);
    }
}
