package me.zhuao.android.sketch.baseactivity;

import me.zhuao.android.sketch.baseactivity.decorator.ActivityDecorator;
import me.zhuao.android.sketch.baseactivity.decorator.RootDecorator;
import me.zhuao.android.sketch.baseactivity.decorator.ToolbarDecorator;

public class ToolbarActivity extends BlankActivity {

    @Override
    protected ActivityDecorator getActivityDecorator() {
        return new ToolbarDecorator(new RootDecorator(this));
    }


}
