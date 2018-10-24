package com.wjl.baserecyclerviewadapterhelpertest.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wjl.baserecyclerviewadapterhelpertest.R;
import com.wjl.baserecyclerviewadapterhelpertest.model.DataSourceModel;

import java.util.List;

/**
 * author: WuJinLi
 * time  : 2018/10/23
 * desc  : 加载和刷新数据的adapter
 */
public class RefreshAndLoadMoreAdapter extends BaseQuickAdapter<DataSourceModel, BaseViewHolder> {

    public RefreshAndLoadMoreAdapter(int layoutResId, @Nullable List<DataSourceModel> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DataSourceModel item) {
        helper.setImageDrawable(R.id.iv_img, item.getImgUrl());
        helper.setText(R.id.tv_title, item.getTitle());
        helper.setText(R.id.tv_content, item.getContent());
    }
}
