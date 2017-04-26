package com.example.bmobdemo2.entity;

import android.os.Parcel;
import android.os.Parcelable;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2017/4/20.
 */

public class OrderDetail extends BmobObject implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(order);
        dest.writeValue(menu);
        dest.writeInt(num);
        dest.writeString(remark);

    }

    public  final Parcelable.Creator<OrderDetail>CREATOR=new Creator<OrderDetail>() {
        @Override
        public OrderDetail createFromParcel(Parcel source) {
            OrderDetail mdetail=new OrderDetail();
            mdetail.order=(Order)source.readValue(Order.class.getClassLoader());
            mdetail.menu=(Menu) source.readValue(Menu.class.getClassLoader());
            mdetail.num=source.readInt();
            mdetail.remark=source.readString();
            return mdetail;
        }

        @Override
        public OrderDetail[] newArray(int size) {
            return new OrderDetail[size];
        }
    };
}
