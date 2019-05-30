package com.ipd.jianghuzuchebusiness.contract;

import com.ipd.jianghuzuchebusiness.base.BasePresenter;
import com.ipd.jianghuzuchebusiness.base.BaseView;
import com.ipd.jianghuzuchebusiness.bean.AddBankBean;
import com.ipd.jianghuzuchebusiness.bean.SelectOpeningBankBean;

import java.util.TreeMap;

import io.reactivex.ObservableTransformer;

/**
 * Description ：MemberCenterContract  V 、P契约类
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/4/2.
 */
public interface SelectOpeningBankContract {

    interface View extends BaseView {
        //不同的Bean单独处理
        void resultSelectOpeningBank(SelectOpeningBankBean data);

        void resultAddBank(AddBankBean data);

        <T> ObservableTransformer<T, T> bindLifecycle();
    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void getSelectOpeningBank(boolean isDialog, boolean cancelable);

        public abstract void getAddBank(TreeMap<String, String> map, boolean isDialog, boolean cancelable);
    }
}