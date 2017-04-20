package com.example.bmobdemo2.entity;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2017/4/20.
 */

public class Table extends BmobObject {

    private Integer num;   //桌号
    private Integer flag;  //是否有人
    private String description;

    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public int getFlag() {
        return flag;
    }
    public void setFlag(int flag) {
        this.flag = flag;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
