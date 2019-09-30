package com.ipd.jianghuzuchebusiness.bean;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/16.
 */
public class OrderDetailsBean {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"picPath":"picture/vehicle/JYJY190252536720190522172345.jpeg,picture/vehicle/JYJY190292864020190522172349.jpeg,picture/vehicle/JYJY190323473320190522172352.jpeg","vehicleOrstatus":[{"orstatusId":43,"vestatusName":"头部","damagedCost":11,"status":2,"orderId":32,"statusId":2,"userId":null,"createTime":"2019-05-22 17:23:57","type":null},{"orstatusId":44,"vestatusName":"尾部","damagedCost":11,"status":2,"orderId":32,"statusId":3,"userId":null,"createTime":"2019-05-22 17:23:57","type":null},{"orstatusId":45,"vestatusName":"头部","damagedCost":11,"status":1,"orderId":32,"statusId":5,"userId":null,"createTime":"2019-05-22 17:23:57","type":null},{"orstatusId":46,"vestatusName":"尾部","damagedCost":11,"status":1,"orderId":32,"statusId":6,"userId":null,"createTime":"2019-05-22 17:23:57","type":null},{"orstatusId":47,"vestatusName":"测试服务","damagedCost":1111,"status":2,"orderId":32,"statusId":26,"userId":null,"createTime":"2019-05-22 17:23:57","type":null},{"orstatusId":48,"vestatusName":"测试01","damagedCost":111,"status":1,"orderId":32,"statusId":24,"userId":null,"createTime":"2019-05-22 17:23:57","type":null},{"orstatusId":49,"vestatusName":"测试01","damagedCost":0,"status":1,"orderId":32,"statusId":25,"userId":null,"createTime":"2019-05-22 17:23:57","type":null},{"orstatusId":50,"vestatusName":"测试01","damagedCost":111,"status":2,"orderId":32,"statusId":28,"userId":null,"createTime":"2019-05-22 17:23:57","type":null},{"orstatusId":51,"vestatusName":"测试01","damagedCost":111,"status":1,"orderId":32,"statusId":27,"userId":null,"createTime":"2019-05-22 17:23:57","type":null},{"orstatusId":52,"vestatusName":"测试01","damagedCost":111,"status":2,"orderId":32,"statusId":23,"userId":null,"createTime":"2019-05-22 17:23:57","type":null},{"orstatusId":53,"vestatusName":"测试01","damagedCost":111,"status":1,"orderId":32,"statusId":29,"userId":null,"createTime":"2019-05-22 17:23:57","type":null},{"orstatusId":54,"vestatusName":"111","damagedCost":12313,"status":2,"orderId":32,"statusId":21,"userId":null,"createTime":"2019-05-22 17:23:57","type":null},{"orstatusId":55,"vestatusName":"测试","damagedCost":22,"status":2,"orderId":32,"statusId":22,"userId":null,"createTime":"2019-05-22 17:23:57","type":null}],"vehicleCost":[{"costId":37,"deposit":1000,"equipCost":100,"tenancyService":300,"total":1350,"orderId":32,"coupon":"50.00","createTime":"2019-05-22 15:15:31","vehicleRent":50,"chargeMoney":null,"rentDuration":1}],"storeStatus":2,"order":{"orderId":32,"userId":7,"orderNo":"1933144987","successTime":"2019-05-22 15:15:31","payWay":2,"payTime":"2019-05-22 15:15:31","payStatus":2,"vehicleId":11,"storeId":7,"takevehicleTime":"2019-05-22","rentDuration":1,"status":4,"createTime":"2019-05-22","telPhone":"18502994087","week":"周三","takeStatus":2,"descStatus":null,"vehicleName":"小刀电动车","vehicleModel":"xs25445","vehicleLogo":"picture/profile/JYJY192842740420190522151444.jpg","storeName":"阳阳车行","descAddress":"上海市青浦区明珠路","payMoney":1350,"revehicleTime":null,"expireTime":"2019-06-21","storeStatus":null,"city":"上海市","params":{}}}
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
         * picPath : {"vehicleInfoId":8,"picPath":"picture/vehicle/JYJY192112721820190528175331.jpeg,picture/vehicle/JYJY192156841020190528175335.jpeg,picture/vehicle/JYJY192337588720190528175353.jpeg","plateNumber":"8888","orderId":16,"createTime":null,"type":null}
         * vehicleOrstatus : [{"orstatusId":43,"vestatusName":"头部","damagedCost":11,"status":2,"orderId":32,"statusId":2,"userId":null,"createTime":"2019-05-22 17:23:57","type":null},{"orstatusId":44,"vestatusName":"尾部","damagedCost":11,"status":2,"orderId":32,"statusId":3,"userId":null,"createTime":"2019-05-22 17:23:57","type":null},{"orstatusId":45,"vestatusName":"头部","damagedCost":11,"status":1,"orderId":32,"statusId":5,"userId":null,"createTime":"2019-05-22 17:23:57","type":null},{"orstatusId":46,"vestatusName":"尾部","damagedCost":11,"status":1,"orderId":32,"statusId":6,"userId":null,"createTime":"2019-05-22 17:23:57","type":null},{"orstatusId":47,"vestatusName":"测试服务","damagedCost":1111,"status":2,"orderId":32,"statusId":26,"userId":null,"createTime":"2019-05-22 17:23:57","type":null},{"orstatusId":48,"vestatusName":"测试01","damagedCost":111,"status":1,"orderId":32,"statusId":24,"userId":null,"createTime":"2019-05-22 17:23:57","type":null},{"orstatusId":49,"vestatusName":"测试01","damagedCost":0,"status":1,"orderId":32,"statusId":25,"userId":null,"createTime":"2019-05-22 17:23:57","type":null},{"orstatusId":50,"vestatusName":"测试01","damagedCost":111,"status":2,"orderId":32,"statusId":28,"userId":null,"createTime":"2019-05-22 17:23:57","type":null},{"orstatusId":51,"vestatusName":"测试01","damagedCost":111,"status":1,"orderId":32,"statusId":27,"userId":null,"createTime":"2019-05-22 17:23:57","type":null},{"orstatusId":52,"vestatusName":"测试01","damagedCost":111,"status":2,"orderId":32,"statusId":23,"userId":null,"createTime":"2019-05-22 17:23:57","type":null},{"orstatusId":53,"vestatusName":"测试01","damagedCost":111,"status":1,"orderId":32,"statusId":29,"userId":null,"createTime":"2019-05-22 17:23:57","type":null},{"orstatusId":54,"vestatusName":"111","damagedCost":12313,"status":2,"orderId":32,"statusId":21,"userId":null,"createTime":"2019-05-22 17:23:57","type":null},{"orstatusId":55,"vestatusName":"测试","damagedCost":22,"status":2,"orderId":32,"statusId":22,"userId":null,"createTime":"2019-05-22 17:23:57","type":null}]
         * vehicleCost : [{"costId":37,"deposit":1000,"equipCost":100,"tenancyService":300,"total":1350,"orderId":32,"coupon":"50.00","createTime":"2019-05-22 15:15:31","vehicleRent":50,"chargeMoney":null,"rentDuration":1}]
         * storeStatus : 2
         * order : {"orderId":32,"userId":7,"orderNo":"1933144987","successTime":"2019-05-22 15:15:31","payWay":2,"payTime":"2019-05-22 15:15:31","payStatus":2,"vehicleId":11,"storeId":7,"takevehicleTime":"2019-05-22","rentDuration":1,"status":4,"createTime":"2019-05-22","telPhone":"18502994087","week":"周三","takeStatus":2,"descStatus":null,"vehicleName":"小刀电动车","vehicleModel":"xs25445","vehicleLogo":"picture/profile/JYJY192842740420190522151444.jpg","storeName":"阳阳车行","descAddress":"上海市青浦区明珠路","payMoney":1350,"revehicleTime":null,"expireTime":"2019-06-21","storeStatus":null,"city":"上海市","params":{}}
         * user : {"userId":7,"telPhone":"18502994087","password":"74e4e50701161c4d481d41ca837f1864","userName":"jhzc427601","userCall":"","parentId":0,"balance":3600.0,"invitationCode":"dogj6yvx","avatar":"picture/profile/JYJY191039252520190702125143.jpeg","userType":1,"status":2,"idPositive":"picture/profileID/JYJY192701404720190520174110.jpeg","idOpposite":"picture/profileID/JYJY192734900920190520174113.jpeg","idHold":"picture/profileID/JYJY192775710020190520174117.jpeg","createTime":"2019-05-20 17:41:04","telPhones":null,"oppenId":null,"params":{},"storeId":0}
         */

        private PicPathBean picPath;
        private int storeStatus;
        private OrderBean order;
        private List<VehicleOrstatusBean> vehicleOrstatus;
        private List<VehicleCostBean> vehicleCost;
        private List<VehicleEndcostBean> vehicleEndcost;
        private UserBean user;

        public PicPathBean getPicPath() {
            return picPath;
        }

        public void setVehiclePic(PicPathBean picPath) {
            this.picPath = picPath;
        }

        public int getStoreStatus() {
            return storeStatus;
        }

        public void setStoreStatus(int storeStatus) {
            this.storeStatus = storeStatus;
        }

        public OrderBean getOrder() {
            return order;
        }

        public void setOrder(OrderBean order) {
            this.order = order;
        }

        public List<VehicleEndcostBean> getVehicleEndcost() {
            return vehicleEndcost;
        }

        public void setVehicleEndcost(List<VehicleEndcostBean> vehicleEndcost) {
            this.vehicleEndcost = vehicleEndcost;
        }

        public List<VehicleOrstatusBean> getVehicleOrstatus() {
            return vehicleOrstatus;
        }

        public void setVehicleOrstatus(List<VehicleOrstatusBean> vehicleOrstatus) {
            this.vehicleOrstatus = vehicleOrstatus;
        }

        public List<VehicleCostBean> getVehicleCost() {
            return vehicleCost;
        }

        public void setVehicleCost(List<VehicleCostBean> vehicleCost) {
            this.vehicleCost = vehicleCost;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class PicPathBean {
            /**
             * vehicleInfoId : 8
             * picPath : picture/vehicle/JYJY192112721820190528175331.jpeg,picture/vehicle/JYJY192156841020190528175335.jpeg,picture/vehicle/JYJY192337588720190528175353.jpeg
             * plateNumber : 8888
             * orderId : 16
             * createTime : null
             * type : null
             */

            private int vehicleInfoId;
            private String picPath;
            private String plateNumber;
            private int orderId;
            private Object createTime;
            private Object type;

            public int getVehicleInfoId() {
                return vehicleInfoId;
            }

            public void setVehicleInfoId(int vehicleInfoId) {
                this.vehicleInfoId = vehicleInfoId;
            }

            public String getPicPath() {
                return picPath;
            }

            public void setPicPath(String picPath) {
                this.picPath = picPath;
            }

            public String getPlateNumber() {
                return plateNumber;
            }

            public void setPlateNumber(String plateNumber) {
                this.plateNumber = plateNumber;
            }

            public int getOrderId() {
                return orderId;
            }

            public void setOrderId(int orderId) {
                this.orderId = orderId;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }

            public Object getType() {
                return type;
            }

            public void setType(Object type) {
                this.type = type;
            }
        }

        public static class OrderBean {
            /**
             * orderId : 32
             * userId : 7
             * orderNo : 1933144987
             * successTime : 2019-05-22 15:15:31
             * payWay : 2
             * payTime : 2019-05-22 15:15:31
             * payStatus : 2
             * vehicleId : 11
             * storeId : 7
             * takevehicleTime : 2019-05-22
             * rentDuration : 1
             * status : 4
             * createTime : 2019-05-22
             * telPhone : 18502994087
             * week : 周三
             * takeStatus : 2
             * descStatus : null
             * vehicleName : 小刀电动车
             * vehicleModel : xs25445
             * vehicleLogo : picture/profile/JYJY192842740420190522151444.jpg
             * storeName : 阳阳车行
             * descAddress : 上海市青浦区明珠路
             * payMoney : 1350.0
             * revehicleTime : null
             * expireTime : 2019-06-21
             * storeStatus : null
             * city : 上海市
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
            private Object storeStatus;
            private String city;
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

            public Object getStoreStatus() {
                return storeStatus;
            }

            public void setStoreStatus(Object storeStatus) {
                this.storeStatus = storeStatus;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
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

        public static class VehicleOrstatusBean {
            /**
             * orstatusId : 43
             * vestatusName : 头部
             * damagedCost : 11.0
             * status : 2
             * orderId : 32
             * statusId : 2
             * userId : null
             * createTime : 2019-05-22 17:23:57
             * type : null
             */

            private int orstatusId;
            private String vestatusName;
            private double damagedCost;
            private int status;
            private int orderId;
            private int statusId;
            private Object userId;
            private String createTime;
            private Object type;

            public int getOrstatusId() {
                return orstatusId;
            }

            public void setOrstatusId(int orstatusId) {
                this.orstatusId = orstatusId;
            }

            public String getVestatusName() {
                return vestatusName;
            }

            public void setVestatusName(String vestatusName) {
                this.vestatusName = vestatusName;
            }

            public double getDamagedCost() {
                return damagedCost;
            }

            public void setDamagedCost(double damagedCost) {
                this.damagedCost = damagedCost;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getOrderId() {
                return orderId;
            }

            public void setOrderId(int orderId) {
                this.orderId = orderId;
            }

            public int getStatusId() {
                return statusId;
            }

            public void setStatusId(int statusId) {
                this.statusId = statusId;
            }

            public Object getUserId() {
                return userId;
            }

            public void setUserId(Object userId) {
                this.userId = userId;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public Object getType() {
                return type;
            }

            public void setType(Object type) {
                this.type = type;
            }
        }

        public static class VehicleCostBean {
            /**
             * costId : 37
             * deposit : 1000.0
             * equipCost : 100.0
             * tenancyService : 300.0
             * total : 1350.0
             * orderId : 32
             * coupon : 50.00
             * createTime : 2019-05-22 15:15:31
             * vehicleRent : 50.0
             * chargeMoney : null
             * rentDuration : 1
             */

            private int costId;
            private double deposit;
            private double equipCost;
            private double tenancyService;
            private double total;
            private int orderId;
            private String coupon;
            private String createTime;
            private double vehicleRent;
            private Object chargeMoney;
            private double overdueMoney;
            private double refundMoney;
            private double defaultMoney;
            private int rentDuration;
            private String couponTitle;

            public double getRefundMoney() {
                return refundMoney;
            }

            public void setRefundMoney(double refundMoney) {
                this.refundMoney = refundMoney;
            }

            public double getDefaultMoney() {
                return defaultMoney;
            }

            public void setDefaultMoney(double defaultMoney) {
                this.defaultMoney = defaultMoney;
            }

            public double getOverdueMoney() {
                return overdueMoney;
            }

            public void setOverdueMoney(double overdueMoney) {
                this.overdueMoney = overdueMoney;
            }

            public String getCouponTitle() {
                return couponTitle;
            }

            public void setCouponTitle(String couponTitle) {
                this.couponTitle = couponTitle;
            }

            public int getCostId() {
                return costId;
            }

            public void setCostId(int costId) {
                this.costId = costId;
            }

            public double getDeposit() {
                return deposit;
            }

            public void setDeposit(double deposit) {
                this.deposit = deposit;
            }

            public double getEquipCost() {
                return equipCost;
            }

            public void setEquipCost(double equipCost) {
                this.equipCost = equipCost;
            }

            public double getTenancyService() {
                return tenancyService;
            }

            public void setTenancyService(double tenancyService) {
                this.tenancyService = tenancyService;
            }

            public double getTotal() {
                return total;
            }

            public void setTotal(double total) {
                this.total = total;
            }

            public int getOrderId() {
                return orderId;
            }

            public void setOrderId(int orderId) {
                this.orderId = orderId;
            }

            public String getCoupon() {
                return coupon;
            }

            public void setCoupon(String coupon) {
                this.coupon = coupon;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public double getVehicleRent() {
                return vehicleRent;
            }

            public void setVehicleRent(double vehicleRent) {
                this.vehicleRent = vehicleRent;
            }

            public Object getChargeMoney() {
                return chargeMoney;
            }

            public void setChargeMoney(Object chargeMoney) {
                this.chargeMoney = chargeMoney;
            }

            public int getRentDuration() {
                return rentDuration;
            }

            public void setRentDuration(int rentDuration) {
                this.rentDuration = rentDuration;
            }
        }

        public static class VehicleEndcostBean {
            /**
             * endcostId : 3
             * deposit : null
             * equipCost : null
             * tenancyService : 300.0
             * total : 1280.6
             * orderId : 35
             * coupon : 20.0
             * vehicleRent : null
             * rentDuration : 3
             * chargeMoney : 998.0
             * lateMoney : 2.6
             * createTime : 2019-05-27 15:13:18
             */

            private int endcostId;
            private Object deposit;
            private Object equipCost;
            private double tenancyService;
            private double total;
            private int orderId;
            private double coupon;
            private Object vehicleRent;
            private int rentDuration;
            private double chargeMoney;
            private double lateMoney;
            private String createTime;

            public int getEndcostId() {
                return endcostId;
            }

            public void setEndcostId(int endcostId) {
                this.endcostId = endcostId;
            }

            public Object getDeposit() {
                return deposit;
            }

            public void setDeposit(Object deposit) {
                this.deposit = deposit;
            }

            public Object getEquipCost() {
                return equipCost;
            }

            public void setEquipCost(Object equipCost) {
                this.equipCost = equipCost;
            }

            public double getTenancyService() {
                return tenancyService;
            }

            public void setTenancyService(double tenancyService) {
                this.tenancyService = tenancyService;
            }

            public double getTotal() {
                return total;
            }

            public void setTotal(double total) {
                this.total = total;
            }

            public int getOrderId() {
                return orderId;
            }

            public void setOrderId(int orderId) {
                this.orderId = orderId;
            }

            public double getCoupon() {
                return coupon;
            }

            public void setCoupon(double coupon) {
                this.coupon = coupon;
            }

            public Object getVehicleRent() {
                return vehicleRent;
            }

            public void setVehicleRent(Object vehicleRent) {
                this.vehicleRent = vehicleRent;
            }

            public int getRentDuration() {
                return rentDuration;
            }

            public void setRentDuration(int rentDuration) {
                this.rentDuration = rentDuration;
            }

            public double getChargeMoney() {
                return chargeMoney;
            }

            public void setChargeMoney(double chargeMoney) {
                this.chargeMoney = chargeMoney;
            }

            public double getLateMoney() {
                return lateMoney;
            }

            public void setLateMoney(double lateMoney) {
                this.lateMoney = lateMoney;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }
        }

        public static class UserBean {
            /**
             * userId : 7
             * telPhone : 18502994087
             * password : 74e4e50701161c4d481d41ca837f1864
             * userName : jhzc427601
             * userCall :
             * parentId : 0
             * balance : 3600.0
             * invitationCode : dogj6yvx
             * avatar : picture/profile/JYJY191039252520190702125143.jpeg
             * userType : 1
             * status : 2
             * idPositive : picture/profileID/JYJY192701404720190520174110.jpeg
             * idOpposite : picture/profileID/JYJY192734900920190520174113.jpeg
             * idHold : picture/profileID/JYJY192775710020190520174117.jpeg
             * createTime : 2019-05-20 17:41:04
             * telPhones : null
             * oppenId : null
             * params : {}
             * storeId : 0
             */

            private int userId;
            private String telPhone;
            private String password;
            private String userName;
            private String userCall;
            private int parentId;
            private double balance;
            private String invitationCode;
            private String avatar;
            private int userType;
            private int status;
            private String idPositive;
            private String idOpposite;
            private String idHold;
            private String createTime;
            private Object telPhones;
            private Object oppenId;
            private TestBean.UserBean.ParamsBean params;
            private int storeId;

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getTelPhone() {
                return telPhone;
            }

            public void setTelPhone(String telPhone) {
                this.telPhone = telPhone;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getUserCall() {
                return userCall;
            }

            public void setUserCall(String userCall) {
                this.userCall = userCall;
            }

            public int getParentId() {
                return parentId;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }

            public double getBalance() {
                return balance;
            }

            public void setBalance(double balance) {
                this.balance = balance;
            }

            public String getInvitationCode() {
                return invitationCode;
            }

            public void setInvitationCode(String invitationCode) {
                this.invitationCode = invitationCode;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public int getUserType() {
                return userType;
            }

            public void setUserType(int userType) {
                this.userType = userType;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getIdPositive() {
                return idPositive;
            }

            public void setIdPositive(String idPositive) {
                this.idPositive = idPositive;
            }

            public String getIdOpposite() {
                return idOpposite;
            }

            public void setIdOpposite(String idOpposite) {
                this.idOpposite = idOpposite;
            }

            public String getIdHold() {
                return idHold;
            }

            public void setIdHold(String idHold) {
                this.idHold = idHold;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public Object getTelPhones() {
                return telPhones;
            }

            public void setTelPhones(Object telPhones) {
                this.telPhones = telPhones;
            }

            public Object getOppenId() {
                return oppenId;
            }

            public void setOppenId(Object oppenId) {
                this.oppenId = oppenId;
            }

            public TestBean.UserBean.ParamsBean getParams() {
                return params;
            }

            public void setParams(TestBean.UserBean.ParamsBean params) {
                this.params = params;
            }

            public int getStoreId() {
                return storeId;
            }

            public void setStoreId(int storeId) {
                this.storeId = storeId;
            }

            public static class ParamsBean {
            }
        }
    }
}
