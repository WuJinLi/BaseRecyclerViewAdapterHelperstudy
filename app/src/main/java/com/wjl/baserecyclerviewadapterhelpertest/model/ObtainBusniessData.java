package com.wjl.baserecyclerviewadapterhelpertest.model;

import android.content.Context;

import com.wjl.baserecyclerviewadapterhelpertest.CallBackListener;
import com.wjl.baserecyclerviewadapterhelpertest.Constract;
import com.wjl.baserecyclerviewadapterhelpertest.R;
import com.wjl.baserecyclerviewadapterhelpertest.widget.AnimationActivity;
import com.wjl.baserecyclerviewadapterhelpertest.widget.ItemClickActivity;
import com.wjl.baserecyclerviewadapterhelpertest.widget.MultipleActivity;
import com.wjl.baserecyclerviewadapterhelpertest.widget.RefreshAndLoadMoreActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * author: WuJinLi
 * time  : 2018/10/24
 * desc  : 获取数据公共类
 */
public class ObtainBusniessData {
    private static ObtainBusniessData ourInstance;
    private Context context;

    public static ObtainBusniessData getInstance(Context context) {
        synchronized (ObtainBusniessData.class) {

            if (ourInstance == null) {
                ourInstance = new ObtainBusniessData(context);
            }
        }
        return ourInstance;
    }

    private ObtainBusniessData(Context context) {
        this.context = context;
    }


    /**
     * 刷新数据或者预加载数据
     *
     * @param callBackListener
     */
    public void refreshData(CallBackListener callBackListener) {

        List<DataSourceModel> childList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            DataSourceModel model = new DataSourceModel();
            model.setTitle("这是第" + i + "数据");
            model.setContent("这是第" + i + "数据");
            model.setImgUrl(context.getResources().getDrawable(R.mipmap.ic_launcher));
            childList.add(model);
        }

        callBackListener.callBack(1, childList);
    }


    /**
     * 加载更多数据
     *
     * @param count
     * @param callBackListener
     */
    public void loadMoreData(int count, CallBackListener callBackListener) {
        count++;
        List<DataSourceModel> childList = new ArrayList<>();
        int limit = 0;
        int start = 0;
        limit = 20 * count;
        start = limit - 20;
        for (int i = start; i < limit; i++) {
            DataSourceModel model = new DataSourceModel();

            model.setTitle("这是第" + i + "数据");
            model.setContent("这是第" + i + "数据");


            model.setImgUrl(context.getResources().getDrawable(R.mipmap.ic_launcher));
            childList.add(model);
        }


        callBackListener.callBack(count, childList);
    }

    public void initMainPageData(CallBackListener callBackListener) {
        List<MainItemModel> mainItemModels = new ArrayList<>();

        mainItemModels.add(new MainItemModel(Constract.REFRESH_LOADMORE_TYPE, Constract.REFRESH_LOADMORE_DESC, context
                .getDrawable(R.drawable.ic_refresh_load_more), RefreshAndLoadMoreActivity.class));
        mainItemModels.add(new MainItemModel(Constract.ANIMATION_TYPE, Constract.ANIMATION_DESC, context.getResources
                ().getDrawable(R.drawable.ic_animation), AnimationActivity.class));
        mainItemModels.add(new MainItemModel(Constract.MULTIPLE_LAYOUT_TYPE, Constract.MULTIPLE_LAYOUT_DESC, context
                .getResources().getDrawable(R.drawable.ic_multiple), MultipleActivity.class));
        mainItemModels.add(new MainItemModel(Constract.ITEM_CLICK_LISTTENER_TYPE, Constract
                .ITEM_CLICK_LISTTENER_DESC, context.getResources().getDrawable(R.drawable.ic_onclick),
                ItemClickActivity.class));


        callBackListener.callBack(-1, mainItemModels);
    }
}
