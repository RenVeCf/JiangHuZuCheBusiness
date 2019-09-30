package com.ipd.jianghuzuchebusiness.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuchebusiness.R;
import com.ipd.jianghuzuchebusiness.adapter.CarPhotoAdapter;
import com.ipd.jianghuzuchebusiness.adapter.ExtendTimeAdapter;
import com.ipd.jianghuzuchebusiness.adapter.VehicleConditionAdapter;
import com.ipd.jianghuzuchebusiness.base.BaseActivity;
import com.ipd.jianghuzuchebusiness.bean.GetCarCancelOrderBean;
import com.ipd.jianghuzuchebusiness.bean.OrderDetailsBean;
import com.ipd.jianghuzuchebusiness.bean.ReturnOrderDescBean;
import com.ipd.jianghuzuchebusiness.bean.SelectCarBean;
import com.ipd.jianghuzuchebusiness.common.view.DividerItemDecoration;
import com.ipd.jianghuzuchebusiness.common.view.TopView;
import com.ipd.jianghuzuchebusiness.contract.OrderDetailsContract;
import com.ipd.jianghuzuchebusiness.presenter.OrderDetailsPresenter;
import com.ipd.jianghuzuchebusiness.utils.ApplicationUtil;
import com.ipd.jianghuzuchebusiness.utils.SPUtil;
import com.ipd.jianghuzuchebusiness.utils.ToastUtil;
import com.ipd.jianghuzuchebusiness.utils.isClickUtil;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.xuexiang.xui.widget.textview.supertextview.SuperTextView;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Consumer;

import static android.Manifest.permission.CALL_PHONE;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.STORE_ID;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.USER_ID;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.BASE_LOCAL_URL;

/**
 * Description ：订单详情
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/10.
 */
public class OrderDetailsActivity extends BaseActivity<OrderDetailsContract.View, OrderDetailsContract.Presenter> implements OrderDetailsContract.View {

    @BindView(R.id.tv_order_details_top)
    TopView tvOrderDetailsTop;
    @BindView(R.id.iv_order_details)
    ImageView ivOrderDetails;
    @BindView(R.id.tv_car_name)
    TextView tvCarName;
    @BindView(R.id.tv_car_model)
    TextView tvCarModel;
    //    @BindView(R.id.tv_store_name)
    //    TextView tvStoreName;
    //    @BindView(R.id.tv_store_path)
    //    TextView tvStorePath;
    //    @BindView(R.id.tv_get_car_time)
    //    TextView tvGetCarTime;
    @BindView(R.id.stv_contact)
    SuperTextView stvContact;
    @BindView(R.id.tv_use_car_time)
    TextView tvUseCarTime;
    @BindView(R.id.tv_use_car_service_time)
    TextView tvUseCarServiceTime;
    @BindView(R.id.tv_use_car_service_charge)
    TextView tvUseCarServiceCharge;
    @BindView(R.id.tv_use_car_equipment_cost)
    TextView tvUseCarEquipmentCost;
    @BindView(R.id.tv_use_car_deposit)
    TextView tvUseCarDeposit;
    @BindView(R.id.tv_use_car_coupon_name)
    TextView tvUseCarCouponName;
    @BindView(R.id.tv_use_car_coupon_money)
    TextView tvUseCarCouponMoney;
    @BindView(R.id.tv_use_car_money_sum)
    TextView tvUseCarMoneySum;
    @BindView(R.id.tv_use_car_money_type)
    TextView tvUseCarMoneyType;
    @BindView(R.id.tv_overdue_fee)
    TextView tvOverdueFee;
    @BindView(R.id.ll_overdue_fee)
    LinearLayout llOverdueFee;
    @BindView(R.id.tv_refund_sum)
    TextView tvRefundSum;
    @BindView(R.id.ll_refund)
    LinearLayout llRefund;
    @BindView(R.id.ll_car_contract)
    LinearLayout llCarContract;
    @BindView(R.id.ll_car_status)
    LinearLayout llCarStatus;
    @BindView(R.id.bt_cancel_order_one)
    Button btCancelOrderOne;
    @BindView(R.id.ll_bottom_one)
    LinearLayout llBottomOne;
    @BindView(R.id.bt_cancel_order)
    Button btCancelOrder;
    @BindView(R.id.bt_select_order)
    Button btSelectOrder;
    @BindView(R.id.ll_bottom_two)
    LinearLayout llBottomTwo;
    @BindView(R.id.tv_end_time)
    TextView tvEndTime;
    @BindView(R.id.ll_end_time)
    LinearLayout llEndTime;
    @BindView(R.id.rv_order_details)
    RecyclerView rvOrderDetails;
    @BindView(R.id.rv_car_photo)
    RecyclerView rvCarPhoto;
    @BindView(R.id.tv_car_code)
    TextView tvCarCode;
    @BindView(R.id.ll_car_code)
    LinearLayout llCarCode;
    @BindView(R.id.view_car_code)
    View viewCarCode;
    @BindView(R.id.rv_extended_fee)
    RecyclerView rvExtendedFee;
    @BindView(R.id.ll_extended_fee)
    LinearLayout llExtendedFee;
    @BindView(R.id.ll_default_fee)
    LinearLayout llDefaultFee;
    @BindView(R.id.tv_default_fee)
    TextView tvDefaultFee;

    private int type;
    private String orderId;
    private int statusGet;
    private int statusOut;
    private int status;
    private List<SelectCarBean.DataBean.VehicleOrstatusBean> vehicleOrstatusBean;
    private List<OrderDetailsBean.DataBean.VehicleOrstatusBean> orderDetailsBean;
    private List<ReturnOrderDescBean.DataBean.VehicleOrstatusBean> returnOrderDescBean;
    private OrderDetailsBean.DataBean.PicPathBean picPathBean;
    private VehicleConditionAdapter vehicleConditionAdapter;
    private CarPhotoAdapter carPhotoAdapter;
    private List<String> imgList;
    private List<OrderDetailsBean.DataBean.VehicleEndcostBean> vehicleEndcostBean = new ArrayList<>();
    private ExtendTimeAdapter extendTimeAdapter;
    private String phoneNum = "";

    @Override
    public int getLayoutId() {
        return R.layout.activity_order_details;
    }

    @Override
    public OrderDetailsContract.Presenter createPresenter() {
        return new OrderDetailsPresenter(this);
    }

    @Override
    public OrderDetailsContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvOrderDetailsTop);

        type = getIntent().getIntExtra("type", 0);
        orderId = getIntent().getStringExtra("order_id");
        statusGet = getIntent().getIntExtra("status_get", 0);
        statusOut = getIntent().getIntExtra("status_out", 0);
        status = getIntent().getIntExtra("status", 0);

        switch (type) {
            case 0:
                tvUseCarMoneyType.setText("已支付");
                btCancelOrder.setText("取消订单");
                if (statusGet == 1) {
                    llCarCode.setVisibility(View.GONE);
                    viewCarCode.setVisibility(View.GONE);
                    btSelectOrder.setText("填写取车单");
                } else if (statusGet == 2)
                    btSelectOrder.setText("查看车辆");
                if (status == 5 || status == 7 || status == 2) {
                    llBottomTwo.setVisibility(View.GONE);
                }
                break;
            case 1:
                tvUseCarMoneyType.setText("已支付");
                btCancelOrder.setText("取消订单");
                if (statusOut == 1)
                    btSelectOrder.setText("填写退车单");
                else if (statusOut == 2)
                    btSelectOrder.setText("查看车辆");
                if (status == 8 || status == 7 || status == 2) {
                    llBottomTwo.setVisibility(View.GONE);
                }
                break;
        }

        // 设置管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvOrderDetails.setLayoutManager(layoutManager);
        rvOrderDetails.setNestedScrollingEnabled(false);
        // 如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        rvOrderDetails.setHasFixedSize(true);
        rvOrderDetails.setItemAnimator(new DefaultItemAnimator());

        GridLayoutManager NotUseList = new GridLayoutManager(this, 4);
        rvCarPhoto.setLayoutManager(NotUseList);
        rvCarPhoto.addItemDecoration(new DividerItemDecoration(this));
        rvCarPhoto.setNestedScrollingEnabled(false);
        rvCarPhoto.setHasFixedSize(true); //item如果一样的大小，可以设置为true让RecyclerView避免重新计算大小
        rvCarPhoto.setItemAnimator(new DefaultItemAnimator()); //默认动画

        returnOrderDescBean = new ArrayList<>();
        orderDetailsBean = new ArrayList<>();
        vehicleOrstatusBean = new ArrayList<>();
        picPathBean = new OrderDetailsBean.DataBean.PicPathBean();
        vehicleConditionAdapter = new VehicleConditionAdapter(vehicleOrstatusBean, type + 1);
        rvOrderDetails.setAdapter(vehicleConditionAdapter);

        imgList = new ArrayList<>();
        carPhotoAdapter = new CarPhotoAdapter(imgList);
        rvCarPhoto.setAdapter(carPhotoAdapter);

        // 延长租期
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this);
        layoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
        rvExtendedFee.setLayoutManager(layoutManager1);
        rvExtendedFee.setNestedScrollingEnabled(false);
        rvExtendedFee.setHasFixedSize(true);
        rvExtendedFee.setItemAnimator(new DefaultItemAnimator());

        extendTimeAdapter = new ExtendTimeAdapter(vehicleEndcostBean);
        rvExtendedFee.setAdapter(extendTimeAdapter);
    }

    @Override
    public void initListener() {
        carPhotoAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                BigImageActivity.launch(OrderDetailsActivity.this, imgList.get(position));
            }
        });

        stvContact.setRightTvClickListener(new SuperTextView.OnRightTvClickListener() {
            @Override
            public void onClickListener() {
                setCenterDialog();
            }
        });
    }

    private void rxPermissionCall() {
        RxPermissions rxPermissions = new RxPermissions((FragmentActivity)this);
        rxPermissions.request(CALL_PHONE).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean granted) throws Exception {
                if (granted) {
                    callPhone();
                } else {
                    // 权限被拒绝
                    ToastUtil.showLongToast("权限被拒绝");
                }
            }
        });
    }

    //打电话
    private void callPhone() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + phoneNum);
        intent.setData(data);
        if (ActivityCompat.checkSelfPermission(this, CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intent);
    }

    //拨打电话
    private void setCenterDialog() {
        TextView tv;
        final Dialog mCameraDialog = new Dialog(this, R.style.BottomDialog);
        //Dialog布局
        LinearLayout root = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.dialog_center, null);
        root.findViewById(R.id.tv_dialog_center_start).setVisibility(View.VISIBLE);
        tv = root.findViewById(R.id.tv_dialog_center_end);
        tv.setText(phoneNum);
        //初始化视图
        root.findViewById(R.id.dialog_center_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rxPermissionCall();
                mCameraDialog.dismiss();
            }
        });
        root.findViewById(R.id.dialog_center_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCameraDialog.dismiss();
            }
        });
        mCameraDialog.setContentView(root);
        Window dialogWindow = mCameraDialog.getWindow();
        dialogWindow.setGravity(Gravity.CENTER); //设置弹出方式
        WindowManager.LayoutParams lp = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        lp.x = 0; // 新位置X坐标
        lp.y = 0; // 新位置Y坐标
        lp.width = 700;
        root.measure(0, 0);
        lp.height = 320;

        lp.alpha = 9f; // 透明度
        dialogWindow.setAttributes(lp);
        mCameraDialog.show();
    }

    @Override
    public void initData() {
        switch (type) {
            case 0:
                TreeMap<String, String> getCarOrderMap = new TreeMap<>();
                getCarOrderMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
                getCarOrderMap.put("orderId", orderId);
                getCarOrderMap.put("storeId", SPUtil.get(this, STORE_ID, "") + "");
                getPresenter().getOrderDetails(getCarOrderMap, false, false);
                break;
            case 1:
                TreeMap<String, String> returnOrderDescMap = new TreeMap<>();
                returnOrderDescMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
                returnOrderDescMap.put("orderId", orderId);
                returnOrderDescMap.put("storeId", SPUtil.get(this, STORE_ID, "") + "");
                getPresenter().getReturnOrderDesc(returnOrderDescMap, false, false);
                break;
        }
    }

    private void setDocumentsReceivedDialog() {
        final TextView tv;
        final Dialog mCameraDialog = new Dialog(this, R.style.BottomDialog);
        //Dialog布局
        LinearLayout root = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.dialog_center, null);
        tv = root.findViewById(R.id.tv_dialog_center_end);
        tv.setText("是否取消订单？");

        //初始化视图
        root.findViewById(R.id.dialog_center_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClickUtil.isFastClick()) {

                    switch (type) {
                        case 0:
                            TreeMap<String, String> getCarOrderMap = new TreeMap<>();
                            getCarOrderMap.put("userId", SPUtil.get(OrderDetailsActivity.this, USER_ID, "") + "");
                            getCarOrderMap.put("orderId", orderId);
                            getCarOrderMap.put("storeId", SPUtil.get(OrderDetailsActivity.this, STORE_ID, "") + "");
                            getPresenter().getGetCarCancelOrder(getCarOrderMap, false, false);
                            break;
                        case 1:
                            TreeMap<String, String> returnCarCancelOrderMap = new TreeMap<>();
                            returnCarCancelOrderMap.put("userId", SPUtil.get(OrderDetailsActivity.this, USER_ID, "") + "");
                            returnCarCancelOrderMap.put("orderId", orderId);
                            returnCarCancelOrderMap.put("storeId", SPUtil.get(OrderDetailsActivity.this, STORE_ID, "") + "");
                            getPresenter().getReturnCarCancelOrder(returnCarCancelOrderMap, false, false);
                            break;
                    }
                    mCameraDialog.dismiss();
                }
            }
        });

        root.findViewById(R.id.dialog_center_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCameraDialog.dismiss();
            }
        });
        mCameraDialog.setContentView(root);
        Window dialogWindow = mCameraDialog.getWindow();
        dialogWindow.setGravity(Gravity.CENTER); //设置弹出方式
        WindowManager.LayoutParams lp = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        lp.x = 0; // 新位置X坐标
        lp.y = 0; // 新位置Y坐标
        lp.width = 700;
        root.measure(0, 0);
        lp.height = 320;

        lp.alpha = 9f; // 透明度
        dialogWindow.setAttributes(lp);
        mCameraDialog.show();
    }

    @OnClick({R.id.ll_car_contract, R.id.bt_cancel_order_one, R.id.bt_cancel_order, R.id.bt_select_order})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_car_contract:
                startActivity(new Intent(this, WebViewActivity.class).putExtra("h5Type", 2));
                break;
            case R.id.bt_cancel_order_one:
                //FIXME
                break;
            case R.id.bt_cancel_order:
                setDocumentsReceivedDialog();
                break;
            case R.id.bt_select_order:
                if (isClickUtil.isFastClick()) {
                    switch (type) {
                        case 0:
                            if (statusGet == 2)
                                startActivity(new Intent(this, SelectCarActivity.class).putExtra("order_id", orderId).putExtra("vehicleType", 1));
                            else {
                                startActivity(new Intent(this, FillInPaperActivity.class).putExtra("order_id", orderId).putExtra("paper_type", type));
                                setResult(RESULT_OK, new Intent()
                                        .putExtra("get_car_result", "1"));
                                finish();
                            }
                            break;
                        case 1:
                            if (statusOut == 2)
                                startActivity(new Intent(this, SelectCarActivity.class).putExtra("order_id", orderId).putExtra("vehicleType", 2));
                            else {
                                startActivity(new Intent(this, FillInPaperActivity.class).putExtra("order_id", orderId).putExtra("paper_type", type));
                                setResult(RESULT_OK, new Intent()
                                        .putExtra("get_car_result", "1"));
                                finish();
                            }
                            break;
                    }
                }
                break;
        }
    }

    @Override
    public void resultOrderDetails(OrderDetailsBean data) {
        orderDetailsBean.clear();
        orderDetailsBean.addAll(data.getData().getVehicleOrstatus());
        Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + data.getData().getOrder().getVehicleLogo()).apply(new RequestOptions().placeholder(R.mipmap.ic_launcher)).into(ivOrderDetails);
        tvCarName.setText(data.getData().getOrder().getVehicleName());
        tvCarModel.setText(data.getData().getOrder().getVehicleModel());
        //        tvStoreName.setText(data.getData().getOrder().getStoreName());
        //        tvStorePath.setText(data.getData().getOrder().getDescAddress());
        //        tvGetCarTime.setText(data.getData().getOrder().getTakevehicleTime() + "（" + data.getData().getOrder().getWeek() + "）");
        Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + data.getData().getUser().getAvatar()).apply(new RequestOptions()).into(stvContact.getLeftIconIV());
        stvContact.setLeftTopString(data.getData().getUser().getUserName())
                .setLeftBottomString(data.getData().getUser().getTelPhone());
        phoneNum = data.getData().getUser().getTelPhone();
        tvUseCarTime.setText(data.getData().getOrder().getRentDuration() + "个月");
        tvEndTime.setText(data.getData().getOrder().getExpireTime());

        tvUseCarServiceTime.setText(data.getData().getVehicleCost().get(0).getRentDuration() + "x" + data.getData().getVehicleCost().get(0).getVehicleRent());
        tvUseCarServiceCharge.setText(data.getData().getVehicleCost().get(0).getTenancyService() + "元");
        tvUseCarEquipmentCost.setText(data.getData().getVehicleCost().get(0).getEquipCost() + "元");
        tvUseCarDeposit.setText(data.getData().getVehicleCost().get(0).getDeposit() + "元");
        tvUseCarCouponName.setText(data.getData().getVehicleCost().get(0).getCouponTitle());
        tvUseCarCouponMoney.setText(data.getData().getVehicleCost().get(0).getCoupon() + "元");
        tvUseCarMoneySum.setText(data.getData().getVehicleCost().get(0).getTotal() + "元");

        vehicleEndcostBean.clear();
        if (data.getData().getVehicleEndcost().size() > 0) {
            llExtendedFee.setVisibility(View.VISIBLE);
            vehicleEndcostBean.addAll(data.getData().getVehicleEndcost());
            for (int i = 0; i < vehicleEndcostBean.size(); i++) {
                vehicleEndcostBean.get(i).setVehicleRent(data.getData().getVehicleCost().get(0).getVehicleRent());
            }
            extendTimeAdapter.setNewData(vehicleEndcostBean);
        }

        if (status == 7) {
            llOverdueFee.setVisibility(View.VISIBLE);
            llDefaultFee.setVisibility(View.VISIBLE);
            tvOverdueFee.setText(data.getData().getVehicleCost().get(0).getOverdueMoney() + "元");
            tvDefaultFee.setText(data.getData().getVehicleCost().get(0).getDefaultMoney() + "元");
        }

        if (orderDetailsBean.size() > 0) {
            llCarStatus.setVisibility(View.VISIBLE);
            for (int i = 0; i < orderDetailsBean.size(); i++) {
                vehicleOrstatusBean.add(new SelectCarBean.DataBean.VehicleOrstatusBean());
                vehicleOrstatusBean.get(i).setVestatusName(orderDetailsBean.get(i).getVestatusName());
                vehicleOrstatusBean.get(i).setStatus(orderDetailsBean.get(i).getStatus());
                vehicleOrstatusBean.get(i).setVehicleType(1);//取车单
            }
            vehicleConditionAdapter.setNewData(vehicleOrstatusBean);

            picPathBean = data.getData().getPicPath();
            tvCarCode.setText(picPathBean.getPlateNumber());
            String[] strs = picPathBean.getPicPath().split(",");
            for (int i = 0, len = strs.length; i < len; i++) {
                imgList.add(strs[i].toString());
            }
            carPhotoAdapter.setNewData(imgList);
        }
    }

    @Override
    public void resultGetCarCancelOrder(GetCarCancelOrderBean data) {
        ToastUtil.showLongToast(data.getMsg());
        startActivity(new Intent(OrderDetailsActivity.this, FinishTypeActivity.class).putExtra("finish_type", 0));
        setResult(RESULT_OK, new Intent()
                .putExtra("get_car_result", "1"));
        finish();
    }

    @Override
    public void resultReturnOrderDesc(ReturnOrderDescBean data) {
        returnOrderDescBean.clear();
        returnOrderDescBean.addAll(data.getData().getVehicleOrstatus());
        Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + data.getData().getOrder().getVehicleLogo()).apply(new RequestOptions().placeholder(R.mipmap.ic_launcher)).into(ivOrderDetails);
        tvCarName.setText(data.getData().getOrder().getVehicleName());
        tvCarModel.setText(data.getData().getOrder().getVehicleModel());
        //        tvStoreName.setText(data.getData().getOrder().getStoreName());
        //        tvStorePath.setText(data.getData().getOrder().getDescAddress());
        //        tvGetCarTime.setText(data.getData().getOrder().getTakevehicleTime() + "（" + data.getData().getOrder().getWeek() + "）");
        Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + data.getData().getUser().getAvatar()).apply(new RequestOptions()).into(stvContact.getLeftIconIV());
        stvContact.setLeftTopString(data.getData().getUser().getUserName())
                .setLeftBottomString(data.getData().getUser().getTelPhone());
        phoneNum = data.getData().getUser().getTelPhone();
        tvUseCarTime.setText(data.getData().getOrder().getRentDuration() + "个月");
        tvEndTime.setText(data.getData().getOrder().getExpireTime());

        tvUseCarServiceTime.setText(data.getData().getOrder().getRentDuration() + "x" + data.getData().getVehicleCost().getVehicleRent());
        tvUseCarServiceCharge.setText(data.getData().getVehicleCost().getTenancyService() + "元");
        tvUseCarEquipmentCost.setText(data.getData().getVehicleCost().getEquipCost() + "元");
        tvUseCarDeposit.setText(data.getData().getVehicleCost().getDeposit() + "元");
        tvUseCarCouponMoney.setText(data.getData().getVehicleCost().getCoupon() + "元");
        tvUseCarMoneySum.setText(data.getData().getVehicleCost().getTotal() + "元");
        tvCarCode.setText(data.getData().getVehiclePic().getPlateNumber());

        if (returnOrderDescBean.size() > 0) {
            llCarStatus.setVisibility(View.VISIBLE);
            llOverdueFee.setVisibility(View.VISIBLE);
            llDefaultFee.setVisibility(View.VISIBLE);
            tvOverdueFee.setText(data.getData().getVehicleCost().getOverdueMoney() + "元");
            tvDefaultFee.setText(data.getData().getVehicleCost().getDefaultMoney() + "元");
            for (int i = 0; i < returnOrderDescBean.size(); i++) {
                vehicleOrstatusBean.add(new SelectCarBean.DataBean.VehicleOrstatusBean());
                vehicleOrstatusBean.get(i).setVestatusName(returnOrderDescBean.get(i).getVestatusName());
                vehicleOrstatusBean.get(i).setStatus(returnOrderDescBean.get(i).getStatus());
                vehicleOrstatusBean.get(i).setDamagedCost(returnOrderDescBean.get(i).getDamagedCost());
                vehicleOrstatusBean.get(i).setVehicleType(2);//退车单
            }
            vehicleConditionAdapter.setNewData(vehicleOrstatusBean);

            String[] strs = data.getData().getVehiclePic().getPicPath().split(",");
            for (int i = 0, len = strs.length; i < len; i++) {
                imgList.add(strs[i].toString());
            }
            carPhotoAdapter.setNewData(imgList);
        }
    }

    @Override
    public void resultReturnCarCancelOrder(GetCarCancelOrderBean data) {
        ToastUtil.showLongToast(data.getMsg());
        startActivity(new Intent(OrderDetailsActivity.this, FinishTypeActivity.class).putExtra("finish_type", 0));
        setResult(RESULT_OK, new Intent()
                .putExtra("get_car_result", "1"));
        finish();
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }
}