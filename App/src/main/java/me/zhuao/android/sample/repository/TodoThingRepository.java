package me.zhuao.android.sample.repository;

import java.util.List;

import me.zhuao.android.sample.domain.TodoThing;
import rx.Observable;

public class TodoThingRepository {

    private final HttpRepository httpRepository;

    public TodoThingRepository() {
        httpRepository = new HttpRepository();
    }

    public Observable<List<TodoThing>> todoThings() {
        return httpRepository.todoThings();
    }
}
