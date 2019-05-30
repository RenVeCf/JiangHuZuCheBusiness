package com.ipd.jianghuzuchebusiness.presenter;

import android.content.Context;

import com.ipd.jianghuzuchebusiness.bean.SelectBankBean;
import com.ipd.jianghuzuchebusiness.contract.SelectBankContract;
import com.ipd.jianghuzuchebusiness.model.SelectBankModel;
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
public class SelectBankPresenter extends SelectBankContract.Presenter {

    private SelectBankModel model;
    private Context context;

    public SelectBankPresenter(Context context) {
        this.model = new SelectBankModel();
        this.context = context;
    }

    @Override
    public void getSelectBank(TreeMap<String, String> map, boolean isDialog, boolean cancelable) {
        model.getSelectBank(context, map, isDialog, cancelable, getView().bindLifecycle(), new ObserverResponseListener() {
            @Override
            public void onNext(Object o) {
                //这一步是必须的，判断view是否已经被销毁
                if (getView() != null) {
                    getView().resultSelectBank((SelectBankBean) o);
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