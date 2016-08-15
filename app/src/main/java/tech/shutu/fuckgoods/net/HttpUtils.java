package tech.shutu.fuckgoods.net;

import android.text.TextUtils;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import tech.shutu.fuckgoods.interfaces.RequestCallbackalbe;

/**
 * Created by raomengyang on 8/12/16.
 */
public class HttpUtils {

    public static final int VOLLEY_REQUEST_TIMEOUT_MS = 20 * 1000;
    public static final int VOLLEY_REQUEST_RETRY_TIMES = 0;

    public static void doVolleyGetNoQA(String getUrl,
                                       RequestCallbackalbe<String> requestCallbackalbe,
                                       final String... strKVs) {
        doVolleyRequestNoQA(Request.Method.GET, getUrl, requestCallbackalbe, strKVs);
    }


    private static void doVolleyRequestNoQA(int requestMethod, String requestUrl,
                                            final RequestCallbackalbe<String> requestCallbackalbe,
                                            final String... strKVs) {
        if (TextUtils.isEmpty(requestUrl)) return;
        StringRequest requestPost = new StringRequest(requestMethod, requestUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String resultStr) {
                        if (requestCallbackalbe != null)
                            requestCallbackalbe.requestSuccess(resultStr);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        if (requestCallbackalbe != null)
                            requestCallbackalbe.requestFailure(volleyError.toString());
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<String, String>();
                if (strKVs != null && (strKVs.length % 2 == 0)) {
                    for (int i = 0; i < strKVs.length; i += 2) {
                        map.put(strKVs[i], strKVs[i + 1]);
                    }
                }
                return map;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
//                params.put("Authentication", AppContext.getHttpToken(RayclearApplication.getContext()));
                return params;
            }
        };
        // 设置volley的请求超时时间，重试次数
        requestPost.setRetryPolicy(new DefaultRetryPolicy(VOLLEY_REQUEST_TIMEOUT_MS, VOLLEY_REQUEST_RETRY_TIMES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        // queueTag 用于调用cancelAll(queueTag)取消加入队列的请求
        RequestManager.getRequestQueue().add(requestPost);
    }

}
