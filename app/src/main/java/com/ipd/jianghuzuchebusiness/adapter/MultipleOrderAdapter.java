package com.ipd.jianghuzuchebusiness.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ipd.jianghuzuchebusiness.R;
import com.ipd.jianghuzuchebusiness.bean.VehicleConditionHorizontalBean;
import com.ipd.jianghuzuchebusiness.common.view.CircleImageView;
import com.ipd.jianghuzuchebusiness.utils.ApplicationUtil;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/10.
 */
public class MultipleOrderAdapter extends BaseMultiItemQuickAdapter<VehicleConditionHorizontalBean.DataBean.VehicleTypeBean.AppVehicleStatusBean, BaseViewHolder> {

    private LinearLayout llBt;

    public MultipleOrderAdapter(@Nullable List<VehicleConditionHorizontalBean.DataBean.VehicleTypeBean.AppVehicleStatusBean> data) {
        super(data);
        //取车单
        addItemType(0, R.layout.adapter_get_car_order);
        //退车单
        addItemType(1, R.layout.adapter_get_car_order);
        //维修订单
        addItemType(2, R.layout.adapter_maintenance_order);
        //车辆状况
        addItemType(3, R.layout.adapter_vehicle_condition);
        //门店资料
        addItemType(4, R.layout.adapter_store_infor);

    }

    @Override
    protected void convert(BaseViewHolder helper, VehicleConditionHorizontalBean.DataBean.VehicleTypeBean.AppVehicleStatusBean item) {
        switch (helper.getItemViewType()) {
            case 0:
                Glide.with(ApplicationUtil.getContext()).load(R.mipmap.ic_test).apply(new RequestOptions().placeholder(R.mipmap.ic_test)).into((ImageView) helper.getView(R.id.iv_order_type));
                helper.setText(R.id.tv_order_time, "全部订单")
                        .setText(R.id.tv_order_num, "1231421432433")
                        .setText(R.id.tv_order_type_brand, "雅迪")
                        .setText(R.id.tv_order_type_introduce, "新款锐致电动车 20AH")
                        .setText(R.id.tv_order_type_location, "上海")
                        .setText(R.id.tv_order_type_store_name, "徐泾客户自助店")
                        .setText(R.id.tv_order_type_get_car_time, "2019-05-09")
                        .setText(R.id.tv_order_type_use_car_time, "1个月")
                        .setText(R.id.bt_order_type_start, "取消订单")
                        .setText(R.id.bt_order_type_end, "填写取车单")
                        .addOnClickListener(R.id.bt_order_type_start)
                        .addOnClickListener(R.id.bt_order_type_end);
                break;
            case 1:
                Glide.with(ApplicationUtil.getContext()).load(R.mipmap.ic_test).apply(new RequestOptions().placeholder(R.mipmap.ic_test)).into((ImageView) helper.getView(R.id.iv_order_type));
                helper.setText(R.id.tv_order_time, "全部订单")
                        .setText(R.id.tv_order_num, "1231421432433")
                        .setText(R.id.tv_order_type_brand, "雅迪")
                        .setText(R.id.tv_order_type_introduce, "新款锐致电动车 20AH")
                        .setText(R.id.tv_order_type_location, "上海")
                        .setText(R.id.tv_order_type_store_name, "徐泾客户自助店")
                        .setText(R.id.tv_order_type_get_car_time, "2019-05-09")
                        .setText(R.id.tv_order_type_use_car_time, "1个月")
                        .setText(R.id.bt_order_type_start, "取消订单")
                        .setText(R.id.bt_order_type_end, "填写退车单")
                        .addOnClickListener(R.id.bt_order_type_start)
                        .addOnClickListener(R.id.bt_order_type_end);
                break;
            case 2:
                llBt = helper.getView(R.id.ll_bt);
                Glide.with(ApplicationUtil.getContext()).load(R.mipmap.ic_test).apply(new RequestOptions().placeholder(R.mipmap.ic_test)).into((CircleImageView) helper.getView(R.id.iv_user_img));
                helper.setText(R.id.tv_order_num, "1233432432")
                        .setText(R.id.tv_order_time, "2019-05-10")
                        .setText(R.id.tv_user_name, "张毅")
                        .setText(R.id.tv_user_phone, "18343543587")
                        .setText(R.id.tv_project, "项目: 车体维修、电瓶维修、电机维修")
                        .setText(R.id.tv_service, "充电服务: 充电1次 x 1");
                break;
            case 3:
                helper.setText(R.id.tv_vehicle_condition_name, item.getStatusName())
                        .addOnClickListener(R.id.rb_start)
                        .addOnClickListener(R.id.rb_end);
                break;
            case 4:
                if (item.getStatusName() == null)
                    helper.setGone(R.id.cb_store_infor, false);
                else
                    helper.setText(R.id.cb_store_infor, item.getStatusName());
                break;
        }
    }
}
