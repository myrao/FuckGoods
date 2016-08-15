package tech.shutu.fuckgoods.presenter;

import tech.shutu.fuckgoods.iview.AndroidRVView;
import tech.shutu.fuckgoods.listener.OnRequestCallbackListener;
import tech.shutu.fuckgoods.model.AndroidModel;
import tech.shutu.fuckgoods.model.IAndroidModel;

/**
 * Created by raomengyang on 8/16/16.
 */
public class AndroidRVPresenter extends BasePresenter<AndroidRVView> implements OnRequestCallbackListener {

    private AndroidRVView androidRVView;
    private IAndroidModel androidModel;

    public AndroidRVPresenter(AndroidRVView rvView) {
        attachView(rvView);
        this.androidRVView = getView();
        androidModel = new AndroidModel();
    }

    @Override
    public void requestSuccess(Object successData) {

    }

    @Override
    public void requestFailure(Object failureMsg) {

    }
}
