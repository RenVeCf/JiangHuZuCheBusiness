package com.ipd.jianghuzuchebusiness.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuchebusiness.R;
import com.ipd.jianghuzuchebusiness.base.BaseActivity;
import com.ipd.jianghuzuchebusiness.bean.StoreImgBean;
import com.ipd.jianghuzuchebusiness.common.view.TopView;
import com.ipd.jianghuzuchebusiness.contract.StoreImgContract;
import com.ipd.jianghuzuchebusiness.presenter.StoreImgPresenter;
import com.ipd.jianghuzuchebusiness.utils.ApplicationUtil;
import com.ipd.jianghuzuchebusiness.utils.SPUtil;
import com.ipd.jianghuzuchebusiness.utils.ToastUtil;
import com.ryane.banner.AdPageInfo;
import com.ryane.banner.AdPlayBanner;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;
import io.reactivex.ObservableTransformer;

import static com.ipd.jianghuzuchebusiness.common.config.IConstants.JPUSH_SEQUENCE;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.STORE_ID;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.BASE_LOCAL_URL;
import static com.ryane.banner.AdPlayBanner.ImageLoaderType.GLIDE;

/**
 * Description ：首页
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/10.
 */
public class MainActivity extends BaseActivity<StoreImgContract.View, StoreImgContract.Presenter> implements StoreImgContract.View {

    @BindView(R.id.tv_main_top)
    TopView tvMainTop;
    @BindView(R.id.ab_main)
    AdPlayBanner abMain;
    @BindView(R.id.ll_store_infor)
    LinearLayout llStoreInfor;
    @BindView(R.id.ll_get_car_order)
    LinearLayout llGetCarOrder;
    @BindView(R.id.ll_out_car_order)
    LinearLayout llOutCarOrder;
    @BindView(R.id.ll_maintenance_order)
    LinearLayout llMaintenanceOrder;
    @BindView(R.id.ll_order_sum)
    LinearLayout llOrderSum;
    @BindView(R.id.ll_finance_sum)
    LinearLayout llFinanceSum;
    @BindView(R.id.bt_out)
    Button btOut;

    private List<AdPageInfo> images;
    private long firstTime = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public StoreImgContract.Presenter createPresenter() {
        return new StoreImgPresenter(this);
    }

    @Override
    public StoreImgContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvMainTop);

        images = new ArrayList<>();
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        TreeMap<String, String> returnCarMap = new TreeMap<>();
        returnCarMap.put("storeId", SPUtil.get(this, STORE_ID, "") + "");
        getPresenter().getStoreImg(returnCarMap, true, false);
    }

    /**
     * 双击退出程序
     */
    @Override
    public void onBackPressed() {
        long secondTime = System.currentTimeMillis();
        if (secondTime - firstTime > 2000) {
            ToastUtil.showShortToast(getResources().getString(R.string.click_out_again));
            firstTime = secondTime;
        } else {
            ApplicationUtil.getManager().exitApp();
        }
    }

    @OnClick({R.id.ll_store_infor, R.id.ll_get_car_order, R.id.ll_out_car_order, R.id.ll_maintenance_order, R.id.ll_order_sum, R.id.ll_finance_sum, R.id.bt_out})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_store_infor:
                startActivity(new Intent(this, StoreInforActivity.class));
                break;
            case R.id.ll_get_car_order:
                startActivity(new Intent(this, GetCarOrderActivity.class).putExtra("order_type", 0));
                break;
            case R.id.ll_out_car_order:
                startActivity(new Intent(this, GetCarOrderActivity.class).putExtra("order_type", 1));
                break;
            case R.id.ll_maintenance_order:
                startActivity(new Intent(this, MultipleOrderActivity.class).putExtra("multiple_type", 2));
                break;
            case R.id.ll_order_sum:
                startActivity(new Intent(this, OrderSumActivity.class));
                break;
            case R.id.ll_finance_sum:
                startActivity(new Intent(this, FinanceSumActivity.class));
                break;
            case R.id.bt_out:
                // 退出登录删除别名
                JPushInterface.deleteAlias(this, JPUSH_SEQUENCE);
                //清除所有临时储存
                SPUtil.clear(ApplicationUtil.getContext());
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;
        }
    }

    @Override
    public void resultStoreImg(StoreImgBean data) {
        String[] picPath = null;
        try {
            picPath = data.getData().getPicPath().getPicPath().split(",");
            for (int i = 0; i < picPath.length; i++) {
                AdPageInfo info1 = new AdPageInfo("", BASE_LOCAL_URL + picPath[i], "", i + 1);
                images.add(info1);
            }
            abMain.setInfoList(images)
                    .setImageLoadType(GLIDE)
                    .setUp();
        } catch (NullPointerException e) {

        }
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }
}
