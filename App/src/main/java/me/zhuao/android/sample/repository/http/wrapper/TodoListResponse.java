package me.zhuao.android.sample.repository.http.wrapper;

import java.util.List;

import me.zhuao.android.sample.domain.TodoThing;

public class TodoListResponse implements DomainWrapper<List<TodoThing>>{
    private List<TodoThing> results;

    @Override
    public List<TodoThing> unwrap() {
        return results;
    }
}
