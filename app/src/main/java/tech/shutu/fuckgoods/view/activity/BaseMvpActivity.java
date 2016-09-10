package tech.shutu.fuckgoods.view.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import tech.shutu.fuckgoods.presenter.BasePresenter;

/**
 * Created by raomengyang on 6/15/16.
 */
public abstract class BaseMvpActivity<P extends BasePresenter> extends BaseActivity {

    protected P mvpPresenter;
    private Bundle bundle;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        ButterKnife.bind(this);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        ButterKnife.bind(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mvpPresenter = createPresenter();
        super.onCreate(savedInstanceState);
        bundle = savedInstanceState;
        initViews();
        initData();
        execOnceTask();
    }

    protected abstract P createPresenter();

    @Override
    protected void onResume() {
        super.onResume();
        executeAsyncTask();
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopAsyncTask();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releaseResources();
        if (mvpPresenter != null) {
            mvpPresenter.detachView();
        }
    }

    protected abstract void initViews();

    protected abstract void initData();

    protected void execOnceTask() {
    }

    protected void executeAsyncTask() {
    }

    protected void stopAsyncTask() {
    }

    protected void releaseResources() {
    }

    public Bundle getBundle() {
        return bundle;
    }
}
