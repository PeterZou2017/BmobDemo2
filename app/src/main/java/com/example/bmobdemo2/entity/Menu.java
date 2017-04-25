package com.example.bmobdemo2.entity;

import com.example.bmobdemo2.activity.PayActivity;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.GetListener;

/**
 * Created by Administrator on 2017/4/20.
 */

public class Menu extends BmobObject {

    private Integer price;
    private MenuType menuType;
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
    public MenuType getmenuType() {
        return menuType;
    }
    public void setMenuType(MenuType menuType) {
        this.menuType = menuType;
    }


}
