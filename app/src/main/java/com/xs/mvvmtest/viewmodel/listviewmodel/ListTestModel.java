package com.xs.mvvmtest.viewmodel.listviewmodel;

import android.content.Context;
import android.os.Handler;

import com.xs.mvvmtest.listview.adapter.UserAdapter;
import com.xs.mvvmtest.viewmodel.ViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-06-21 16:43
 * @email Xs.lin@foxmail.com
 */
public class ListTestModel extends ViewModel {


    public void initData(final UserAdapter userAdapter) {
       addAdapterData(userAdapter);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                addAdapterData(userAdapter);
            }
        },5000);
    }
    public void addAdapterData(UserAdapter userAdapter) {
        List<UserViewModel> list = new ArrayList<>();
        list.add(new UserViewModel("cc",11,"man"));
        list.add(new UserViewModel("dd",33,"girl"));
        userAdapter.addAll(list);
    }
}
