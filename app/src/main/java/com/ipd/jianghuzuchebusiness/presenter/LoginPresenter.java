package com.ipd.jianghuzuchebusiness.presenter;

import android.content.Context;

import com.ipd.jianghuzuchebusiness.bean.LoginBean;
import com.ipd.jianghuzuchebusiness.contract.LoginContract;
import com.ipd.jianghuzuchebusiness.model.LoginModel;
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
public class LoginPresenter extends LoginContract.Presenter {

    private LoginModel model;
    private Context context;

    public LoginPresenter(Context context) {
        this.model = new LoginModel();
        this.context = context;
    }

    @Override
    public void getLogin(TreeMap<String, String> map, boolean isDialog, boolean cancelable) {
        model.getLogin(context, map, isDialog, cancelable, getView().bindLifecycle(), new ObserverResponseListener() {
            @Override
            public void onNext(Object o) {
                //这一步是必须的，判断view是否已经被销毁
                if (getView() != null) {
                    getView().resultLogin((LoginBean) o);
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