package com.xs.mvvmtest.listview;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;
import com.xs.mvvmtest.R;
import com.xs.mvvmtest.activity.MvvmActivity;
import com.xs.mvvmtest.listview.adapter.BaseAdapter;
import com.xs.mvvmtest.listview.adapter.UserAdapter;
import com.xs.mvvmtest.viewmodel.listviewmodel.ListBinding;
import com.xs.mvvmtest.viewmodel.listviewmodel.ListTestModel;
import com.xs.mvvmtest.viewmodel.listviewmodel.UserViewModel;

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

        final UserAdapter userAdapter = new UserAdapter(this, new BaseAdapter.OnItemClickListener<UserViewModel>() {
            @Override
            public void onItemClick(View view, UserViewModel userViewModel, int position) {
                Toast.makeText(ListTestActivity.this,"act:"+userViewModel.name.get()+"  "+position,Toast.LENGTH_LONG).show();
            }
        });
        getBinding().rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        getBinding().rv.setAdapter(userAdapter);

        getViewModel().initData(userAdapter);

    }
}
