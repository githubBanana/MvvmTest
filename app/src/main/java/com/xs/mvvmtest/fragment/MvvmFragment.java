package com.xs.mvvmtest.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xs.mvvmtest.R;
import com.xs.mvvmtest.viewmodel.ViewModel;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-06-18 15:27
 * @email Xs.lin@foxmail.com
 */
public abstract class MvvmFragment<VM extends ViewModel , B extends ViewDataBinding> extends Fragment {
    private static final String TAG = "MvvmFragment";

    private VM _vm;
    private B _b;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        _vm = initViewModel();
        _b = DataBindingUtil.inflate(inflater,getContentViewId(),container,false);
        isBinding();
        return getBinding().getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    /* init ViewModel*/
    protected abstract VM initViewModel();
    /* init DataBinding*/
    protected abstract int getContentViewId();
    /* bind ViewModel and DataBinding*/
    protected abstract boolean toBinding();
    /* init other view*/
    protected abstract void initView(View view);

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
