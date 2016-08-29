package com.xs.basic_general.temp.ui.callback;

import com.xs.basic_general.temp.model.LoginModel;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-08-29 11:56
 * @email Xs.lin@foxmail.com
 */
public interface ILoginCallback extends IBaseCallback {

    /**
     * 登录成功回调
     */
    void onLoginSuccess(LoginModel loginModel);


}
