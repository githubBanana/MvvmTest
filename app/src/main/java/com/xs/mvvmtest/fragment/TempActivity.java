package com.xs.mvvmtest.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.xs.mvvmtest.R;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-06-18 16:32
 * @email Xs.lin@foxmail.com
 */
public class TempActivity extends AppCompatActivity {
    private static final String TAG = "TempActivity";

    public static void startTempActivity(Activity content) {
        Intent intent = new Intent(content,TempActivity.class);
        content.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_layout);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fm,new MainFragment()).commit();
    }
}
