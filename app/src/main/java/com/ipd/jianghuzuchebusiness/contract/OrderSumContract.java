package com.ipd.jianghuzuchebusiness.contract;

import com.ipd.jianghuzuchebusiness.base.BasePresenter;
import com.ipd.jianghuzuchebusiness.base.BaseView;
import com.ipd.jianghuzuchebusiness.bean.CarRentalOrderBean;
import com.ipd.jianghuzuchebusiness.bean.RepairOrderBean;

import java.util.TreeMap;

import io.reactivex.ObservableTransformer;

/**
 * Description ：MemberCenterContract  V 、P契约类
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/4/2.
 */
public interface OrderSumContract {

    interface View extends BaseView {
        //不同的Bean单独处理
        void resultRepairOrder(RepairOrderBean data);

        void resultCarRentalOrder(CarRentalOrderBean data);

        <T> ObservableTransformer<T, T> bindLifecycle();
    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void getRepairOrder(TreeMap<String, String> map, boolean isDialog, boolean cancelable);

        public abstract void getCarRentalOrder(TreeMap<String, String> map, boolean isDialog, boolean cancelable);
    }
}