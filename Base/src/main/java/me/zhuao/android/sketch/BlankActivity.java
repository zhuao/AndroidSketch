package me.zhuao.android.sketch;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

public class BlankActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getActivityDecorator().onPostCreate();
    }

    @Override
    public void setContentView(int layoutResID) {
        FrameLayout content = (FrameLayout) findViewById(R.id.fragment_content);
        getLayoutInflater().inflate(layoutResID, content);
        getActivityDecorator().onCreate();
    }

    protected void inflateFragment(Fragment frag) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction()
                .replace(R.id.fragment_content, frag, frag.getClass().getName());
        transaction.commit();
    }

    protected ActivityDecorator getActivityDecorator() {
        return new ActivityDecorator.ActivityEmptyDecorator();
    }

}
