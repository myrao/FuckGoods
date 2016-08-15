package tech.shutu.fuckgoods.model;

import tech.shutu.fuckgoods.listener.OnRequestCallbackListener;

/**
 * Created by raomengyang on 8/15/16.
 */
public interface IAndroidModel extends IModel {

    void requestData(String url, OnRequestCallbackListener requestCallbackListener);
}
