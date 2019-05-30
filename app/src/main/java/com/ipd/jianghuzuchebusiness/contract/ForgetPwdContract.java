package com.ipd.jianghuzuchebusiness.contract;

import com.ipd.jianghuzuchebusiness.base.BasePresenter;
import com.ipd.jianghuzuchebusiness.base.BaseView;
import com.ipd.jianghuzuchebusiness.bean.CaptchaBean;
import com.ipd.jianghuzuchebusiness.bean.ForgetPwdBean;

import java.util.TreeMap;

import io.reactivex.ObservableTransformer;

/**
 * Description ：MemberCenterContract  V 、P契约类
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/4/2.
 */
public interface ForgetPwdContract {

    interface View extends BaseView {
        //不同的Bean单独处理
        void resultForgetPwd(ForgetPwdBean data);

        void resultCaptcha(CaptchaBean data);

        <T> ObservableTransformer<T, T> bindLifecycle();
    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void getForgetPwd(TreeMap<String, String> map, boolean isDialog, boolean cancelable);

        public abstract void getCaptcha(TreeMap<String, String> map, boolean isDialog, boolean cancelable);
    }
}