package me.zhuao.android.sketch.baseactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import me.zhuao.android.baseactivity.R;
import me.zhuao.android.sketch.baseactivity.decorator.ActivityDecorator;
import me.zhuao.android.sketch.baseactivity.decorator.RootDecorator;

public class BlankActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_blank);
        getActivityDecorator().onCreate(R.id.root);
    }

    @Override
    public void setContentView(int layoutResID) {
        getActivityDecorator().setContentView(layoutResID);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getActivityDecorator().onPostCreate();
    }

    protected ActivityDecorator getActivityDecorator() {
        return new RootDecorator(this);
    }

}
