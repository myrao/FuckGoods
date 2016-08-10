package tech.shutu.fuckgoods.presenter;

/**
 * Created by raomengyang on 8/11/16.
 */
public interface BasePresenter extends Presenter {

    @Override
    void attachView();

    @Override
    void dettachView();
}
