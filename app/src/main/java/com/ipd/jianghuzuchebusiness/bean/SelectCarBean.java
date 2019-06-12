package com.ipd.jianghuzuchebusiness.bean;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/20.
 */
public class SelectCarBean {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"vehicleOrstatus":[{"orstatusId":158,"vestatusName":"轮胎","damagedCost":50,"status":1,"orderId":16,"statusId":9,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":159,"vestatusName":"大灯","damagedCost":40,"status":1,"orderId":16,"statusId":8,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":160,"vestatusName":"外壳","damagedCost":30,"status":1,"orderId":16,"statusId":7,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":161,"vestatusName":"车体","damagedCost":20,"status":1,"orderId":16,"statusId":6,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":162,"vestatusName":"仪表","damagedCost":10,"status":1,"orderId":16,"statusId":5,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":163,"vestatusName":"轮胎","damagedCost":50,"status":1,"orderId":16,"statusId":14,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":164,"vestatusName":"大灯","damagedCost":40,"status":1,"orderId":16,"statusId":13,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":165,"vestatusName":"外壳","damagedCost":30,"status":1,"orderId":16,"statusId":12,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":166,"vestatusName":"车体","damagedCost":20,"status":1,"orderId":16,"statusId":11,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":167,"vestatusName":"仪表","damagedCost":10,"status":1,"orderId":16,"statusId":10,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":168,"vestatusName":"轮胎","damagedCost":10,"status":1,"orderId":16,"statusId":19,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":169,"vestatusName":"大灯","damagedCost":10,"status":1,"orderId":16,"statusId":18,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":170,"vestatusName":"外壳","damagedCost":10,"status":1,"orderId":16,"statusId":17,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":171,"vestatusName":"车体","damagedCost":10,"status":1,"orderId":16,"statusId":16,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":172,"vestatusName":"仪表","damagedCost":10,"status":1,"orderId":16,"statusId":15,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":173,"vestatusName":"轮胎","damagedCost":50,"status":1,"orderId":16,"statusId":24,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":174,"vestatusName":"大灯","damagedCost":40,"status":1,"orderId":16,"statusId":23,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":175,"vestatusName":"外壳","damagedCost":30,"status":1,"orderId":16,"statusId":22,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":176,"vestatusName":"车体","damagedCost":10,"status":1,"orderId":16,"statusId":21,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":177,"vestatusName":"仪表","damagedCost":10,"status":1,"orderId":16,"statusId":20,"userId":null,"createTime":"2019-05-28 17:53:59","type":null}],"vehiclePic":{"vehicleInfoId":8,"picPath":"picture/vehicle/JYJY192112721820190528175331.jpeg,picture/vehicle/JYJY192156841020190528175335.jpeg,picture/vehicle/JYJY192337588720190528175353.jpeg","plateNumber":"8888","orderId":16,"createTime":null,"type":null}}
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
         * vehicleOrstatus : [{"orstatusId":158,"vestatusName":"轮胎","damagedCost":50,"status":1,"orderId":16,"statusId":9,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":159,"vestatusName":"大灯","damagedCost":40,"status":1,"orderId":16,"statusId":8,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":160,"vestatusName":"外壳","damagedCost":30,"status":1,"orderId":16,"statusId":7,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":161,"vestatusName":"车体","damagedCost":20,"status":1,"orderId":16,"statusId":6,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":162,"vestatusName":"仪表","damagedCost":10,"status":1,"orderId":16,"statusId":5,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":163,"vestatusName":"轮胎","damagedCost":50,"status":1,"orderId":16,"statusId":14,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":164,"vestatusName":"大灯","damagedCost":40,"status":1,"orderId":16,"statusId":13,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":165,"vestatusName":"外壳","damagedCost":30,"status":1,"orderId":16,"statusId":12,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":166,"vestatusName":"车体","damagedCost":20,"status":1,"orderId":16,"statusId":11,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":167,"vestatusName":"仪表","damagedCost":10,"status":1,"orderId":16,"statusId":10,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":168,"vestatusName":"轮胎","damagedCost":10,"status":1,"orderId":16,"statusId":19,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":169,"vestatusName":"大灯","damagedCost":10,"status":1,"orderId":16,"statusId":18,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":170,"vestatusName":"外壳","damagedCost":10,"status":1,"orderId":16,"statusId":17,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":171,"vestatusName":"车体","damagedCost":10,"status":1,"orderId":16,"statusId":16,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":172,"vestatusName":"仪表","damagedCost":10,"status":1,"orderId":16,"statusId":15,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":173,"vestatusName":"轮胎","damagedCost":50,"status":1,"orderId":16,"statusId":24,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":174,"vestatusName":"大灯","damagedCost":40,"status":1,"orderId":16,"statusId":23,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":175,"vestatusName":"外壳","damagedCost":30,"status":1,"orderId":16,"statusId":22,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":176,"vestatusName":"车体","damagedCost":10,"status":1,"orderId":16,"statusId":21,"userId":null,"createTime":"2019-05-28 17:53:59","type":null},{"orstatusId":177,"vestatusName":"仪表","damagedCost":10,"status":1,"orderId":16,"statusId":20,"userId":null,"createTime":"2019-05-28 17:53:59","type":null}]
         * vehiclePic : {"vehicleInfoId":8,"picPath":"picture/vehicle/JYJY192112721820190528175331.jpeg,picture/vehicle/JYJY192156841020190528175335.jpeg,picture/vehicle/JYJY192337588720190528175353.jpeg","plateNumber":"8888","orderId":16,"createTime":null,"type":null}
         */

        private VehiclePicBean vehiclePic;
        private List<VehicleOrstatusBean> vehicleOrstatus;

        public VehiclePicBean getVehiclePic() {
            return vehiclePic;
        }

        public void setVehiclePic(VehiclePicBean vehiclePic) {
            this.vehiclePic = vehiclePic;
        }

        public List<VehicleOrstatusBean> getVehicleOrstatus() {
            return vehicleOrstatus;
        }

        public void setVehicleOrstatus(List<VehicleOrstatusBean> vehicleOrstatus) {
            this.vehicleOrstatus = vehicleOrstatus;
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

        public static class VehicleOrstatusBean {
            /**
             * orstatusId : 158
             * vestatusName : 轮胎
             * damagedCost : 50.0
             * status : 1
             * orderId : 16
             * statusId : 9
             * userId : null
             * createTime : 2019-05-28 17:53:59
             * type : null
             * vehicleType : ""
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
            private int vehicleType;

            public int getVehicleType() {
                return vehicleType;
            }

            public void setVehicleType(int vehicleType) {
                this.vehicleType = vehicleType;
            }

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
    }
}
