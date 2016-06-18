package com.xs.mvvmtest.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.xs.mvvmtest.MvvmApplication;
import com.xs.mvvmtest.R;
import com.xs.mvvmtest.fragment.TempActivity;


/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-06-18 09:51
 * @email Xs.lin@foxmail.com
 */
public class MainViewModel extends ViewModel {

    private Context _context;
    private OnDialogShow _dialog;

    public MainViewModel(Context context) {
        _context = context;
        _dialog = (OnDialogShow) context;
    }
    public ObservableField<String> _a = new ObservableField<>(null);
    public ObservableField<String> _b = new ObservableField<>(null);
    public View.OnClickListener onClickLoadData() {
        return new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_b) {
                    Toast.makeText(_context, "Onclick", Toast.LENGTH_LONG).show();
                    _dialog.showProgress("sa lan hei yo");
                    _b.set("BCBC");
                    TempActivity.startTempActivity((Activity) _context);
                }
            }
        };
    }

    public interface OnDialogShow {
        void showDialog();
        void showProgress(String message);
    }


}
