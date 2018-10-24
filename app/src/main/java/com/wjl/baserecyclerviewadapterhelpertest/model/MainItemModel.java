package com.wjl.baserecyclerviewadapterhelpertest.model;

import java.io.Serializable;

/**
 * author: WuJinLi
 * time  : 2018/10/24
 * desc  :
 */
public class MainItemModel implements Serializable {
    private int itemType;
    private String itemName;


    public MainItemModel(int itemType,String itemName){
        this.itemName=itemName;
        this.itemType=itemType;
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
}
