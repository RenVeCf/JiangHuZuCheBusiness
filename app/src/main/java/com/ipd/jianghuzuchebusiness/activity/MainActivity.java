package com.ipd.jianghuzuchebusiness.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
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
import com.ipd.jianghuzuchebusiness.utils.BDLocationUtils;
import com.ipd.jianghuzuchebusiness.utils.SPUtil;
import com.ipd.jianghuzuchebusiness.utils.ToastUtil;
import com.xuexiang.xui.widget.banner.widget.banner.BannerItem;
import com.xuexiang.xui.widget.banner.widget.banner.SimpleImageBanner;
import com.xuexiang.xui.widget.banner.widget.banner.base.BaseBanner;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;
import io.reactivex.ObservableTransformer;

import static com.ipd.jianghuzuchebusiness.common.config.IConstants.FIRST_APP;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.JPUSH_SEQUENCE;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.STORE_ID;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.BASE_LOCAL_URL;

/**
 * Description ：首页
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/10.
 */
public class MainActivity extends BaseActivity<StoreImgContract.View, StoreImgContract.Presenter> implements StoreImgContract.View {

    @BindView(R.id.tv_main_top)
    TopView tvMainTop;
    @BindView(R.id.sib_main)
    SimpleImageBanner sibMain;
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

    private List<BannerItem> images;
    private long firstTime = 0;
    private static final int PERMISSIONS_REQUEST_CODE = 1003;
    //定位相关
    BDLocationUtils bdLocationUtils;

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

        SPUtil.put(this, FIRST_APP, false);

        requestPermission();
        bdLocationUtils = new BDLocationUtils(this);
        images = new ArrayList<>();
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        bdLocationUtils.doLocation();//开启定位
        bdLocationUtils.mLocationClient.start();//开始定位

        TreeMap<String, String> returnCarMap = new TreeMap<>();
        returnCarMap.put("storeId", SPUtil.get(this, STORE_ID, "") + "");
        getPresenter().getStoreImg(returnCarMap, true, false);
    }

    /**
     * 检查支付宝 SDK 所需的权限，并在必要的时候动态获取。
     * 在 targetSDK = 23 以上，READ_PHONE_STATE 和 WRITE_EXTERNAL_STORAGE 权限需要应用在运行时获取。
     * 如果接入支付宝 SDK 的应用 targetSdk 在 23 以下，可以省略这个步骤。
     */
    private void requestPermission() {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION
                    }, PERMISSIONS_REQUEST_CODE);
        }
    }

    /**
     * 权限获取回调
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST_CODE:
                // 用户取消了权限弹窗
                if (grantResults.length == 0) {
                    ToastUtil.showShortToast(getString(R.string.permission_rejected));
                    return;
                }

                // 用户拒绝了某些权限
                for (int x : grantResults) {
                    if (x == PackageManager.PERMISSION_DENIED) {
                        ToastUtil.showShortToast(getString(R.string.permission_rejected));
                        return;
                    }
                }

                // 所需的权限均正常获取
//                ToastUtil.showShortToast(getString(R.string.permission_granted));
                break;
        }
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
        String[] picPath = data.getData().getPicPath().getPicPath().split(",");
        for (int i = 0; i < picPath.length; i++) {
            BannerItem info1 = new BannerItem();
            info1.setImgUrl(BASE_LOCAL_URL + picPath[i]);
            images.add(info1);
        }
        sibMain.setSource(images)
                .setOnItemClickL(new BaseBanner.OnItemClickL() {
                    @Override
                    public void onItemClick(int position) {
//                        ToastUtil.showShortToast("position--->" + position);
                    }
                })
                .setIsOnePageLoop(false).startScroll();
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }
}
