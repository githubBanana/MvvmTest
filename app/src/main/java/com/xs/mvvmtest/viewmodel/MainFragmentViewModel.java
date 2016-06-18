package com.xs.mvvmtest.viewmodel;

import android.databinding.ObservableField;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-06-18 16:48
 * @email Xs.lin@foxmail.com
 */
public class MainFragmentViewModel extends ViewModel {

    public ObservableField<String> _a = new ObservableField<>(null);
    public ObservableField<String> _d = new ObservableField<>(null);


    public void login() {
        _a.set("login haxi");
    }
}
