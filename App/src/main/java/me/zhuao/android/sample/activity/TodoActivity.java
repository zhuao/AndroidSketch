package me.zhuao.android.sample.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import me.zhuao.android.sample.R;
import me.zhuao.android.sketch.ui.ToolbarActivity;

public class TodoActivity extends ToolbarActivity{

    @InjectView(R.id.todo_list)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        ButterKnife.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        recyclerView.setAdapter(new TodoItemsAdapter());
    }

    private static class TodoItemsAdapter extends RecyclerView.Adapter {

        private static class TodoItemViewHolder extends ViewHolder {

            public final TextView descriptionView;

            public TodoItemViewHolder(View view) {
                super(view);
                descriptionView = ((TextView) view.findViewById(R.id.todo_item_description));
            }
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_item, parent);
            return new TodoItemViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            ((TodoItemViewHolder) holder).descriptionView.setText("haha");
        }

        @Override
        public int getItemCount() {
            return 1;
        }
    }
}
