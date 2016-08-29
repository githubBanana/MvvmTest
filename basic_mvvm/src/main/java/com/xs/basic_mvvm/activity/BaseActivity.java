package com.xs.basic_mvvm.activity;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.xs.basic_mvvm.R;

/**
 * @version V1.0 <Toolbar Base Activity>
 * @author: Xs
 * @date: 2016-08-17 11:15
 * @email Xs.lin@foxmail.com
 */
public class BaseActivity extends AppCompatActivity{

    protected void initContentView(int contentViewId) {
        initToolbar(contentViewId,true);
    }

    protected void initContentView(int contentViewId,boolean isToolbar) {
        initToolbar(contentViewId,isToolbar);
    }

    /**
     * 初始化 Toolbar
     * @param contentViewId
     * @param isToolbar
     */
    private void initToolbar(int contentViewId,boolean isToolbar) {
        if (isToolbar) {
            ViewGroup contentView = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.layout_toolbar, null);
            Toolbar toolbar = (Toolbar) contentView.findViewById(R.id.toolbar);
            contentView.addView(getLayoutInflater().inflate(contentViewId, null), new ViewGroup.LayoutParams(-1, -1));
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            super.setContentView(contentView);
        } else {
            super.setContentView(contentViewId);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
