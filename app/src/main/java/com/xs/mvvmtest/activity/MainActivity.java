package com.xs.mvvmtest.activity;

import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;

import com.xs.mvvmtest.MainBinding;
import com.xs.mvvmtest.R;
import com.xs.mvvmtest.viewmodel.MainViewModel;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-06-18 09:51
 * @email Xs.lin@foxmail.com
 */
public class MainActivity extends MvvmActivity<MainViewModel,MainBinding>
implements MainViewModel.OnDialogShow{

    private static final String TAG = "MainActivity";

    @Override
    protected MainViewModel initViewModel() {
        return new MainViewModel(this);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main_layout;
    }

    @Override
    protected boolean toBinding() {
        getBinding().setMyviewmodel(getViewModel());
        return true;

    }

    @Override
    protected void initView() {
      /*  getBinding().btnB.setText("i need");
        getBinding().tvC.setText("CCCCCC");*/
//        getViewModel()._a.set("nihao ");
        Log.e(TAG, "initView: "+getBinding() );
        getViewModel()._a.set("ddddd");
        getBinding().tvAaa.setText("eeeeeeeeeee ");

    }


    @Override
    public void showDialog() {

    }

    @Override
    public void showProgress(String message) {
        final View _view = getBinding().llMain;
        Snackbar.make(_view,message,Snackbar.LENGTH_LONG).show();
    }
}
