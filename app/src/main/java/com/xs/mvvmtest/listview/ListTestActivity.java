package com.xs.mvvmtest.listview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.xs.mvvmtest.R;
import com.xs.mvvmtest.activity.MainActivity;
import com.xs.mvvmtest.activity.MvvmActivity;
import com.xs.mvvmtest.fragment.MvvmFragment;
import com.xs.mvvmtest.listview.adapter.UserAdapter;
import com.xs.mvvmtest.viewmodel.ViewModel;
import com.xs.mvvmtest.viewmodel.listviewmodel.ListBinding;
import com.xs.mvvmtest.viewmodel.listviewmodel.ListTestModel;
import com.xs.mvvmtest.viewmodel.listviewmodel.UserViewModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-06-21 16:37
 * @email Xs.lin@foxmail.com
 */
public class ListTestActivity extends MvvmActivity<ListTestModel,ListBinding> {


    @Override
    protected ListTestModel initViewModel() {
        return new ListTestModel();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_listest;
    }

    @Override
    protected boolean toBinding() {
        getBinding().setListTest(getViewModel());
        return true;
    }

    @Override
    protected void initView() {

        UserAdapter userAdapter = new UserAdapter(this);
        getBinding().rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        getBinding().rv.setAdapter(userAdapter);

        List<UserViewModel> list = new ArrayList<>();
        list.add(new UserViewModel("jj",11,"man"));
        list.add(new UserViewModel("gg",33,"girl"));
        userAdapter.setData(list);
    }
}
