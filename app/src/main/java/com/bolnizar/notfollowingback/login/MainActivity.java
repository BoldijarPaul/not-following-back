package com.bolnizar.notfollowingback.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bolnizar.notfollowingback.R;

public class MainActivity extends AppCompatActivity implements LoginView {

    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        mLoginPresenter = new LoginPresenter(this);
    }

    public void loginClicked(View view) {
        mLoginPresenter.login();
    }
}
