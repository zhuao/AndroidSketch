package me.zhuao.android.sketch.ui;

import me.zhuao.android.sketch.ui.decorator.ActivityDecorator;
import me.zhuao.android.sketch.ui.decorator.RootDecorator;
import me.zhuao.android.sketch.ui.decorator.ToolbarDecorator;

public class ToolbarActivity extends BlankActivity {

    @Override
    protected ActivityDecorator getActivityDecorator() {
        return new ToolbarDecorator(new RootDecorator(this));
    }
}
