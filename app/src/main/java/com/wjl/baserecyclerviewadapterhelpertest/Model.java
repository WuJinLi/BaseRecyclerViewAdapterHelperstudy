package com.wjl.baserecyclerviewadapterhelpertest;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * author: WuJinLi
 * time  : 2018/10/23
 * desc  :
 */
public class Model implements Serializable {
    private String title;
    private String content;
    private Drawable imgUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Drawable getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(Drawable imgUrl) {
        this.imgUrl = imgUrl;
    }
}
