package com.ipd.jianghuzuchebusiness.contract;

import com.ipd.jianghuzuchebusiness.base.BasePresenter;
import com.ipd.jianghuzuchebusiness.base.BaseView;
import com.ipd.jianghuzuchebusiness.bean.GetCarCancelOrderBean;
import com.ipd.jianghuzuchebusiness.bean.GetCarOrderBean;
import com.ipd.jianghuzuchebusiness.bean.RepairCancelBean;
import com.ipd.jianghuzuchebusiness.bean.RepairDetailsBean;
import com.ipd.jianghuzuchebusiness.bean.RepairFinishBean;
import com.ipd.jianghuzuchebusiness.bean.RepairOrderListBean;

import java.util.TreeMap;

import io.reactivex.ObservableTransformer;

/**
 * Description ：MemberCenterContract  V 、P契约类
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/4/2.
 */
public interface MultipleOrderContract {

    interface View extends BaseView {
        //不同的Bean单独处理
        void resultRepairOrderList(RepairOrderListBean data);

        void resultRepairDetails(RepairDetailsBean data);

        void resultRepairFinish(RepairFinishBean data);

        void resultRepairCancel(RepairCancelBean data);

        void resultGetCarOrder(GetCarOrderBean data);

        void resultCarReturnOrder(GetCarOrderBean data);

        void resultGetCarCancelOrder(GetCarCancelOrderBean data);

        void resultReturnCarCancelOrder(GetCarCancelOrderBean data);

        <T> ObservableTransformer<T, T> bindLifecycle();
    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void getRepairOrderList(TreeMap<String, String> map, boolean isDialog, boolean cancelable);

        public abstract void getRepairDetails(TreeMap<String, String> map, boolean isDialog, boolean cancelable);

        public abstract void getRepairFinish(TreeMap<String, String> map, boolean isDialog, boolean cancelable);

        public abstract void getRepairCancel(TreeMap<String, String> map, boolean isDialog, boolean cancelable);

        public abstract void getGetCarOrder(TreeMap<String, String> map, boolean isDialog, boolean cancelable);

        public abstract void getCarReturnOrder(TreeMap<String, String> map, boolean isDialog, boolean cancelable);

        public abstract void getGetCarCancelOrder(TreeMap<String, String> map, boolean isDialog, boolean cancelable);

        public abstract void getReturnCarCancelOrder(TreeMap<String, String> map, boolean isDialog, boolean cancelable);
    }
}