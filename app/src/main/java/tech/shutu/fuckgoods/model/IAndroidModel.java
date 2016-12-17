package tech.shutu.fuckgoods.model;

import tech.shutu.fuckgoods.listener.OnAndroidRequestListener;
import tech.shutu.fuckgoods.listener.OnRequestCallbackListener;

/**
 * Created by raomengyang on 8/15/16.
 */
public interface IAndroidModel extends IModel {

    void requestData(OnRequestCallbackListener requestCallbackListener);

    void requestPage(int pageCount, OnAndroidRequestListener requestCallbackListener);

    void loadImage(OnRequestCallbackListener requestCallbackListener);
}
