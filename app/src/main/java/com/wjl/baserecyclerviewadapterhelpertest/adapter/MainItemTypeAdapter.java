package com.wjl.baserecyclerviewadapterhelpertest.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wjl.baserecyclerviewadapterhelpertest.R;
import com.wjl.baserecyclerviewadapterhelpertest.model.MainItemModel;

import java.util.List;

/**
 * author: WuJinLi
 * time  : 2018/10/24
 * desc  : 主页面adapter
 */
public class MainItemTypeAdapter extends BaseQuickAdapter<MainItemModel, BaseViewHolder> {

    public MainItemTypeAdapter(int layoutResId, @Nullable List<MainItemModel> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MainItemModel item) {
        helper.setText(R.id.tv_item_title, item.getItemName())
                .setImageDrawable(R.id.iv_icon, item.getDrawable())
        ;
    }
}
