package com.ipd.jianghuzuchebusiness.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuchebusiness.R;
import com.ipd.jianghuzuchebusiness.adapter.ViewPagerAdapter;
import com.ipd.jianghuzuchebusiness.base.BaseActivity;
import com.ipd.jianghuzuchebusiness.bean.ChargeBean;
import com.ipd.jianghuzuchebusiness.bean.RepairProjectHorizontalBean;
import com.ipd.jianghuzuchebusiness.bean.StoreInforBean;
import com.ipd.jianghuzuchebusiness.common.view.AutoHeightViewPager;
import com.ipd.jianghuzuchebusiness.common.view.NavitationLayout;
import com.ipd.jianghuzuchebusiness.common.view.TopView;
import com.ipd.jianghuzuchebusiness.contract.StoreDetailsContract;
import com.ipd.jianghuzuchebusiness.fragment.MultipleOrderFragment;
import com.ipd.jianghuzuchebusiness.presenter.StoreDetailsPresenter;
import com.ipd.jianghuzuchebusiness.utils.ApplicationUtil;
import com.ipd.jianghuzuchebusiness.utils.SPUtil;
import com.ipd.jianghuzuchebusiness.utils.ToastUtil;
import com.ipd.jianghuzuchebusiness.utils.isClickUtil;
import com.ryane.banner.AdPageInfo;
import com.ryane.banner.AdPlayBanner;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;

import static com.ipd.jianghuzuchebusiness.common.config.IConstants.CITY;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.REQUEST_CODE_106;
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
    public AutoHeightViewPager vpStoreInfor;
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
    @BindView(R.id.iv_charge_frist)
    ImageView ivChargeFrist;
    @BindView(R.id.iv_charge_second)
    ImageView ivChargeSecond;
    @BindView(R.id.iv_charge_three)
    ImageView ivChargeThree;

    private ViewPagerAdapter viewPagerAdapter;
    private List<Fragment> fragments;
    private List<AdPageInfo> images;
    private List<ChargeBean.DataBean.ChargeListBean> chargeListBean;
    private StoreInforBean.DataBean.SelectStoreBean selectStoreBean;
    private int storeInfor_positions = 0;
    private List<RepairProjectHorizontalBean.DataBean.RepairTypeBean> repairProjectHorizontalBean = new ArrayList<>();

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
        vpStoreInfor.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {
                int o;
                if (repairProjectHorizontalBean.get(position).getAppRepairs().size() > 4)
                    o = repairProjectHorizontalBean.get(position).getAppRepairs().size() % 4;
                else if (repairProjectHorizontalBean.get(position).getAppRepairs().size() < 4 && repairProjectHorizontalBean.get(position).getAppRepairs().size() != 0)
                    o = 1;
                else
                    o = 0;
                // 切换到当前页面，重置高度
                vpStoreInfor.resetHeight(position, o);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        vpStoreInfor.resetHeight(0, 0);
    }

    @Override
    public void initData() {
        if (!SPUtil.get(this, CITY, "").equals("")) {
            TreeMap<String, String> storeInforMap = new TreeMap<>();
            storeInforMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
            getPresenter().getStoreInfor(storeInforMap, false, false);
            TreeMap<String, String> repairProjectHorizontalMap = new TreeMap<>();
            repairProjectHorizontalMap.put("city", SPUtil.get(this, CITY, "") + "");
            getPresenter().getRepairProjectHorizontal(repairProjectHorizontalMap, false, false);
            getPresenter().getCharge(false, false);
        } else
            ToastUtil.showShortToast("请重新获取定位...");
    }

    @OnClick(R.id.bt_store_infor)
    public void onViewClicked() {
        if (isClickUtil.isFastClick()) {
            startActivityForResult(new Intent(this, EditStoreInforActivity.class).putExtra("select_store_bean", selectStoreBean).putParcelableArrayListExtra("charge_list", (ArrayList<? extends Parcelable>) chargeListBean), REQUEST_CODE_106);
        }
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
        repairProjectHorizontalBean.addAll(data.getData().getRepairType());
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
            args.putParcelableArrayList("store_infor", (ArrayList<? extends Parcelable>) repairProjectHorizontalBean);
            args.putInt("status_position", i);
            args.putInt("storeInfor_positions", storeInfor_positions);
            fm.setArguments(args);
            fragments.add(fm);
        }
        //设置导航条
        nlStoreInfor.setViewPager(this, titles, vpStoreInfor, R.color.tx_bottom_navigation, R.color.tx_bottom_navigation_select, 16, 16, 0, 45, true);
        nlStoreInfor.setBgLine(this, 0, R.color.whitesmoke);
        nlStoreInfor.setNavLine(this, 3, R.color.tx_bottom_navigation_select, 0);

        viewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager(), fragments);
        vpStoreInfor.setAdapter(viewPagerAdapter);
        vpStoreInfor.setOffscreenPageLimit(titles.length);
    }

    @Override
    public void resultCharge(ChargeBean data) {
        chargeListBean.addAll(data.getData().getChargeList());
        if (chargeListBean.size() < 1) {
            llCharge.setVisibility(View.GONE);
        } else if (chargeListBean.size() < 2) {
            llChargeSecond.setVisibility(View.GONE);
            llChargeThree.setVisibility(View.GONE);
            tvChargeFrist.setText(chargeListBean.get(0).getTitle());
            Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + chargeListBean.get(0).getIcon()).apply(new RequestOptions()).apply(new RequestOptions().placeholder(R.drawable.ic_charge)).into(ivChargeFrist);
            tvChargeFristFee.setText("费用" + chargeListBean.get(0).getCost() + "元");
        } else if (chargeListBean.size() < 3) {
            llChargeThree.setVisibility(View.GONE);
            tvChargeFrist.setText(chargeListBean.get(0).getTitle());
            Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + chargeListBean.get(0).getIcon()).apply(new RequestOptions()).apply(new RequestOptions().placeholder(R.drawable.ic_charge)).into(ivChargeFrist);
            tvChargeFristFee.setText("费用" + chargeListBean.get(0).getCost() + "元");
            tvChargeSecond.setText(chargeListBean.get(1).getTitle());
            Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + chargeListBean.get(1).getIcon()).apply(new RequestOptions()).apply(new RequestOptions().placeholder(R.drawable.ic_charge)).into(ivChargeSecond);
            tvChargeSecondFee.setText("费用" + chargeListBean.get(1).getCost() + "元");
        } else {
            tvChargeFrist.setText(chargeListBean.get(0).getTitle());
            Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + chargeListBean.get(0).getIcon()).apply(new RequestOptions()).apply(new RequestOptions().placeholder(R.drawable.ic_charge)).into(ivChargeFrist);
            tvChargeFristFee.setText("费用" + chargeListBean.get(0).getCost() + "元");
            tvChargeSecond.setText(chargeListBean.get(1).getTitle());
            Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + chargeListBean.get(1).getIcon()).apply(new RequestOptions()).apply(new RequestOptions().placeholder(R.drawable.ic_charge)).into(ivChargeSecond);
            tvChargeSecondFee.setText("费用" + chargeListBean.get(1).getCost() + "元");
            tvChargeThree.setText(chargeListBean.get(2).getTitle());
            Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + chargeListBean.get(2).getIcon()).apply(new RequestOptions()).apply(new RequestOptions().placeholder(R.drawable.ic_charge)).into(ivChargeThree);
            tvChargeThreeFee.setText("费用" + chargeListBean.get(2).getCost() + "元");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            switch (requestCode) {
                case REQUEST_CODE_106:
                    initData();
                    break;
            }
        }
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }
}
