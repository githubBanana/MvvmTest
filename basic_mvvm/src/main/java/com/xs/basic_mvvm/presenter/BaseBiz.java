package com.xs.basic_mvvm.presenter;

import android.support.annotation.StringRes;

import com.xs.basic_mvvm.callback.ICallBck;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-08-17 15:28
 * @email Xs.lin@foxmail.com
 */
public class BaseBiz<View extends IBaseView> implements IBaseBiz,ICallBck{

    private View _iView;
    private ICallBck _iCallback;

    public BaseBiz(View view ,ICallBck callBck) {
        this._iView = view;
        this._iCallback = callBck;
    }

    public <T> T getCallBack() {
        return (T) _iCallback;
    }

    public View getView() {
        return _iView;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public void submit() {

    }

    @Override
    public void showToast(String str) {
        if (_iCallback != null)
            _iCallback.showToast(str);
    }

    @Override
    public void showToast(@StringRes int resId) {
        if (_iCallback != null)
            _iCallback.showToast(resId);
    }

    @Override
    public void showLoadingView(@StringRes int resId) {
        if (_iCallback != null)
            _iCallback.showLoadingView(resId);
    }

    @Override
    public void showLoadingView() {
        if (_iCallback != null)
            _iCallback.showLoadingView();
    }

    @Override
    public void dismissLoadingView() {
        if (_iCallback != null)
            _iCallback.dismissLoadingView();
    }
}
