package com.ipd.jianghuzuchebusiness.presenter;

import android.content.Context;

import com.ipd.jianghuzuchebusiness.bean.AddBankBean;
import com.ipd.jianghuzuchebusiness.bean.SelectOpeningBankBean;
import com.ipd.jianghuzuchebusiness.contract.SelectOpeningBankContract;
import com.ipd.jianghuzuchebusiness.model.SelectOpeningBankModel;
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
public class SelectOpeningBankPresenter extends SelectOpeningBankContract.Presenter {

    private SelectOpeningBankModel model;
    private Context context;

    public SelectOpeningBankPresenter(Context context) {
        this.model = new SelectOpeningBankModel();
        this.context = context;
    }

    @Override
    public void getSelectOpeningBank(boolean isDialog, boolean cancelable) {
        model.getSelectOpeningBank(context, isDialog, cancelable, getView().bindLifecycle(), new ObserverResponseListener() {
            @Override
            public void onNext(Object o) {
                //这一步是必须的，判断view是否已经被销毁
                if (getView() != null) {
                    getView().resultSelectOpeningBank((SelectOpeningBankBean) o);
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
    public void getAddBank(TreeMap<String, String> map, boolean isDialog, boolean cancelable) {
        model.getAddBank(context, map, isDialog, cancelable, getView().bindLifecycle(), new ObserverResponseListener() {
            @Override
            public void onNext(Object o) {
                //这一步是必须的，判断view是否已经被销毁
                if (getView() != null) {
                    getView().resultAddBank((AddBankBean) o);
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