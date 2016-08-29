package com.xs.basic_general.temp.model;


import com.xs.basic_mvvm.presenter.BaseModel;

public class LoginModel extends BaseModel<LoginModel> {

    private String ID;// eg:338,
    private String Name;// eg:付焱平,


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
