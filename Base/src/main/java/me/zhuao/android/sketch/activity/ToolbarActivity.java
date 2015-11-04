package me.zhuao.android.sketch.activity;

public class ToolbarActivity extends BlankActivity {

    @Override
    protected ActivityDecorator getActivityDecorator() {
        return new ActivityToolbarDecorator(this);
    }
}
