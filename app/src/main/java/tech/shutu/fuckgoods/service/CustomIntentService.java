package tech.shutu.fuckgoods.service;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by raomengyang on 8/29/16.
 */
public class CustomIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public CustomIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }


}
