package com.ipd.jianghuzuchebusiness.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ipd.jianghuzuchebusiness.R;
import com.ipd.jianghuzuchebusiness.bean.OrderDetailsBean;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/27.
 */
public class ExtendTimeAdapter extends BaseQuickAdapter<OrderDetailsBean.DataBean.VehicleEndcostBean, BaseViewHolder> {

    public ExtendTimeAdapter(@Nullable List<OrderDetailsBean.DataBean.VehicleEndcostBean> data) {
        super(R.layout.adapter_extend_time, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderDetailsBean.DataBean.VehicleEndcostBean item) {
        helper.setText(R.id.tv_use_car_service_charge, item.getTenancyService() + "元")
                .setText(R.id.tv_use_car_service_time, item.getRentDuration() + "x" + item.getVehicleRent())
                .setText(R.id.tv_charge_service, item.getChargeMoney() + "元")
                .setText(R.id.tv_use_car_coupon_money, "-" + item.getCoupon() + "元")
                .setText(R.id.tv_use_car_money_sum, item.getTotal() + "元");
        if (item.getLateMoney() > 0)
            helper.setText(R.id.tv_late_payment, item.getLateMoney() + "元")
                    .setGone(R.id.ll_late_payment, true);
    }
}
