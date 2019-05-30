package com.ipd.jianghuzuchebusiness.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ipd.jianghuzuchebusiness.R;
import com.ipd.jianghuzuchebusiness.bean.GetCarOrderBean;
import com.ipd.jianghuzuchebusiness.utils.ApplicationUtil;

import java.util.List;

import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.BASE_LOCAL_URL;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/10.
 */
public class GetCarOrderAdapter extends BaseQuickAdapter<GetCarOrderBean.DataBean.OrderListBean, BaseViewHolder> {

    private int type;

    public GetCarOrderAdapter(@Nullable List<GetCarOrderBean.DataBean.OrderListBean> data, int type) {
        super(R.layout.adapter_get_car_order, data);
        this.type = type;
    }

    @Override
    protected void convert(BaseViewHolder helper, GetCarOrderBean.DataBean.OrderListBean item) {
        Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + item.getVehicleLogo()).apply(new RequestOptions().placeholder(R.mipmap.ic_test)).into((ImageView) helper.getView(R.id.iv_order_type));

        helper.setText(R.id.tv_order_time, "今日订单") //FIXME
                .setText(R.id.tv_order_num, item.getOrderNo())
                .setText(R.id.tv_order_type_brand, item.getVehicleName())
                .setText(R.id.tv_order_type_introduce, item.getVehicleModel())
                .setText(R.id.tv_order_type_location, "上海")//FIXME
                .setText(R.id.tv_order_type_store_name, item.getStoreName())
                .setText(R.id.tv_order_type_get_car_time, item.getTakevehicleTime())
                .setText(R.id.tv_order_type_use_car_time, item.getRentDuration() + "个月")
                .addOnClickListener(R.id.bt_order_type_start)
                .addOnClickListener(R.id.bt_order_type_end);

        switch (type) {
            case 0:
                helper.setText(R.id.bt_order_type_start, "取消订单");
                if (item.getTakeStatus() == 1)
                    helper.setText(R.id.bt_order_type_end, "填写取车单");
                else if (item.getTakeStatus() == 2)
                    helper.setText(R.id.bt_order_type_end, "查看车辆");
                break;
            case 1:
                helper.setText(R.id.bt_order_type_start, "取消订单");
                if (item.getStoreStatus() == 1)
                    helper.setText(R.id.bt_order_type_end, "填写退车单");
                else if (item.getStoreStatus() == 2)
                    helper.setText(R.id.bt_order_type_end, "查看车辆");
                break;
        }
    }
}
