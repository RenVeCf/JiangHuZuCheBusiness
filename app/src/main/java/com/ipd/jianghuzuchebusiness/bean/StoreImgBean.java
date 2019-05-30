package com.ipd.jianghuzuchebusiness.bean;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/23.
 */
public class StoreImgBean {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"picPath":{"storeId":7,"storeName":"阳阳车行","picPath":"picture/vehicle/JYJY197809371720190522221940.jpeg,picture/vehicle/JYJY197875619520190522221947.jpeg,picture/vehicle/JYJY197909872020190522221950.jpeg","contactsPhone":"18502994087","contactsName":null,"descAddress":"上海市青浦区明珠路","province":"上海","city":"上海市","area":"青浦区","createTime":"2019-05-22 15:12:47","repairId":null,"repairNames":"","chargeId":"","distance":3.6,"status":null,"userName":null,"telPhone":null,"userId":null,"logo":"picture/profile/JYJY191561917620190522151236.jpg","stock":null,"longitude":"121.274445","latitude":"31.179451","totalNum":null,"availableNum":null,"params":{}}}
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
         * picPath : {"storeId":7,"storeName":"阳阳车行","picPath":"picture/vehicle/JYJY197809371720190522221940.jpeg,picture/vehicle/JYJY197875619520190522221947.jpeg,picture/vehicle/JYJY197909872020190522221950.jpeg","contactsPhone":"18502994087","contactsName":null,"descAddress":"上海市青浦区明珠路","province":"上海","city":"上海市","area":"青浦区","createTime":"2019-05-22 15:12:47","repairId":null,"repairNames":"","chargeId":"","distance":3.6,"status":null,"userName":null,"telPhone":null,"userId":null,"logo":"picture/profile/JYJY191561917620190522151236.jpg","stock":null,"longitude":"121.274445","latitude":"31.179451","totalNum":null,"availableNum":null,"params":{}}
         */

        private PicPathBean picPath;

        public PicPathBean getPicPath() {
            return picPath;
        }

        public void setPicPath(PicPathBean picPath) {
            this.picPath = picPath;
        }

        public static class PicPathBean {
            /**
             * storeId : 7
             * storeName : 阳阳车行
             * picPath : picture/vehicle/JYJY197809371720190522221940.jpeg,picture/vehicle/JYJY197875619520190522221947.jpeg,picture/vehicle/JYJY197909872020190522221950.jpeg
             * contactsPhone : 18502994087
             * contactsName : null
             * descAddress : 上海市青浦区明珠路
             * province : 上海
             * city : 上海市
             * area : 青浦区
             * createTime : 2019-05-22 15:12:47
             * repairId : null
             * repairNames :
             * chargeId :
             * distance : 3.6
             * status : null
             * userName : null
             * telPhone : null
             * userId : null
             * logo : picture/profile/JYJY191561917620190522151236.jpg
             * stock : null
             * longitude : 121.274445
             * latitude : 31.179451
             * totalNum : null
             * availableNum : null
             * params : {}
             */

            private int storeId;
            private String storeName;
            private String picPath;
            private String contactsPhone;
            private Object contactsName;
            private String descAddress;
            private String province;
            private String city;
            private String area;
            private String createTime;
            private Object repairId;
            private String repairNames;
            private String chargeId;
            private double distance;
            private Object status;
            private Object userName;
            private Object telPhone;
            private Object userId;
            private String logo;
            private Object stock;
            private String longitude;
            private String latitude;
            private Object totalNum;
            private Object availableNum;
            private ParamsBean params;

            public int getStoreId() {
                return storeId;
            }

            public void setStoreId(int storeId) {
                this.storeId = storeId;
            }

            public String getStoreName() {
                return storeName;
            }

            public void setStoreName(String storeName) {
                this.storeName = storeName;
            }

            public String getPicPath() {
                return picPath;
            }

            public void setPicPath(String picPath) {
                this.picPath = picPath;
            }

            public String getContactsPhone() {
                return contactsPhone;
            }

            public void setContactsPhone(String contactsPhone) {
                this.contactsPhone = contactsPhone;
            }

            public Object getContactsName() {
                return contactsName;
            }

            public void setContactsName(Object contactsName) {
                this.contactsName = contactsName;
            }

            public String getDescAddress() {
                return descAddress;
            }

            public void setDescAddress(String descAddress) {
                this.descAddress = descAddress;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public Object getRepairId() {
                return repairId;
            }

            public void setRepairId(Object repairId) {
                this.repairId = repairId;
            }

            public String getRepairNames() {
                return repairNames;
            }

            public void setRepairNames(String repairNames) {
                this.repairNames = repairNames;
            }

            public String getChargeId() {
                return chargeId;
            }

            public void setChargeId(String chargeId) {
                this.chargeId = chargeId;
            }

            public double getDistance() {
                return distance;
            }

            public void setDistance(double distance) {
                this.distance = distance;
            }

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }

            public Object getUserName() {
                return userName;
            }

            public void setUserName(Object userName) {
                this.userName = userName;
            }

            public Object getTelPhone() {
                return telPhone;
            }

            public void setTelPhone(Object telPhone) {
                this.telPhone = telPhone;
            }

            public Object getUserId() {
                return userId;
            }

            public void setUserId(Object userId) {
                this.userId = userId;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public Object getStock() {
                return stock;
            }

            public void setStock(Object stock) {
                this.stock = stock;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public Object getTotalNum() {
                return totalNum;
            }

            public void setTotalNum(Object totalNum) {
                this.totalNum = totalNum;
            }

            public Object getAvailableNum() {
                return availableNum;
            }

            public void setAvailableNum(Object availableNum) {
                this.availableNum = availableNum;
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
    }
}
