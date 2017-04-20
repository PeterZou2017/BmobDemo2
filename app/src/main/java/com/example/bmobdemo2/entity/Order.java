package com.example.bmobdemo2.entity;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2017/4/20.
 */

public class Order extends BmobObject{

    // 下单用户
    private MyUser user;
    // 桌号
    private Table table;
    // 人数
    private Integer personNum;
    // 是否结算
    private Integer isPay;
    // 备注
    private String remark;

    public MyUser getUser() {
        return user;
    }
    public void setUser(MyUser user) {
        this.user=user;
    }


    public Table getTable() {
        return table;
    }
    public void setTable(Table table) {
        this.table= table;
    }

    public int getPersonNum() {
        return personNum;
    }
    public void setPersonNum(int personNum) {
        this.personNum = personNum;
    }

    public int getIsPay() {
        return isPay;
    }
    public void setIsPay(int isPay) {
        this.isPay = isPay;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }




}
