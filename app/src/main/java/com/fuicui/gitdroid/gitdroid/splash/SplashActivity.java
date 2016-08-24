package com.fuicui.gitdroid.gitdroid.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.fuicui.gitdroid.gitdroid.MainActivity;
import com.fuicui.gitdroid.gitdroid.R;
import com.fuicui.gitdroid.gitdroid.login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2016/8/23.
 */
public class SplashActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.btnEnter) protected Button btnEnter;
    @BindView(R.id.btnLogin) protected Button btnLogin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        btnEnter.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()){
            case R.id.btnEnter:
                intent.setClass(getBaseContext(), MainActivity.class);
                break;
            case R.id.btnLogin:
                intent.setClass(getBaseContext(), LoginActivity.class);
                break;

        }
        startActivity(intent);
    }
}
