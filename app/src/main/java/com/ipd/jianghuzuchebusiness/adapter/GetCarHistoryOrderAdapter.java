package com.ipd.jianghuzuchebusiness.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ipd.jianghuzuchebusiness.R;
import com.ipd.jianghuzuchebusiness.bean.GetCarOrderBean;
import com.ipd.jianghuzuchebusiness.utils.ApplicationUtil;
import com.ipd.jianghuzuchebusiness.utils.LogUtils;

import java.util.List;

import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.BASE_LOCAL_URL;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/10.
 */
public class GetCarHistoryOrderAdapter extends BaseMultiItemQuickAdapter<GetCarOrderBean.DataBean.OrderListBean, BaseViewHolder> {

    public GetCarHistoryOrderAdapter(@Nullable List<GetCarOrderBean.DataBean.OrderListBean> data) {
        super(data);
        //取车单
        addItemType(0, R.layout.adapter_get_car_order);
        //退车单
        addItemType(1, R.layout.adapter_get_car_order);
    }

    @Override
    protected void convert(BaseViewHolder helper, GetCarOrderBean.DataBean.OrderListBean item) {
        switch (helper.getItemViewType()) {
            case 0:
                Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + item.getVehicleLogo()).apply(new RequestOptions().placeholder(R.mipmap.ic_test)).into((ImageView) helper.getView(R.id.iv_order_type));

                helper.setText(R.id.tv_order_time, "全部订单") //FIXME
                        .setText(R.id.tv_order_num, item.getOrderNo())
                        .setText(R.id.tv_order_type_brand, item.getVehicleName())
                        .setText(R.id.tv_order_type_introduce, item.getVehicleModel())
                        .setText(R.id.tv_order_type_location, item.getCity())
                        .setText(R.id.tv_order_type_store_name, item.getStoreName())
                        .setText(R.id.tv_order_type_get_car_time, item.getTakevehicleTime())
                        .setText(R.id.tv_order_type_use_car_time, item.getRentDuration() + "个月")
                        .addOnClickListener(R.id.bt_order_type_start)
                        .addOnClickListener(R.id.bt_order_type_end);

                Button btOrderTypeStart = helper.getView(R.id.bt_order_type_start);
                Button btOrderTypeEnd = helper.getView(R.id.bt_order_type_end);

                helper.setText(R.id.bt_order_type_start, "取消订单");
                if (item.getPickStatus() == 1)
                    helper.setText(R.id.bt_order_type_end, "填写取车单");
                else if (item.getPickStatus() == 2)
                    helper.setText(R.id.bt_order_type_end, "查看车辆");
                if (item.getStatus() == 5 || item.getStatus() == 7 || item.getStatus() == 2) {
                    btOrderTypeStart.setVisibility(View.GONE);
                    btOrderTypeEnd.setVisibility(View.GONE);
                }
                break;
            case 1:
                Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + item.getVehicleLogo()).apply(new RequestOptions().placeholder(R.mipmap.ic_test)).into((ImageView) helper.getView(R.id.iv_order_type));

                helper.setText(R.id.tv_order_time, "全部订单") //FIXME
                        .setText(R.id.tv_order_num, item.getOrderNo())
                        .setText(R.id.tv_order_type_brand, item.getVehicleName())
                        .setText(R.id.tv_order_type_introduce, item.getVehicleModel())
                        .setText(R.id.tv_order_type_location, item.getCity())
                        .setText(R.id.tv_order_type_store_name, item.getStoreName())
                        .setText(R.id.tv_order_type_get_car_time, item.getTakevehicleTime())
                        .setText(R.id.tv_order_type_use_car_time, item.getRentDuration() + "个月")
                        .addOnClickListener(R.id.bt_order_type_start)
                        .addOnClickListener(R.id.bt_order_type_end);

                Button btOrderTypeStart1 = helper.getView(R.id.bt_order_type_start);
                Button btOrderTypeEnd1 = helper.getView(R.id.bt_order_type_end);

                helper.setText(R.id.bt_order_type_start, "取消订单");
                if (item.getStoreStatus() == 1)
                    helper.setText(R.id.bt_order_type_end, "填写退车单");
                else if (item.getStoreStatus() == 2)
                    helper.setText(R.id.bt_order_type_end, "查看车辆");

                if (item.getStatus() == 8 || item.getStatus() == 7 || item.getStatus() == 2) {
                    btOrderTypeStart1.setVisibility(View.GONE);
                    btOrderTypeEnd1.setVisibility(View.GONE);
                }
                break;
        }
    }
}
