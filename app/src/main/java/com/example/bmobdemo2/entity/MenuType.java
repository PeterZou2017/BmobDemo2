package com.example.bmobdemo2.entity;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2017/4/20.
 */

public class MenuType extends BmobObject {

    private String name;

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }
}
