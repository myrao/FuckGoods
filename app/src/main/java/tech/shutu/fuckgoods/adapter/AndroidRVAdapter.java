package tech.shutu.fuckgoods.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tech.shutu.fuckgoods.R;
import tech.shutu.fuckgoods.model.bean.AndroidBean;
import tech.shutu.fuckgoods.view.activity.WebViewActivity;

/**
 * Created by raomengyang on 8/15/16.
 */
public class AndroidRVAdapter extends RecyclerView.Adapter<AndroidRVAdapter.ViewHolder> {

    private Context mContext;
    private List<AndroidBean.ResultsBean> androidBeanList;

    public AndroidRVAdapter(Context context) {
        this.mContext = context;
    }

    public void setDataToAdapter(List<AndroidBean.ResultsBean> list) {
        if (list != null) {
            if (androidBeanList != null) {
                androidBeanList.clear();
                androidBeanList.addAll(list);
            } else {
                androidBeanList = list;
            }
        }
        notifyDataSetChanged();
    }

    public void addDataAndNotifyChanged(List<AndroidBean.ResultsBean> list) {
        if (list != null) {
            androidBeanList.addAll(list);
        }
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_android_rv, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final AndroidBean.ResultsBean bean = androidBeanList.get(position);
        if (bean != null) {
            holder.tvPublishTitle.setText(bean.getDesc());
            holder.tvPublishTime.setText(bean.getPublishedAt().replace("T", " "));
            holder.tvSource.setText(bean.getSource());
            holder.tvAuthor.setText(bean.getWho());
            holder.tvType.setText(bean.getType());
        }

        holder.cvAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, WebViewActivity.class);
                intent.putExtra("request_url", bean.getUrl());
                mContext.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return androidBeanList == null ? 0 : androidBeanList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_item)
        SimpleDraweeView ivItem;
        @BindView(R.id.tv_publish_title)
        TextView tvPublishTitle;
        @BindView(R.id.tv_publish_time)
        TextView tvPublishTime;
        @BindView(R.id.tv_source)
        TextView tvSource;
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
