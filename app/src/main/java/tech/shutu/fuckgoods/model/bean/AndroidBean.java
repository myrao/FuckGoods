package tech.shutu.fuckgoods.model.bean;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * Created by raomengyang on 8/12/16.
 */
public class AndroidBean {


    /**
     * error : false
     * results : [{"_id":"57aca861421aa949ef961f48","createdAt":"2016-08-12T00:31:29.798Z","desc":"一个简单，强大的广告活动弹窗控件 ","publishedAt":"2016-08-12T11:39:10.578Z","source":"chrome","type":"Android","url":"https://github.com/yipianfengye/android-adDialog","used":true,"who":"Jason"},{"_id":"57ac6af3421aa94a077b354f","createdAt":"2016-08-11T20:09:23.108Z","desc":"Retrofit进阶","publishedAt":"2016-08-12T11:39:10.578Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/a0fd69380735","used":true,"who":null},{"_id":"57ac175e421aa94a0226e654","createdAt":"2016-08-11T14:12:46.69Z","desc":"清楚明了的自定义View流程","publishedAt":"2016-08-12T11:39:10.578Z","source":"chrome","type":"Android","url":"http://www.jianshu.com/p/86e867b9bee8","used":true,"who":"打哈哈"},{"_id":"57ac1342421aa949ef961f3f","createdAt":"2016-08-11T13:55:14.853Z","desc":"实现动态模糊","publishedAt":"2016-08-12T11:39:10.578Z","source":"web","type":"Android","url":"http://blog.csdn.net/wl9739/article/details/51955598","used":true,"who":null},{"_id":"57aafbae421aa90c1dcbcbb8","createdAt":"2016-08-10T18:02:22.207Z","desc":"Add a headview for any view and supports sticking the navigator on the top when ItemView scrolls.","publishedAt":"2016-08-11T12:07:01.963Z","source":"chrome","type":"Android","url":"https://github.com/w446108264/ScrollableLayout","used":true,"who":"dreamxuwj"},{"_id":"57aae9ef421aa90c2c3ecb17","createdAt":"2016-08-10T16:46:39.678Z","desc":"Android 开发之 App 启动时间统计","publishedAt":"2016-08-11T12:07:01.963Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/c967653a9468","used":true,"who":"单刀土豆"},{"_id":"57aa8f7b421aa90b3aac1ee4","createdAt":"2016-08-10T10:20:43.504Z","desc":"imagepicker(图片选择器)","publishedAt":"2016-08-11T12:07:01.963Z","source":"web","type":"Android","url":"https://github.com/917386389/imagepickerdemo","used":true,"who":"fsuper"},{"_id":"57aa7d5c421aa90b3aac1edf","createdAt":"2016-08-10T09:03:24.470Z","desc":"Java8 实用字符串操作库","publishedAt":"2016-08-10T11:37:13.981Z","source":"chrome","type":"Android","url":"https://github.com/shekhargulati/strman-java","used":true,"who":"代码家"},{"_id":"57aa72eb421aa90b3aac1ede","createdAt":"2016-08-10T08:18:51.657Z","desc":"Button 拉长展开效果","publishedAt":"2016-08-10T11:37:13.981Z","source":"chrome","type":"Android","url":"https://github.com/daniel-martins-IR/MagicButton","used":true,"who":"代码家"},{"_id":"57aa7241421aa90b3aac1edd","createdAt":"2016-08-10T08:16:01.833Z","desc":"漂亮的变换引导效果","publishedAt":"2016-08-10T11:37:13.981Z","source":"chrome","type":"Android","url":"https://github.com/eoinfogarty/Onboarding","used":true,"who":"代码家"}]
     */

    private boolean error;
    /**
     * _id : 57aca861421aa949ef961f48
     * createdAt : 2016-08-12T00:31:29.798Z
     * desc : 一个简单，强大的广告活动弹窗控件
     * publishedAt : 2016-08-12T11:39:10.578Z
     * source : chrome
     * type : Android
     * url : https://github.com/yipianfengye/android-adDialog
     * used : true
     * who : Jason
     */

    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }
    }


    public static List<AndroidBean.ResultsBean> parseJsonFromString(String jsonStr) {
        if (!TextUtils.isEmpty(jsonStr)) {
            AndroidBean androidBean = JSON.parseObject(jsonStr, AndroidBean.class);
            if (androidBean.isError()) {
                return null;
            }
            List<AndroidBean.ResultsBean> list = androidBean.getResults();
            return list;
        } else return null;
    }
}
