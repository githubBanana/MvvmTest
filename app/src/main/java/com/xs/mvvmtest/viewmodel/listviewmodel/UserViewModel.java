package com.xs.mvvmtest.viewmodel.listviewmodel;

import android.databinding.ObservableField;

import com.xs.mvvmtest.viewmodel.ViewModel;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-06-21 15:54
 * @email Xs.lin@foxmail.com
 */
public class UserViewModel extends ViewModel {

    public ObservableField<String> name = new ObservableField<>(null);

    public ObservableField<Integer> age = new ObservableField<>(9);

    public ObservableField<String> sex = new ObservableField<>(null);


    public UserViewModel(String name,int age,String sex) {
        this.name.set(name);
        this.age.set(age);
        this.sex.set(sex);
    }

}
