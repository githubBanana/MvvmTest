package com.xs.mvvmtest.listview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-06-21 14:27
 * @email Xs.lin@foxmail.com
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter {

    protected List<T> mList;

    private Object mLock = new Object();

    protected BaseAdapter() {
        mList = new ArrayList<>();
    }

    public List<T> getmList() {
        return mList;
    }

    public boolean add(T item) {
        synchronized (mList) {
            if (getmList().add(item)) {
                int position = getmList().size();
                notifyItemInserted(position - 1);
                return true;
            }
            return false;
        }
    }

    public boolean add(int position , T item) {
        synchronized (mLock) {
            getmList().add(position,item);
            notifyItemInserted(position);
            return true;
        }
    }

    public boolean addAll(T... items) {
        synchronized (mLock) {
            int size = getmList().size();
            if (Collections.addAll(getmList(),items)) {
                notifyItemRangeInserted(size,items.length);
                return true;
            }
            return false;
        }
    }

    public boolean addAll(Collection<T> items) {
        synchronized (mLock) {
            int size = getmList().size();
            if (getmList().addAll(items)) {
                notifyItemRangeInserted(size,items.size());
                return true;
            }
            return false;
        }
    }

    public boolean addAll(int position, Collection<T> items) {
        synchronized (mLock) {
            if (getmList().addAll(position,items)) {
                notifyItemRangeInserted(position,items.size());
                return true;
            }
            return false;
        }
    }

    public void clear() {
        synchronized (mLock) {
            int size = getmList().size();
            getmList().clear();
            notifyItemRangeRemoved(0,size);
        }
    }

    public void setData(Collection<T> items) {
        synchronized (mLock) {
            clear();
            addAll(items);
        }
    }

    public boolean isEmpty() {
        return getItemCount() == 0;
    }

    public T getItem(int position) {
        return getmList().get(position);
    }

    @Override
    public int getItemCount() {
        return getmList().size();
    }

    public interface OnItemClickListener<T> {
        void onItemClick(View view, T t, int position);
    }
}
