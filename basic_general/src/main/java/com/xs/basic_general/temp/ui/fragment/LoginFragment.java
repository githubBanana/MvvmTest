package com.xs.basic_general.temp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.xs.basic_general.R;
import com.xs.basic_general.databinding.FragmentTest3Binding;
import com.xs.basic_general.temp.model.LoginModel;
import com.xs.basic_general.temp.ui.callback.ILoginCallback;
import com.xs.basic_general.temp.ui.fragment.base.BaseFragment;
import com.xs.basic_general.temp.ui.viewmodel.LoginModelView;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-09-01 09:17
 * @email Xs.lin@foxmail.com
 */
public class LoginFragment extends BaseFragment<LoginModelView,FragmentTest3Binding> implements ILoginCallback {
    private static final String TAG = "LoginFragment";


    @Override
    protected LoginModelView initViewModel() {
        return new LoginModelView(this);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_test3;
    }

    @Override
    protected void toBinding() {
        getBinding().setLoginviewmdeol(getViewModel());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        getViewModel().setUserName("linxiaoshengyo");
        getViewModel().setPassword("123333");
        getBinding().btnFragmentTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"btn11",Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onLoginSuccess(LoginModel loginModel) {

    }
}
