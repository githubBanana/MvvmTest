package com.xs.basic_general.temp.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.xs.basic_general.R;
import com.xs.basic_general.databinding.ActivityLoginBinding;
import com.xs.basic_general.temp.model.LoginModel;
import com.xs.basic_general.temp.ui.activity.base.BaseActivity;
import com.xs.basic_general.temp.ui.callback.ILoginCallback;
import com.xs.basic_general.temp.ui.viewmodel.LoginModelView;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-08-29 11:07
 * @email Xs.lin@foxmail.com
 */
public class Test1Activity extends BaseActivity<LoginModelView,ActivityLoginBinding> implements ILoginCallback{
    private static final String TAG = "Test1Activity";


    @Override
    protected LoginModelView initViewModel() {
        return new LoginModelView(this);
    }

    @Override
    protected void toBinding() {
        getBinding().setLoginViewModel(getViewModel());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login,true);
//        setContentView(R.layout.activity_login);
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        setTitle("abcd");
    }

    private void initView() {
        getViewModel().setUserName("linxiaosheng e");
        getViewModel().setPassword("23232323");
        getViewModel().setLoginText("i am login text111");
        getBinding().btnTest.setText(" login t");
        getBinding().btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(getViewModel().getUserName());
            }
        });
    }


    @Override
    public void onLoginSuccess(LoginModel loginModel) {

    }

}
