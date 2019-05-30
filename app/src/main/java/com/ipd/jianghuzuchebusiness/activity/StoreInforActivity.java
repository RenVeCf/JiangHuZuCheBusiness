package com.ipd.jianghuzuchebusiness.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuchebusiness.R;
import com.ipd.jianghuzuchebusiness.adapter.ViewPagerAdapter;
import com.ipd.jianghuzuchebusiness.base.BaseActivity;
import com.ipd.jianghuzuchebusiness.bean.ChargeBean;
import com.ipd.jianghuzuchebusiness.bean.RepairProjectHorizontalBean;
import com.ipd.jianghuzuchebusiness.bean.StoreInforBean;
import com.ipd.jianghuzuchebusiness.common.view.NavitationLayout;
import com.ipd.jianghuzuchebusiness.common.view.TopView;
import com.ipd.jianghuzuchebusiness.contract.StoreDetailsContract;
import com.ipd.jianghuzuchebusiness.fragment.MultipleOrderFragment;
import com.ipd.jianghuzuchebusiness.presenter.StoreDetailsPresenter;
import com.ipd.jianghuzuchebusiness.utils.ApplicationUtil;
import com.ipd.jianghuzuchebusiness.utils.SPUtil;
import com.ryane.banner.AdPageInfo;
import com.ryane.banner.AdPlayBanner;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;

import static com.ipd.jianghuzuchebusiness.common.config.IConstants.USER_ID;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.BASE_LOCAL_URL;
import static com.ryane.banner.AdPlayBanner.ImageLoaderType.GLIDE;

/**
 * Description ：门店资料
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/12.
 */
public class StoreInforActivity extends BaseActivity<StoreDetailsContract.View, StoreDetailsContract.Presenter> implements StoreDetailsContract.View {

    @BindView(R.id.tv_store_infor_top)
    TopView tvStoreInforTop;
    @BindView(R.id.ab_store_details)
    AdPlayBanner abStoreDetails;
    @BindView(R.id.tv_store_name)
    TextView tvStoreName;
    @BindView(R.id.tv_store_phone)
    TextView tvStorePhone;
    @BindView(R.id.tv_store_path)
    TextView tvStorePath;
    @BindView(R.id.nl_store_infor)
    NavitationLayout nlStoreInfor;
    @BindView(R.id.vp_store_infor)
    ViewPager vpStoreInfor;
    @BindView(R.id.bt_store_infor)
    Button btStoreInfor;
    @BindView(R.id.ll_charge_frist)
    LinearLayout llChargeFrist;
    @BindView(R.id.ll_charge_second)
    LinearLayout llChargeSecond;
    @BindView(R.id.ll_charge_three)
    LinearLayout llChargeThree;
    @BindView(R.id.ll_charge)
    LinearLayout llCharge;
    @BindView(R.id.tv_charge_frist)
    TextView tvChargeFrist;
    @BindView(R.id.tv_charge_frist_fee)
    TextView tvChargeFristFee;
    @BindView(R.id.tv_charge_second)
    TextView tvChargeSecond;
    @BindView(R.id.tv_charge_second_fee)
    TextView tvChargeSecondFee;
    @BindView(R.id.tv_charge_three)
    TextView tvChargeThree;
    @BindView(R.id.tv_charge_three_fee)
    TextView tvChargeThreeFee;

    private ViewPagerAdapter viewPagerAdapter;
    private List<Fragment> fragments;
    private List<AdPageInfo> images;
    private List<ChargeBean.DataBean.ChargeListBean> chargeListBean;
    private StoreInforBean.DataBean.SelectStoreBean selectStoreBean;

    @Override
    public int getLayoutId() {
        return R.layout.activity_store_infor;
    }

    @Override
    public StoreDetailsContract.Presenter createPresenter() {
        return new StoreDetailsPresenter(this);
    }

    @Override
    public StoreDetailsContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvStoreInforTop);

        selectStoreBean = new StoreInforBean.DataBean.SelectStoreBean();
        images = new ArrayList<>();
        fragments = new ArrayList<>();
        chargeListBean = new ArrayList<>();
        vpStoreInfor.setOffscreenPageLimit(2);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        TreeMap<String, String> storeInforMap = new TreeMap<>();
        storeInforMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
        getPresenter().getStoreInfor(storeInforMap, false, false);
        TreeMap<String, String> repairProjectHorizontalMap = new TreeMap<>();
        repairProjectHorizontalMap.put("city", "上海市");
        getPresenter().getRepairProjectHorizontal(repairProjectHorizontalMap, false, false);
        getPresenter().getCharge(false, false);
    }

    @OnClick(R.id.bt_store_infor)
    public void onViewClicked() {
        startActivity(new Intent(this, EditStoreInforActivity.class).putExtra("select_store_bean", selectStoreBean).putParcelableArrayListExtra("charge_list", (ArrayList<? extends Parcelable>) chargeListBean));
    }

    @Override
    public void resultStoreInfor(StoreInforBean data) {
        selectStoreBean = data.getData().getSelectStore();
        tvStoreName.setText(selectStoreBean.getStoreName());
        tvStorePhone.setText("联系电话：" + selectStoreBean.getContactsPhone());
        tvStorePath.setText("地址：" + selectStoreBean.getDescAddress());

        String[] picPath = null;
        try {
            picPath = selectStoreBean.getPicPath().split(",");
            for (int i = 0; i < picPath.length; i++) {
                AdPageInfo info1 = new AdPageInfo("", BASE_LOCAL_URL + picPath[i], "", i + 1);
                images.add(info1);
            }
            abStoreDetails.setInfoList(images)
                    .setImageLoadType(GLIDE)
                    .setUp();
        } catch (NullPointerException e) {

        }
    }

    @Override
    public void resultRepairProjectHorizontal(RepairProjectHorizontalBean data) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < data.getData().getRepairType().size(); i++) {
            list.add(data.getData().getRepairType().get(i).getRepairName());
        }
        String[] titles = list.toArray(new String[list.size()]);

        //向集合添加Fragment
        for (int i = 0; i < titles.length; i++) {
            final MultipleOrderFragment fm = new MultipleOrderFragment();
            Bundle args = new Bundle();
            args.putInt("multiple_fm_type", 4);
            args.putParcelableArrayList("store_infor", (ArrayList<? extends Parcelable>) data.getData().getRepairType());
            args.putInt("status_position", i);
            fm.setArguments(args);
            fragments.add(fm);
        }
        //设置导航条
        nlStoreInfor.setViewPager(this, titles, vpStoreInfor, R.color.tx_bottom_navigation, R.color.tx_bottom_navigation_select, 16, 16, 0, 45, true);
        nlStoreInfor.setBgLine(this, 0, R.color.whitesmoke);
        nlStoreInfor.setNavLine(this, 3, R.color.tx_bottom_navigation_select, 0);

        viewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager(), fragments);
        vpStoreInfor.setAdapter(viewPagerAdapter);
    }

    @Override
    public void resultCharge(ChargeBean data) { //FIXME
        chargeListBean.addAll(data.getData().getChargeList());
        if (chargeListBean.size() < 1) {
            llCharge.setVisibility(View.GONE);
        } else if (chargeListBean.size() < 2) {
            llChargeSecond.setVisibility(View.GONE);
            llChargeThree.setVisibility(View.GONE);
            tvChargeFrist.setText(chargeListBean.get(0).getTitle());
            tvChargeFristFee.setText("费用" + chargeListBean.get(0).getCost() + "元");
        } else if (chargeListBean.size() < 3) {
            llChargeThree.setVisibility(View.GONE);
            tvChargeFrist.setText(chargeListBean.get(0).getTitle());
            tvChargeFristFee.setText("费用" + chargeListBean.get(0).getCost() + "元");
            tvChargeSecond.setText(chargeListBean.get(1).getTitle());
            tvChargeSecondFee.setText("费用" + chargeListBean.get(1).getCost() + "元");
        } else {
            tvChargeFrist.setText(chargeListBean.get(0).getTitle());
            tvChargeFristFee.setText("费用" + chargeListBean.get(0).getCost() + "元");
            tvChargeSecond.setText(chargeListBean.get(1).getTitle());
            tvChargeSecondFee.setText("费用" + chargeListBean.get(1).getCost() + "元");
            tvChargeThree.setText(chargeListBean.get(2).getTitle());
            tvChargeThreeFee.setText("费用" + chargeListBean.get(2).getCost() + "元");
        }
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }
}
