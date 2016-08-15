package tech.shutu.fuckgoods.interfaces;

/**
 * Created by raomengyang on 8/12/16.
 */
public interface RequestCallbackalbe<T> {

    void requestSuccess(T successCallback);

    void requestFailure(T failureCallback);

}
