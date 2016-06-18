package com.xs.mvvmtest.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.xs.mvvmtest.viewmodel.ViewModel;

/**
 * @version V1.0 <Mvvm 基类Activity>
 * @author: Xs
 * @date: 2016-06-18 11:56
 * @email Xs.lin@foxmail.com
 */
public abstract class MvvmActivity<VM extends ViewModel,B extends ViewDataBinding> extends AppCompatActivity {

    private final String TAG = MvvmActivity.class.getSimpleName();

    private VM _vm;
    private B _b;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _vm = initViewModel();
        _b = DataBindingUtil.<B>setContentView(this,getContentViewId());
        isBinding();
        initView();
    }

    /* init ViewModel*/
    protected abstract VM initViewModel();
    /* init DataBinding*/
    protected abstract int getContentViewId();
    /* bind ViewModel and DataBinding*/
    protected abstract boolean toBinding();
    /* init other view*/
    protected abstract void initView();

    public B getBinding() {
        if (_b == null)
            throw new NullPointerException("binding not init!");
        return _b;
    }
    public VM getViewModel() {
        if (_vm == null)
            throw new NullPointerException("your should init view model first!");
        return _vm;
    }

    /**
     * To determine whether or not to bind
     */
    private void isBinding() {
        if (!toBinding())
            try {
                throw new Exception();
            } catch (Exception e) {
                Log.e(TAG, "ViewModel and DataBinding should be bind" );
            }
    }

}
