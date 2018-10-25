package com.wjl.baserecyclerviewadapterhelpertest.model;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * author: WuJinLi
 * time  : 2018/10/24
 * desc  : 数页面数据模型
 */
public class MainItemModel implements Serializable {
    private int itemType;
    private String itemName;
    private Drawable drawable;
    private Class<?> acClass;


    public MainItemModel(int itemType,String itemName,Drawable drawable,Class acClass){
        this.itemName=itemName;
        this.itemType=itemType;
        this.drawable=drawable;
        this.acClass=acClass;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }


    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }


    public void setAcClass(Class acClass) {
        this.acClass = acClass;
    }


    public Class getAcClass() {
        return acClass;
    }
}
