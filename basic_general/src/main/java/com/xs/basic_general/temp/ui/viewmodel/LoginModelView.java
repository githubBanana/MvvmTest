package com.xs.basic_general.temp.ui.viewmodel;

import com.xs.basic_general.temp.model.LoginModel;
import com.xs.basic_general.temp.presenter.ILoginView;
import com.xs.basic_general.temp.presenter.biz.ILoginBiz;
import com.xs.basic_general.temp.presenter.biz.impl.LoginBizImpl;
import com.xs.basic_general.temp.ui.callback.ILoginCallback;
import com.xs.basic_mvvm.presenter.BaseBiz;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-08-29 11:49
 * @email Xs.lin@foxmail.com
 */
public class LoginModelView extends BaseViewModel<ILoginCallback,LoginModel> implements ILoginView {
    private static final String TAG = "LoginModelView";

    public String userName;
    public String password;
    public String version;

    public ILoginBiz biz;

    public LoginModelView(ILoginCallback iLoginCallback) {
        super(iLoginCallback);
        biz = getBiz();
    }

    @Override
    protected BaseBiz createBiz() {
        return new LoginBizImpl(this,this);
    }

    /**
     * 登录方法
     */
    public void login() {
        biz.login();
    }

    @Override
    public String getUserName() {
        return userName;
    }


    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public void onLoginCompleted(LoginModel loginModel) {

    }
}
