package com.example.bmobdemo2;

import cn.bmob.v3.BmobUser;

/**
 * Created by Administrator on 2017/4/20.
 */
public class MyUser extends BmobUser {

    private String gender;
    private Integer permission;
    private String remark;

    public String getGender(){
        return this.gender;
    }
    public void setGender(String gender){
        this.gender=gender;

    }

    public Integer getPermission(){
        return this.permission;
    }
    public void setPermission(Integer permission){
        this.permission=permission;
    }

    public String getRemark(){
        return this.remark;
    }

    public void setRemark(String remark){
        this.remark=remark;
    }


}
