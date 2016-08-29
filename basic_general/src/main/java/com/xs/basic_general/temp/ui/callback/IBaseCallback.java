package com.xs.basic_general.temp.ui.callback;

import com.xs.basic_mvvm.callback.ICallBck;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-08-29 11:57
 * @email Xs.lin@foxmail.com
 */
public interface IBaseCallback extends ICallBck {


    /**
     * 获取用户id
     * @return
     */
    String getUserId();


    /**
     * 网络数据加载完成回调
     */
    void onDataLoadSuccess();

    /**
     * 提交完成的回调
     * @param object
     */
    void onSubmitCompleted(Object object);

}
