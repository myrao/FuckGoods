package tech.shutu.fuckgoods.iview;

import java.util.List;

import tech.shutu.fuckgoods.model.bean.PeroBean;
import tech.shutu.fuckgoods.view.IView;

/**
 * Created by Administrator on 2016/12/18.
 */

public interface PeroGirlView extends IView {

    void setDataToUI(List<PeroBean.ResultBean> beanList);

    /**
     * ??这样依赖于业务细节真的好么？
     * @param beanList
     */
    void setRefreshData(List<PeroBean.ResultBean> beanList);


}
