package com.wangpos.welcomemodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.wangpos.basesdk.BaseActivity;

@Route(path = "/welcome/1")
public class WelcomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

//        ARouter.getInstance().build("/welcome/1").navigation();

//        ARouter.getInstance().build("/login/1").navigation();
    }
}
