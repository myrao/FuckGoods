package tech.shutu.fuckgoods.utils;

import android.util.Log;

import com.orhanobut.logger.Logger;

/**
 * Created by raomengyang on 9/10/16.
 */
public class LogUtils {

    private static final String TAG = "debug==> ";
    public static final String O_TAG = "xxxxxxxxx, ";


    public static void o(String printStr) {
        try {
            if (!SysUtils.DEBUG_LOG || printStr == null) {
                return;
            }
            Log.e(O_TAG, printStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void json(String jsonStr) {
        try {
            if (!SysUtils.DEBUG_LOG || jsonStr == null) {
                return;
            }
            Logger.json(jsonStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
