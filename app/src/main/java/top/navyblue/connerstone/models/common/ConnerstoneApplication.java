package top.navyblue.connerstone.models.common;

import android.app.Application;
import android.content.Context;

/**
 * Created by CIR on 8/2/15.
 */
public class ConnerstoneApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static Context getContext(){
        return mContext;
    }
}
