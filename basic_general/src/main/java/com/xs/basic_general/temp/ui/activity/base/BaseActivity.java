package com.xs.basic_general.temp.ui.activity.base;

import android.databinding.ViewDataBinding;

import com.xs.basic_general.temp.ui.callback.IBaseCallback;
import com.xs.basic_mvvm.ui.activity.BaseMvvmActivity;
import com.xs.basic_mvvm.ui.viewmodel.ViewModel;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-08-29 14:33
 * @email Xs.lin@foxmail.com
 */
public abstract class BaseActivity<VM extends ViewModel,B extends ViewDataBinding> extends BaseMvvmActivity<VM,B> implements IBaseCallback {

    @Override
    public String getUserId() {
        return null;
    }

    @Override
    public void onDataLoadSuccess() {

    }
    @Override
    public void onSubmitCompleted(Object object) {

    }
}



