package tech.shutu.fuckgoods.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;

import java.util.List;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import tech.shutu.fuckgoods.R;
import tech.shutu.fuckgoods.adapter.AndroidRVAdapter;
import tech.shutu.fuckgoods.model.bean.AndroidBean;
import tech.shutu.fuckgoods.iview.AndroidRVView;
import tech.shutu.fuckgoods.presenter.AndroidRVPresenter;
import tech.shutu.fuckgoods.utils.LogUtils;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class RecyclerViewFragment extends BaseMvpFragment<AndroidRVPresenter> implements AndroidRVView, SwipeRefreshLayout.OnRefreshListener {

    public static final boolean GRID_LAYOUT = false;

    @BindColor(R.color.swipe_refresh_color_1)
    int refreshRed;
    @BindView(R.id.rv_android_list)
    RecyclerView rvAndroidList;
    @BindView(R.id.srfl_android)
    SwipeRefreshLayout srflAndroid;

    private AndroidRVAdapter mAdapter;

    public static RecyclerViewFragment newInstance() {
        return new RecyclerViewFragment();
    }

    public AndroidRVPresenter createPresenter() {
        return new AndroidRVPresenter(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createPresenter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_main, container, false);
        ButterKnife.bind(this, view);
        srflAndroid.setColorSchemeColors(refreshRed);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView.LayoutManager layoutManager;
        if (GRID_LAYOUT) {
            layoutManager = new GridLayoutManager(getActivity(), 2);
        } else {
            layoutManager = new LinearLayoutManager(getActivity());
        }
        rvAndroidList.setLayoutManager(layoutManager);
        rvAndroidList.setHasFixedSize(true);
        //Use this now
        rvAndroidList.addItemDecoration(new MaterialViewPagerHeaderDecorator());
        mAdapter = new AndroidRVAdapter(getActivity());
        rvAndroidList.setAdapter(mAdapter);
        srflAndroid.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        LogUtils.o("onRefresh==> ");
        presenter.refreshPage();
    }

    @Override
    public void setDataToUI(List<AndroidBean.ResultsBean> androidBeanList) {
        mAdapter.addDataAndNotifyChanged(androidBeanList);

    }

    @Override
    public void setRefreshData(List<AndroidBean.ResultsBean> androidBeanList) {
        mAdapter.setDataToAdapter(androidBeanList);

    }

    @Override
    public void onLoading() {
        srflAndroid.setRefreshing(true);
    }

    @Override
    public void onLoadingFinished() {
        srflAndroid.setRefreshing(false);
    }

    @Override
    protected void performStartTask() {
        super.performStartTask();
        onRefresh();
    }
}
