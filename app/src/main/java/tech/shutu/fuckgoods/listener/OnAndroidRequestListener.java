package tech.shutu.fuckgoods.listener;

/**
 * Created by raomengyang on 9/10/16.
 */
public interface OnAndroidRequestListener<T> {

    void onPageRefreshSuccess(T data);

    void onPageLoadMoreSuccess(T data);

    void onPageRequestFailure(String msg);
}
