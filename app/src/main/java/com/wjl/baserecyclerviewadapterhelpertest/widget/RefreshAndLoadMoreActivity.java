package com.wjl.baserecyclerviewadapterhelpertest.widget;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
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
public class RefreshAndLoadMoreActivity extends AppCompatActivity {
    private RecyclerView rv_list;
    private List<DataSourceModel> list = new ArrayList<>();
    private RefreshAndLoadMoreAdapter adapter;
    private View empty;
    private int mCount = 1;
    private SwipeRefreshLayout swipeLayout;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_refresh_and_loadmore);
        mContext = this;

        rv_list = findViewById(R.id.rv_list);
        adapter = new RefreshAndLoadMoreAdapter(R.layout.item_rv, list);

        swipeLayout = findViewById(R.id.swipeLayout);


        //初始化没有数据界面
        empty = LayoutInflater.from(this).inflate(R.layout.view_empty, null);
        TextView loadDataView = empty.findViewById(R.id.view_empty);

        //配置recyclerview属性
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv_list.setLayoutManager(linearLayoutManager);

        //添加加载item动画
        adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);

        //加载数据执行次数，false每次执行，true只执行一次
        adapter.isFirstOnly(false);
        rv_list.setAdapter(adapter);

        //没有数据时，展示没有数据的页面(没有数据可能造成的原因：1：网络请求失败没有获取数据,2:网络返回数据正常，但是没有数据)
        if (list.size() == 0 || list == null) {
            adapter.setEmptyView(empty);
        }


        //点击空白区域重新加载数据
        loadDataView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.setEnableLoadMore(false);
                ObtainBusniessData.getInstance(mContext).refreshData(new CallBackListener() {
                    @Override
                    public void callBack(int count, List<DataSourceModel> models) {
                        mCount = count;
                        adapter.setNewData(models);
                        adapter.setEnableLoadMore(true);
                        swipeLayout.setRefreshing(false);
                    }
                });
            }
        });


        swipeLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        swipeLayout.setRefreshing(false);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //在刷新数据是禁止下拉加载更多操作
                        adapter.setEnableLoadMore(false);

                        //刷新数据
                        ObtainBusniessData.getInstance(mContext).refreshData(new CallBackListener() {
                            @Override
                            public void callBack(int count, List<DataSourceModel> models) {
                                //加载新数据 操作类似addAll
                                adapter.replaceData(models);
                                adapter.setEnableLoadMore(true);
                                swipeLayout.setRefreshing(false);
                            }
                        });
                    }
                }, 3000);

            }
        });


        //加载更多
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {

                ObtainBusniessData.getInstance(mContext).loadMoreData(mCount, new CallBackListener() {
                    @Override
                    public void callBack(int count, List<DataSourceModel> models) {
                        if (count == 4) {
                            adapter.loadMoreEnd();
                        } else {
                            adapter.addData(models);
                            adapter.loadMoreComplete();
                        }
                        mCount = count;
                    }
                });

            }
        }, rv_list);
    }
}
