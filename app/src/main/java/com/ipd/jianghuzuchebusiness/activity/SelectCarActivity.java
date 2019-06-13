package com.ipd.jianghuzuchebusiness.activity;

import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuchebusiness.R;
import com.ipd.jianghuzuchebusiness.adapter.CarPhotoAdapter;
import com.ipd.jianghuzuchebusiness.adapter.VehicleConditionAdapter;
import com.ipd.jianghuzuchebusiness.base.BaseActivity;
import com.ipd.jianghuzuchebusiness.bean.SelectCarBean;
import com.ipd.jianghuzuchebusiness.common.view.DividerItemDecoration;
import com.ipd.jianghuzuchebusiness.common.view.TopView;
import com.ipd.jianghuzuchebusiness.contract.SelectCarContract;
import com.ipd.jianghuzuchebusiness.presenter.SelectCarPresenter;
import com.ipd.jianghuzuchebusiness.utils.ApplicationUtil;
import com.ipd.jianghuzuchebusiness.utils.SPUtil;
import com.ipd.jianghuzuchebusiness.utils.isClickUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;

import static com.ipd.jianghuzuchebusiness.common.config.IConstants.USER_ID;

/**
 * Description ：查看车辆
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/13.
 */
public class SelectCarActivity extends BaseActivity<SelectCarContract.View, SelectCarContract.Presenter> implements SelectCarContract.View {
    @BindView(R.id.tv_select_car_top)
    TopView tvSelectCarTop;
    @BindView(R.id.rv_select_car)
    RecyclerView rvSelectCar;
    @BindView(R.id.ll_car_contract)
    LinearLayout llCarContract;
    @BindView(R.id.rv_car_photo)
    RecyclerView rvCarPhoto;
    @BindView(R.id.tv_car_code)
    TextView tvCarCode;

    private VehicleConditionAdapter vehicleConditionAdapter;
    private CarPhotoAdapter carPhotoAdapter;
    private List<SelectCarBean.DataBean.VehicleOrstatusBean> vehicleOrstatusBean;
    private SelectCarBean.DataBean.VehiclePicBean vehiclePicBean;
    private List<String> imgList;
    private String orderId;
    private int vehicleType;

    @Override
    public int getLayoutId() {
        return R.layout.activity_select_car;
    }

    @Override
    public SelectCarContract.Presenter createPresenter() {
        return new SelectCarPresenter(this);
    }

    @Override
    public SelectCarContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvSelectCarTop);

        // 设置管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvSelectCar.setLayoutManager(layoutManager);
        rvSelectCar.setNestedScrollingEnabled(false);
        // 如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        rvSelectCar.setHasFixedSize(true);
        rvSelectCar.setItemAnimator(new DefaultItemAnimator());

        GridLayoutManager NotUseList = new GridLayoutManager(this, 4);
        rvCarPhoto.setLayoutManager(NotUseList);
        rvCarPhoto.addItemDecoration(new DividerItemDecoration(this));
        rvCarPhoto.setNestedScrollingEnabled(false);
        rvCarPhoto.setHasFixedSize(true); //item如果一样的大小，可以设置为true让RecyclerView避免重新计算大小
        rvCarPhoto.setItemAnimator(new DefaultItemAnimator()); //默认动画

        orderId = getIntent().getStringExtra("order_id");
        vehicleType = getIntent().getIntExtra("vehicleType", 0);
        vehicleOrstatusBean = new ArrayList<>();
        vehiclePicBean = new SelectCarBean.DataBean.VehiclePicBean();

        vehicleConditionAdapter = new VehicleConditionAdapter(vehicleOrstatusBean, vehicleType);
        rvSelectCar.setAdapter(vehicleConditionAdapter);

        imgList = new ArrayList<>();
        carPhotoAdapter = new CarPhotoAdapter(imgList);
        rvCarPhoto.setAdapter(carPhotoAdapter);
    }

    @Override
    public void initListener() {
        carPhotoAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                BigImageActivity.launch(SelectCarActivity.this, imgList.get(position));
            }
        });
    }

    @Override
    public void initData() {
        TreeMap<String, String> unpaidCancelOrderMap = new TreeMap<>();
        unpaidCancelOrderMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
        unpaidCancelOrderMap.put("orderId", orderId);
        getPresenter().getSelectCar(unpaidCancelOrderMap, false, false);
    }

    @Override
    public void resultSelectCar(SelectCarBean data) {
        vehicleOrstatusBean.clear();
        vehicleOrstatusBean.addAll(data.getData().getVehicleOrstatus());
        vehicleConditionAdapter.setNewData(vehicleOrstatusBean);
        if (data.getData().getVehicleOrstatus().size() <= 0) {
//            //空数据时的页面
//            setContentView(R.layout.null_select_car);
//
//            TopView tvNullSelectCarTop = findViewById(R.id.tv_null_select_car_top);
//            //防止状态栏和标题重叠
//            ImmersionBar.setTitleBar(this, tvNullSelectCarTop);
        } else {
            vehiclePicBean = data.getData().getVehiclePic();
            tvCarCode.setText(vehiclePicBean.getPlateNumber());
            String[] strs = vehiclePicBean.getPicPath().split(",");
            for (int i = 0, len = strs.length; i < len; i++) {
                imgList.add(strs[i].toString());
            }
            carPhotoAdapter.setNewData(imgList);
        }
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }

    @OnClick(R.id.ll_car_contract)
    public void onViewClicked() {
        startActivity(new Intent(this, WebViewActivity.class).putExtra("h5Type", 2));
    }
}
