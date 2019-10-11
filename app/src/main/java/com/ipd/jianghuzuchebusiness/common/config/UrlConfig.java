package com.ipd.jianghuzuchebusiness.common.config;

/**
 * Description ：URL 配置
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2018/8/26.
 */
public interface UrlConfig {
    /**
     * 域名
     */
    String BASE_URL = "http://jhkc.hanyu365.com.cn:8010/jhzc/";
    String BASE_LOCAL_URL = "http://jhkc.hanyu365.com.cn:8010/";
//    String BASE_URL = "http://119.29.217.120/jhzc/";
//    String BASE_LOCAL_URL = "http://119.29.217.120/";

    /**
     * 登陆
     */
    String VERIFICATION_CODE = "appUser/util/getSms"; //验证码
    String FORGET_PWD = "appStore/login/forgetPassword"; //忘记密码
    String LOGIN = "appStore/login/login"; //登陆
    String UPLOAD_ID_IMG = "appUser/login/uploadID"; //上传身份证照片
    String UPLOAD_IMG = "appUser/util/upload"; //上传图片
    String MODIFY_USER_DATA = "appUser/user/userUpdate"; //修改用户信息
    String FEED_BACK = "appUser/feedback/userFeedback"; //用户意见反馈


    /**
     * 取车订单
     */
    String GET_CAR_ORDER = "appStore/pickOrder/pickOrder"; //取车订单-列表-状态-4
    String GET_CAR_ORDER_DETAILS = "appStore/pickOrder/pickOrderDesc"; //取车订单详情
    String GET_CAR_CANCEL_ORDER = "appStore/pickOrder/pickCancelOrder"; //取车取消订单
    String VEHICLE_CONDITION_HORIZONTAL = "appStore/carReturn/vehicleStatus"; //门店填写推车单-回显车辆状况-单个接口两个数据
    String VEHICLE_CONDITION_VERTICAL = "appStore/pickOrder/vehicleStatus"; //车辆状况-类型-下级数据
    String GET_CAR_COMMIT = "appStore/pickOrder/addPickOrder"; //填写去取车单-提交推送
    String SELECT_CAR = "appStore/pickOrder/selectVehicle"; //订单查看-详情-查看车辆-取车单


    /**
     * 退车订单
     */
    String CAR_RETURN_ORDER = "appStore/carReturn/carReturnOrder"; //退车订单-列表-5
    String RETURN_CAR_CANCEL_ORDER = "appStore/carReturn/pickCancelOrder"; //退车取消订单
    String RETURN_ORDER_DESC = "appStore/carReturn/ReturnOrderDesc"; //退车订单-详情
    String RETURN_CAR_COMMIT = "appStore/carReturn/addReturnOrder"; //填写去退车单-提交推送


    /**
     * 订单统计
     */
    String REPAIR_ORDER = "appStore/orderData/repairData"; //维修订单-数据统计
    String CAR_RENTAL_ORDER = "appStore/orderData/vehiclelData"; //租车订单-数据统计


    /**
     * 财务统计
     */
    String FINANCE_SUM = "appStore/financialData/dataList"; //财务统计列表数据
    String WALLET = "appUser/balance/userDetailed"; //我的钱包余额明细
    String CASH_WITHDRAWAL_FEE = "appUser/balance/putConf"; //提现费率
    String SELECT_BACK = "appUser/bank/myList"; //我的银行卡列表
    String SELECT_OPENING_BACK = "appUser/bank/bankType"; //添加银行卡-选择开户行
    String ADD_BANK = "appUser/bank/insertBank"; //添加银行卡
    String LAST_BANK = "appUser/bank/latelyBank"; //我的银行卡最近使用的-一张银行卡
    String CASH_WITHDRAWAL = "appUser/balance/balancePutforwardPay"; //我的钱包提现


    /**
     * 门店资料
     */
    String STORE_IMG = "appStore/means/picPath"; //门店图片
    String REPAIR_PROJECT_HORIZONTAL = "appUser/repair/repairType"; //维修保养-维修项目-类型
    String CHARGE = "appUser/repair/downCharge"; //维修保养-充电下拉数据
    String STORE_INFOR = "appStore/means/storeMeans"; //门店资料
    String MODIFY_STORE_INFOR = "appStore/means/updateMeans"; //门店资料-修改


    /**
     * 维保订单
     */
    String REPAIR_ORDER_LIST = "appStore/repairOrder/orderList"; //维修保养订单-列表数据
    String REPAIR_DETAILS = "appStore/repairOrder/orderDetails"; //维修保养订单-列表详情数据
    String REPAIR_FINISH = "appStore/repairOrder/completeOrder"; //维修保养订单-维修完毕
    String REPAIR_CANCEL = "appStore/repairOrder/cancelOrder"; //维修保养订单-取消订单

    /**
     * 版本更新
     */
    String MODIFY_VERSION = "appUser/version/versionInfo"; //版本更新
}
