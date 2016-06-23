package com.xs.mvvmtest.listview.adapter;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.xs.mvvmtest.R;
import com.xs.mvvmtest.viewmodel.MyBinding;
import com.xs.mvvmtest.viewmodel.listviewmodel.UserViewModel;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-06-21 15:50
 * @email Xs.lin@foxmail.com
 */
public class UserAdapter extends BaseAdapter<UserViewModel> implements View.OnClickListener {

    private static final String TAG = "UserAdapter";
    private Activity mAct;
    private OnItemClickListener<UserViewModel> mOnItemClickListener;
    public UserAdapter(Activity activity,OnItemClickListener<UserViewModel> mOnItemClickListener) {
        this.mAct = activity;
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        return new Holder(mAct,mView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Holder h = (Holder) holder;
        h.itemView.setTag(h);
        h.setData(getItem(position),position);
        h.itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Holder h = (Holder) v.getTag();
        Toast.makeText(mAct,""+h.myBinding.sex.getText(),Toast.LENGTH_LONG).show();
        if (mOnItemClickListener !=null)
            mOnItemClickListener.onItemClick(v,h.myBinding.getUser(),h.position);
    }

    public static class Holder extends RecyclerView.ViewHolder implements View.OnClickListener{

        MyBinding myBinding;
        Activity mAct;
        View itemView;
        DisplayMetrics mDisplayMetrics;
        int position;
        public Holder(Activity activity,View itemView) {
            super(itemView);
            this.mAct = activity;
            this.itemView = itemView;
            myBinding = DataBindingUtil.bind(itemView);
            myBinding.sex.setOnClickListener(this);
            mDisplayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(mDisplayMetrics);
        }

        public void setData(UserViewModel userViewModel,int position) {
            this.position = position;
            userViewModel.age.set(999000000);
            myBinding.setUser(userViewModel);
            myBinding.sex.setOnClickListener(this);


//            myBinding.sex.setTag(userViewModel);
        }


        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.sex:
                    Toast.makeText(mAct,"sex:"+myBinding.getUser().sex.get(),Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }

}
