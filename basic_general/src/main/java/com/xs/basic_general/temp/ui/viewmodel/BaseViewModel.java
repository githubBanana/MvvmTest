package com.xs.basic_general.temp.ui.viewmodel;

import com.xs.basic_general.temp.presenter.IBaseSuperView;
import com.xs.basic_general.temp.ui.callback.IBaseCallback;
import com.xs.basic_mvvm.model.ViewModel;

import java.util.HashMap;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-08-29 13:54
 * @email Xs.lin@foxmail.com
 */
public class BaseViewModel <CallBack extends IBaseCallback, DType> extends ViewModel<CallBack>
        implements IBaseSuperView<DType> {
    private static final String TAG = "BaseViewModel";

    public BaseViewModel(CallBack callBack) {
        super(callBack);
    }

    @Override
    public String getUserId() {
        return null;
    }

    @Override
    public void onDataLoad(DType dType) {

    }

    @Override
    public void onSubmitCompleted() {

    }

    @Override
    public HashMap<String, Object> getSubmitData() {
        return null;
    }

}
