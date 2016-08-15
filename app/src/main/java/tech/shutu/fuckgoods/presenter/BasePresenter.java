package tech.shutu.fuckgoods.presenter;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by raomengyang on 8/11/16.
 */
public abstract class BasePresenter<V> implements Presenter<V> {

    private Reference<V> refrence;

    @Override
    public void attachView(V view) {
        this.refrence = new WeakReference<V>(view);
    }

    public V getView() {
        return refrence.get();
    }

    public boolean isViewAttached() {
        return refrence != null && refrence.get() != null; //判断是否与View建立关联
    }


    @Override
    public void dettachView() {

    }
}
