package com.ipd.jianghuzuchebusiness.presenter;

import android.content.Context;

import com.ipd.jianghuzuchebusiness.bean.VehicleConditionHorizontalBean;
import com.ipd.jianghuzuchebusiness.contract.VehicleConditionHorizontalContract;
import com.ipd.jianghuzuchebusiness.model.VehicleConditionHorizontalModel;
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
public class VehicleConditionHorizontalPresenter extends VehicleConditionHorizontalContract.Presenter {

    private VehicleConditionHorizontalModel model;
    private Context context;

    public VehicleConditionHorizontalPresenter(Context context) {
        this.model = new VehicleConditionHorizontalModel();
        this.context = context;
    }

    @Override
    public void getVehicleConditionHorizontal(TreeMap<String, String> map, boolean isDialog, boolean cancelable) {
        model.getVehicleConditionHorizontal(context, map, isDialog, cancelable, getView().bindLifecycle(), new ObserverResponseListener() {
            @Override
            public void onNext(Object o) {
                //这一步是必须的，判断view是否已经被销毁
                if (getView() != null) {
                    getView().resultVehicleConditionHorizontal((VehicleConditionHorizontalBean) o);
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