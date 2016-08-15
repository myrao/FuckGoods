package tech.shutu.fuckgoods.net;

import com.squareup.okhttp.OkHttpClient;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/8/16.
 */
public class OKHttpClientManager {

    private static final long TIME_OUT_MS = 20 * 1000;
    private static OKHttpClientManager sInstance;
    private OkHttpClient okHttpClient;

    public OKHttpClientManager() {
        okHttpClient = new OkHttpClient();
        okHttpClient.setCookieHandler(new CookieManager(null, CookiePolicy.ACCEPT_ORIGINAL_SERVER));
        okHttpClient.setConnectTimeout(TIME_OUT_MS, TimeUnit.MILLISECONDS);
    }

    public static OKHttpClientManager getInstance() {
        if (sInstance == null){
            synchronized (OKHttpClientManager.class){
                if (sInstance == null) sInstance = new OKHttpClientManager();
            }
        }
        return sInstance;
    }


    public OkHttpClient getOkHttpClient(){
        return okHttpClient;
    }
}
