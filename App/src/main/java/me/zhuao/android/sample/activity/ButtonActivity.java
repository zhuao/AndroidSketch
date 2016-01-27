package me.zhuao.android.sample.activity;

import android.os.Bundle;

import me.zhuao.android.sample.R;
import me.zhuao.android.sketch.ui.ToolbarActivity;

public class ButtonActivity extends ToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_layout);
    }
}
