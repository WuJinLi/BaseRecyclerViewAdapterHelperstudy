package com.wjl.baserecyclerviewadapterhelpertest.widget;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wjl.baserecyclerviewadapterhelpertest.CallBackListener;
import com.wjl.baserecyclerviewadapterhelpertest.R;
import com.wjl.baserecyclerviewadapterhelpertest.adapter.RefreshAndLoadMoreAdapter;
import com.wjl.baserecyclerviewadapterhelpertest.model.DataSourceModel;
import com.wjl.baserecyclerviewadapterhelpertest.model.ObtainBusniessData;

import java.util.ArrayList;
import java.util.List;

/**
 * author: WuJinLi
 * time  : 2018/10/24
 * desc  :
 */
public class AnimationActivity extends AppCompatActivity {
    private TabLayout tb_tab;
    private RecyclerView rv_animation_list;
    private Context mContext;

    private List<DataSourceModel> list = new ArrayList<>();
    private RefreshAndLoadMoreAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_animation);
        initData();
        initView();
        setView();
    }

    private void initData() {
        mContext = this;
        adapter = new RefreshAndLoadMoreAdapter(R.layout.item_rv, list);
    }

    private void initView() {
        tb_tab = findViewById(R.id.tb_tab);
        rv_animation_list = findViewById(R.id.rv_animation_list);

        initRecyclerView();
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        rv_animation_list.setLayoutManager(linearLayoutManager);

        adapter.openLoadAnimation();
        adapter.isFirstOnly(false);
        rv_animation_list.setAdapter(adapter);
    }

    private void setView() {
        ObtainBusniessData.getInstance(mContext).refreshData(new CallBackListener() {
            @Override
            public void callBack(int count, List t) {
                adapter.addData((List<DataSourceModel>) t);
            }
        });
    }
}
