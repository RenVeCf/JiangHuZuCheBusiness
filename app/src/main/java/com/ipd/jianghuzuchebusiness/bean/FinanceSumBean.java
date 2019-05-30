package com.ipd.jianghuzuchebusiness.bean;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/19.
 */
public class FinanceSumBean {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"userData":{"availableMoney":270,"cumulativeMoney":1281,"dayMoney":1280,"monthMoney":1281},"userDetailed":[{"detailedId":3,"userId":13,"money":150,"moneyType":1,"title":"提现","details":null,"createTime":"2019-05-24 17:19:31","status":null,"type":2},{"detailedId":4,"userId":13,"money":130,"moneyType":1,"title":"提现","details":null,"createTime":"2019-05-24 17:21:45","status":null,"type":2}]}
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
         * userData : {"availableMoney":270,"cumulativeMoney":1281,"dayMoney":1280,"monthMoney":1281}
         * userDetailed : [{"detailedId":3,"userId":13,"money":150,"moneyType":1,"title":"提现","details":null,"createTime":"2019-05-24 17:19:31","status":null,"type":2},{"detailedId":4,"userId":13,"money":130,"moneyType":1,"title":"提现","details":null,"createTime":"2019-05-24 17:21:45","status":null,"type":2}]
         */

        private UserDataBean userData;
        private List<UserDetailedBean> userDetailed;

        public UserDataBean getUserData() {
            return userData;
        }

        public void setUserData(UserDataBean userData) {
            this.userData = userData;
        }

        public List<UserDetailedBean> getUserDetailed() {
            return userDetailed;
        }

        public void setUserDetailed(List<UserDetailedBean> userDetailed) {
            this.userDetailed = userDetailed;
        }

        public static class UserDataBean {
            /**
             * availableMoney : 270.0
             * cumulativeMoney : 1281.0
             * dayMoney : 1280.0
             * monthMoney : 1281.0
             */

            private double availableMoney;
            private double cumulativeMoney;
            private double dayMoney;
            private double monthMoney;

            public double getAvailableMoney() {
                return availableMoney;
            }

            public void setAvailableMoney(double availableMoney) {
                this.availableMoney = availableMoney;
            }

            public double getCumulativeMoney() {
                return cumulativeMoney;
            }

            public void setCumulativeMoney(double cumulativeMoney) {
                this.cumulativeMoney = cumulativeMoney;
            }

            public double getDayMoney() {
                return dayMoney;
            }

            public void setDayMoney(double dayMoney) {
                this.dayMoney = dayMoney;
            }

            public double getMonthMoney() {
                return monthMoney;
            }

            public void setMonthMoney(double monthMoney) {
                this.monthMoney = monthMoney;
            }
        }

        public static class UserDetailedBean {
            /**
             * detailedId : 3
             * userId : 13
             * money : 150.0
             * moneyType : 1
             * title : 提现
             * details : null
             * createTime : 2019-05-24 17:19:31
             * status : null
             * type : 2
             */

            private int detailedId;
            private int userId;
            private double money;
            private int moneyType;
            private String title;
            private Object details;
            private String createTime;
            private Object status;
            private int type;

            public int getDetailedId() {
                return detailedId;
            }

            public void setDetailedId(int detailedId) {
                this.detailedId = detailedId;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public double getMoney() {
                return money;
            }

            public void setMoney(double money) {
                this.money = money;
            }

            public int getMoneyType() {
                return moneyType;
            }

            public void setMoneyType(int moneyType) {
                this.moneyType = moneyType;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public Object getDetails() {
                return details;
            }

            public void setDetails(Object details) {
                this.details = details;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }
    }
}
