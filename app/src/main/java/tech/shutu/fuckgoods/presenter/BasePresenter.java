package tech.shutu.fuckgoods.presenter;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by raomengyang on 8/11/16.
 */
public abstract class BasePresenter<V> implements Presenter<V> {

    private Reference<V> reference;

    @Override
    public void attachView(V view) {
        this.reference = new WeakReference<V>(view);
    }

    public V getView() {
        return reference.get();
    }

    public boolean isViewAttached() {
        return reference != null && reference.get() != null; //判断是否与View建立关联
    }


    @Override
    public void detachView() {
        if (reference != null) {
            reference.clear();
            reference = null;
        }
    }
}
