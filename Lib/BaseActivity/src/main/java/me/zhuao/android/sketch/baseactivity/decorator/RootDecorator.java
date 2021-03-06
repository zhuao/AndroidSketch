package me.zhuao.android.sketch.baseactivity.decorator;

import android.view.ViewStub;

import me.zhuao.android.baseactivity.R;
import me.zhuao.android.sketch.baseactivity.BlankActivity;

public class RootDecorator implements ActivityDecorator {
    private BlankActivity activity;

    public RootDecorator(BlankActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onCreate(int containerResId) {
    }

    @Override
    public void setContentView(int contentResId) {
        ViewStub content = (ViewStub) getActivity().findViewById(getContentElementId());
        content.setLayoutResource(contentResId);
        content.inflate();
    }

    @Override
    public void onPostCreate() {

    }

    @Override
    public int getContentElementId() {
        return R.id.root;
    }

    @Override
    public BlankActivity getActivity() {
        return activity;
    }
}
