package com.wangpos.commpenttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wangpos.basesdk.BaseActivity;
import com.wangpos.basesdk.MainApplication;

import butterknife.BindView;
import butterknife.ButterKnife;
//import com.wangpos.loginmodule.LoginActivity;


/**
 *
 *
 * 集成ARouter
 *  1.在每个build.gradle 添加两句话
 *
 *
 *   compile 'com.alibaba:arouter-api:1.2.1'
 annotationProcessor 'com.alibaba:arouter-compiler:1.1.2'

    2.在每个build.gradle 添加
         defaultConfig{}
         javaCompileOptions {
         annotationProcessorOptions {
         arguments = [moduleName: project.getName()]
         }
         }
 }
 */
public class MainActivity extends BaseActivity {


    @BindView(R.id.tv_mainApplication)
    public TextView tt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        MainApplication mainApplication = (MainApplication) getApplication();
        TextView textView = (TextView) findViewById(R.id.tv_mainApplication);
        textView.setText(mainApplication.say());

        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //此处以后用路由方便开发，最好不要用反射
//                startActivity(new Intent(MainActivity.this,LoginActivity.class));

                ARouter.getInstance().build("/login/1").navigation();
//                ARouter.getInstance().build("/welcome/1").navigation();
            }
        });


    }
}
