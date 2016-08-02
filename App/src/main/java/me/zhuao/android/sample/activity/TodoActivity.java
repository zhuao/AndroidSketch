package me.zhuao.android.sample.activity;

import android.os.Bundle;

import butterknife.ButterKnife;
import me.zhuao.android.sample.R;
import me.zhuao.android.sample.presenter.TodoListPresenter;
import me.zhuao.android.sketch.ui.ToolbarActivity;

public class TodoActivity extends ToolbarActivity{


    private TodoListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        presenter = new TodoListPresenter();
        ButterKnife.inject(presenter, this.findViewById(R.id.todo_list));
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.start();
    }

}
