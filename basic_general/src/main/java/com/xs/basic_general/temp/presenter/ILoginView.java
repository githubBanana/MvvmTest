package com.xs.basic_general.temp.presenter;

import com.xs.basic_general.temp.model.LoginModel;
import com.xs.basic_mvvm.presenter.IBaseView;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-08-29 13:59
 * @email Xs.lin@foxmail.com
 */
public interface ILoginView extends IBaseView{

    /**
     * 用户名
     * @return
     */
    String getUserName();

    /**
     * 用户名
     * @param userName
     */
    void setUserName(String userName);


    /**
     * 获取密码
     * @return
     */
    String getPassword();

    /**
     * 密码
     */
    void setPassword(String password);


    /**
     * 版本号
     * @return
     */
    String getVersion();

    /**
     * 版本号
     * @param version
     */
    void setVersion(String version);

    /**
     * 登录回调
     * @param loginModel
     */
    void onLoginCompleted(LoginModel loginModel);

    String getLoginText();
    void   setLoginText(String text);
}
