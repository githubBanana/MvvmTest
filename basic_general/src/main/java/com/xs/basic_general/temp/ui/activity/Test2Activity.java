package com.xs.basic_general.temp.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.xs.basic_general.R;
import com.xs.basic_general.temp.model.LoginModel;
import com.xs.basic_general.temp.ui.activity.base.BaseActivity;
import com.xs.basic_general.temp.ui.callback.ILoginCallback;
import com.xs.basic_general.temp.ui.viewmodel.LoginModelView;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-08-30 15:56
 * @email Xs.lin@foxmail.com
 */
public class Test2Activity extends BaseActivity implements ILoginCallback {

    private static final String TAG = "Test2Activity";


    private LoginModelView _viewmodel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2,true);
        _viewmodel = new LoginModelView(this);
        _viewmodel.login();
    }

    @Override
    public void onLoginSuccess(LoginModel loginModel) {

    }
}
