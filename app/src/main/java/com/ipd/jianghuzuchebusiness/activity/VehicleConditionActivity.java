package com.ipd.jianghuzuchebusiness.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.Button;

import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuchebusiness.R;
import com.ipd.jianghuzuchebusiness.adapter.ViewPagerAdapter;
import com.ipd.jianghuzuchebusiness.base.BaseActivity;
import com.ipd.jianghuzuchebusiness.bean.VehicleConditionHorizontalBean;
import com.ipd.jianghuzuchebusiness.common.view.NavitationFollowScrollLayoutText;
import com.ipd.jianghuzuchebusiness.common.view.TopView;
import com.ipd.jianghuzuchebusiness.contract.VehicleConditionHorizontalContract;
import com.ipd.jianghuzuchebusiness.fragment.MultipleOrderFragment;
import com.ipd.jianghuzuchebusiness.presenter.VehicleConditionHorizontalPresenter;
import com.ipd.jianghuzuchebusiness.utils.ApplicationUtil;
import com.ipd.jianghuzuchebusiness.utils.SPUtil;
import com.ipd.jianghuzuchebusiness.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;

import static com.ipd.jianghuzuchebusiness.common.config.IConstants.CITY;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.USER_ID;

/**
 * Description ：车辆状况
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/10.
 */
public class VehicleConditionActivity extends BaseActivity<VehicleConditionHorizontalContract.View, VehicleConditionHorizontalContract.Presenter> implements VehicleConditionHorizontalContract.View {

    @BindView(R.id.tv_vehicle_condition_top)
    TopView tvVehicleConditionTop;
    @BindView(R.id.nl_vehicle_condition)
    NavitationFollowScrollLayoutText nlVehicleCondition;
    @BindView(R.id.vp_vehicle_condition)
    ViewPager vpVehicleCondition;
    @BindView(R.id.bt_vehicle_condition)
    Button btVehicleCondition;

    private ViewPagerAdapter viewPagerAdapter;
    private List<Fragment> fragments;
    private MultipleOrderFragment fm;
    private int paperType;
    private String orderId;

    @Override
    public int getLayoutId() {
        return R.layout.activity_vehicle_condition;
    }

    @Override
    public VehicleConditionHorizontalContract.Presenter createPresenter() {
        return new VehicleConditionHorizontalPresenter(this);
    }

    @Override
    public VehicleConditionHorizontalContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvVehicleConditionTop);

        paperType = getIntent().getIntExtra("paper_type", 0);
        orderId = getIntent().getStringExtra("order_id");
        fragments = new ArrayList<>();
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        if (!SPUtil.get(this, CITY, "").equals("")) {
            TreeMap<String, String> vehicleConditionHorizontalMap = new TreeMap<>();
            vehicleConditionHorizontalMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
            vehicleConditionHorizontalMap.put("orderId", orderId);
            vehicleConditionHorizontalMap.put("type", (paperType + 1) + "");
            getPresenter().getVehicleConditionHorizontal(vehicleConditionHorizontalMap, false, false);
        } else
            ToastUtil.showShortToast("请重新获取定位...");
    }

    @OnClick(R.id.bt_vehicle_condition)
    public void onViewClicked() {
        setResult(RESULT_OK, new Intent().putExtra("status_ids", fm.getLoadStringTwo(paperType)));
        finish();
    }

    @Override
    public void resultVehicleConditionHorizontal(VehicleConditionHorizontalBean data) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < data.getData().getVehicleType().size(); i++) {
            list.add(data.getData().getVehicleType().get(i).getStatusName());
        }
        String[] titles = list.toArray(new String[list.size()]);
        //向集合添加Fragment
        for (int i = 0; i < titles.length; i++) {
            fm = new MultipleOrderFragment();
            Bundle args = new Bundle();
            args.putInt("multiple_fm_type", 3);
            args.putParcelableArrayList("vehicle_type", (ArrayList<? extends Parcelable>) data.getData().getVehicleType());
            args.putInt("status_position", i);
            args.putInt("paper_type", paperType);
            fm.setArguments(args);
            fragments.add(fm);
        }
        //设置导航条
//        nlVehicleCondition.setViewPager(this, titles, vpVehicleCondition, R.color.tx_bottom_navigation, R.color.tx_bottom_navigation_select, 16, 16, 0, 45, true);
//        nlVehicleCondition.setBgLine(this, 0, R.color.whitesmoke);
//        nlVehicleCondition.setNavLine(this, 3, R.color.tx_bottom_navigation_select, 0);

        nlVehicleCondition.setViewPager(this, titles, vpVehicleCondition, R.color.tx_bottom_navigation, R.color.tx_bottom_navigation_select, 14, 14, 24, true, R.color.black, 0, 0, 0, 80);
        nlVehicleCondition.setBgLine(this, 1, R.color.whitesmoke);
        nlVehicleCondition.setNavLine(this, 3, R.color.tx_bottom_navigation_select);

        vpVehicleCondition.setOffscreenPageLimit(titles.length);
        viewPagerAdapter = new ViewPagerAdapter(VehicleConditionActivity.this.getSupportFragmentManager(), fragments);
        vpVehicleCondition.setAdapter(viewPagerAdapter);
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }
}
