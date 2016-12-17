package tech.shutu.fuckgoods.presenter;

import tech.shutu.fuckgoods.iview.WebPreviewView;
import tech.shutu.fuckgoods.listener.OnAndroidRequestListener;
import tech.shutu.fuckgoods.model.WebPreviewModel;
import tech.shutu.fuckgoods.model.WebPreviewModelImpl;

/**
 * Created by raomengyang on 9/10/16.
 */
public class WebViewPresenter extends BasePresenter<WebPreviewView> implements OnAndroidRequestListener {
    private WebPreviewView webPreviewView;
    private WebPreviewModel webPreviewModel;

    public WebViewPresenter(WebPreviewView rvView) {
        attachView(rvView);
        this.webPreviewView = getView();
        webPreviewModel = new WebPreviewModelImpl();
    }

    public void loadPage(String pageUrl) {
        webPreviewView.onLoading();
        webPreviewModel.loadWebPager(pageUrl);
    }

    @Override
    public void onPageRefreshSuccess(Object data) {
        webPreviewView.onLoadingFinished();
//        if (data != null) webPreviewView.setRefreshData((List<AndroidBean.ResultsBean>) data);
    }

    @Override
    public void onPageLoadMoreSuccess(Object data) {
        webPreviewView.onLoadingFinished();
//        if (data != null) webPreviewView.setDataToUI((List<AndroidBean.ResultsBean>) data);
    }

    @Override
    public void onPageRequestFailure(String msg) {
        webPreviewView.onLoadingFinished();
    }
}
