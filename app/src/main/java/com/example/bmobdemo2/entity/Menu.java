package com.example.bmobdemo2.entity;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2017/4/20.
 */

public class Menu extends BmobObject {

    private Integer price;
    private Integer typeId;
    private String name;
    private String pic;
    private String remark;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPic() {
        return pic;
    }
    public void setPic(String pic) {
        this.pic = pic;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public int getTypeId() {
        return typeId;
    }
    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }


}