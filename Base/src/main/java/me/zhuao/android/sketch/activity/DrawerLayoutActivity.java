package me.zhuao.android.sketch.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.view.View;
import android.view.ViewStub;

import me.zhuao.android.sketch.R;

public abstract class DrawerLayoutActivity extends ToolbarActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_drawer_layout);

    }

    @Override
    protected ActivityDecorator getActivityDecorator() {
        return new ActivityDrawerLayoutDecorator(this, this, DrawerLayoutActivity.this, getDrawerLayoutResId());
    }

    protected abstract int getDrawerLayoutResId();

    @Override
    public void setContentView(int layoutResID) {
        ViewStub pageContentView = ((ViewStub) findViewById(R.id.page_content));
        pageContentView.setLayoutResource(layoutResID);
        pageContentView.inflate().setVisibility(View.VISIBLE);
    }

}
