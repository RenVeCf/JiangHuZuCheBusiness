package com.ipd.jianghuzuchebusiness.bean;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/19.
 */
public class RepairOrderBean {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"repairData":{"notOkOrderMoney":0,"profitCount":0,"dayOrderMoney":0,"notOkOrderCount":0,"profitMoney":0,"okOrderCount":0,"okOrderMoney":-0,"dayOrderCount":0,"totalOrderCount":0,"totalOrderMoney":0}}
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
         * repairData : {"notOkOrderMoney":0,"profitCount":0,"dayOrderMoney":0,"notOkOrderCount":0,"profitMoney":0,"okOrderCount":0,"okOrderMoney":-0,"dayOrderCount":0,"totalOrderCount":0,"totalOrderMoney":0}
         */

        private RepairDataBean repairData;

        public RepairDataBean getRepairData() {
            return repairData;
        }

        public void setRepairData(RepairDataBean repairData) {
            this.repairData = repairData;
        }

        public static class RepairDataBean {
            /**
             * notOkOrderMoney : 0.0
             * profitCount : 0
             * dayOrderMoney : 0.0
             * notOkOrderCount : 0
             * profitMoney : 0.0
             * okOrderCount : 0
             * okOrderMoney : -0.0
             * dayOrderCount : 0
             * totalOrderCount : 0
             * totalOrderMoney : 0.0
             */

            private double notOkOrderMoney;
            private int profitCount;
            private double dayOrderMoney;
            private int notOkOrderCount;
            private double profitMoney;
            private int okOrderCount;
            private double okOrderMoney;
            private int dayOrderCount;
            private int totalOrderCount;
            private double totalOrderMoney;

            public double getNotOkOrderMoney() {
                return notOkOrderMoney;
            }

            public void setNotOkOrderMoney(double notOkOrderMoney) {
                this.notOkOrderMoney = notOkOrderMoney;
            }

            public int getProfitCount() {
                return profitCount;
            }

            public void setProfitCount(int profitCount) {
                this.profitCount = profitCount;
            }

            public double getDayOrderMoney() {
                return dayOrderMoney;
            }

            public void setDayOrderMoney(double dayOrderMoney) {
                this.dayOrderMoney = dayOrderMoney;
            }

            public int getNotOkOrderCount() {
                return notOkOrderCount;
            }

            public void setNotOkOrderCount(int notOkOrderCount) {
                this.notOkOrderCount = notOkOrderCount;
            }

            public double getProfitMoney() {
                return profitMoney;
            }

            public void setProfitMoney(double profitMoney) {
                this.profitMoney = profitMoney;
            }

            public int getOkOrderCount() {
                return okOrderCount;
            }

            public void setOkOrderCount(int okOrderCount) {
                this.okOrderCount = okOrderCount;
            }

            public double getOkOrderMoney() {
                return okOrderMoney;
            }

            public void setOkOrderMoney(double okOrderMoney) {
                this.okOrderMoney = okOrderMoney;
            }

            public int getDayOrderCount() {
                return dayOrderCount;
            }

            public void setDayOrderCount(int dayOrderCount) {
                this.dayOrderCount = dayOrderCount;
            }

            public int getTotalOrderCount() {
                return totalOrderCount;
            }

            public void setTotalOrderCount(int totalOrderCount) {
                this.totalOrderCount = totalOrderCount;
            }

            public double getTotalOrderMoney() {
                return totalOrderMoney;
            }

            public void setTotalOrderMoney(double totalOrderMoney) {
                this.totalOrderMoney = totalOrderMoney;
            }
        }
    }
}
