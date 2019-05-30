package com.ipd.jianghuzuchebusiness.contract;

import com.ipd.jianghuzuchebusiness.base.BasePresenter;
import com.ipd.jianghuzuchebusiness.base.BaseView;
import com.ipd.jianghuzuchebusiness.bean.GetCarCancelOrderBean;
import com.ipd.jianghuzuchebusiness.bean.OrderDetailsBean;
import com.ipd.jianghuzuchebusiness.bean.ReturnOrderDescBean;

import java.util.TreeMap;

import io.reactivex.ObservableTransformer;

/**
 * Description ：MemberCenterContract  V 、P契约类
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/4/2.
 */
public interface OrderDetailsContract {

    interface View extends BaseView {
        //不同的Bean单独处理
        void resultOrderDetails(OrderDetailsBean data);

        void resultGetCarCancelOrder(GetCarCancelOrderBean data);

        void resultReturnOrderDesc(ReturnOrderDescBean data);

        void resultReturnCarCancelOrder(GetCarCancelOrderBean data);

        <T> ObservableTransformer<T, T> bindLifecycle();
    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void getOrderDetails(TreeMap<String, String> map, boolean isDialog, boolean cancelable);

        public abstract void getGetCarCancelOrder(TreeMap<String, String> map, boolean isDialog, boolean cancelable);

        public abstract void getReturnCarCancelOrder(TreeMap<String, String> map, boolean isDialog, boolean cancelable);

        public abstract void getReturnOrderDesc(TreeMap<String, String> map, boolean isDialog, boolean cancelable);
    }
}