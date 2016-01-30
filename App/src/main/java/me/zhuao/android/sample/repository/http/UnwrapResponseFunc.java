package me.zhuao.android.sample.repository.http;

import me.zhuao.android.sample.repository.http.wrapper.DomainWrapper;
import rx.functions.Func1;

public class UnwrapResponseFunc<T> implements Func1<DomainWrapper<T>, T> {

    @Override
    public T call(DomainWrapper<T> tDomainWrapper) {
        return tDomainWrapper.unwrap();
    }
}
