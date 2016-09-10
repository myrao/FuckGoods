package tech.shutu.fuckgoods.presenter;

/**
 * Created by raomengyang on 8/11/16.
 */
public interface Presenter<V> {

    void attachView(V view);

    void detachView();
}
