package com.ipd.jianghuzuchebusiness.api;

import com.ipd.jianghuzuchebusiness.bean.AddBankBean;
import com.ipd.jianghuzuchebusiness.bean.CaptchaBean;
import com.ipd.jianghuzuchebusiness.bean.CarRentalOrderBean;
import com.ipd.jianghuzuchebusiness.bean.CashWithdrawalBean;
import com.ipd.jianghuzuchebusiness.bean.CashWithdrawalFeeBean;
import com.ipd.jianghuzuchebusiness.bean.ChargeBean;
import com.ipd.jianghuzuchebusiness.bean.FinanceSumBean;
import com.ipd.jianghuzuchebusiness.bean.ForgetPwdBean;
import com.ipd.jianghuzuchebusiness.bean.GetCarCancelOrderBean;
import com.ipd.jianghuzuchebusiness.bean.GetCarCommitBean;
import com.ipd.jianghuzuchebusiness.bean.GetCarOrderBean;
import com.ipd.jianghuzuchebusiness.bean.LastBankBean;
import com.ipd.jianghuzuchebusiness.bean.LoginBean;
import com.ipd.jianghuzuchebusiness.bean.OrderDetailsBean;
import com.ipd.jianghuzuchebusiness.bean.RepairCancelBean;
import com.ipd.jianghuzuchebusiness.bean.RepairDetailsBean;
import com.ipd.jianghuzuchebusiness.bean.RepairFinishBean;
import com.ipd.jianghuzuchebusiness.bean.RepairOrderBean;
import com.ipd.jianghuzuchebusiness.bean.RepairOrderListBean;
import com.ipd.jianghuzuchebusiness.bean.RepairProjectHorizontalBean;
import com.ipd.jianghuzuchebusiness.bean.ReturnOrderDescBean;
import com.ipd.jianghuzuchebusiness.bean.SelectBankBean;
import com.ipd.jianghuzuchebusiness.bean.SelectCarBean;
import com.ipd.jianghuzuchebusiness.bean.SelectOpeningBankBean;
import com.ipd.jianghuzuchebusiness.bean.StoreImgBean;
import com.ipd.jianghuzuchebusiness.bean.StoreInforBean;
import com.ipd.jianghuzuchebusiness.bean.UploadImgBean;
import com.ipd.jianghuzuchebusiness.bean.VehicleConditionHorizontalBean;
import com.ipd.jianghuzuchebusiness.bean.VehicleConditionVerticalBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.Query;

import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.ADD_BANK;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.CAR_RENTAL_ORDER;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.CAR_RETURN_ORDER;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.CASH_WITHDRAWAL;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.CASH_WITHDRAWAL_FEE;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.CHARGE;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.FINANCE_SUM;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.FORGET_PWD;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.GET_CAR_CANCEL_ORDER;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.GET_CAR_COMMIT;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.GET_CAR_ORDER;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.GET_CAR_ORDER_DETAILS;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.LAST_BANK;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.LOGIN;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.MODIFY_STORE_INFOR;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.REPAIR_CANCEL;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.REPAIR_DETAILS;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.REPAIR_FINISH;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.REPAIR_ORDER;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.REPAIR_ORDER_LIST;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.REPAIR_PROJECT_HORIZONTAL;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.RETURN_CAR_CANCEL_ORDER;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.RETURN_CAR_COMMIT;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.RETURN_ORDER_DESC;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.SELECT_BACK;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.SELECT_CAR;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.SELECT_OPENING_BACK;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.STORE_IMG;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.STORE_INFOR;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.UPLOAD_IMG;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.VEHICLE_CONDITION_HORIZONTAL;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.VEHICLE_CONDITION_VERTICAL;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.VERIFICATION_CODE;

/**
 * Description ：请求配置
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2018/8/27.
 */
public interface ApiService {

    //验证码
    @FormUrlEncoded
    @POST(VERIFICATION_CODE)
    Observable<CaptchaBean> getCaptcha(@FieldMap Map<String, String> map);

    //忘记密码
    @FormUrlEncoded
    @POST(FORGET_PWD)
    Observable<ForgetPwdBean> getForgetPwd(@FieldMap Map<String, String> map);

    //登录
    @FormUrlEncoded
    @POST(LOGIN)
    Observable<LoginBean> getLogin(@FieldMap Map<String, String> map);

    //上传图片
    @Multipart
    @POST(UPLOAD_IMG)
    Observable<UploadImgBean> getUploadImg(@Query("type") String description, @PartMap Map<String, RequestBody> map);

    //取车订单-列表-状态-4
    @FormUrlEncoded
    @POST(GET_CAR_ORDER)
    Observable<GetCarOrderBean> getGetCarOrder(@FieldMap Map<String, String> map);

    //取车订单详情
    @FormUrlEncoded
    @POST(GET_CAR_ORDER_DETAILS)
    Observable<OrderDetailsBean> getGetCarOrderDetails(@FieldMap Map<String, String> map);

    //取车取消订单
    @FormUrlEncoded
    @POST(GET_CAR_CANCEL_ORDER)
    Observable<GetCarCancelOrderBean> getGetCarCancelOrder(@FieldMap Map<String, String> map);

    //车辆状况-类型列表
    @FormUrlEncoded
    @POST(VEHICLE_CONDITION_HORIZONTAL)
    Observable<VehicleConditionHorizontalBean> getVehicleConditionHorizontal(@FieldMap Map<String, String> map);

    //车辆状况-类型-下级数据
    @FormUrlEncoded
    @POST(VEHICLE_CONDITION_VERTICAL)
    Observable<VehicleConditionVerticalBean> getVehicleConditionVertical(@FieldMap Map<String, String> map);

    //填写去取车单-提交推送
    @FormUrlEncoded
    @POST(GET_CAR_COMMIT)
    Observable<GetCarCommitBean> getGetCarCommit(@FieldMap Map<String, String> map);

    //订单查看-详情-查看车辆-取车单
    @FormUrlEncoded
    @POST(SELECT_CAR)
    Observable<SelectCarBean> getSelectCar(@FieldMap Map<String, String> map);

    //退车订单-列表-5
    @FormUrlEncoded
    @POST(CAR_RETURN_ORDER)
    Observable<GetCarOrderBean> getCarReturnOrder(@FieldMap Map<String, String> map);

    //退车取消订单
    @FormUrlEncoded
    @POST(RETURN_CAR_CANCEL_ORDER)
    Observable<GetCarCancelOrderBean> getReturnCarCancelOrder(@FieldMap Map<String, String> map);

    //退车订单-详情
    @FormUrlEncoded
    @POST(RETURN_ORDER_DESC)
    Observable<ReturnOrderDescBean> getReturnOrderDesc(@FieldMap Map<String, String> map);

    //填写去退车单-提交推送
    @FormUrlEncoded
    @POST(RETURN_CAR_COMMIT)
    Observable<GetCarCommitBean> getReturnCarCommit(@FieldMap Map<String, String> map);

    //维修订单-数据统计
    @FormUrlEncoded
    @POST(REPAIR_ORDER)
    Observable<RepairOrderBean> getRepairOrder(@FieldMap Map<String, String> map);

    //租车订单-数据统计
    @FormUrlEncoded
    @POST(CAR_RENTAL_ORDER)
    Observable<CarRentalOrderBean> getCarRentalOrder(@FieldMap Map<String, String> map);

    //财务统计列表数据
    @FormUrlEncoded
    @POST(FINANCE_SUM)
    Observable<FinanceSumBean> getFinanceSum(@FieldMap Map<String, String> map);

    //维修保养-维修项目-类型
    @FormUrlEncoded
    @POST(REPAIR_PROJECT_HORIZONTAL)
    Observable<RepairProjectHorizontalBean> getRepairProjectHorizontal(@FieldMap Map<String, String> map);

    //维修保养-充电下拉数据
    @POST(CHARGE)
    Observable<ChargeBean> getCharge();

    //门店资料
    @FormUrlEncoded
    @POST(STORE_INFOR)
    Observable<StoreInforBean> getStoreInfor(@FieldMap Map<String, String> map);

    //门店资料-修改
    @FormUrlEncoded
    @POST(MODIFY_STORE_INFOR)
    Observable<CaptchaBean> getEditStoreInfor(@FieldMap Map<String, String> map);

    //门店图片
    @FormUrlEncoded
    @POST(STORE_IMG)
    Observable<StoreImgBean> getStoreImg(@FieldMap Map<String, String> map);

    //维修保养订单-列表数据
    @FormUrlEncoded
    @POST(REPAIR_ORDER_LIST)
    Observable<RepairOrderListBean> getRepairOrderList(@FieldMap Map<String, String> map);

    //维修保养订单-列表详情数据
    @FormUrlEncoded
    @POST(REPAIR_DETAILS)
    Observable<RepairDetailsBean> getRepairDetails(@FieldMap Map<String, String> map);

    //维修保养订单-维修完毕
    @FormUrlEncoded
    @POST(REPAIR_FINISH)
    Observable<RepairFinishBean> getRepairFinish(@FieldMap Map<String, String> map);

    //维修保养订单-取消订单
    @FormUrlEncoded
    @POST(REPAIR_CANCEL)
    Observable<RepairCancelBean> getRepairCancel(@FieldMap Map<String, String> map);

    //提现费率
    @FormUrlEncoded
    @POST(CASH_WITHDRAWAL_FEE)
    Observable<CashWithdrawalFeeBean> getCashWithdrawalFee(@FieldMap Map<String, String> map);

    //我的银行卡列表
    @FormUrlEncoded
    @POST(SELECT_BACK)
    Observable<SelectBankBean> getSelectBank(@FieldMap Map<String, String> map);

    //添加银行卡-选择开户行
    @POST(SELECT_OPENING_BACK)
    Observable<SelectOpeningBankBean> getSelectOpeningBank();

    //添加银行卡
    @FormUrlEncoded
    @POST(ADD_BANK)
    Observable<AddBankBean> getAddBank(@FieldMap Map<String, String> map);

    //我的银行卡最近使用的-一张银行卡
    @FormUrlEncoded
    @POST(LAST_BANK)
    Observable<LastBankBean> getLastBank(@FieldMap Map<String, String> map);

    //我的钱包提现
    @FormUrlEncoded
    @POST(CASH_WITHDRAWAL)
    Observable<CashWithdrawalBean> getCashWithdrawal(@FieldMap Map<String, String> map);
}
