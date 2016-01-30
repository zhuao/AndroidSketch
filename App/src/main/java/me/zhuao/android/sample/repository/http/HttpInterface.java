package me.zhuao.android.sample.repository.http;

import me.zhuao.android.sample.repository.http.wrapper.TodoListResponse;
import retrofit2.http.GET;
import rx.Observable;

public interface HttpInterface {
    @GET("classes/Todo")
    Observable<TodoListResponse> todoThings();
}
