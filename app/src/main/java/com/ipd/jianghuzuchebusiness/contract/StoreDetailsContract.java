package com.ipd.jianghuzuchebusiness.contract;

import com.ipd.jianghuzuchebusiness.base.BasePresenter;
import com.ipd.jianghuzuchebusiness.base.BaseView;
import com.ipd.jianghuzuchebusiness.bean.ChargeBean;
import com.ipd.jianghuzuchebusiness.bean.RepairProjectHorizontalBean;
import com.ipd.jianghuzuchebusiness.bean.StoreInforBean;

import java.util.TreeMap;

import io.reactivex.ObservableTransformer;

/**
 * Description ：MemberCenterContract  V 、P契约类
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/4/2.
 */
public interface StoreDetailsContract {

    interface View extends BaseView {
        //不同的Bean单独处理
        void resultStoreInfor(StoreInforBean data);

        void resultRepairProjectHorizontal(RepairProjectHorizontalBean data);

        void resultCharge(ChargeBean data);

        <T> ObservableTransformer<T, T> bindLifecycle();
    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void getStoreInfor(TreeMap<String, String> map, boolean isDialog, boolean cancelable);

        public abstract void getRepairProjectHorizontal(TreeMap<String, String> map, boolean isDialog, boolean cancelable);

        public abstract void getCharge(boolean isDialog, boolean cancelable);
    }
}