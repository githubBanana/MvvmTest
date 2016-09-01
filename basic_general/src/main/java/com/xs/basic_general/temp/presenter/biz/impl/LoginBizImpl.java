package com.xs.basic_general.temp.presenter.biz.impl;

import com.xs.basic_general.temp.presenter.ILoginView;
import com.xs.basic_general.temp.presenter.biz.ILoginBiz;
import com.xs.basic_mvvm.ui.callback.ICallBck;
import com.xs.basic_mvvm.presenter.BaseBiz;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-08-29 13:57
 * @email Xs.lin@foxmail.com
 */
public class LoginBizImpl extends BaseBiz<ILoginView> implements ILoginBiz {
    public LoginBizImpl(ILoginView view, ICallBck callBck) {
        super(view, callBck);
    }

    @Override
    public void login() {
        showToast("login laxi");
    }
}
