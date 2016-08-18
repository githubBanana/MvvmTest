package com.xs.basic_mvvm.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.xs.basic_mvvm.callback.ICallBck;
import com.xs.basic_mvvm.widget.load.LoadingFragment;

/**
 * @version V1.0 <提示View>
 * @author: Xs
 * @date: 2016-08-17 11:15
 * @email Xs.lin@foxmail.com
 */
public class BaseActivity extends AppCompatActivity implements ICallBck{
    private static final String TAG = "BaseActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
