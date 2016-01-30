package me.zhuao.android.sample.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import me.zhuao.android.sample.R;
import me.zhuao.android.sample.domain.TodoThing;
import me.zhuao.android.sample.repository.TodoThingRepository;
import me.zhuao.android.sketch.ui.ToolbarActivity;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class TodoActivity extends ToolbarActivity{

    @InjectView(R.id.todo_list)
    RecyclerView recyclerView;
    private TodoThingRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        ButterKnife.inject(this);
        repository = new TodoThingRepository();
    }

    @Override
    protected void onStart() {
        super.onStart();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final TodoItemsAdapter adapter = new TodoItemsAdapter();
        recyclerView.setAdapter(adapter);

        repository.todoThings()
                //TODO:Distinguish sub and obs, get understand the sample about arbitrary thread on RxAndroid
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<TodoThing>>() {
            @Override
            public void call(List<TodoThing> todoThings) {
                adapter.updateData(todoThings);
            }
        });


    }

    private static class TodoItemsAdapter extends RecyclerView.Adapter {

        private List<TodoThing> todoThings;

        public void updateData(List<TodoThing> todoThings) {
            this.todoThings = todoThings;
            notifyDataSetChanged();
        }

        private static class TodoItemViewHolder extends ViewHolder {

            public final TextView descriptionView;

            public TodoItemViewHolder(View view) {
                super(view);
                descriptionView = ((TextView) view.findViewById(R.id.todo_item_description));
            }
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_item, parent, false);
            return new TodoItemViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            ((TodoItemViewHolder) holder).descriptionView.setText(todoThings.get(position).getThing());
        }

        @Override
        public int getItemCount() {
            if (todoThings == null) return 0;
            return todoThings.size();
        }
    }
}
