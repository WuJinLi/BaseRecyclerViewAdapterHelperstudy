package com.wjl.baserecyclerviewadapterhelpertest;

import com.wjl.baserecyclerviewadapterhelpertest.model.DataSourceModel;

import java.util.List;

/**
 * author: WuJinLi
 * time  : 2018/10/24
 * desc  :
 */
public interface CallBackListener<T> {
    void callBack(int count,List<T> t);
}
