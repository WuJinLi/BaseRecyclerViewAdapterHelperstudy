package com.wjl.baserecyclerviewadapterhelpertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv_list;
    private List<Model> list = new ArrayList<>();
    private MyAdapter adapter;
    private View empty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_list = findViewById(R.id.rv_list);
        adapter=new MyAdapter(R.layout.item_rv,list);

        //初始化没有数据界面
        empty= LayoutInflater.from(this).inflate(R.layout.view_empty,null);
        TextView loadDataView=empty.findViewById(R.id.view_empty);

        //配置recyclerview属性
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rv_list.setLayoutManager(linearLayoutManager);

        //添加加载item动画
        adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);

        //加载数据执行次数，false每次执行，true只执行一次
        adapter.isFirstOnly(false);
        rv_list.setAdapter(adapter);

        //没有数据时，展示没有数据的页面(没有数据可能造成的原因：1：网络请求失败没有获取数据,2:网络返回数据正常，但是没有数据)
        if (list.size()==0||list==null){
            adapter.setEmptyView(empty);
        }


        //点击空白区域重新加载数据
        loadDataView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initData();
                adapter.setNewData(list);
            }
        });


    }



    //模拟数据
    private List<Model> initData() {
        if (list != null || list.size() != 0) {
            list.clear();
        }

        for (int i = 0; i < 20; i++) {
            Model model = new Model();
            model.setTitle("这是第"+i+"数据");
            model.setContent("这是第"+i+"数据");
            model.setImgUrl(getResources().getDrawable(R.mipmap.ic_launcher));
            list.add(model);
        }

        return list;
    }
}
