package me.zhuao.android.sample;

import android.os.Bundle;
import android.view.View;

import me.zhuao.android.controller.Navigator;
import me.zhuao.android.sketch.ui.ToolbarActivity;

public class MainActivity extends ToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.function_lists);
    }


    public void todo(View view) {
        Navigator.goTo("/todo");
    }
}
