package com.ipd.jianghuzuchebusiness.fragment;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.ipd.jianghuzuchebusiness.R;
import com.ipd.jianghuzuchebusiness.activity.FillInPaperActivity;
import com.ipd.jianghuzuchebusiness.activity.FinishTypeActivity;
import com.ipd.jianghuzuchebusiness.activity.MaintenanceOrderDetailsActivity;
import com.ipd.jianghuzuchebusiness.activity.OrderDetailsActivity;
import com.ipd.jianghuzuchebusiness.activity.SelectCarActivity;
import com.ipd.jianghuzuchebusiness.activity.StoreInforActivity;
import com.ipd.jianghuzuchebusiness.adapter.GetCarHistoryOrderAdapter;
import com.ipd.jianghuzuchebusiness.adapter.MultipleOrderAdapter;
import com.ipd.jianghuzuchebusiness.adapter.RepairOrderAdapter;
import com.ipd.jianghuzuchebusiness.adapter.ReturnCarAdapter;
import com.ipd.jianghuzuchebusiness.adapter.StoreInfoRepairAdapter;
import com.ipd.jianghuzuchebusiness.base.BaseFragment;
import com.ipd.jianghuzuchebusiness.bean.GetCarCancelOrderBean;
import com.ipd.jianghuzuchebusiness.bean.GetCarOrderBean;
import com.ipd.jianghuzuchebusiness.bean.RepairCancelBean;
import com.ipd.jianghuzuchebusiness.bean.RepairDetailsBean;
import com.ipd.jianghuzuchebusiness.bean.RepairFinishBean;
import com.ipd.jianghuzuchebusiness.bean.RepairOrderListBean;
import com.ipd.jianghuzuchebusiness.bean.RepairProjectHorizontalBean;
import com.ipd.jianghuzuchebusiness.bean.VehicleConditionHorizontalBean;
import com.ipd.jianghuzuchebusiness.common.view.DividerItemDecoration;
import com.ipd.jianghuzuchebusiness.contract.MultipleOrderContract;
import com.ipd.jianghuzuchebusiness.presenter.MultipleOrderPresenter;
import com.ipd.jianghuzuchebusiness.utils.SPUtil;
import com.ipd.jianghuzuchebusiness.utils.ToastUtil;
import com.ipd.jianghuzuchebusiness.utils.isClickUtil;
import com.trello.rxlifecycle2.android.FragmentEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;
import io.reactivex.ObservableTransformer;

import static com.ipd.jianghuzuchebusiness.common.config.IConstants.REQUEST_CODE_101;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.REQUEST_CODE_96;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.REQUEST_CODE_97;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.REQUEST_CODE_98;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.STORE_ID;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.USER_ID;

/**
 * Description ：车辆状况/历史/维保
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/10.
 */
public class MultipleOrderFragment extends BaseFragment<MultipleOrderContract.View, MultipleOrderContract.Presenter> implements MultipleOrderContract.View, BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.rv_multiple_order)
    RecyclerView rvMultipleOrder;
    @BindView(R.id.view_line)
    View viewLine;
    @BindView(R.id.srl_multiple_order)
    SwipeRefreshLayout srlMultipleOrder;

    private RepairOrderAdapter repairOrderAdapter;
    private List<RepairOrderListBean.DataBean.OrderListBean> repairOrderListBean;
    private GetCarHistoryOrderAdapter getCarHistoryOrderAdapter;
    private List<GetCarOrderBean.DataBean.OrderListBean> getCarOrderBean;
    private MultipleOrderAdapter multipleOrderAdapter;
    private StoreInfoRepairAdapter storeInfoRepairAdapter;
    private ReturnCarAdapter returnCarAdapter;
    private List<RepairProjectHorizontalBean.DataBean.RepairTypeBean> repairTypeBean = new ArrayList<>();
    private List<VehicleConditionHorizontalBean.DataBean.VehicleTypeBean> vehicleTypeBean = new ArrayList<>();
    private List<VehicleConditionHorizontalBean.DataBean.VehicleTypeBean.AppVehicleStatusBean> appVehicleStatusBean = new ArrayList<>();
    private int multipleFmType;
    private int statusPosition;
    private RadioButton rbStart;
    private RadioButton rbEnd;
    private int page;
    private String content = "";
    private int positions = 0;
    private int storeInfor_positions = 0;
    private int paperType = 0;
    private StoreInforActivity storeInforActivity;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_multiple_order;
    }

    @Override
    public MultipleOrderContract.Presenter createPresenter() {
        return new MultipleOrderPresenter(mContext);
    }

    @Override
    public MultipleOrderContract.View createView() {
        return this;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(getActivity());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.ipd.action");
        BroadcastReceiver mItemViewListClickReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                positions = intent.getIntExtra("positions", 0);
                content = intent.getStringExtra("content");
                onRefresh();
            }
        };
        broadcastManager.registerReceiver(mItemViewListClickReceiver, intentFilter);
    }

    @Override
    public void init(View view) {
        Bundle args = getArguments();
        if (args != null) {
            multipleFmType = args.getInt("multiple_fm_type");
            statusPosition = args.getInt("status_position");
            vehicleTypeBean = args.getParcelableArrayList("vehicle_type");
            repairTypeBean = args.getParcelableArrayList("store_infor");
            paperType = args.getInt("paper_type");
            storeInfor_positions = args.getInt("storeInfor_positions");
        }
        srlMultipleOrder.setOnRefreshListener(this);
        if (multipleFmType != 3 || multipleFmType != 4)
            viewLine.setVisibility(View.GONE);
        if (multipleFmType == 4) {
            GridLayoutManager NotUseList = new GridLayoutManager(getActivity(), 4);
            rvMultipleOrder.setLayoutManager(NotUseList);
            rvMultipleOrder.addItemDecoration(new DividerItemDecoration(getActivity()));
            rvMultipleOrder.setNestedScrollingEnabled(false);
            rvMultipleOrder.setHasFixedSize(true); //item如果一样的大小，可以设置为true让RecyclerView避免重新计算大小
            rvMultipleOrder.setItemAnimator(new DefaultItemAnimator()); //默认动画

            //            vehicleTypeBean = new ArrayList<>();
            //            for (int i = 0; i < repairTypeBean.size(); i++) {
            //                int m = 0;
            //                for (int j = 0; j < statusPosition + 1; j++) {
            //                    vehicleTypeBean.add(new VehicleConditionHorizontalBean.DataBean.VehicleTypeBean());
            //                }
            //                vehicleTypeBean.get(statusPosition).setAppVehicleStatus(appVehicleStatusBean);
            //                appVehicleStatusBean.add(new VehicleConditionHorizontalBean.DataBean.VehicleTypeBean.AppVehicleStatusBean());
            //                vehicleTypeBean.get(statusPosition).getAppVehicleStatus().get(i).setItemType(multipleFmType);
            //                if (repairTypeBean.get(statusPosition).getAppRepairs().size() > 0 && repairTypeBean.get(statusPosition).getAppRepairs().size() > i) {
            //                    vehicleTypeBean.get(statusPosition).getAppVehicleStatus().get(i).setStatusName(repairTypeBean.get(statusPosition).getAppRepairs().get(i).getRepairName());
            //                    m++;
            //                }
            //            }
            //            LogUtils.i("rmy", "size = " + vehicleTypeBean.get(statusPosition).getAppVehicleStatus().size());
            //            multipleOrderAdapter = new MultipleOrderAdapter(vehicleTypeBean.get(statusPosition).getAppVehicleStatus());
            //            rvMultipleOrder.setAdapter(multipleOrderAdapter);
            //            returnCarAdapter = new ReturnCarAdapter(vehicleTypeBean.get(statusPosition).getVehicleOrstatus());
            storeInfoRepairAdapter = new StoreInfoRepairAdapter(repairTypeBean.get(statusPosition).getAppRepairs());
            rvMultipleOrder.setAdapter(storeInfoRepairAdapter);
            storeInforActivity = (StoreInforActivity) getActivity();
            storeInforActivity.vpStoreInfor.setObjectForPosition(view, statusPosition);
        } else if (multipleFmType == 3) { //车辆状况
            // 设置管理器
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            rvMultipleOrder.setLayoutManager(layoutManager);
            // 如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
            rvMultipleOrder.setHasFixedSize(true);
            rvMultipleOrder.setItemAnimator(new DefaultItemAnimator());

            if (paperType == 0) {
                for (int i = 0; i < vehicleTypeBean.get(statusPosition).getAppVehicleStatus().size(); i++) {
                    vehicleTypeBean.get(statusPosition).getAppVehicleStatus().get(i).setItemType(multipleFmType);
                }
            } else {
                for (int i = 0; i < vehicleTypeBean.get(statusPosition).getVehicleOrstatus().size(); i++) {
                    vehicleTypeBean.get(statusPosition).getVehicleOrstatus().get(i).setItemType(multipleFmType);
                }
            }

            multipleOrderAdapter = new MultipleOrderAdapter(vehicleTypeBean.get(statusPosition).getAppVehicleStatus());
            returnCarAdapter = new ReturnCarAdapter(vehicleTypeBean.get(statusPosition).getVehicleOrstatus());
            if (paperType == 0)
                rvMultipleOrder.setAdapter(multipleOrderAdapter);
            else
                rvMultipleOrder.setAdapter(returnCarAdapter);
        } else if (multipleFmType == 2) { //维保订单
            // 设置管理器
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            rvMultipleOrder.setLayoutManager(layoutManager);
            // 如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
            rvMultipleOrder.setHasFixedSize(true);
            rvMultipleOrder.setItemAnimator(new DefaultItemAnimator());

            repairOrderListBean = new ArrayList<>();
            repairOrderAdapter = new RepairOrderAdapter(repairOrderListBean);
            rvMultipleOrder.setAdapter(repairOrderAdapter);
        } else { //历史订单
            // 设置管理器
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            rvMultipleOrder.setLayoutManager(layoutManager);
            // 如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
            rvMultipleOrder.setHasFixedSize(true);
            rvMultipleOrder.setItemAnimator(new DefaultItemAnimator());

            getCarOrderBean = new ArrayList<>();
            getCarHistoryOrderAdapter = new GetCarHistoryOrderAdapter(getCarOrderBean);
            rvMultipleOrder.setAdapter(getCarHistoryOrderAdapter);
        }
    }

    @Override
    public void initListener() {
        if (multipleFmType == 4) {

        } else if (multipleFmType == 3) {
            multipleOrderAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                @Override
                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                    if (isClickUtil.isFastClick()) {
                        switch (view.getId()) {
                            case R.id.rb_start:
                                rbStart = (RadioButton) view;
                                if (rbStart.isChecked())
                                    vehicleTypeBean.get(statusPosition).getAppVehicleStatus().get(position).setStatus(2);
                                break;
                            case R.id.rb_end:
                                rbEnd = (RadioButton) view;
                                if (rbEnd.isChecked())
                                    vehicleTypeBean.get(statusPosition).getAppVehicleStatus().get(position).setStatus(1);
                                break;
                        }
                    }
                }
            });

            returnCarAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                @Override
                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                    if (isClickUtil.isFastClick()) {
                        switch (view.getId()) {
                            case R.id.rb_start:
                                rbStart = (RadioButton) view;
                                if (rbStart.isChecked())
                                    vehicleTypeBean.get(statusPosition).getVehicleOrstatus().get(position).setStatus(2);
                                break;
                            case R.id.rb_end:
                                rbEnd = (RadioButton) view;
                                if (rbEnd.isChecked())
                                    vehicleTypeBean.get(statusPosition).getVehicleOrstatus().get(position).setStatus(1);
                                break;
                        }
                    }
                }
            });
        } else if (multipleFmType == 2) {
            repairOrderAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    if (isClickUtil.isFastClick()) {
                        startActivityForResult(new Intent(getActivity(), MaintenanceOrderDetailsActivity.class).putExtra("order_id", repairOrderListBean.get(position).getOrderId()).putExtra("repairs", repairOrderListBean.get(position).getRepairs()).putExtra("charges", repairOrderListBean.get(position).getCharges()).putExtra("status", repairOrderListBean.get(position).getStatus()), REQUEST_CODE_96);
                    }
                }
            });

            repairOrderAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                @Override
                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                    if (isClickUtil.isFastClick()) {
                        switch (view.getId()) {
                            case R.id.bt_order_type_start:
                                setDocumentsReceivedDialog(repairOrderListBean.get(position).getOrderId());
                                break;
                            case R.id.bt_order_type_end:
                                TreeMap<String, String> repairFinishMap = new TreeMap<>();
                                repairFinishMap.put("userId", SPUtil.get(getActivity(), USER_ID, "") + "");
                                repairFinishMap.put("orderId", repairOrderListBean.get(position).getOrderId() + "");
                                repairFinishMap.put("storeId", SPUtil.get(getActivity(), STORE_ID, "") + "");
                                getPresenter().getRepairFinish(repairFinishMap, true, false);
                                break;
                        }
                    }
                }
            });
        } else {
            getCarHistoryOrderAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    if (isClickUtil.isFastClick()) {
                        startActivity(new Intent(getActivity(), OrderDetailsActivity.class).putExtra("type", multipleFmType).putExtra("order_id", getCarOrderBean.get(position).getOrderId() + "").putExtra("status_get", getCarOrderBean.get(position).getPickStatus()).putExtra("status_out", getCarOrderBean.get(position).getStoreStatus()).putExtra("status", getCarOrderBean.get(position).getStatus()));
                    }
                }
            });

            getCarHistoryOrderAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                @Override
                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                    if (isClickUtil.isFastClick()) {

                        switch (view.getId()) {
                            case R.id.bt_order_type_start:
                                setDocumentsReceivedDialog(getCarOrderBean.get(position).getOrderId());
                                break;
                            case R.id.bt_order_type_end:
                                if (multipleFmType == 0) {
                                    if (getCarOrderBean.get(position).getPickStatus() == 2)
                                        startActivity(new Intent(getActivity(), SelectCarActivity.class).putExtra("order_id", getCarOrderBean.get(position).getOrderId() + "").putExtra("vehicleType", 1));
                                    else
                                        startActivityForResult(new Intent(getActivity(), FillInPaperActivity.class).putExtra("paper_type", multipleFmType).putExtra("order_id", getCarOrderBean.get(position).getOrderId() + ""), REQUEST_CODE_98);
                                } else {
                                    if (getCarOrderBean.get(position).getStoreStatus() == 2)
                                        startActivity(new Intent(getActivity(), SelectCarActivity.class).putExtra("order_id", getCarOrderBean.get(position).getOrderId() + "").putExtra("vehicleType", 2));
                                    else
                                        startActivityForResult(new Intent(getActivity(), FillInPaperActivity.class).putExtra("paper_type", multipleFmType).putExtra("order_id", getCarOrderBean.get(position).getOrderId() + ""), REQUEST_CODE_101);
                                }
                                break;
                        }
                    }
                }
            });
        }
    }

    @Override
    public void initData() {
        switch (multipleFmType) {
            case 0:
                int i;
                TreeMap<String, String> getCarOrderMap = new TreeMap<>();
                getCarOrderMap.put("userId", SPUtil.get(getActivity(), USER_ID, "") + "");
                if (!content.equals("")) {
                    getCarOrderMap.put("telPhone", content);
                    i = positions;
                } else
                    i = statusPosition;
                switch (i) {
                    case 0:
                        getCarOrderMap.put("status", "1");
                        break;
                    case 1:
                        getCarOrderMap.put("status", "5");
                        break;
                    case 2:
                        getCarOrderMap.put("status", "7");
                        break;
                    case 3:
                        getCarOrderMap.put("status", "4");
                        break;
                    case 4:
                        getCarOrderMap.put("status", "2");
                        break;
                }

                getCarOrderMap.put("page", page + "");
                getCarOrderMap.put("storeId", SPUtil.get(getActivity(), STORE_ID, "") + "");
                getPresenter().getGetCarOrder(getCarOrderMap, true, false);
                break;
            case 1:
                int j;
                TreeMap<String, String> carReturnOrderMap = new TreeMap<>();
                carReturnOrderMap.put("userId", SPUtil.get(getActivity(), USER_ID, "") + "");
                if (!content.equals("")) {
                    carReturnOrderMap.put("telPhone", content);
                    j = positions;
                } else
                    j = statusPosition;
                switch (j) {
                    case 0:
                        carReturnOrderMap.put("status", "1");
                        break;
                    case 1:
                        carReturnOrderMap.put("status", "8");
                        break;
                    case 2:
                        carReturnOrderMap.put("status", "7");
                        break;
                    case 3:
                        carReturnOrderMap.put("status", "5");
                        break;
                    case 4:
                        carReturnOrderMap.put("status", "2");
                        break;
                }
                carReturnOrderMap.put("page", page + "");
                carReturnOrderMap.put("storeId", SPUtil.get(getActivity(), STORE_ID, "") + "");
                getPresenter().getCarReturnOrder(carReturnOrderMap, true, false);
                break;
            case 2:
                TreeMap<String, String> returnCarMap = new TreeMap<>();
                returnCarMap.put("userId", SPUtil.get(getActivity(), USER_ID, "") + "");
                returnCarMap.put("page", page + "");
                switch (statusPosition) {
                    case 0:
                        returnCarMap.put("status", "1");
                        break;
                    case 1:
                        returnCarMap.put("status", "4");
                        break;
                    case 2:
                        returnCarMap.put("status", "5");
                        break;
                    case 3:
                        returnCarMap.put("status", "2");
                        break;
                }
                returnCarMap.put("storeId", SPUtil.get(getActivity(), STORE_ID, "") + "");
                getPresenter().getRepairOrderList(returnCarMap, true, false);
                break;
        }
    }

    private void setDocumentsReceivedDialog(final int orderId) {
        final TextView tv;
        final Dialog mCameraDialog = new Dialog(getActivity(), R.style.BottomDialog);
        //Dialog布局
        LinearLayout root = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.dialog_center, null);
        tv = root.findViewById(R.id.tv_dialog_center_end);
        tv.setText("是否取消订单？");

        //初始化视图
        root.findViewById(R.id.dialog_center_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClickUtil.isFastClick()) {
                    switch (multipleFmType) {
                        case 0:
                            TreeMap<String, String> getCarOrderMap = new TreeMap<>();
                            getCarOrderMap.put("userId", SPUtil.get(getActivity(), USER_ID, "") + "");
                            getCarOrderMap.put("orderId", orderId + "");
                            getCarOrderMap.put("storeId", SPUtil.get(getActivity(), STORE_ID, "") + "");
                            getPresenter().getGetCarCancelOrder(getCarOrderMap, false, false);
                            break;
                        case 1:
                            TreeMap<String, String> returnCarCancelOrderMap = new TreeMap<>();
                            returnCarCancelOrderMap.put("userId", SPUtil.get(getActivity(), USER_ID, "") + "");
                            returnCarCancelOrderMap.put("orderId", orderId + "");
                            returnCarCancelOrderMap.put("storeId", SPUtil.get(getActivity(), STORE_ID, "") + "");
                            getPresenter().getReturnCarCancelOrder(returnCarCancelOrderMap, false, false);
                            break;
                        case 2:
                            TreeMap<String, String> repairFinishMap = new TreeMap<>();
                            repairFinishMap.put("userId", SPUtil.get(getActivity(), USER_ID, "") + "");
                            repairFinishMap.put("orderId", orderId + "");
                            repairFinishMap.put("storeId", SPUtil.get(getActivity(), STORE_ID, "") + "");
                            getPresenter().getRepairCancel(repairFinishMap, true, false);
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

    public String getLoadStringTwo(int paperType) {
        List<Map<String, String>> listMap = new ArrayList<>();
        if (paperType == 0) {
            for (VehicleConditionHorizontalBean.DataBean.VehicleTypeBean chargeList : vehicleTypeBean) {
                for (VehicleConditionHorizontalBean.DataBean.VehicleTypeBean.AppVehicleStatusBean appVehicleStatusBean : chargeList.getAppVehicleStatus()) {
                    Map<String, String> map = new HashMap<>();
                    map.put("statusId", appVehicleStatusBean.getStatusId() + "");
                    map.put("statusName", appVehicleStatusBean.getStatusName() + "");
                    map.put("status", appVehicleStatusBean.getStatus() + ""); // 1:正常  2：破损
                    map.put("damagedCost", appVehicleStatusBean.getDamagedCost() + "");
                    map.put("parentId", appVehicleStatusBean.getParentId() + "");
                    listMap.add(map);
                }
            }
        } else {
            for (VehicleConditionHorizontalBean.DataBean.VehicleTypeBean chargeList : vehicleTypeBean) {
                for (VehicleConditionHorizontalBean.DataBean.VehicleTypeBean.VehicleOrstatusBean VehicleOrstatusBean : chargeList.getVehicleOrstatus()) {
                    Map<String, String> map = new HashMap<>();
                    map.put("statusId", VehicleOrstatusBean.getStatusId() + "");
                    map.put("statusName", VehicleOrstatusBean.getVestatusName() + "");
                    map.put("status", VehicleOrstatusBean.getStatus() + ""); // 1:正常  2：破损
                    map.put("damagedCost", VehicleOrstatusBean.getDamagedCost() + "");
                    map.put("parentId", VehicleOrstatusBean.getParentId() + "");
                    map.put("orstatusId", VehicleOrstatusBean.getOrstatusId() + "");
                    listMap.add(map);
                }
            }
        }
        if (listMap.size() <= 0)
            return "";
        Gson g = new Gson();
        String jsonString = g.toJson(listMap);
        return jsonString;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            switch (requestCode) {
                case REQUEST_CODE_96:
                    page = 0;
                    initData();
                    break;
                case REQUEST_CODE_97:
                    page = 0;
                    initData();
                    break;
                case REQUEST_CODE_98:
                    page = 0;
                    initData();
                case REQUEST_CODE_101:
                    page = 0;
                    initData();
                    break;
            }
        }
    }

    @Override
    public void resultRepairOrderList(RepairOrderListBean data) {
        if (page == 0) {
            repairOrderListBean.clear();
            repairOrderListBean.addAll(data.getData().getOrderList());
            repairOrderAdapter.setNewData(repairOrderListBean);
            if (data.getData().getOrderList().size() > 0) {
                page += 1;
                repairOrderAdapter.setOnLoadMoreListener(this, rvMultipleOrder);
            } else {
                repairOrderAdapter.loadMoreEnd();
            }
        } else {
            if (data.getData().getOrderList().size() > 0) {
                page += 1;
                repairOrderAdapter.addData(data.getData().getOrderList());
                repairOrderAdapter.loadMoreComplete();
            } else {
                repairOrderAdapter.loadMoreEnd();
            }
        }
        //空数据时的页面
        repairOrderAdapter.setEmptyView(R.layout.null_data, rvMultipleOrder);
    }

    @Override
    public void resultRepairDetails(RepairDetailsBean data) {

    }

    @Override
    public void resultRepairFinish(RepairFinishBean data) {
        ToastUtil.showShortToast(data.getMsg());
        page = 0;
        initData();
    }

    @Override
    public void resultRepairCancel(RepairCancelBean data) {
        ToastUtil.showShortToast(data.getMsg());
        startActivityForResult(new Intent(getActivity(), FinishTypeActivity.class).putExtra("finish_type", 0), REQUEST_CODE_97);
    }

    @Override
    public void resultGetCarOrder(final GetCarOrderBean data) {
        if (page == 0) {
            getCarOrderBean.clear();
            getCarOrderBean.addAll(data.getData().getOrderList());
            for (int i = 0; i < getCarOrderBean.size(); i++) {
                getCarOrderBean.get(i).setItemType(multipleFmType);
            }

            getCarHistoryOrderAdapter.setNewData(getCarOrderBean);
            getCarHistoryOrderAdapter.notifyDataSetChanged();
            if (data.getData().getOrderList().size() > 0) {
                page += 1;
                getCarHistoryOrderAdapter.setOnLoadMoreListener(this, rvMultipleOrder);
            } else {
                getCarHistoryOrderAdapter.loadMoreEnd();
            }
        } else {
            for (int i = 0; i < data.getData().getOrderList().size(); i++) {
                data.getData().getOrderList().get(i).setItemType(multipleFmType);
            }
            if (data.getData().getOrderList().size() > 0) {
                page += 1;
                getCarHistoryOrderAdapter.addData(data.getData().getOrderList());
                getCarHistoryOrderAdapter.loadMoreComplete();
            } else {
                getCarHistoryOrderAdapter.loadMoreEnd();
            }
        }
        //空数据时的页面
        getCarHistoryOrderAdapter.setEmptyView(R.layout.null_data, rvMultipleOrder);
    }

    @Override
    public void resultCarReturnOrder(GetCarOrderBean data) {
        if (page == 0) {
            getCarOrderBean.clear();
            getCarOrderBean.addAll(data.getData().getOrderList());
            for (int i = 0; i < getCarOrderBean.size(); i++) {
                getCarOrderBean.get(i).setItemType(multipleFmType);
            }
            getCarHistoryOrderAdapter.setNewData(getCarOrderBean);
            if (data.getData().getOrderList().size() > 0) {
                page += 1;
                getCarHistoryOrderAdapter.setOnLoadMoreListener(this, rvMultipleOrder);
            } else {
                getCarHistoryOrderAdapter.loadMoreEnd();
            }
        } else {
            for (int i = 0; i < data.getData().getOrderList().size(); i++) {
                data.getData().getOrderList().get(i).setItemType(multipleFmType);
            }
            if (data.getData().getOrderList().size() > 0) {
                page += 1;
                getCarHistoryOrderAdapter.addData(data.getData().getOrderList());
                getCarHistoryOrderAdapter.loadMoreComplete();
            } else {
                getCarHistoryOrderAdapter.loadMoreEnd();
            }
        }
        //空数据时的页面
        getCarHistoryOrderAdapter.setEmptyView(R.layout.null_data, rvMultipleOrder);
    }

    @Override
    public void resultGetCarCancelOrder(GetCarCancelOrderBean data) {
        ToastUtil.showLongToast(data.getMsg());
        if (data.getCode() == 200) {
            page = 0;
            initData();
            startActivity(new Intent(getActivity(), FinishTypeActivity.class).putExtra("finish_type", 0));
        }
    }

    @Override
    public void resultReturnCarCancelOrder(GetCarCancelOrderBean data) {
        ToastUtil.showLongToast(data.getMsg());
        if (data.getCode() == 200) {
            page = 0;
            initData();
            startActivity(new Intent(getActivity(), FinishTypeActivity.class).putExtra("finish_type", 0));
        }
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindUntilEvent(FragmentEvent.PAUSE);
    }

    @Override
    public void onLoadMoreRequested() {
        initData();
    }

    @Override
    public void onRefresh() {
        page = 0;
        initData();
        srlMultipleOrder.setRefreshing(false);
    }
}
