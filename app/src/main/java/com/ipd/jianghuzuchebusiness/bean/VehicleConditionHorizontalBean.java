package com.ipd.jianghuzuchebusiness.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/16.
 */
public class VehicleConditionHorizontalBean implements Parcelable {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"vehicleType":[{"statusId":1,"statusName":"大灯","damagedCost":11,"createTime":"2019-05-20 10:03:40","status":1,"parentId":0,"appVehicleStatus":[{"statusId":2,"statusName":"头部","damagedCost":11,"createTime":"2019-05-20 10:03:47","status":1,"parentId":1,"appVehicleStatus":null},{"statusId":3,"statusName":"尾部","damagedCost":11,"createTime":"2019-05-20 10:03:52","status":1,"parentId":1,"appVehicleStatus":null}]},{"statusId":4,"statusName":"车胎","damagedCost":11,"createTime":"2019-05-20 10:04:05","status":1,"parentId":0,"appVehicleStatus":[{"statusId":5,"statusName":"头部","damagedCost":11,"createTime":"2019-05-20 10:04:39","status":1,"parentId":4,"appVehicleStatus":null},{"statusId":6,"statusName":"尾部","damagedCost":11,"createTime":"2019-05-20 10:04:44","status":1,"parentId":4,"appVehicleStatus":null}]},{"statusId":7,"statusName":"111","damagedCost":null,"createTime":"2019-05-22 14:20:31","status":1,"parentId":0,"appVehicleStatus":[]}]}
     */

    private int code;
    private String msg;
    private DataBean data;

    protected VehicleConditionHorizontalBean(Parcel in) {
        code = in.readInt();
        msg = in.readString();
    }

    public static final Creator<VehicleConditionHorizontalBean> CREATOR = new Creator<VehicleConditionHorizontalBean>() {
        @Override
        public VehicleConditionHorizontalBean createFromParcel(Parcel in) {
            return new VehicleConditionHorizontalBean(in);
        }

        @Override
        public VehicleConditionHorizontalBean[] newArray(int size) {
            return new VehicleConditionHorizontalBean[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(code);
        dest.writeString(msg);
    }

    public static class DataBean implements Parcelable {
        private List<VehicleTypeBean> vehicleType;

        protected DataBean(Parcel in) {
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel in) {
                return new DataBean(in);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };

        public List<VehicleTypeBean> getVehicleType() {
            return vehicleType;
        }

        public void setVehicleType(List<VehicleTypeBean> vehicleType) {
            this.vehicleType = vehicleType;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
        }

        public static class VehicleTypeBean implements Parcelable {
            /**
             * statusId : 1
             * statusName : 大灯
             * damagedCost : 11.0
             * createTime : 2019-05-20 10:03:40
             * status : 1
             * parentId : 0
             * appVehicleStatus : [{"statusId":2,"statusName":"头部","damagedCost":11,"createTime":"2019-05-20 10:03:47","status":1,"parentId":1,"appVehicleStatus":null},{"statusId":3,"statusName":"尾部","damagedCost":11,"createTime":"2019-05-20 10:03:52","status":1,"parentId":1,"appVehicleStatus":null}]
             */

            private int statusId;
            private String statusName;
            private double damagedCost;
            private String createTime;
            private int status;
            private int parentId;
            private List<AppVehicleStatusBean> appVehicleStatus;

            public VehicleTypeBean() {
                super();
            }

            public VehicleTypeBean(Parcel in) {
                statusId = in.readInt();
                statusName = in.readString();
                damagedCost = in.readDouble();
                createTime = in.readString();
                status = in.readInt();
                parentId = in.readInt();
            }

            public static final Creator<VehicleTypeBean> CREATOR = new Creator<VehicleTypeBean>() {
                @Override
                public VehicleTypeBean createFromParcel(Parcel in) {
                    return new VehicleTypeBean(in);
                }

                @Override
                public VehicleTypeBean[] newArray(int size) {
                    return new VehicleTypeBean[size];
                }
            };

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

            public double getDamagedCost() {
                return damagedCost;
            }

            public void setDamagedCost(double damagedCost) {
                this.damagedCost = damagedCost;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getParentId() {
                return parentId;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }

            public List<AppVehicleStatusBean> getAppVehicleStatus() {
                return appVehicleStatus;
            }

            public void setAppVehicleStatus(List<AppVehicleStatusBean> appVehicleStatus) {
                this.appVehicleStatus = appVehicleStatus;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(statusId);
                dest.writeString(statusName);
                dest.writeDouble(damagedCost);
                dest.writeString(createTime);
                dest.writeInt(status);
                dest.writeInt(parentId);
            }

            public static class AppVehicleStatusBean implements Parcelable, MultiItemEntity {
                /**
                 * statusId : 2
                 * statusName : 头部
                 * damagedCost : 11.0
                 * createTime : 2019-05-20 10:03:47
                 * status : 1
                 * parentId : 1
                 * appVehicleStatus : null
                 */

                private int statusId;
                private String statusName;
                private double damagedCost;
                private String createTime;
                private int status;
                private int parentId;
                private Object appVehicleStatus;
                private int itemType;

                public void setItemType(int itemType) {
                    this.itemType = itemType;
                }

                public AppVehicleStatusBean() {
                    super();
                }

                public AppVehicleStatusBean(Parcel in) {
                    statusId = in.readInt();
                    statusName = in.readString();
                    damagedCost = in.readDouble();
                    createTime = in.readString();
                    status = in.readInt();
                    parentId = in.readInt();
                }

                public static final Creator<AppVehicleStatusBean> CREATOR = new Creator<AppVehicleStatusBean>() {
                    @Override
                    public AppVehicleStatusBean createFromParcel(Parcel in) {
                        return new AppVehicleStatusBean(in);
                    }

                    @Override
                    public AppVehicleStatusBean[] newArray(int size) {
                        return new AppVehicleStatusBean[size];
                    }
                };

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

                public double getDamagedCost() {
                    return damagedCost;
                }

                public void setDamagedCost(double damagedCost) {
                    this.damagedCost = damagedCost;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public int getParentId() {
                    return parentId;
                }

                public void setParentId(int parentId) {
                    this.parentId = parentId;
                }

                public Object getAppVehicleStatus() {
                    return appVehicleStatus;
                }

                public void setAppVehicleStatus(Object appVehicleStatus) {
                    this.appVehicleStatus = appVehicleStatus;
                }

                @Override
                public int getItemType() {
                    return itemType;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeInt(statusId);
                    dest.writeString(statusName);
                    dest.writeDouble(damagedCost);
                    dest.writeString(createTime);
                    dest.writeInt(status);
                    dest.writeInt(parentId);
                }
            }
        }
    }
}
