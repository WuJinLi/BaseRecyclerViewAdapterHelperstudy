package com.wjl.baserecyclerviewadapterhelpertest;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * author: WuJinLi
 * time  : 2018/10/23
 * desc  :
 */
public class MyAdapter extends BaseQuickAdapter<Model, BaseViewHolder> {

    public MyAdapter(int layoutResId, @Nullable List<Model> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Model item) {
        helper.setImageDrawable(R.id.iv_img,item.getImgUrl());
        helper.setText(R.id.tv_title,item.getTitle());
        helper.setText(R.id.tv_content,item.getContent());
    }
}
