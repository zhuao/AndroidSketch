package me.zhuao.android.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;
import android.view.View;

import me.zhuao.android.sample.activity.AudioRecorderActivity;
import me.zhuao.android.sample.activity.EditTextActivity;
import me.zhuao.android.sample.activity.MomentsActivity;
import me.zhuao.android.sample.activity.SpinnerActivity;
import me.zhuao.android.sample.activity.StepIndicatorActivity;
import me.zhuao.android.sketch.activity.DrawerLayoutActivity;

public class MainActivity extends DrawerLayoutActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.function_lists);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        NavigationView navigateView = (NavigationView) findViewById(R.id.navigation_main);
        navigateView.setNavigationItemSelectedListener(this);
        navigateView.setVisibility(View.VISIBLE);

    }

    @Override
    protected int getDrawerLayoutResId() {
        return R.layout.main_drawer_layout;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.navigation_spinner) {
            spinner(null);
        }
        return false;
    }

    public void spinner(View view) {
        startActivity(new Intent(this, SpinnerActivity.class));
    }

    public void text(View view) {
        startActivity(new Intent(this, EditTextActivity.class));
    }

    public void recorder(View view) {
        startActivity(new Intent(this, AudioRecorderActivity.class));
    }

    public void moments(View view) {
        startActivity(new Intent(this, MomentsActivity.class));
    }

    public void stepIndicator(View view) {
        startActivity(new Intent(this, StepIndicatorActivity.class));
    }
}
