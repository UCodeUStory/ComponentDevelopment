package com.wangpos.loginmodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.wangpos.basesdk.BaseActivity;
import com.wangpos.basesdk.MainApplication;


@Route(path = "/login/1")
public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        MainApplication mainApplication = (MainApplication) getApplication();

        TextView textView = (TextView) findViewById(R.id.tv_mainApplication);
        textView.setText(mainApplication.say());
        Button btnNext = (Button) findViewById(R.id.btn_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(LoginActivity.this,"onClick",Toast.LENGTH_SHORT).show();
                ARouter.getInstance().build("/welcome/1").navigation();
            }
        });

    }
}
