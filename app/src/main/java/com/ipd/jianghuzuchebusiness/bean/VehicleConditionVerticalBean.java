package com.ipd.jianghuzuchebusiness.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/16.
 */
public class VehicleConditionVerticalBean {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"vehicleStatus":[{"statusId":3,"statusName":"大灯头部","damagedCost":2,"createTime":"2019-05-08 15:22:52","status":null,"parentId":1},{"statusId":4,"statusName":"大灯2","damagedCost":2,"createTime":"2019-05-08 15:22:59","status":null,"parentId":1}]}
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
        private List<VehicleStatusBean> vehicleStatus;

        public List<VehicleStatusBean> getVehicleStatus() {
            return vehicleStatus;
        }

        public void setVehicleStatus(List<VehicleStatusBean> vehicleStatus) {
            this.vehicleStatus = vehicleStatus;
        }

        public static class VehicleStatusBean implements MultiItemEntity {
            /**
             * statusId : 3
             * statusName : 大灯头部
             * damagedCost : 2
             * createTime : 2019-05-08 15:22:52
             * status : null
             * parentId : 1
             */

            private int statusId;
            private String statusName;
            private int damagedCost;
            private String createTime;
            private Object status;
            private int parentId;
            private int itemType;

            public void setItemType(int itemType) {
                this.itemType = itemType;
            }

            public int getStatusId() {
                return statusId;
            }

            public void setStatusId(int statusId) {
                this.statusId = statusId;
            }

            public String getStatusName() {
                return statusName;
            }

            public void setStatusName(String statusName) {
                this.statusName = statusName;
            }

            public int getDamagedCost() {
                return damagedCost;
            }

            public void setDamagedCost(int damagedCost) {
                this.damagedCost = damagedCost;
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

            public int getParentId() {
                return parentId;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }

            @Override
            public int getItemType() {
                return itemType;
            }
        }
    }
}
