package tech.shutu.fuckgoods.application;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

import tech.shutu.fuckgoods.net.RequestManager;

/**
 * Created by raomengyang on 9/2/16.
 */
public class CustomApplication extends Application {

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
        Fresco.initialize(this);
        RequestManager.init(this);
    }

    public static Context getsContext() {
        return sContext;
    }
}
