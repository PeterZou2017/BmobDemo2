package com.example.bmobdemo2.entity;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2017/4/20.
 */

public class OrderDetail extends BmobObject {

    private Order order;
    private Menu menu;
    private Integer num;
    private String remark;

    public void setOrder(Order order){
        this.order=order;
    }
    public Order getOrder(){
        return this.order;
    }

    public void setMenu(Menu menu){
        this.menu=menu;
    }
    public Menu getMenu(){
        return this.menu;
    }

    public void setNum(int num){
        this.num=num;
    }
    public int getNum(){
        return this.num;
    }

    public void setRemark(String remark){
        this.remark=remark;
    }
    public String getRemark(){
        return this.remark;
    }
}
