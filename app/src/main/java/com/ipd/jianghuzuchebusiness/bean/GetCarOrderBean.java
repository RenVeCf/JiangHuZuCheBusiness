package com.ipd.jianghuzuchebusiness.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/16.
 */
public class GetCarOrderBean {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"orderList":[{"orderId":17,"userId":44,"orderNo":"1968149569","successTime":"2019-05-31 00:44:53","payWay":1,"payTime":"2019-05-31 00:44:41","payStatus":2,"vehicleId":11,"storeId":7,"takevehicleTime":"2019-05-31","rentDuration":3,"status":4,"createTime":"2019-05-31","telPhone":"15937016358","week":"周五","takeStatus":1,"descStatus":null,"vehicleName":"小刀电动车","vehicleModel":"xs25445","vehicleLogo":"picture/profile/JYJY192842740420190522151444.jpg","storeName":"阳阳车行","descAddress":"诚爱路58号","payMoney":1250,"revehicleTime":null,"expireTime":"2019-08-29","storeStatus":0,"city":"上海市","supId":8,"refundMoney":null,"retuStatus":null,"extendMoney":null,"pickStatus":1,"params":{}},{"orderId":14,"userId":44,"orderNo":"1942747731","successTime":"2019-05-31 00:23:55","payWay":1,"payTime":"2019-05-31 00:23:47","payStatus":2,"vehicleId":11,"storeId":7,"takevehicleTime":"2019-05-31","rentDuration":3,"status":4,"createTime":"2019-05-31","telPhone":"15937016358","week":"周五","takeStatus":2,"descStatus":null,"vehicleName":"小刀电动车","vehicleModel":"xs25445","vehicleLogo":"picture/profile/JYJY192842740420190522151444.jpg","storeName":"阳阳车行","descAddress":"诚爱路58号","payMoney":1250,"revehicleTime":null,"expireTime":"2019-08-29","storeStatus":0,"city":"上海市","supId":8,"refundMoney":null,"retuStatus":null,"extendMoney":null,"pickStatus":null,"params":{}},{"orderId":3,"userId":7,"orderNo":"1979457023","successTime":"2019-05-30 22:50:00","payWay":1,"payTime":"2019-05-30 22:49:54","payStatus":2,"vehicleId":11,"storeId":7,"takevehicleTime":"2019-05-30","rentDuration":8,"status":4,"createTime":"2019-05-30","telPhone":"18502994087","week":"周四","takeStatus":2,"descStatus":null,"vehicleName":"小刀电动车","vehicleModel":"xs25445","vehicleLogo":"picture/profile/JYJY192842740420190522151444.jpg","storeName":"阳阳车行","descAddress":"诚爱路58号","payMoney":1480,"revehicleTime":null,"expireTime":"2020-01-25","storeStatus":0,"city":"上海市","supId":8,"refundMoney":null,"retuStatus":null,"extendMoney":null,"pickStatus":null,"params":{}}]}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<OrderListBean> orderList;

        public List<OrderListBean> getOrderList() {
            return orderList;
        }

        public void setOrderList(List<OrderListBean> orderList) {
            this.orderList = orderList;
        }

        public static class OrderListBean implements MultiItemEntity{
            /**
             * orderId : 17
             * userId : 44
             * orderNo : 1968149569
             * successTime : 2019-05-31 00:44:53
             * payWay : 1
             * payTime : 2019-05-31 00:44:41
             * payStatus : 2
             * vehicleId : 11
             * storeId : 7
             * takevehicleTime : 2019-05-31
             * rentDuration : 3
             * status : 4
             * createTime : 2019-05-31
             * telPhone : 15937016358
             * week : 周五
             * takeStatus : 1
             * descStatus : null
             * vehicleName : 小刀电动车
             * vehicleModel : xs25445
             * vehicleLogo : picture/profile/JYJY192842740420190522151444.jpg
             * storeName : 阳阳车行
             * descAddress : 诚爱路58号
             * payMoney : 1250.0
             * revehicleTime : null
             * expireTime : 2019-08-29
             * storeStatus : 0
             * city : 上海市
             * supId : 8
             * refundMoney : null
             * retuStatus : null
             * extendMoney : null
             * pickStatus : 1
             * params : {}
             */

            private int orderId;
            private int userId;
            private String orderNo;
            private String successTime;
            private int payWay;
            private String payTime;
            private int payStatus;
            private int vehicleId;
            private int storeId;
            private String takevehicleTime;
            private int rentDuration;
            private int status;
            private String createTime;
            private String telPhone;
            private String week;
            private int takeStatus;
            private Object descStatus;
            private String vehicleName;
            private String vehicleModel;
            private String vehicleLogo;
            private String storeName;
            private String descAddress;
            private double payMoney;
            private Object revehicleTime;
            private String expireTime;
            private int storeStatus;
            private String city;
            private int supId;
            private Object refundMoney;
            private Object retuStatus;
            private Object extendMoney;
            private int pickStatus;
            private int itemType;
            private ParamsBean params;

            public void setItemType(int itemType) {
                this.itemType = itemType;
            }

            public int getOrderId() {
                return orderId;
            }

            public void setOrderId(int orderId) {
                this.orderId = orderId;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getOrderNo() {
                return orderNo;
            }

            public void setOrderNo(String orderNo) {
                this.orderNo = orderNo;
            }

            public String getSuccessTime() {
                return successTime;
            }

            public void setSuccessTime(String successTime) {
                this.successTime = successTime;
            }

            public int getPayWay() {
                return payWay;
            }

            public void setPayWay(int payWay) {
                this.payWay = payWay;
            }

            public String getPayTime() {
                return payTime;
            }

            public void setPayTime(String payTime) {
                this.payTime = payTime;
            }

            public int getPayStatus() {
                return payStatus;
            }

            public void setPayStatus(int payStatus) {
                this.payStatus = payStatus;
            }

            public int getVehicleId() {
                return vehicleId;
            }

            public void setVehicleId(int vehicleId) {
                this.vehicleId = vehicleId;
            }

            public int getStoreId() {
                return storeId;
            }

            public void setStoreId(int storeId) {
                this.storeId = storeId;
            }

            public String getTakevehicleTime() {
                return takevehicleTime;
            }

            public void setTakevehicleTime(String takevehicleTime) {
                this.takevehicleTime = takevehicleTime;
            }

            public int getRentDuration() {
                return rentDuration;
            }

            public void setRentDuration(int rentDuration) {
                this.rentDuration = rentDuration;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getTelPhone() {
                return telPhone;
            }

            public void setTelPhone(String telPhone) {
                this.telPhone = telPhone;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public int getTakeStatus() {
                return takeStatus;
            }

            public void setTakeStatus(int takeStatus) {
                this.takeStatus = takeStatus;
            }

            public Object getDescStatus() {
                return descStatus;
            }

            public void setDescStatus(Object descStatus) {
                this.descStatus = descStatus;
            }

            public String getVehicleName() {
                return vehicleName;
            }

            public void setVehicleName(String vehicleName) {
                this.vehicleName = vehicleName;
            }

            public String getVehicleModel() {
                return vehicleModel;
            }

            public void setVehicleModel(String vehicleModel) {
                this.vehicleModel = vehicleModel;
            }

            public String getVehicleLogo() {
                return vehicleLogo;
            }

            public void setVehicleLogo(String vehicleLogo) {
                this.vehicleLogo = vehicleLogo;
            }

            public String getStoreName() {
                return storeName;
            }

            public void setStoreName(String storeName) {
                this.storeName = storeName;
            }

            public String getDescAddress() {
                return descAddress;
            }

            public void setDescAddress(String descAddress) {
                this.descAddress = descAddress;
            }

            public double getPayMoney() {
                return payMoney;
            }

            public void setPayMoney(double payMoney) {
                this.payMoney = payMoney;
            }

            public Object getRevehicleTime() {
                return revehicleTime;
            }

            public void setRevehicleTime(Object revehicleTime) {
                this.revehicleTime = revehicleTime;
            }

            public String getExpireTime() {
                return expireTime;
            }

            public void setExpireTime(String expireTime) {
                this.expireTime = expireTime;
            }

            public int getStoreStatus() {
                return storeStatus;
            }

            public void setStoreStatus(int storeStatus) {
                this.storeStatus = storeStatus;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public int getSupId() {
                return supId;
            }

            public void setSupId(int supId) {
                this.supId = supId;
            }

            public Object getRefundMoney() {
                return refundMoney;
            }

            public void setRefundMoney(Object refundMoney) {
                this.refundMoney = refundMoney;
            }

            public Object getRetuStatus() {
                return retuStatus;
            }

            public void setRetuStatus(Object retuStatus) {
                this.retuStatus = retuStatus;
            }

            public Object getExtendMoney() {
                return extendMoney;
            }

            public void setExtendMoney(Object extendMoney) {
                this.extendMoney = extendMoney;
            }

            public int getPickStatus() {
                return pickStatus;
            }

            public void setPickStatus(int pickStatus) {
                this.pickStatus = pickStatus;
            }

            public ParamsBean getParams() {
                return params;
            }

            public void setParams(ParamsBean params) {
                this.params = params;
            }

            @Override
            public int getItemType() {
                return itemType;
            }

            public static class ParamsBean {
            }
        }
    }
}
