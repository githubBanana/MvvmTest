package com.xs.basic_mvvm.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Toast;

import com.xs.basic_mvvm.callback.ICallBck;
import com.xs.basic_mvvm.model.ViewModel;
import com.xs.basic_mvvm.widget.load.LoadingFragment;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-08-17 11:14
 * @email Xs.lin@foxmail.com
 */
public abstract class BaseMvvmActivity<VM extends ViewModel,B extends ViewDataBinding> extends BaseActivity implements ICallBck{
    private static final String TAG = "BaseMvvmActivity";

    private B   _b;
    private VM  _vm;

    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _vm = initViewModel();
        _b = DataBindingUtil.setContentView(this,getContentViewId());
        isBinding();
        initView();
        if (isHasToolbar())
            initContentView(getContentViewId());
        else
            initContentView(getContentViewId(),false);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (_vm != null)
            _vm.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (_vm != null)
            _vm.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (_vm != null)
            _vm.onDestroy();
    }


    /* init ViewModel*/
    protected abstract VM initViewModel();
    /* init DataBinding*/
    protected abstract int getContentViewId();
    /* to bind ViewModel and DataBinding*/
    protected abstract boolean toBinding();
    /* init other view*/
    protected abstract void initView();
    /* to determine whether or not to be have a toolbar*/
    protected abstract boolean isHasToolbar();

    protected VM getViewModel() {
        if (_vm == null)
            throw new NullPointerException("you should init ViewModel");
        return _vm;
    }

    protected B getBinding() {
        if (_b == null)
            throw new NullPointerException("you should init binding");
        return _b;
    }

    /**
     * To determine whether or not to bind
     */
    private void isBinding() {
        if (!toBinding()) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
                Log.e(TAG, "ViewModel and DataBinding should be bind" );
            }
        }
    }



    @Override
    public void showToast(String str) {
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showToast(@StringRes int resId) {
        Toast.makeText(this,getString(resId),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoadingView(@StringRes int resId) {
        LoadingFragment.getLoad(getString(resId)).show(getSupportFragmentManager(),LoadingFragment.TAG);
    }

    @Override
    public void showLoadingView() {
        LoadingFragment.getLoad(null).show(getSupportFragmentManager(),LoadingFragment.TAG);
    }

    @Override
    public void dismissLoadingView() {
        Fragment _fm = getSupportFragmentManager().findFragmentByTag(LoadingFragment.TAG);
        if (_fm != null) {
            DialogFragment _df = (DialogFragment) _fm;
            _df.dismiss();
        }
    }



}
