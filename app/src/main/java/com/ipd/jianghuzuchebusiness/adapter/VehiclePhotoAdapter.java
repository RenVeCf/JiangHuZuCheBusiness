package com.ipd.jianghuzuchebusiness.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.ipd.jianghuzuchebusiness.R;
import com.ipd.jianghuzuchebusiness.bean.VehiclePhotoBean;
import com.ipd.jianghuzuchebusiness.utils.ApplicationUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.BASE_LOCAL_URL;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/16.
 */
public class VehiclePhotoAdapter extends BaseQuickAdapter<VehiclePhotoBean, BaseViewHolder> {
    private List<VehiclePhotoBean> data;

    public VehiclePhotoAdapter(@Nullable List<VehiclePhotoBean> data) {
        super(R.layout.adapter_household_registration_item, data);
        this.data = data;
    }

    private boolean isLook = false;

    public VehiclePhotoAdapter(@Nullable List<VehiclePhotoBean> data, boolean isLook) {
        super(R.layout.adapter_household_registration_item, data);
        this.data = data;
        this.isLook = isLook;
    }

    @Override
    protected void convert(BaseViewHolder helper, VehiclePhotoBean item) {
        helper.addOnClickListener(R.id.iv_household_registration)
                .addOnClickListener(R.id.iv_household_registration_del);
        ImageView ivOne = helper.getView(R.id.iv_household_registration);
        ImageView ivOneDel = helper.getView(R.id.iv_household_registration_del);
        if (!TextUtils.isEmpty(item.getName())) {
            Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + item.getName()).apply(new RequestOptions()).into(ivOne);
            ivOneDel.setVisibility(View.VISIBLE);
        } else {
            ivOne.setImageResource(R.drawable.bg_photo);
            ivOneDel.setVisibility(View.GONE);
        }
        helper.getView(R.id.tv_household_registration_down).setVisibility(View.GONE);
        if (isLook) {
            ivOneDel.setVisibility(View.GONE);
        }
    }


    public boolean isCanAdd() {
        boolean isCanAdd = false;
        for (VehiclePhotoBean dataBean : data) {
            if (!TextUtils.isEmpty(dataBean.getName())) {
                isCanAdd = true;
            }
        }
        return isCanAdd;

    }

    public String getLoadString() {
        List<Map<String, String>> listMap = new ArrayList<>();
        for (VehiclePhotoBean dataBean : data) {
            if (!TextUtils.isEmpty(dataBean.getName())) {
                Map<String, String> map = new HashMap<>();
                map.put("imgurl", dataBean.getName());
                listMap.add(map);
            }

        }
        Gson g = new Gson();
        String jsonString = g.toJson(listMap);
        Log.e("TAG", jsonString);
        return jsonString;
    }
}
