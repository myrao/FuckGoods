package tech.shutu.fuckgoods.view.activity;

import android.content.Intent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import tech.shutu.fuckgoods.R;
import tech.shutu.fuckgoods.iview.WebPreviewView;
import tech.shutu.fuckgoods.presenter.BasePresenter;
import tech.shutu.fuckgoods.presenter.WebViewPresenter;

/**
 * Created by raomengyang on 9/10/16.
 */
public class WebViewActivity extends BaseMvpActivity implements WebPreviewView {

    @BindView(R.id.wv_preview)
    WebView wvPreview;

    @Override
    protected BasePresenter createPresenter() {
        return new WebViewPresenter(this);
    }

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_web_preview);
        ButterKnife.bind(this);

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String requestUrl = intent.getStringExtra("request_url");
        setWebView(requestUrl);
    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onLoadingFinished() {

    }

    private void setWebView(String url) {
        //启用支持javascript
        WebSettings webSettings = wvPreview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wvPreview.loadUrl(url);
        // 而不是新开Android的系统browser中响应该链接，必须覆盖webview的WebViewClient对象
        wvPreview.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //  重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
                view.loadUrl(url);
                return true;
            }
        });
    }
}
