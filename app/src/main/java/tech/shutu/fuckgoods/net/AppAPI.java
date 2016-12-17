package tech.shutu.fuckgoods.net;

/**
 * Created by raomengyang on 8/12/16.
 */
public class AppAPI {
    // http://gank.io/api/data/Android/10/1
    // http://gank.io/api/data/福利/10/1
    // http://gank.io/api/data/iOS/20/2
    // http://gank.io/api/data/all/20/2

    public static final String IP_PREFIX = "http://gank.io";

    public static final String SUFFIX_ANDROID = "/api/data/Android";
    public static final String SUFFIX_IOS = "/api/data/iOS";
    public static final String SUFFIX_WELFARE = "/api/data/福利";


    public static final String API_ANDROID_URL = IP_PREFIX + SUFFIX_ANDROID;
    public static final String API_IOS_URL = IP_PREFIX + SUFFIX_IOS;
    public static final String API_WELWARE_URL = IP_PREFIX + SUFFIX_WELFARE;

    public static final String API_PERO_GIRL_HOME_PAGE_URL = "https://api.pero.moe/v2/posts?type=homepage";

    public static String getApiAndroidUrl() {
        return API_ANDROID_URL;
    }

    public static String getApiIosUrl() {
        return API_IOS_URL;
    }

    public static String getApiWelwareUrl() {
        return API_WELWARE_URL;
    }

    public static String getApiPeroGirlHomePageUrl(int page) {
        return API_PERO_GIRL_HOME_PAGE_URL + "&page=" + page;
    }
}
