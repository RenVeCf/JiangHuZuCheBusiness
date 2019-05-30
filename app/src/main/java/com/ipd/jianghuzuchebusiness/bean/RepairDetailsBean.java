package com.ipd.jianghuzuchebusiness.bean;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/23.
 */
public class RepairDetailsBean {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"costList":[{"costId":83,"title":"充电包月","money":999,"createTime":"2019-05-23 16:02:29","chargeNum":1,"orderId":37,"type":2,"coupon":null},{"costId":84,"title":"灯尾","money":99,"createTime":"2019-05-23 16:02:29","chargeNum":0,"orderId":37,"type":1,"coupon":null},{"costId":85,"title":"优惠卷","money":50,"createTime":"2019-05-23 16:02:37","chargeNum":0,"orderId":37,"type":1,"coupon":null}],"order":{"orderId":37,"userId":7,"orderNo":"1954974854","successTime":"2019-02-01","payWay":0,"payTime":"2019-05-23 16:02:37","payStatus":2,"storeId":7,"status":4,"telPhone":"18502994087","userName":"jhzc427601","totalMoney":null,"createTime":"2019-05-23 16:02:29","charges":null,"repairs":null,"storeName":"阳阳车行","descAddress":"上海市青浦区明珠路","logo":"picture/profile/JYJY191561917620190522151236.jpg","payMoney":null,"params":{}}}
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
        /**
         * costList : [{"costId":83,"title":"充电包月","money":999,"createTime":"2019-05-23 16:02:29","chargeNum":1,"orderId":37,"type":2,"coupon":null},{"costId":84,"title":"灯尾","money":99,"createTime":"2019-05-23 16:02:29","chargeNum":0,"orderId":37,"type":1,"coupon":null},{"costId":85,"title":"优惠卷","money":50,"createTime":"2019-05-23 16:02:37","chargeNum":0,"orderId":37,"type":1,"coupon":null}]
         * order : {"orderId":37,"userId":7,"orderNo":"1954974854","successTime":"2019-02-01","payWay":0,"payTime":"2019-05-23 16:02:37","payStatus":2,"storeId":7,"status":4,"telPhone":"18502994087","userName":"jhzc427601","totalMoney":null,"createTime":"2019-05-23 16:02:29","charges":null,"repairs":null,"storeName":"阳阳车行","descAddress":"上海市青浦区明珠路","logo":"picture/profile/JYJY191561917620190522151236.jpg","payMoney":null,"params":{}}
         */

        private OrderBean order;
        private List<CostListBean> costList;

        public OrderBean getOrder() {
            return order;
        }

        public void setOrder(OrderBean order) {
            this.order = order;
        }

        public List<CostListBean> getCostList() {
            return costList;
        }

        public void setCostList(List<CostListBean> costList) {
            this.costList = costList;
        }

        public static class OrderBean {
            /**
             * orderId : 37
             * userId : 7
             * orderNo : 1954974854
             * successTime : 2019-02-01
             * payWay : 0
             * payTime : 2019-05-23 16:02:37
             * payStatus : 2
             * storeId : 7
             * status : 4
             * telPhone : 18502994087
             * userName : jhzc427601
             * totalMoney : null
             * createTime : 2019-05-23 16:02:29
             * charges : null
             * repairs : null
             * storeName : 阳阳车行
             * descAddress : 上海市青浦区明珠路
             * logo : picture/profile/JYJY191561917620190522151236.jpg
             * payMoney : null
             * params : {}
             */

            private int orderId;
            private int userId;
            private String orderNo;
            private String successTime;
            private int payWay;
            private String payTime;
            private int payStatus;
            private int storeId;
            private int status;
            private String telPhone;
            private String userName;
            private Object totalMoney;
            private String createTime;
            private String charges;
            private String repairs;
            private String storeName;
            private String descAddress;
            private String logo;
            private Object payMoney;
            private ParamsBean params;

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

            public int getStoreId() {
                return storeId;
            }

            public void setStoreId(int storeId) {
                this.storeId = storeId;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getTelPhone() {
                return telPhone;
            }

            public void setTelPhone(String telPhone) {
                this.telPhone = telPhone;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public Object getTotalMoney() {
                return totalMoney;
            }

            public void setTotalMoney(Object totalMoney) {
                this.totalMoney = totalMoney;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getCharges() {
                return charges;
            }

            public void setCharges(String charges) {
                this.charges = charges;
            }

            public String getRepairs() {
                return repairs;
            }

            public void setRepairs(String repairs) {
                this.repairs = repairs;
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

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public Object getPayMoney() {
                return payMoney;
            }

            public void setPayMoney(Object payMoney) {
                this.payMoney = payMoney;
            }

            public ParamsBean getParams() {
                return params;
            }

            public void setParams(ParamsBean params) {
                this.params = params;
            }

            public static class ParamsBean {
            }
        }

        public static class CostListBean {
            /**
             * costId : 83
             * title : 充电包月
             * money : 999.0
             * createTime : 2019-05-23 16:02:29
             * chargeNum : 1
             * orderId : 37
             * type : 2
             * coupon : null
             */

            private int costId;
            private String title;
            private double money;
            private String createTime;
            private int chargeNum;
            private int orderId;
            private int type;
            private Object coupon;

            public int getCostId() {
                return costId;
            }

            public void setCostId(int costId) {
                this.costId = costId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public double getMoney() {
                return money;
            }

            public void setMoney(double money) {
                this.money = money;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public int getChargeNum() {
                return chargeNum;
            }

            public void setChargeNum(int chargeNum) {
                this.chargeNum = chargeNum;
            }

            public int getOrderId() {
                return orderId;
            }

            public void setOrderId(int orderId) {
                this.orderId = orderId;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public Object getCoupon() {
                return coupon;
            }

            public void setCoupon(Object coupon) {
                this.coupon = coupon;
            }
        }
    }
}
