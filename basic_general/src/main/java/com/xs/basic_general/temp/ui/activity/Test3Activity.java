package com.xs.basic_general.temp.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Toast;

import com.xs.basic_general.R;
import com.xs.basic_general.databinding.ActivityTest3Binding;
import com.xs.basic_general.temp.model.LoginModel;
import com.xs.basic_general.temp.ui.activity.base.BaseActivity;
import com.xs.basic_general.temp.ui.callback.ILoginCallback;
import com.xs.basic_general.temp.ui.fragment.LoginFragment;
import com.xs.basic_general.temp.ui.viewmodel.LoginModelView;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-09-01 09:08
 * @email Xs.lin@foxmail.com
 */
public class Test3Activity extends BaseActivity<LoginModelView,ActivityTest3Binding> implements ILoginCallback {
    private static final String TAG = "Test3Activity";


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
        setContentView(R.layout.activity_test3);
//        setContentView(R.layout.activity_test3,true);
        initView();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.fl_content,new LoginFragment()).commit();
        transaction.add(R.id.fl_content,new LoginFragment()).commit();


    }

    private void initView() {
        getViewModel().setUserName("activity3 username");
        getViewModel().setPassword("kkkk");
        getBinding().btnActivity3Test.setText("wode anniu");
        getBinding().btnActivity3Test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"test3activity",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onLoginSuccess(LoginModel loginModel) {

    }
}
