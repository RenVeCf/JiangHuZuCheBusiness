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
     * data : {"orderList":[{"orderId":96,"userId":3,"orderNo":"1962631584","successTime":"2019-05-16 14:53:46","payWay":1,"payTime":"2019-05-16 14:53:46","payStatus":2,"vehicleId":17,"storeId":13,"takevehicleTime":"2019-05-16","rentDuration":1,"status":4,"createTime":"2019-05-16","telPhone":"18502994087","week":"周四","takeStatus":1,"descStatus":null,"vehicleName":"小刀电动车","vehicleModel":"xs25445","vehicleLogo":"picture/profile/JYJY193963789020190516143316.jpg","storeName":"万达信息","descAddress":"上海市青浦区华徐公路888号中国梦谷","payMoney":1400,"revehicleTime":null,"expireTime":"2019-06-15","params":{}}]}
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
             * orderId : 96
             * userId : 3
             * orderNo : 1962631584
             * successTime : 2019-05-16 14:53:46
             * payWay : 1
             * payTime : 2019-05-16 14:53:46
             * payStatus : 2
             * vehicleId : 17
             * storeId : 13
             * takevehicleTime : 2019-05-16
             * rentDuration : 1
             * status : 4
             * createTime : 2019-05-16
             * telPhone : 18502994087
             * week : 周四
             * takeStatus : 1
             * descStatus : null
             * vehicleName : 小刀电动车
             * vehicleModel : xs25445
             * vehicleLogo : picture/profile/JYJY193963789020190516143316.jpg
             * storeName : 万达信息
             * descAddress : 上海市青浦区华徐公路888号中国梦谷
             * payMoney : 1400.0
             * revehicleTime : null
             * expireTime : 2019-06-15
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
            private ParamsBean params;
            private int itemType;

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public void setItemType(int itemType) {
                this.itemType = itemType;
            }

            public int getStoreStatus() {
                return storeStatus;
            }

            public void setStoreStatus(int storeStatus) {
                this.storeStatus = storeStatus;
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
