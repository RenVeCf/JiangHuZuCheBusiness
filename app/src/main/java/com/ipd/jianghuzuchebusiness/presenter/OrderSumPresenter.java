package com.ipd.jianghuzuchebusiness.presenter;

import android.content.Context;

import com.ipd.jianghuzuchebusiness.bean.CarRentalOrderBean;
import com.ipd.jianghuzuchebusiness.bean.RepairOrderBean;
import com.ipd.jianghuzuchebusiness.contract.OrderSumContract;
import com.ipd.jianghuzuchebusiness.model.OrderSumModel;
import com.ipd.jianghuzuchebusiness.progress.ObserverResponseListener;
import com.ipd.jianghuzuchebusiness.utils.ExceptionHandle;
import com.ipd.jianghuzuchebusiness.utils.ToastUtil;

import java.util.TreeMap;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2018/8/26.
 */
public class OrderSumPresenter extends OrderSumContract.Presenter {

    private OrderSumModel model;
    private Context context;

    public OrderSumPresenter(Context context) {
        this.model = new OrderSumModel();
        this.context = context;
    }

    @Override
    public void getRepairOrder(TreeMap<String, String> map, boolean isDialog, boolean cancelable) {
        model.getRepairOrder(context, map, isDialog, cancelable, getView().bindLifecycle(), new ObserverResponseListener() {
            @Override
            public void onNext(Object o) {
                //这一步是必须的，判断view是否已经被销毁
                if (getView() != null) {
                    getView().resultRepairOrder((RepairOrderBean) o);
                }
            }

            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if (getView() != null) {
                    //// TODO: 2017/12/28 自定义处理异常
                    ToastUtil.showShortToast(ExceptionHandle.handleException(e).message);
                }
            }
        });
    }

    @Override
    public void getCarRentalOrder(TreeMap<String, String> map, boolean isDialog, boolean cancelable) {
        model.getCarRentalOrder(context, map, isDialog, cancelable, getView().bindLifecycle(), new ObserverResponseListener() {
            @Override
            public void onNext(Object o) {
                //这一步是必须的，判断view是否已经被销毁
                if (getView() != null) {
                    getView().resultCarRentalOrder((CarRentalOrderBean) o);
                }
            }

            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if (getView() != null) {
                    //// TODO: 2017/12/28 自定义处理异常
                    ToastUtil.showShortToast(ExceptionHandle.handleException(e).message);
                }
            }
        });
    }
}