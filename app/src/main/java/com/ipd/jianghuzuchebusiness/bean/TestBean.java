package com.ipd.jianghuzuchebusiness.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/10.
 */
public class TestBean implements MultiItemEntity {

//    public static final int TEXT = 1;
//    public static final int IMG = 2;
    private int itemType;
    private int layoutType;
    private String name;

    public int getLayoutType() {
        return layoutType;
    }

    public void setLayoutType(int layoutType) {
        this.layoutType = layoutType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestBean(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
