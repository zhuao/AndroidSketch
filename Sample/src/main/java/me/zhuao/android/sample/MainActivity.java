package me.zhuao.android.sample;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;
import android.view.View;

import me.zhuao.android.controller.Navigator;
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
        if (menuItem.getItemId() == R.id.navigation_button_sample) {
            Navigator.goTo("/button");
        }
        return false;
    }

    public void spinner(View view) {
        Navigator.goTo("/spinner");
    }

    public void text(View view) {
        Navigator.goTo("/text");
    }

    public void recorder(View view) {
        Navigator.goTo("/audio");
    }

    public void moments(View view) {
        Navigator.goTo("/moments");
    }

    public void stepIndicator(View view) {
        Navigator.goTo("/indicator");
    }
}
