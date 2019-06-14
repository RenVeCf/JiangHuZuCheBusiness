package com.ipd.jianghuzuchebusiness.adapter;

import android.support.annotation.Nullable;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ipd.jianghuzuchebusiness.R;
import com.ipd.jianghuzuchebusiness.bean.RepairProjectHorizontalBean;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/10.
 */
public class StoreInfoRepairAdapter extends BaseQuickAdapter<RepairProjectHorizontalBean.DataBean.RepairTypeBean.AppRepairsBean, BaseViewHolder> {

    public StoreInfoRepairAdapter(@Nullable List<RepairProjectHorizontalBean.DataBean.RepairTypeBean.AppRepairsBean> data) {
        super(R.layout.adapter_store_infor, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RepairProjectHorizontalBean.DataBean.RepairTypeBean.AppRepairsBean item) {
        if (item.getRepairName() == null)
            helper.setGone(R.id.cb_store_infor, false);
        else
            helper.setText(R.id.cb_store_infor, item.getRepairName());
    }
}
