package tech.shutu.fuckgoods.iview;

import java.util.List;

import tech.shutu.fuckgoods.bean.AndroidBean;
import tech.shutu.fuckgoods.view.IView;

/**
 * Created by raomengyang on 8/16/16.
 */
public interface AndroidRVView extends IView {

    void setDataToUI(List<AndroidBean.ResultsBean> androidBeanList);

    /**
     * ??这样依赖于业务细节真的好么？
     */
    void setRefreshData(List<AndroidBean.ResultsBean> androidBeanList);
}
