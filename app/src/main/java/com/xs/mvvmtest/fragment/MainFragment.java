package com.xs.mvvmtest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.xs.mvvmtest.R;
import com.xs.mvvmtest.viewmodel.MainFragmentBingding;
import com.xs.mvvmtest.viewmodel.MainFragmentViewModel;
import com.xs.mvvmtest.viewmodel.MainViewModel;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-06-18 15:26
 * @email Xs.lin@foxmail.com
 */
public class MainFragment extends MvvmFragment<MainFragmentViewModel,MainFragmentBingding>
implements MainViewModel.OnDialogShow{
    private static final String TAG = "MainFragment";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: " );
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e(TAG, "onViewCreated: " );
    }

    @Override
    protected MainFragmentViewModel initViewModel() {
        return new MainFragmentViewModel();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_main_layout;
    }

    @Override
    protected boolean toBinding() {
        getBinding().setMyviewmodel(getViewModel());
        return true;
    }

    @Override
    protected void initView(View view) {
        final Button _btn = (Button) view.findViewById(R.id.btn_fm);
        _btn.setText("hellow");
        Toast.makeText(getActivity(),view.getId()+"",Toast.LENGTH_LONG).show();
        getBinding().tvFmB.setText("tvB");
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void showProgress(String message) {

    }
}
