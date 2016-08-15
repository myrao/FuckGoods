package tech.shutu.fuckgoods.listener;

/**
 * Created by raomengyang on 8/15/16.
 */
public interface OnRequestCallbackListener<T> {

    void requestSuccess(T successData);

    void requestFailure(T failureMsg);
}
