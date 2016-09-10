package tech.shutu.fuckgoods.presenter;

import java.util.List;

import tech.shutu.fuckgoods.bean.AndroidBean;
import tech.shutu.fuckgoods.iview.AndroidRVView;
import tech.shutu.fuckgoods.listener.OnAndroidRequestListener;
import tech.shutu.fuckgoods.model.AndroidModel;
import tech.shutu.fuckgoods.model.IAndroidModel;

/**
 * Created by raomengyang on 8/16/16.
 */
public class AndroidRVPresenter extends BasePresenter<AndroidRVView> implements OnAndroidRequestListener {

    private AndroidRVView androidRVView;
    private IAndroidModel androidModel;

    public AndroidRVPresenter(AndroidRVView rvView) {
        attachView(rvView);
        this.androidRVView = getView();
        androidModel = new AndroidModel();
    }

    public void refreshPage() {
        androidRVView.onLoading();
        androidModel.requestPage(1, this);
    }

    public void loadMorePage(int pageCount) {
        androidModel.requestPage(pageCount, this);
    }


    @Override
    public void onPageRefreshSuccess(Object data) {
        androidRVView.onLoadingFinished();
        if (data != null) androidRVView.setRefreshData((List<AndroidBean.ResultsBean>) data);
    }

    @Override
    public void onPageLoadMoreSuccess(Object data) {
        androidRVView.onLoadingFinished();
        if (data != null) androidRVView.setDataToUI((List<AndroidBean.ResultsBean>) data);
    }

    @Override
    public void onPageRequestFailure(String msg) {
        androidRVView.onLoadingFinished();
    }

}
