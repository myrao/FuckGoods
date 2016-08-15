package tech.shutu.fuckgoods.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tech.shutu.fuckgoods.R;
import tech.shutu.fuckgoods.bean.AndroidBean;

/**
 * Created by raomengyang on 8/15/16.
 */
public class AndroidRVAdapter extends RecyclerView.Adapter<AndroidRVAdapter.ViewHolder> {

    private Context mContext;
    private List<AndroidBean> androidBeanList = new ArrayList<>();

    public AndroidRVAdapter(Context context) {
        this.mContext = context;
    }

    public void setDataToAdapter(List<AndroidBean> list) {
        if (androidBeanList == null) androidBeanList = list;
        else {
            androidBeanList.clear();
            androidBeanList.addAll(list);
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_android_rv, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        AndroidBean bean = androidBeanList.get(position).getResults()
    }


    @Override
    public int getItemCount() {
        return 0;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_publish_time)
        TextView tvPublishTime;
        @BindView(R.id.tv_type)
        TextView tvType;
        @BindView(R.id.tv_author)
        TextView tvAuthor;
        @BindView(R.id.cv_android)
        CardView cvAndroid;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
