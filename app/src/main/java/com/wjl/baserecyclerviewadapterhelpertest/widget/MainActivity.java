package com.wjl.baserecyclerviewadapterhelpertest.widget;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.wjl.baserecyclerviewadapterhelpertest.CallBackListener;
import com.wjl.baserecyclerviewadapterhelpertest.R;
import com.wjl.baserecyclerviewadapterhelpertest.adapter.MainItemTypeAdapter;
import com.wjl.baserecyclerviewadapterhelpertest.model.MainItemModel;
import com.wjl.baserecyclerviewadapterhelpertest.model.ObtainBusniessData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainItemTypeAdapter adapter;
    private Context mContext;
    private List<MainItemModel> list = new ArrayList<>();
    private RecyclerView rv_main_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);

        initData();
        initView();
        setData();
    }

    private void setData() {
        ObtainBusniessData.getInstance(mContext).initMainPageData(new CallBackListener() {
            @Override
            public void callBack(int count, List t) {
                adapter.addData((List<MainItemModel>) t);
            }
        });


        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(MainActivity.this, ((MainItemModel)adapter.getData().get(position))
                        .getAcClass()));
            }
        });
    }

    private void initView() {
        rv_main_list = findViewById(R.id.rv_main_list);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2);
        rv_main_list.setLayoutManager(gridLayoutManager);
//        rv_main_list.addItemDecoration(new GridDividerItemDecoration(10,getResources().getColor(R.color.itemde)));
        rv_main_list.setAdapter(adapter);
    }

    private void initData() {
        mContext = this;
        adapter = new MainItemTypeAdapter(R.layout.item_main, list);
    }
}
