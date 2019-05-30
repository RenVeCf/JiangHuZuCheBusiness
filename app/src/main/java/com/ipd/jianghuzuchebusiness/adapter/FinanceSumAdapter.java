package com.ipd.jianghuzuchebusiness.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ipd.jianghuzuchebusiness.R;
import com.ipd.jianghuzuchebusiness.bean.FinanceSumBean;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/13.
 */
public class FinanceSumAdapter extends BaseQuickAdapter<FinanceSumBean.DataBean.UserDetailedBean, BaseViewHolder> {
    public FinanceSumAdapter(@Nullable List<FinanceSumBean.DataBean.UserDetailedBean> data) {
        super(R.layout.adapter_finance_sum, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FinanceSumBean.DataBean.UserDetailedBean item) {
        helper.setText(R.id.tv_bill_name, item.getTitle())
                .setText(R.id.tv_bill_time, item.getCreateTime());
        switch (item.getMoneyType()) {
            case 1:
                helper.setText(R.id.tv_bill_fee, "+" + item.getMoney())
                        .setTextColor(R.id.tv_bill_fee, Color.GREEN);
                break;
            case 2:
                helper.setText(R.id.tv_bill_fee, "-" + item.getMoney())
                        .setTextColor(R.id.tv_bill_fee, Color.RED);
                break;
        }

    }
}
