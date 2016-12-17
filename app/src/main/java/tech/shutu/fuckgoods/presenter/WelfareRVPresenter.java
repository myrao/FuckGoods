package tech.shutu.fuckgoods.presenter;

import java.util.List;

import tech.shutu.fuckgoods.iview.PeroGirlView;
import tech.shutu.fuckgoods.listener.OnAndroidRequestListener;
import tech.shutu.fuckgoods.model.IAndroidModel;
import tech.shutu.fuckgoods.model.WelfareModelImpl;
import tech.shutu.fuckgoods.model.bean.AndroidBean;
import tech.shutu.fuckgoods.model.bean.PeroBean;

/**
 * Created by raomengyang on 8/16/16.
 */
public class WelfareRVPresenter extends BasePresenter<PeroGirlView> implements OnAndroidRequestListener {

    private PeroGirlView androidRVView;
    private IAndroidModel welfareModel;

    public WelfareRVPresenter(PeroGirlView rvView) {
        attachView(rvView);
        this.androidRVView = getView();
        welfareModel = new WelfareModelImpl();
    }

    public void refreshPage() {
        androidRVView.onLoading();
        welfareModel.requestPage(1, this);
    }

    public void loadMorePage(int pageCount) {
        welfareModel.requestPage(pageCount, this);
    }


    @Override
    public void onPageRefreshSuccess(Object data) {
        androidRVView.onLoadingFinished();
        if (data != null) androidRVView.setRefreshData((List<PeroBean.ResultBean>) data);
    }

    @Override
    public void onPageLoadMoreSuccess(Object data) {
        androidRVView.onLoadingFinished();
        if (data != null) androidRVView.setDataToUI((List<PeroBean.ResultBean>) data);
    }

    @Override
    public void onPageRequestFailure(String msg) {
        androidRVView.onLoadingFinished();
    }

}
