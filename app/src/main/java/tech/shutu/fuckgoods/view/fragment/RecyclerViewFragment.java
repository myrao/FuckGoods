package tech.shutu.fuckgoods.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import tech.shutu.fuckgoods.R;
import tech.shutu.fuckgoods.adapter.AndroidRVAdapter;
import tech.shutu.fuckgoods.iview.AndroidRVView;
import tech.shutu.fuckgoods.presenter.AndroidRVPresenter;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class RecyclerViewFragment extends Fragment implements AndroidRVView, SwipeRefreshLayout.OnRefreshListener {

    public static final boolean GRID_LAYOUT = false;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindColor(R.color.swipe_refresh_color_1)
    int refreshRed;

    private SwipeRefreshLayout mSwipeRefreshLayout;

    private AndroidRVAdapter mAdapter;
//    private List<Object> mContentItems = new ArrayList<>();

    public static RecyclerViewFragment newInstance() {
        return new RecyclerViewFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createPresenter();
    }

    public AndroidRVPresenter createPresenter() {
        return new AndroidRVPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        ButterKnife.bind(this, view);
        mSwipeRefreshLayout.setColorSchemeColors(refreshRed);
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
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        //Use this now
        mRecyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
        mAdapter = new AndroidRVAdapter(getContext());

        //mAdapter = new RecyclerViewMaterialAdapter();
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onRefresh() {


    }


    @Override
    public void setDataToUI() {

    }
}
