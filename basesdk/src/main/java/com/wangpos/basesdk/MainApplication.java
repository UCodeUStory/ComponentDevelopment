package com.wangpos.basesdk;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by qiyue on 2017/11/2.
 */

public class MainApplication extends Application {

    public Context mApplicationContext;

    @Override
    public void onCreate() {
        super.onCreate();

        this.mApplicationContext = this;

        ARouter.init(this);

    }


    public Context getApplicationContext(){
        return mApplicationContext;
    }

    public String say(){
        return "I am main application";
    }
}
