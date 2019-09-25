package com.ipd.jianghuzuchebusiness.bean;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/17.
 */
public class ReturnOrderDescBean {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"vehicleEndcost":[],"vehicleOrstatus":[{"orstatusId":218,"vestatusName":"轮胎","damagedCost":50,"status":1,"orderId":17,"statusId":9,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":219,"vestatusName":"大灯","damagedCost":40,"status":1,"orderId":17,"statusId":8,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":220,"vestatusName":"外壳","damagedCost":30,"status":1,"orderId":17,"statusId":7,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":221,"vestatusName":"车体","damagedCost":20,"status":1,"orderId":17,"statusId":6,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":222,"vestatusName":"仪表","damagedCost":10,"status":1,"orderId":17,"statusId":5,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":223,"vestatusName":"轮胎","damagedCost":50,"status":1,"orderId":17,"statusId":14,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":224,"vestatusName":"大灯","damagedCost":40,"status":1,"orderId":17,"statusId":13,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":225,"vestatusName":"外壳","damagedCost":30,"status":1,"orderId":17,"statusId":12,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":226,"vestatusName":"车体","damagedCost":20,"status":1,"orderId":17,"statusId":11,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":227,"vestatusName":"仪表","damagedCost":10,"status":1,"orderId":17,"statusId":10,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":228,"vestatusName":"轮胎","damagedCost":10,"status":1,"orderId":17,"statusId":19,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":229,"vestatusName":"大灯","damagedCost":10,"status":1,"orderId":17,"statusId":18,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":230,"vestatusName":"外壳","damagedCost":10,"status":1,"orderId":17,"statusId":17,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":231,"vestatusName":"车体","damagedCost":10,"status":1,"orderId":17,"statusId":16,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":232,"vestatusName":"仪表","damagedCost":10,"status":1,"orderId":17,"statusId":15,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":233,"vestatusName":"轮胎","damagedCost":50,"status":1,"orderId":17,"statusId":24,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":234,"vestatusName":"大灯","damagedCost":40,"status":1,"orderId":17,"statusId":23,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":235,"vestatusName":"外壳","damagedCost":30,"status":1,"orderId":17,"statusId":22,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":236,"vestatusName":"车体","damagedCost":10,"status":1,"orderId":17,"statusId":21,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":237,"vestatusName":"仪表","damagedCost":10,"status":1,"orderId":17,"statusId":20,"userId":null,"createTime":"2019-05-28 18:46:06","type":null}],"vehicleCost":{"costId":17,"deposit":1000,"equipCost":100,"tenancyService":150,"total":1250,"orderId":17,"coupon":"0.00","createTime":"2019-05-28 18:43:26","vehicleRent":50,"chargeMoney":0,"rentDuration":3,"lateMoney":null,"overdueMoney":0,"refundMoney":550,"defaultMoney":400},"vehiclePic":"picture/vehicle/JYJY193518284720190528184551.jpeg,picture/vehicle/JYJY193568918320190528184556.jpeg,picture/vehicle/JYJY193637858420190528184603.jpeg","status":2,"order":{"orderId":17,"userId":33,"orderNo":"1920623296","successTime":"2019-05-28 18:43:26","payWay":2,"payTime":"2019-05-28 18:43:26","payStatus":2,"vehicleId":12,"storeId":17,"takevehicleTime":"2019-05-28","rentDuration":3,"status":5,"createTime":"2019-05-28","telPhone":"15937013824","week":"周二","takeStatus":2,"descStatus":null,"vehicleName":"小刀电动车","vehicleModel":"xs25445","vehicleLogo":"picture/profile/JYJY198725294120190528171432.jpg","storeName":"付宗乐测试门店01","descAddress":"上海市青浦区徐径镇盈港东路明珠路","payMoney":1250,"revehicleTime":null,"expireTime":"2019-08-26","storeStatus":2,"city":"上海市","supId":8,"refundMoney":null,"retuStatus":1,"params":{}}}
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
         * vehicleEndcost : []
         * vehicleOrstatus : [{"orstatusId":218,"vestatusName":"轮胎","damagedCost":50,"status":1,"orderId":17,"statusId":9,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":219,"vestatusName":"大灯","damagedCost":40,"status":1,"orderId":17,"statusId":8,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":220,"vestatusName":"外壳","damagedCost":30,"status":1,"orderId":17,"statusId":7,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":221,"vestatusName":"车体","damagedCost":20,"status":1,"orderId":17,"statusId":6,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":222,"vestatusName":"仪表","damagedCost":10,"status":1,"orderId":17,"statusId":5,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":223,"vestatusName":"轮胎","damagedCost":50,"status":1,"orderId":17,"statusId":14,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":224,"vestatusName":"大灯","damagedCost":40,"status":1,"orderId":17,"statusId":13,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":225,"vestatusName":"外壳","damagedCost":30,"status":1,"orderId":17,"statusId":12,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":226,"vestatusName":"车体","damagedCost":20,"status":1,"orderId":17,"statusId":11,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":227,"vestatusName":"仪表","damagedCost":10,"status":1,"orderId":17,"statusId":10,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":228,"vestatusName":"轮胎","damagedCost":10,"status":1,"orderId":17,"statusId":19,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":229,"vestatusName":"大灯","damagedCost":10,"status":1,"orderId":17,"statusId":18,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":230,"vestatusName":"外壳","damagedCost":10,"status":1,"orderId":17,"statusId":17,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":231,"vestatusName":"车体","damagedCost":10,"status":1,"orderId":17,"statusId":16,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":232,"vestatusName":"仪表","damagedCost":10,"status":1,"orderId":17,"statusId":15,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":233,"vestatusName":"轮胎","damagedCost":50,"status":1,"orderId":17,"statusId":24,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":234,"vestatusName":"大灯","damagedCost":40,"status":1,"orderId":17,"statusId":23,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":235,"vestatusName":"外壳","damagedCost":30,"status":1,"orderId":17,"statusId":22,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":236,"vestatusName":"车体","damagedCost":10,"status":1,"orderId":17,"statusId":21,"userId":null,"createTime":"2019-05-28 18:46:06","type":null},{"orstatusId":237,"vestatusName":"仪表","damagedCost":10,"status":1,"orderId":17,"statusId":20,"userId":null,"createTime":"2019-05-28 18:46:06","type":null}]
         * vehicleCost : {"costId":17,"deposit":1000,"equipCost":100,"tenancyService":150,"total":1250,"orderId":17,"coupon":"0.00","createTime":"2019-05-28 18:43:26","vehicleRent":50,"chargeMoney":0,"rentDuration":3,"lateMoney":null,"overdueMoney":0,"refundMoney":550,"defaultMoney":400}
         * vehiclePic : picture/vehicle/JYJY193518284720190528184551.jpeg,picture/vehicle/JYJY193568918320190528184556.jpeg,picture/vehicle/JYJY193637858420190528184603.jpeg
         * status : 2
         * order : {"orderId":17,"userId":33,"orderNo":"1920623296","successTime":"2019-05-28 18:43:26","payWay":2,"payTime":"2019-05-28 18:43:26","payStatus":2,"vehicleId":12,"storeId":17,"takevehicleTime":"2019-05-28","rentDuration":3,"status":5,"createTime":"2019-05-28","telPhone":"15937013824","week":"周二","takeStatus":2,"descStatus":null,"vehicleName":"小刀电动车","vehicleModel":"xs25445","vehicleLogo":"picture/profile/JYJY198725294120190528171432.jpg","storeName":"付宗乐测试门店01","descAddress":"上海市青浦区徐径镇盈港东路明珠路","payMoney":1250,"revehicleTime":null,"expireTime":"2019-08-26","storeStatus":2,"city":"上海市","supId":8,"refundMoney":null,"retuStatus":1,"params":{}}
         */

        private VehicleCostBean vehicleCost;
        private VehiclePicBean vehiclePic;
        private int status;
        private OrderBean order;
        private List<?> vehicleEndcost;
        private List<VehicleOrstatusBean> vehicleOrstatus;
        private OrderDetailsBean.DataBean.UserBean user;


        public VehiclePicBean getVehiclePic() {
            return vehiclePic;
        }

        public void setVehiclePic(VehiclePicBean vehiclePic) {
            this.vehiclePic = vehiclePic;
        }

        public VehicleCostBean getVehicleCost() {
            return vehicleCost;
        }

        public void setVehicleCost(VehicleCostBean vehicleCost) {
            this.vehicleCost = vehicleCost;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public OrderBean getOrder() {
            return order;
        }

        public void setOrder(OrderBean order) {
            this.order = order;
        }

        public List<?> getVehicleEndcost() {
            return vehicleEndcost;
        }

        public void setVehicleEndcost(List<?> vehicleEndcost) {
            this.vehicleEndcost = vehicleEndcost;
        }

        public List<VehicleOrstatusBean> getVehicleOrstatus() {
            return vehicleOrstatus;
        }

        public void setVehicleOrstatus(List<VehicleOrstatusBean> vehicleOrstatus) {
            this.vehicleOrstatus = vehicleOrstatus;
        }

        public OrderDetailsBean.DataBean.UserBean getUser() {
            return user;
        }

        public void setUser(OrderDetailsBean.DataBean.UserBean user) {
            this.user = user;
        }

        public static class VehiclePicBean {
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

        public static class VehicleCostBean {
            /**
             * costId : 17
             * deposit : 1000
             * equipCost : 100
             * tenancyService : 150
             * total : 1250
             * orderId : 17
             * coupon : 0.00
             * createTime : 2019-05-28 18:43:26
             * vehicleRent : 50
             * chargeMoney : 0
             * rentDuration : 3
             * lateMoney : null
             * overdueMoney : 0
             * refundMoney : 550
             * defaultMoney : 400
             */

            private int costId;
            private int deposit;
            private int equipCost;
            private int tenancyService;
            private int total;
            private int orderId;
            private String coupon;
            private String createTime;
            private int vehicleRent;
            private int chargeMoney;
            private int rentDuration;
            private Object lateMoney;
            private int overdueMoney;
            private double refundMoney;
            private double defaultMoney;

            public int getCostId() {
                return costId;
            }

            public void setCostId(int costId) {
                this.costId = costId;
            }

            public int getDeposit() {
                return deposit;
            }

            public void setDeposit(int deposit) {
                this.deposit = deposit;
            }

            public int getEquipCost() {
                return equipCost;
            }

            public void setEquipCost(int equipCost) {
                this.equipCost = equipCost;
            }

            public int getTenancyService() {
                return tenancyService;
            }

            public void setTenancyService(int tenancyService) {
                this.tenancyService = tenancyService;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
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

            public int getVehicleRent() {
                return vehicleRent;
            }

            public void setVehicleRent(int vehicleRent) {
                this.vehicleRent = vehicleRent;
            }

            public int getChargeMoney() {
                return chargeMoney;
            }

            public void setChargeMoney(int chargeMoney) {
                this.chargeMoney = chargeMoney;
            }

            public int getRentDuration() {
                return rentDuration;
            }

            public void setRentDuration(int rentDuration) {
                this.rentDuration = rentDuration;
            }

            public Object getLateMoney() {
                return lateMoney;
            }

            public void setLateMoney(Object lateMoney) {
                this.lateMoney = lateMoney;
            }

            public int getOverdueMoney() {
                return overdueMoney;
            }

            public void setOverdueMoney(int overdueMoney) {
                this.overdueMoney = overdueMoney;
            }

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
        }

        public static class OrderBean {
            /**
             * orderId : 17
             * userId : 33
             * orderNo : 1920623296
             * successTime : 2019-05-28 18:43:26
             * payWay : 2
             * payTime : 2019-05-28 18:43:26
             * payStatus : 2
             * vehicleId : 12
             * storeId : 17
             * takevehicleTime : 2019-05-28
             * rentDuration : 3
             * status : 5
             * createTime : 2019-05-28
             * telPhone : 15937013824
             * week : 周二
             * takeStatus : 2
             * descStatus : null
             * vehicleName : 小刀电动车
             * vehicleModel : xs25445
             * vehicleLogo : picture/profile/JYJY198725294120190528171432.jpg
             * storeName : 付宗乐测试门店01
             * descAddress : 上海市青浦区徐径镇盈港东路明珠路
             * payMoney : 1250
             * revehicleTime : null
             * expireTime : 2019-08-26
             * storeStatus : 2
             * city : 上海市
             * supId : 8
             * refundMoney : null
             * retuStatus : 1
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
            private int payMoney;
            private Object revehicleTime;
            private String expireTime;
            private int storeStatus;
            private String city;
            private int supId;
            private Object refundMoney;
            private int retuStatus;
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

            public int getPayMoney() {
                return payMoney;
            }

            public void setPayMoney(int payMoney) {
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

            public int getRetuStatus() {
                return retuStatus;
            }

            public void setRetuStatus(int retuStatus) {
                this.retuStatus = retuStatus;
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
             * orstatusId : 218
             * vestatusName : 轮胎
             * damagedCost : 50
             * status : 1
             * orderId : 17
             * statusId : 9
             * userId : null
             * createTime : 2019-05-28 18:46:06
             * type : null
             */

            private int orstatusId;
            private String vestatusName;
            private int damagedCost;
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

            public int getDamagedCost() {
                return damagedCost;
            }

            public void setDamagedCost(int damagedCost) {
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
