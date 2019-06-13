package com.ipd.jianghuzuchebusiness.activity;

import android.app.Dialog;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuchebusiness.R;
import com.ipd.jianghuzuchebusiness.adapter.GetCarOrderAdapter;
import com.ipd.jianghuzuchebusiness.base.BaseActivity;
import com.ipd.jianghuzuchebusiness.bean.GetCarCancelOrderBean;
import com.ipd.jianghuzuchebusiness.bean.GetCarOrderBean;
import com.ipd.jianghuzuchebusiness.common.view.TopView;
import com.ipd.jianghuzuchebusiness.contract.GetCarOrderContract;
import com.ipd.jianghuzuchebusiness.presenter.GetCarOrderPresenter;
import com.ipd.jianghuzuchebusiness.utils.ApplicationUtil;
import com.ipd.jianghuzuchebusiness.utils.SPUtil;
import com.ipd.jianghuzuchebusiness.utils.ToastUtil;
import com.ipd.jianghuzuchebusiness.utils.isClickUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;

import static com.ipd.jianghuzuchebusiness.common.config.IConstants.REQUEST_CODE_102;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.REQUEST_CODE_103;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.REQUEST_CODE_92;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.STORE_ID;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.USER_ID;

/**
 * Description ：取/退车订单
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/10.
 */
public class GetCarOrderActivity extends BaseActivity<GetCarOrderContract.View, GetCarOrderContract.Presenter> implements GetCarOrderContract.View, BaseQuickAdapter.RequestLoadMoreListener {
    @BindView(R.id.tv_get_car_order_top)
    TopView tvGetCarOrderTop;
    @BindView(R.id.tv_top_history)
    TextView tvTopHistory;
    @BindView(R.id.tv_top_title)
    TextView tvTopTitle;
    @BindView(R.id.rv_get_car_order)
    RecyclerView rvGetCarOrder;
    @BindView(R.id.srl_get_car_order)
    SwipeRefreshLayout srlGetCarOrder;

    private GetCarOrderAdapter getCarOrderAdapter;
    private List<GetCarOrderBean.DataBean.OrderListBean> getCarOrderBean;
    private int orderType;
    private int page;

    @Override
    public int getLayoutId() {
        return R.layout.activity_get_car_order;
    }

    @Override
    public GetCarOrderContract.Presenter createPresenter() {
        return new GetCarOrderPresenter(this);
    }

    @Override
    public GetCarOrderContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvGetCarOrderTop);

        orderType = getIntent().getIntExtra("order_type", 0);
        switch (orderType) {
            case 0:
                tvTopTitle.setText("取车订单");
                break;
            case 1:
                tvTopTitle.setText("退车订单");
                break;
        }

        // 设置管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvGetCarOrder.setLayoutManager(layoutManager);
        // 如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        rvGetCarOrder.setHasFixedSize(true);
        rvGetCarOrder.setItemAnimator(new DefaultItemAnimator());

        getCarOrderBean = new ArrayList<>();
        getCarOrderAdapter = new GetCarOrderAdapter(getCarOrderBean, orderType);
        rvGetCarOrder.setAdapter(getCarOrderAdapter);
    }

    @Override
    public void initListener() {
        srlGetCarOrder.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 0;
                initData();
                srlGetCarOrder.setRefreshing(false);
            }
        });

        getCarOrderAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (isClickUtil.isFastClick()) {
                    startActivityForResult(new Intent(GetCarOrderActivity.this, OrderDetailsActivity.class).putExtra("type", orderType).putExtra("order_id", getCarOrderBean.get(position).getOrderId() + "").putExtra("status_get", getCarOrderBean.get(position).getPickStatus()).putExtra("status_out", getCarOrderBean.get(position).getStoreStatus()), REQUEST_CODE_92);
                }
            }
        });

        getCarOrderAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (isClickUtil.isFastClick()) {
                    switch (view.getId()) {
                        case R.id.bt_order_type_start:
                            setDocumentsReceivedDialog(getCarOrderBean.get(position).getOrderId());
                            break;
                        case R.id.bt_order_type_end:
                            if (orderType == 0) {
                                if (getCarOrderBean.get(position).getPickStatus() == 2)
                                    startActivity(new Intent(GetCarOrderActivity.this, SelectCarActivity.class).putExtra("order_id", getCarOrderBean.get(position).getOrderId() + "").putExtra("vehicleType", 1));
                                else
                                    startActivityForResult(new Intent(GetCarOrderActivity.this, FillInPaperActivity.class).putExtra("paper_type", orderType).putExtra("order_id", getCarOrderBean.get(position).getOrderId() + ""), REQUEST_CODE_102);
                            } else {
                                if (getCarOrderBean.get(position).getStoreStatus() == 2)
                                    startActivity(new Intent(GetCarOrderActivity.this, SelectCarActivity.class).putExtra("order_id", getCarOrderBean.get(position).getOrderId() + "").putExtra("vehicleType", 2));
                                else
                                    startActivityForResult(new Intent(GetCarOrderActivity.this, FillInPaperActivity.class).putExtra("paper_type", orderType).putExtra("order_id", getCarOrderBean.get(position).getOrderId() + ""), REQUEST_CODE_103);
                            }
                            break;
                    }
                }
            }
        });
    }

    @Override
    public void initData() {
        switch (orderType) {
            case 0:
                TreeMap<String, String> getCarOrderMap = new TreeMap<>();
                getCarOrderMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
                getCarOrderMap.put("status", "4");
                getCarOrderMap.put("page", page + "");
                getCarOrderMap.put("storeId", SPUtil.get(this, STORE_ID, "") + "");
                getPresenter().getGetCarOrder(getCarOrderMap, false, false);
                break;
            case 1:
                TreeMap<String, String> carReturnOrderMap = new TreeMap<>();
                carReturnOrderMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
                carReturnOrderMap.put("status", "5");
                carReturnOrderMap.put("page", page + "");
                carReturnOrderMap.put("storeId", SPUtil.get(this, STORE_ID, "") + "");
                getPresenter().getCarReturnOrder(carReturnOrderMap, false, false);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            switch (requestCode) {
                case REQUEST_CODE_92:
                    page = 0;
                    initData();
                case REQUEST_CODE_102:
                    page = 0;
                    initData();
                case REQUEST_CODE_103:
                    page = 0;
                    initData();
                    break;
            }
        }
    }

    private void setDocumentsReceivedDialog(final int orderId) {
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
                switch (orderType) {
                    case 0:
                        TreeMap<String, String> getCarOrderMap = new TreeMap<>();
                        getCarOrderMap.put("userId", SPUtil.get(GetCarOrderActivity.this, USER_ID, "") + "");
                        getCarOrderMap.put("orderId", orderId + "");
                        getCarOrderMap.put("storeId", SPUtil.get(GetCarOrderActivity.this, STORE_ID, "") + "");
                        getPresenter().getGetCarCancelOrder(getCarOrderMap, false, false);
                        break;
                    case 1:
                        TreeMap<String, String> returnCarCancelOrderMap = new TreeMap<>();
                        returnCarCancelOrderMap.put("userId", SPUtil.get(GetCarOrderActivity.this, USER_ID, "") + "");
                        returnCarCancelOrderMap.put("orderId", orderId + "");
                        returnCarCancelOrderMap.put("storeId", SPUtil.get(GetCarOrderActivity.this, STORE_ID, "") + "");
                        getPresenter().getReturnCarCancelOrder(returnCarCancelOrderMap, false, false);
                        break;
                }
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

    @OnClick(R.id.tv_top_history)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_top_history:
                if (isClickUtil.isFastClick()) {
                    startActivity(new Intent(this, MultipleOrderActivity.class).putExtra("multiple_type", orderType));
                }
                break;
        }
    }

    @Override
    public void resultGetCarOrder(GetCarOrderBean data) {
        if (page == 0) {
            getCarOrderBean.clear();
            getCarOrderBean.addAll(data.getData().getOrderList());
            getCarOrderAdapter.setNewData(getCarOrderBean);
            if (data.getData().getOrderList().size() > 0) {
                page += 1;
                getCarOrderAdapter.setOnLoadMoreListener(this, rvGetCarOrder);
            } else {
                getCarOrderAdapter.loadMoreEnd();
            }
        } else {
            if (data.getData().getOrderList().size() > 0) {
                page += 1;
                getCarOrderAdapter.addData(data.getData().getOrderList());
                getCarOrderAdapter.loadMoreComplete();
            } else {
                getCarOrderAdapter.loadMoreEnd();
            }
        }
        //空数据时的页面
        getCarOrderAdapter.setEmptyView(R.layout.null_data, rvGetCarOrder);
    }

    @Override
    public void resultCarReturnOrder(GetCarOrderBean data) {
        if (page == 0) {
            getCarOrderBean.clear();
            getCarOrderBean.addAll(data.getData().getOrderList());
            getCarOrderAdapter.setNewData(getCarOrderBean);
            if (data.getData().getOrderList().size() > 0) {
                page += 1;
                getCarOrderAdapter.setOnLoadMoreListener(this, rvGetCarOrder);
            } else {
                getCarOrderAdapter.loadMoreEnd();
            }
        } else {
            if (data.getData().getOrderList().size() > 0) {
                page += 1;
                getCarOrderAdapter.addData(data.getData().getOrderList());
                getCarOrderAdapter.loadMoreComplete();
            } else {
                getCarOrderAdapter.loadMoreEnd();
            }
        }
        //空数据时的页面
        getCarOrderAdapter.setEmptyView(R.layout.null_data, rvGetCarOrder);
    }

    @Override
    public void resultGetCarCancelOrder(GetCarCancelOrderBean data) {
        ToastUtil.showLongToast(data.getMsg());
        if (data.getCode() == 200) {
            page = 0;
            initData();
            startActivity(new Intent(GetCarOrderActivity.this, FinishTypeActivity.class).putExtra("finish_type", 0));
            finish();
        }
    }

    @Override
    public void resultReturnCarCancelOrder(GetCarCancelOrderBean data) {
        ToastUtil.showLongToast(data.getMsg());
        if (data.getCode() == 200) {
            page = 0;
            initData();
            startActivity(new Intent(GetCarOrderActivity.this, FinishTypeActivity.class).putExtra("finish_type", 0));
            finish();
        }
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }

    @Override
    public void onLoadMoreRequested() {
        initData();
    }
}
