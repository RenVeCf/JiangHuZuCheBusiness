package com.ipd.jianghuzuchebusiness.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ipd.jianghuzuchebusiness.R;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/12.
 */
public class OrderSumAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public OrderSumAdapter(@Nullable List<String> data) {
        super(R.layout.adapter_order_sum, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_order_sum, item);
    }
}
