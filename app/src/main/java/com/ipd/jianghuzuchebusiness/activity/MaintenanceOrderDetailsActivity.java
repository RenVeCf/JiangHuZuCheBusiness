package com.ipd.jianghuzuchebusiness.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuchebusiness.R;
import com.ipd.jianghuzuchebusiness.adapter.MaintenanceOrderDetailsAdapter;
import com.ipd.jianghuzuchebusiness.base.BaseActivity;
import com.ipd.jianghuzuchebusiness.bean.GetCarCancelOrderBean;
import com.ipd.jianghuzuchebusiness.bean.GetCarOrderBean;
import com.ipd.jianghuzuchebusiness.bean.RepairCancelBean;
import com.ipd.jianghuzuchebusiness.bean.RepairDetailsBean;
import com.ipd.jianghuzuchebusiness.bean.RepairFinishBean;
import com.ipd.jianghuzuchebusiness.bean.RepairOrderListBean;
import com.ipd.jianghuzuchebusiness.common.view.CircleImageView;
import com.ipd.jianghuzuchebusiness.common.view.TopView;
import com.ipd.jianghuzuchebusiness.contract.MultipleOrderContract;
import com.ipd.jianghuzuchebusiness.presenter.MultipleOrderPresenter;
import com.ipd.jianghuzuchebusiness.utils.ApplicationUtil;
import com.ipd.jianghuzuchebusiness.utils.SPUtil;
import com.ipd.jianghuzuchebusiness.utils.ToastUtil;
import com.ipd.jianghuzuchebusiness.utils.isClickUtil;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Consumer;

import static android.Manifest.permission.CALL_PHONE;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.REQUEST_CODE_104;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.STORE_ID;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.USER_ID;

/**
 * Description ：订单详情（维修）
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/10.
 */
public class MaintenanceOrderDetailsActivity extends BaseActivity<MultipleOrderContract.View, MultipleOrderContract.Presenter> implements MultipleOrderContract.View {

    @BindView(R.id.tv_repair_order_details_top)
    TopView tvRepairOrderDetailsTop;
    @BindView(R.id.iv_user_img)
    CircleImageView ivUserImg;
    @BindView(R.id.tv_user_name)
    TextView tvUserName;
    @BindView(R.id.tv_user_phone)
    TextView tvUserPhone;
    @BindView(R.id.tv_call_phone)
    TextView tvCallPhone;
    @BindView(R.id.tv_project)
    TextView tvProject;
    @BindView(R.id.tv_service)
    TextView tvService;
    @BindView(R.id.tv_use_car_money_sum)
    TextView tvUseCarMoneySum;
    @BindView(R.id.bt_cancel_order)
    Button btCancelOrder;
    @BindView(R.id.bt_repair_finish)
    Button btRepairFinish;
    @BindView(R.id.ll_bottom_two)
    LinearLayout llBottomTwo;
    @BindView(R.id.rv_maintenance_order)
    RecyclerView rvMaintenanceOrder;

    private int orderId;
    private String repairs;
    private String charges;
    private int status;
    private List<RepairDetailsBean.DataBean.CostListBean> costListBean;
    private MaintenanceOrderDetailsAdapter maintenanceOrderDetailsAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_maintenance_order_details;
    }

    @Override
    public MultipleOrderContract.Presenter createPresenter() {
        return new MultipleOrderPresenter(this);
    }

    @Override
    public MultipleOrderContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvRepairOrderDetailsTop);

        orderId = getIntent().getIntExtra("order_id", 0);
        repairs = getIntent().getStringExtra("repairs");
        charges = getIntent().getStringExtra("charges");
        status = getIntent().getIntExtra("status", 0);
        if (status == 4)
            llBottomTwo.setVisibility(View.VISIBLE);
        else
            llBottomTwo.setVisibility(View.GONE);

        // 设置管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMaintenanceOrder.setLayoutManager(layoutManager);
        // 如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        rvMaintenanceOrder.setHasFixedSize(true);
        rvMaintenanceOrder.setItemAnimator(new DefaultItemAnimator());

        costListBean = new ArrayList<>();
        maintenanceOrderDetailsAdapter = new MaintenanceOrderDetailsAdapter(costListBean);
        rvMaintenanceOrder.setAdapter(maintenanceOrderDetailsAdapter);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        TreeMap<String, String> repairFinishMap = new TreeMap<>();
        repairFinishMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
        repairFinishMap.put("orderId", orderId + "");
        repairFinishMap.put("storeId", SPUtil.get(this, STORE_ID, "") + "");
        getPresenter().getRepairDetails(repairFinishMap, true, false);
    }

    private void rxPermissionCall() {
        RxPermissions rxPermissions = new RxPermissions((FragmentActivity) this);
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
        Uri data = Uri.parse("tel:" + "400-806-7299");
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

    private void setCenterDialog() {
        TextView tv;
        final Dialog mCameraDialog = new Dialog(this, R.style.BottomDialog);
        //Dialog布局
        LinearLayout root = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.dialog_center, null);
        root.findViewById(R.id.tv_dialog_center_start).setVisibility(View.VISIBLE);
        tv = root.findViewById(R.id.tv_dialog_center_end);
        tv.setText("400-806-7299");
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
                    TreeMap<String, String> repairFinishMap = new TreeMap<>();
                    repairFinishMap.put("userId", SPUtil.get(MaintenanceOrderDetailsActivity.this, USER_ID, "") + "");
                    repairFinishMap.put("orderId", orderId + "");
                    repairFinishMap.put("storeId", SPUtil.get(MaintenanceOrderDetailsActivity.this, STORE_ID, "") + "");
                    getPresenter().getRepairCancel(repairFinishMap, true, false);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            switch (requestCode) {
                case REQUEST_CODE_104:
                    initData();
                    break;
            }
        }
    }

    @OnClick({R.id.tv_call_phone, R.id.bt_cancel_order, R.id.bt_repair_finish})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_call_phone:
                setCenterDialog();
                break;
            case R.id.bt_cancel_order:
                setDocumentsReceivedDialog();
                break;
            case R.id.bt_repair_finish:
                if (isClickUtil.isFastClick()) {
                    TreeMap<String, String> repairFinishMap = new TreeMap<>();
                    repairFinishMap.put("userId", SPUtil.get(MaintenanceOrderDetailsActivity.this, USER_ID, "") + "");
                    repairFinishMap.put("orderId", orderId + "");
                    repairFinishMap.put("storeId", SPUtil.get(MaintenanceOrderDetailsActivity.this, STORE_ID, "") + "");
                    getPresenter().getRepairFinish(repairFinishMap, true, false);
                }
                break;
        }
    }

    @Override
    public void resultRepairOrderList(RepairOrderListBean data) {

    }

    @Override
    public void resultRepairDetails(RepairDetailsBean data) {
        costListBean.clear();
        costListBean.addAll(data.getData().getCostList());
        maintenanceOrderDetailsAdapter.setNewData(costListBean);

        tvUserName.setText(data.getData().getOrder().getStoreName());
        tvUserPhone.setText(data.getData().getOrder().getTelPhone());
        if (!repairs.equals(""))
            tvProject.setText("项目: " + repairs);
        else
            tvProject.setVisibility(View.GONE);
        if (!charges.equals(""))
            tvService.setText("充电服务: " + charges);
        else
            tvService.setVisibility(View.GONE);

        double money = 0;
        for (int i = 0; i < costListBean.size(); i++) {
            if (!costListBean.get(i).getTitle().equals("优惠券"))
                money += costListBean.get(i).getMoney();
            else
                money -= costListBean.get(i).getMoney();
        }
        tvUseCarMoneySum.setText(money + "元");
    }

    @Override
    public void resultRepairFinish(RepairFinishBean data) {
        ToastUtil.showShortToast(data.getMsg());
        setResult(RESULT_OK, new Intent().putExtra("is_refresh", "1"));
        finish();
    }

    @Override
    public void resultRepairCancel(RepairCancelBean data) {
        ToastUtil.showShortToast(data.getMsg());
        startActivityForResult(new Intent(MaintenanceOrderDetailsActivity.this, FinishTypeActivity.class).putExtra("finish_type", 0), REQUEST_CODE_104);
        finish();
    }

    @Override
    public void resultGetCarOrder(GetCarOrderBean data) {

    }

    @Override
    public void resultCarReturnOrder(GetCarOrderBean data) {

    }

    @Override
    public void resultGetCarCancelOrder(GetCarCancelOrderBean data) {

    }

    @Override
    public void resultReturnCarCancelOrder(GetCarCancelOrderBean data) {

    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }
}
