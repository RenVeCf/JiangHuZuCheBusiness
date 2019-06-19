package com.ipd.jianghuzuchebusiness.activity;

import android.graphics.Color;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuchebusiness.R;
import com.ipd.jianghuzuchebusiness.adapter.OrderSumAdapter;
import com.ipd.jianghuzuchebusiness.base.BaseActivity;
import com.ipd.jianghuzuchebusiness.bean.CarRentalOrderBean;
import com.ipd.jianghuzuchebusiness.bean.RepairOrderBean;
import com.ipd.jianghuzuchebusiness.common.view.DividerItemDecoration;
import com.ipd.jianghuzuchebusiness.common.view.TopView;
import com.ipd.jianghuzuchebusiness.contract.OrderSumContract;
import com.ipd.jianghuzuchebusiness.presenter.OrderSumPresenter;
import com.ipd.jianghuzuchebusiness.utils.ApplicationUtil;
import com.ipd.jianghuzuchebusiness.utils.DateUtils;
import com.ipd.jianghuzuchebusiness.utils.SPUtil;
import com.ipd.jianghuzuchebusiness.utils.isClickUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;

import static com.ipd.jianghuzuchebusiness.common.config.IConstants.USER_ID;

/**
 * Description ：订单统计
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/12.
 */
public class OrderSumActivity extends BaseActivity<OrderSumContract.View, OrderSumContract.Presenter> implements OrderSumContract.View {

    @BindView(R.id.tv_order_sum_top)
    TopView tvOrderSumTop;
    @BindView(R.id.rb_order_sum_start)
    RadioButton rbOrderSumStart;
    @BindView(R.id.rb_order_sum_end)
    RadioButton rbOrderSumEnd;
    @BindView(R.id.rv_order_sum)
    RecyclerView rvOrderSum;
    @BindView(R.id.tv_order_sum_start)
    TextView tvOrderSumStart;
    @BindView(R.id.tv_order_sum_end)
    TextView tvOrderSumEnd;
    @BindView(R.id.bt_order_sum)
    Button btOrderSum;
    @BindView(R.id.ll_order_sum)
    LinearLayout llOrderSum;
    @BindView(R.id.tv_day_order)
    TextView tvDayOrder;
    @BindView(R.id.tv_day_order_money)
    TextView tvDayOrderMoney;
    @BindView(R.id.tv_total_order)
    TextView tvTotalOrder;
    @BindView(R.id.tv_total_order_money)
    TextView tvTotalOrderMoney;

    private OrderSumAdapter orderSumAdapter;
    private List<String> listData;
    private List<String> datas;
    private GridLayoutManager NotUseList;
    private TimePickerView pvTime;
    private CarRentalOrderBean.DataBean.VehiclelDataBean carRentalOrderBean;
    private RepairOrderBean.DataBean.RepairDataBean repairOrderBean;

    @Override
    public int getLayoutId() {
        return R.layout.activity_order_sum;
    }

    @Override
    public OrderSumContract.Presenter createPresenter() {
        return new OrderSumPresenter(this);
    }

    @Override
    public OrderSumContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvOrderSumTop);

        //设置RecyclerView方向和是否反转
        GridLayoutManager NotUseList = new GridLayoutManager(this, 5);
        rvOrderSum.setLayoutManager(NotUseList);
        rvOrderSum.addItemDecoration(new DividerItemDecoration(this));
        rvOrderSum.setHasFixedSize(true); //item如果一样的大小，可以设置为true让RecyclerView避免重新计算大小
        rvOrderSum.setItemAnimator(new DefaultItemAnimator()); //默认动画

        listData = new ArrayList<>();
        datas = new ArrayList<>();
        //初始化数据
        datas.add("");
        datas.add("门店收益");
        datas.add("取车订单");
        datas.add("还车订单");
        datas.add("未完成订单");
        datas.add("数量");
        datas.add("-");
        datas.add("-");
        datas.add("-");
        datas.add("-");
        datas.add("金额");
        datas.add("-");
        datas.add("-");
        datas.add("-");
        datas.add("-");
        orderSumAdapter = new OrderSumAdapter(datas);
        rvOrderSum.setAdapter(orderSumAdapter);

//        tvDayOrder.setVisibility(View.GONE);
//        tvDayOrderMoney.setVisibility(View.GONE);
//        tvTotalOrder.setVisibility(View.GONE);
//        tvTotalOrderMoney.setVisibility(View.GONE);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
//        TreeMap<String, String> repairOrderMap = new TreeMap<>();
//        repairOrderMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
//        getPresenter().getRepairOrder(repairOrderMap, false, false);

        TreeMap<String, String> carRentalOrderMap = new TreeMap<>();
        carRentalOrderMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
        getPresenter().getCarRentalOrder(carRentalOrderMap, true, false);
    }

    //时间选择器
    private void selectTime(final int type) {
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        //startDate.set(2013,1,1);
        Calendar endDate = Calendar.getInstance();
        //endDate.set(2020,1,1);

        //正确设置方式 原因：注意事项有说明
        startDate.set(2013, 0, 1);
        endDate.set(2022, 11, 31);

        pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                switch (type) {
                    case 0:
                        tvOrderSumStart.setText(DateUtils.timedate1(date.getTime() + ""));
                        tvOrderSumStart.setTextColor(Color.BLACK);
                        break;
                    case 1:
                        tvOrderSumEnd.setText(DateUtils.timedate1(date.getTime() + ""));
                        tvOrderSumEnd.setTextColor(Color.BLACK);
                        break;
                }

                if (!tvOrderSumStart.getText().toString().trim().equals("选择起始日期") && !tvOrderSumEnd.getText().toString().trim().equals("选择结束日期")) {
                    if (rbOrderSumStart.isChecked())
                        selectOrder(0);
                    else
                        selectOrder(1);
//                    llOrderSum.setVisibility(View.VISIBLE);
                } else if (tvOrderSumStart.getText().toString().trim().equals("选择起始日期") && tvOrderSumEnd.getText().toString().trim().equals("选择结束日期")) {
                    if (rbOrderSumStart.isChecked())
                        selectOrder(2);
                    else
                        selectOrder(3);
                }
            }
        })
                .setLayoutRes(R.layout.pickerview_custom_time, new CustomListener() {
                    @Override
                    public void customLayout(View v) {
                        final Button tvSubmit = (Button) v.findViewById(R.id.bt_pickview_confirm);
                        tvSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvTime.returnData();
                                pvTime.dismiss();
                            }
                        });
                    }
                })
                .setType(new boolean[]{true, true, true, false, false, false})// 默认全部显示
//                .setCancelText("请选择起始时间")//取消按钮文字
//                .setSubmitText("")//确认按钮文字
                //                .setContentSize(18)//滚轮文字大小
//                .setTitleSize(16)//标题文字大小
//                .setTitleText("请选择起始时间")
                .setDecorView((ViewGroup) getWindow().getDecorView().findViewById(android.R.id.content))
                .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
                .isCyclic(false)//是否循环滚动
//                .setTitleColor(Color.BLACK)//标题文字颜色
//                .setSubmitColor(Color.BLACK)//确定按钮文字颜色
//                .setCancelColor(Color.BLACK)//取消按钮文字颜色
//                .setTitleBgColor(0xFFFFFFFF)//标题背景颜色 Night mode
                .setBgColor(Color.WHITE)//滚轮背景颜色 Night mode
                .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
                .setRangDate(startDate, endDate)//起始终止年月日设定
                .setLabel("", "", "", "时", "分", "秒")//默认设置为年月日时分秒
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .isDialog(false)//是否显示为对话框样式
                .build();
        pvTime.show();
    }

    private void selectOrder(int type) {
        switch (type) {
            case 0:
                TreeMap<String, String> carRentalOrderMap = new TreeMap<>();
                carRentalOrderMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
                carRentalOrderMap.put("params[beginTime]", tvOrderSumStart.getText().toString().trim());
                carRentalOrderMap.put("params[endTime]", tvOrderSumEnd.getText().toString().trim());
                getPresenter().getCarRentalOrder(carRentalOrderMap, true, false);
                break;
            case 1:
                TreeMap<String, String> repairOrderMap = new TreeMap<>();
                repairOrderMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
                repairOrderMap.put("params[beginTime]", tvOrderSumStart.getText().toString().trim());
                repairOrderMap.put("params[endTime]", tvOrderSumEnd.getText().toString().trim());
                getPresenter().getRepairOrder(repairOrderMap, true, false);
                break;
            case 2:
                TreeMap<String, String> carRentalOrderMap1 = new TreeMap<>();
                carRentalOrderMap1.put("userId", SPUtil.get(this, USER_ID, "") + "");
                getPresenter().getCarRentalOrder(carRentalOrderMap1, true, false);
                break;
            case 3:
                TreeMap<String, String> repairOrderMap1 = new TreeMap<>();
                repairOrderMap1.put("userId", SPUtil.get(this, USER_ID, "") + "");
                getPresenter().getRepairOrder(repairOrderMap1, true, false);
                break;
        }
    }

    @OnClick({R.id.rb_order_sum_start, R.id.rb_order_sum_end, R.id.tv_order_sum_start, R.id.tv_order_sum_end, R.id.bt_order_sum})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rb_order_sum_start:
                if (!tvOrderSumStart.getText().toString().trim().equals("选择起始日期") && !tvOrderSumEnd.getText().toString().trim().equals("选择结束日期")) {
                    if (rbOrderSumStart.isChecked())
                        selectOrder(0);
                    else
                        selectOrder(1);
                } else if (tvOrderSumStart.getText().toString().trim().equals("选择起始日期") && tvOrderSumEnd.getText().toString().trim().equals("选择结束日期")) {
                    if (rbOrderSumStart.isChecked())
                        selectOrder(2);
                    else
                        selectOrder(3);
                }
                break;
            case R.id.rb_order_sum_end:
                if (!tvOrderSumStart.getText().toString().trim().equals("选择起始日期") && !tvOrderSumEnd.getText().toString().trim().equals("选择结束日期")) {
                    if (rbOrderSumStart.isChecked())
                        selectOrder(0);
                    else
                        selectOrder(1);
                } else if (tvOrderSumStart.getText().toString().trim().equals("选择起始日期") && tvOrderSumEnd.getText().toString().trim().equals("选择结束日期")) {
                    if (rbOrderSumStart.isChecked())
                        selectOrder(2);
                    else
                        selectOrder(3);
                }
                break;
            case R.id.tv_order_sum_start:
                selectTime(0);
                break;
            case R.id.tv_order_sum_end:
                selectTime(1);
                break;
            case R.id.bt_order_sum:
                if (isClickUtil.isFastClick()) {
                    tvOrderSumStart.setText("选择起始日期");
                    tvOrderSumStart.setTextColor(getResources().getColor(R.color.tx_bottom_navigation));
                    tvOrderSumEnd.setText("选择结束日期");
                    tvOrderSumEnd.setTextColor(getResources().getColor(R.color.tx_bottom_navigation));
                    initData();
                }
                break;
        }
    }

    @Override
    public void resultCarRentalOrder(CarRentalOrderBean data) {
        carRentalOrderBean = data.getData().getVehiclelData();
        NotUseList = null;
        NotUseList = new GridLayoutManager(this, 5);
        rvOrderSum.setLayoutManager(NotUseList);
        datas.clear();
        datas.add("");
        datas.add("门店收益");
        datas.add("取车订单");
        datas.add("还车订单");
        datas.add("未完成订单");
        datas.add("数量");
        datas.add(carRentalOrderBean.getProfitCount() + "");
        datas.add(carRentalOrderBean.getPickOrder() + "");
        datas.add(carRentalOrderBean.getReturnOrder() + "");
        datas.add(carRentalOrderBean.getNoOkOrder() + "");
        datas.add("金额");
        datas.add("¥" + carRentalOrderBean.getProfitMoney());
        datas.add("¥" + carRentalOrderBean.getPickMoney());
        datas.add("¥" + carRentalOrderBean.getReturnMoney());
        datas.add("¥" + carRentalOrderBean.getNoOkOrderMoney());
        orderSumAdapter.setNewData(datas);

        tvDayOrder.setVisibility(View.VISIBLE);
        tvDayOrderMoney.setVisibility(View.VISIBLE);
        tvTotalOrder.setVisibility(View.VISIBLE);
        tvTotalOrderMoney.setVisibility(View.VISIBLE);

        tvDayOrder.setText("当日订单数量: " + carRentalOrderBean.getDayOrder());
        tvDayOrderMoney.setText("当日订单金额: ¥" + carRentalOrderBean.getDayOrderMoney());
        tvTotalOrder.setText("合计订单数量: " + carRentalOrderBean.getTotalOrder());
        tvTotalOrderMoney.setText("合计订单金额: ¥" + carRentalOrderBean.getTotalOrderMoney());
    }

    @Override
    public void resultRepairOrder(RepairOrderBean data) {
        repairOrderBean = data.getData().getRepairData();
        NotUseList = null;
        NotUseList = new GridLayoutManager(this, 4);
        rvOrderSum.setLayoutManager(NotUseList);
        datas.clear();
        datas.add("");
        datas.add("门店收益");
        datas.add("已完成订单");
        datas.add("未完成订单");
        datas.add("数量");
        datas.add(repairOrderBean.getProfitCount() + "");
        datas.add(repairOrderBean.getOkOrderCount() + "");
        datas.add(repairOrderBean.getNotOkOrderCount() + "");
        datas.add("金额");
        datas.add("¥" + repairOrderBean.getProfitMoney());
        datas.add("¥" + repairOrderBean.getOkOrderMoney());
        datas.add("¥" + repairOrderBean.getNotOkOrderMoney());
        orderSumAdapter.setNewData(datas);

        tvDayOrder.setVisibility(View.VISIBLE);
        tvDayOrderMoney.setVisibility(View.VISIBLE);
        tvTotalOrder.setVisibility(View.VISIBLE);
        tvTotalOrderMoney.setVisibility(View.VISIBLE);

        tvDayOrder.setText("当日订单数量: " + repairOrderBean.getDayOrderCount());
        tvDayOrderMoney.setText("当日订单金额: ¥" + repairOrderBean.getDayOrderMoney());
        tvTotalOrder.setText("合计订单数量: " + repairOrderBean.getTotalOrderCount());
        tvTotalOrderMoney.setText("合计订单金额: ¥" + repairOrderBean.getTotalOrderMoney());
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }
}
