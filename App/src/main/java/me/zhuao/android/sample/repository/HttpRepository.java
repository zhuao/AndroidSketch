package me.zhuao.android.sample.repository;

import java.io.IOException;
import java.util.List;

import me.zhuao.android.sample.BuildConfig;
import me.zhuao.android.sample.domain.TodoThing;
import me.zhuao.android.sample.repository.http.HttpInterface;
import me.zhuao.android.sample.repository.http.UnwrapResponseFunc;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.RxJavaCallAdapterFactory;
import rx.Observable;

public class HttpRepository {

    //TODO: Singleton
    private final HttpInterface httpInterface;

    public HttpRepository() {
        //TODO: How many request in parallel
        //TODO: Why OKHttpClient? What'd difference with HttpClient?
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request.Builder builder = chain.request().newBuilder();
                        //TODO:Extract to config
                        builder.addHeader("X-Bmob-Application-Id", "437ee68b70d8825b2a8bcda2ad041aa1");
                        builder.addHeader("X-Bmob-REST-API-Key", "457e69098ef3bbf6db647d2c898f42e3");
                        return chain.proceed(builder.build());
                    }
                }).build();

        Retrofit retrofit = new Retrofit.Builder()
                //TODO: Extract to config
                .baseUrl(BuildConfig.HTTP_SERVER_HOST)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        httpInterface = retrofit.create(HttpInterface.class);
    }

    public Observable<List<TodoThing>> todoThings() {
        return httpInterface.todoThings().map(new UnwrapResponseFunc());
    }

}
