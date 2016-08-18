package com.xs.basic_mvvm.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.xs.basic_mvvm.model.ViewModel;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-08-17 11:14
 * @email Xs.lin@foxmail.com
 */
public abstract class BaseMvvmActivity<VM extends ViewModel,B extends ViewDataBinding> extends BaseActivity {
    private static final String TAG = "BaseMvvmActivity";

    private B   _b;
    private VM  _vm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _vm = initViewModel();
        _b = DataBindingUtil.<B>setContentView(this,getContentViewId());
        isBinding();
        initView();
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


}
