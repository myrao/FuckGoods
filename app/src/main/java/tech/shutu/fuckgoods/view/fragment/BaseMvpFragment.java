package tech.shutu.fuckgoods.view.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.View;

import tech.shutu.fuckgoods.presenter.BasePresenter;

/**
 * Created by raomengyang on 9/10/16.
 */
public abstract class BaseMvpFragment<P extends BasePresenter> extends Fragment {
    protected P presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        presenter = createPresenter();
        super.onCreate(savedInstanceState);
        initData();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    @Override
    public void onStart() {
        super.onStart();
        performStartTask();
    }

    @Override
    public void onResume() {
        super.onResume();
        performResumeTask();
    }

    @Override
    public void onPause() {
        super.onPause();
        performPauseTask();
    }

    @Override
    public void onStop() {
        super.onStop();
        performStopTask();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        releaseResources();
        perfromDestroyTask();
        if (presenter != null) {
            presenter.detachView();
        }
    }

    protected abstract P createPresenter();

    protected void initData() {
    }

    protected void initViews() {
    }

    protected void performStartTask() {
    }

    protected void performResumeTask() {
    }

    protected void performPauseTask() {
    }

    protected void performStopTask() {
    }

    protected void perfromDestroyTask() {
    }

    protected void releaseResources() {
    }

}
