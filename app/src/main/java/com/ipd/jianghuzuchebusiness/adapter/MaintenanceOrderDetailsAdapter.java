package com.ipd.jianghuzuchebusiness.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ipd.jianghuzuchebusiness.R;
import com.ipd.jianghuzuchebusiness.bean.RepairDetailsBean;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/23.
 */
public class MaintenanceOrderDetailsAdapter extends BaseQuickAdapter<RepairDetailsBean.DataBean.CostListBean, BaseViewHolder> {
    public MaintenanceOrderDetailsAdapter(@Nullable List<RepairDetailsBean.DataBean.CostListBean> data) {
        super(R.layout.adapter_maintenance_details, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RepairDetailsBean.DataBean.CostListBean item) {
        helper.setText(R.id.tv_maintenance_name, item.getTitle())
                .setText(R.id.tv_maintenance_money, item.getMoney() + "元");
        if (item.getTitle().equals("优惠券")) //FIXME 后台没返回优惠券名称
            helper.setText(R.id.tv_maintenance_money, "-" + item.getMoney() + "元");
    }
}
