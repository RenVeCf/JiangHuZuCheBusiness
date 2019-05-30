package com.ipd.jianghuzuchebusiness.model;

import android.content.Context;

import com.ipd.jianghuzuchebusiness.api.Api;
import com.ipd.jianghuzuchebusiness.base.BaseModel;
import com.ipd.jianghuzuchebusiness.progress.ObserverResponseListener;

import java.util.TreeMap;

import io.reactivex.ObservableTransformer;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2018/8/26.
 */
public class StoreDetailsModel<T> extends BaseModel {

    public void getStoreInfor(Context context, TreeMap<String, String> map, boolean isDialog, boolean cancelable,
                              ObservableTransformer<T, T> transformer, ObserverResponseListener observerListener) {

        //当不需要指定是否由dialog时，可以调用这个方法
        //        subscribe(context, Api.getApiService().login(map), observerListener);
        paramSubscribe(context, Api.getApiService().getStoreInfor(map), observerListener, transformer, isDialog, cancelable);
    }

    public void getRepairProjectHorizontal(Context context, TreeMap<String, String> map, boolean isDialog, boolean cancelable,
                                           ObservableTransformer<T, T> transformer, ObserverResponseListener observerListener) {

        //当不需要指定是否由dialog时，可以调用这个方法
        //        subscribe(context, Api.getApiService().login(map), observerListener);
        paramSubscribe(context, Api.getApiService().getRepairProjectHorizontal(map), observerListener, transformer, isDialog, cancelable);
    }

    public void getCharge(Context context, boolean isDialog, boolean cancelable,
                          ObserverResponseListener observerListener) {

        //当不需要指定是否由dialog时，可以调用这个方法
        //        subscribe(context, Api.getApiService().login(map), observerListener);
        nullParamSubscribe(context, Api.getApiService().getCharge(), observerListener, isDialog, cancelable);
    }
    //// TODO: 2017/12/27 其他需要请求、数据库等等的操作
}
