package com.ipd.jianghuzuchebusiness.bean;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/19.
 */
public class CarRentalOrderBean {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"vehiclelData":{"profitCount":0,"dayOrderMoney":103404,"pickMoney":4400,"ReturnMoney":0,"profitMoney":0,"pickOrder":3,"dayOrder":37,"totalOrder":37,"NoOkOrder":0,"NoOkOrderMoney":0,"ReturnOrder":0,"totalOrderMoney":103404}}
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
         * vehiclelData : {"profitCount":0,"dayOrderMoney":103404,"pickMoney":4400,"ReturnMoney":0,"profitMoney":0,"pickOrder":3,"dayOrder":37,"totalOrder":37,"NoOkOrder":0,"NoOkOrderMoney":0,"ReturnOrder":0,"totalOrderMoney":103404}
         */

        private VehiclelDataBean vehiclelData;

        public VehiclelDataBean getVehiclelData() {
            return vehiclelData;
        }

        public void setVehiclelData(VehiclelDataBean vehiclelData) {
            this.vehiclelData = vehiclelData;
        }

        public static class VehiclelDataBean {
            /**
             * profitCount : 0
             * dayOrderMoney : 103404.0
             * pickMoney : 4400.0
             * ReturnMoney : 0.0
             * profitMoney : 0.0
             * pickOrder : 3
             * dayOrder : 37
             * totalOrder : 37
             * NoOkOrder : 0
             * NoOkOrderMoney : 0.0
             * ReturnOrder : 0
             * totalOrderMoney : 103404.0
             */

            private int profitCount;
            private double dayOrderMoney;
            private double pickMoney;
            private double ReturnMoney;
            private double profitMoney;
            private int pickOrder;
            private int dayOrder;
            private int totalOrder;
            private int NoOkOrder;
            private double NoOkOrderMoney;
            private int ReturnOrder;
            private double totalOrderMoney;

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

            public double getPickMoney() {
                return pickMoney;
            }

            public void setPickMoney(double pickMoney) {
                this.pickMoney = pickMoney;
            }

            public double getReturnMoney() {
                return ReturnMoney;
            }

            public void setReturnMoney(double ReturnMoney) {
                this.ReturnMoney = ReturnMoney;
            }

            public double getProfitMoney() {
                return profitMoney;
            }

            public void setProfitMoney(double profitMoney) {
                this.profitMoney = profitMoney;
            }

            public int getPickOrder() {
                return pickOrder;
            }

            public void setPickOrder(int pickOrder) {
                this.pickOrder = pickOrder;
            }

            public int getDayOrder() {
                return dayOrder;
            }

            public void setDayOrder(int dayOrder) {
                this.dayOrder = dayOrder;
            }

            public int getTotalOrder() {
                return totalOrder;
            }

            public void setTotalOrder(int totalOrder) {
                this.totalOrder = totalOrder;
            }

            public int getNoOkOrder() {
                return NoOkOrder;
            }

            public void setNoOkOrder(int NoOkOrder) {
                this.NoOkOrder = NoOkOrder;
            }

            public double getNoOkOrderMoney() {
                return NoOkOrderMoney;
            }

            public void setNoOkOrderMoney(double NoOkOrderMoney) {
                this.NoOkOrderMoney = NoOkOrderMoney;
            }

            public int getReturnOrder() {
                return ReturnOrder;
            }

            public void setReturnOrder(int ReturnOrder) {
                this.ReturnOrder = ReturnOrder;
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
