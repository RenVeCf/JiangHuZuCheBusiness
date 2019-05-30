package com.ipd.jianghuzuchebusiness.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ipd.jianghuzuchebusiness.R;
import com.ipd.jianghuzuchebusiness.bean.RepairOrderListBean;
import com.ipd.jianghuzuchebusiness.common.view.CircleImageView;
import com.ipd.jianghuzuchebusiness.utils.ApplicationUtil;

import java.util.List;

import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.BASE_LOCAL_URL;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/10.
 */
public class RepairOrderAdapter extends BaseQuickAdapter<RepairOrderListBean.DataBean.OrderListBean, BaseViewHolder> {

    private LinearLayout llBt;

    public RepairOrderAdapter(@Nullable List<RepairOrderListBean.DataBean.OrderListBean> data) {
        super(R.layout.adapter_maintenance_order, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RepairOrderListBean.DataBean.OrderListBean item) {
        llBt = helper.getView(R.id.ll_bt);
        if (item.getStatus() == 4)
            llBt.setVisibility(View.VISIBLE);
        else
            llBt.setVisibility(View.GONE);
        Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + item.getLogo()).apply(new RequestOptions()).into((CircleImageView) helper.getView(R.id.iv_user_img));
        helper.setText(R.id.tv_order_num, item.getOrderNo())
                .setText(R.id.tv_order_time, item.getSuccessTime())
                .setText(R.id.tv_user_name, item.getStoreName())
                .setText(R.id.tv_user_phone, item.getTelPhone())
                .setText(R.id.tv_project, "项目: " + item.getRepairs())
                .setText(R.id.tv_service, "充电服务: " + item.getCharges())
                .addOnClickListener(R.id.bt_order_type_start)
                .addOnClickListener(R.id.bt_order_type_end);
    }
}
