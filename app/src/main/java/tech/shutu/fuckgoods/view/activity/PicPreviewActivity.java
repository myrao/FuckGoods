package tech.shutu.fuckgoods.view.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.Toolbar;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import tech.shutu.fuckgoods.R;

/**
 * Created by raomengyang on 17/12/2016.
 */

public class PicPreviewActivity extends BaseActivity {
    @BindView(R.id.toolbar2)
    Toolbar toolbar2;
    @BindView(R.id.iv_preview)
    SimpleDraweeView ivPreview;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_pic_preview);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("pic_url");
        try {
            ivPreview.setImageURI(Uri.parse(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
