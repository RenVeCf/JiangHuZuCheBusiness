package com.ipd.jianghuzuchebusiness.adapter;

import android.support.annotation.Nullable;
import android.widget.RadioButton;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ipd.jianghuzuchebusiness.R;
import com.ipd.jianghuzuchebusiness.bean.VehicleConditionHorizontalBean;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/6/5.
 */
public class ReturnCarAdapter extends BaseQuickAdapter<VehicleConditionHorizontalBean.DataBean.VehicleTypeBean.VehicleOrstatusBean, BaseViewHolder> {

    private RadioButton rbStart;
    private RadioButton rbEnd;

    public ReturnCarAdapter(@Nullable List<VehicleConditionHorizontalBean.DataBean.VehicleTypeBean.VehicleOrstatusBean> data) {
        super(R.layout.adapter_vehicle_condition, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, VehicleConditionHorizontalBean.DataBean.VehicleTypeBean.VehicleOrstatusBean item) {
        rbStart = helper.getView(R.id.rb_start);
        rbEnd = helper.getView(R.id.rb_end);
        if (item.getStatus() == 1)
            rbEnd.setChecked(true);
        else
            rbStart.setChecked(true);
        helper.setText(R.id.tv_vehicle_condition_name, item.getVestatusName())
                .addOnClickListener(R.id.rb_start)
                .addOnClickListener(R.id.rb_end);
    }
}
