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
     * data : {"vehicleType":[{"statusId":4,"statusName":"车体","damagedCost":null,"createTime":"2019-05-27 20:18:25","status":1,"parentId":0,"appVehicleStatus":[{"statusId":14,"statusName":"轮胎","damagedCost":50,"createTime":"2019-05-27 20:21:24","status":1,"parentId":3,"appVehicleStatus":null,"region":null,"province":null,"city":null,"area":null,"vehicleOrstatus":null},{"statusId":13,"statusName":"大灯","damagedCost":40,"createTime":"2019-05-27 20:21:17","status":1,"parentId":3,"appVehicleStatus":null,"region":null,"province":null,"city":null,"area":null,"vehicleOrstatus":null}],"region":null,"province":"上海","city":"上海市","area":null,"vehicleOrstatus":[{"orstatusId":781,"vestatusName":"轮胎","damagedCost":50,"status":2,"orderId":67,"statusId":9,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":782,"vestatusName":"大灯","damagedCost":40,"status":2,"orderId":67,"statusId":8,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":783,"vestatusName":"外壳","damagedCost":30,"status":1,"orderId":67,"statusId":7,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":784,"vestatusName":"车体","damagedCost":20,"status":1,"orderId":67,"statusId":6,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":785,"vestatusName":"仪表","damagedCost":10,"status":1,"orderId":67,"statusId":5,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":786,"vestatusName":"轮胎","damagedCost":50,"status":1,"orderId":67,"statusId":14,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":787,"vestatusName":"大灯","damagedCost":40,"status":1,"orderId":67,"statusId":13,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":788,"vestatusName":"外壳","damagedCost":30,"status":1,"orderId":67,"statusId":12,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":789,"vestatusName":"车体","damagedCost":20,"status":1,"orderId":67,"statusId":11,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":790,"vestatusName":"仪表","damagedCost":10,"status":1,"orderId":67,"statusId":10,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":791,"vestatusName":"轮胎","damagedCost":10,"status":1,"orderId":67,"statusId":19,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":792,"vestatusName":"大灯","damagedCost":10,"status":1,"orderId":67,"statusId":18,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":793,"vestatusName":"外壳","damagedCost":10,"status":1,"orderId":67,"statusId":17,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":794,"vestatusName":"车体","damagedCost":10,"status":1,"orderId":67,"statusId":16,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":795,"vestatusName":"仪表","damagedCost":10,"status":1,"orderId":67,"statusId":15,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":796,"vestatusName":"轮胎","damagedCost":50,"status":1,"orderId":67,"statusId":24,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":797,"vestatusName":"大灯","damagedCost":40,"status":1,"orderId":67,"statusId":23,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":798,"vestatusName":"外壳","damagedCost":30,"status":1,"orderId":67,"statusId":22,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":799,"vestatusName":"车体","damagedCost":10,"status":1,"orderId":67,"statusId":21,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":800,"vestatusName":"仪表","damagedCost":10,"status":1,"orderId":67,"statusId":20,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4}]},{"statusId":3,"statusName":"车尾","damagedCost":null,"createTime":"2019-05-27 20:18:15","status":1,"parentId":0,"appVehicleStatus":null,"region":null,"province":"上海","city":"上海市","area":null,"vehicleOrstatus":[]},{"statusId":2,"statusName":"车身","damagedCost":null,"createTime":"2019-05-27 20:18:02","status":1,"parentId":0,"appVehicleStatus":null,"region":null,"province":"上海","city":"上海市","area":null,"vehicleOrstatus":[]},{"statusId":1,"statusName":"车头","damagedCost":null,"createTime":"2019-05-27 20:17:52","status":1,"parentId":0,"appVehicleStatus":null,"region":null,"province":"上海","city":"上海市","area":null,"vehicleOrstatus":[]}]}
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
             * statusId : 4
             * statusName : 车体
             * damagedCost : null
             * createTime : 2019-05-27 20:18:25
             * status : 1
             * parentId : 0
             * appVehicleStatus : [{"statusId":14,"statusName":"轮胎","damagedCost":50,"createTime":"2019-05-27 20:21:24","status":1,"parentId":3,"appVehicleStatus":null,"region":null,"province":null,"city":null,"area":null,"vehicleOrstatus":null},{"statusId":13,"statusName":"大灯","damagedCost":40,"createTime":"2019-05-27 20:21:17","status":1,"parentId":3,"appVehicleStatus":null,"region":null,"province":null,"city":null,"area":null,"vehicleOrstatus":null}]
             * region : null
             * province : 上海
             * city : 上海市
             * area : null
             * vehicleOrstatus : [{"orstatusId":781,"vestatusName":"轮胎","damagedCost":50,"status":2,"orderId":67,"statusId":9,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":782,"vestatusName":"大灯","damagedCost":40,"status":2,"orderId":67,"statusId":8,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":783,"vestatusName":"外壳","damagedCost":30,"status":1,"orderId":67,"statusId":7,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":784,"vestatusName":"车体","damagedCost":20,"status":1,"orderId":67,"statusId":6,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":785,"vestatusName":"仪表","damagedCost":10,"status":1,"orderId":67,"statusId":5,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":786,"vestatusName":"轮胎","damagedCost":50,"status":1,"orderId":67,"statusId":14,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":787,"vestatusName":"大灯","damagedCost":40,"status":1,"orderId":67,"statusId":13,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":788,"vestatusName":"外壳","damagedCost":30,"status":1,"orderId":67,"statusId":12,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":789,"vestatusName":"车体","damagedCost":20,"status":1,"orderId":67,"statusId":11,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":790,"vestatusName":"仪表","damagedCost":10,"status":1,"orderId":67,"statusId":10,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":791,"vestatusName":"轮胎","damagedCost":10,"status":1,"orderId":67,"statusId":19,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":792,"vestatusName":"大灯","damagedCost":10,"status":1,"orderId":67,"statusId":18,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":793,"vestatusName":"外壳","damagedCost":10,"status":1,"orderId":67,"statusId":17,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":794,"vestatusName":"车体","damagedCost":10,"status":1,"orderId":67,"statusId":16,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":795,"vestatusName":"仪表","damagedCost":10,"status":1,"orderId":67,"statusId":15,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":796,"vestatusName":"轮胎","damagedCost":50,"status":1,"orderId":67,"statusId":24,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":797,"vestatusName":"大灯","damagedCost":40,"status":1,"orderId":67,"statusId":23,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":798,"vestatusName":"外壳","damagedCost":30,"status":1,"orderId":67,"statusId":22,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":799,"vestatusName":"车体","damagedCost":10,"status":1,"orderId":67,"statusId":21,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4},{"orstatusId":800,"vestatusName":"仪表","damagedCost":10,"status":1,"orderId":67,"statusId":20,"userId":null,"createTime":"2019-06-05 10:17:51","type":null,"parentId":4}]
             */

            private int statusId;
            private String statusName;
            private Object damagedCost;
            private String createTime;
            private int status;
            private int parentId;
            private Object region;
            private String province;
            private String city;
            private Object area;
            private List<AppVehicleStatusBean> appVehicleStatus;
            private List<VehicleOrstatusBean> vehicleOrstatus;

            public VehicleTypeBean() {
                super();
            }

            public VehicleTypeBean(Parcel in) {
                statusId = in.readInt();
                statusName = in.readString();
                createTime = in.readString();
                status = in.readInt();
                parentId = in.readInt();
                province = in.readString();
                city = in.readString();
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

            public Object getDamagedCost() {
                return damagedCost;
            }

            public void setDamagedCost(Object damagedCost) {
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

            public Object getRegion() {
                return region;
            }

            public void setRegion(Object region) {
                this.region = region;
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

            public Object getArea() {
                return area;
            }

            public void setArea(Object area) {
                this.area = area;
            }

            public List<AppVehicleStatusBean> getAppVehicleStatus() {
                return appVehicleStatus;
            }

            public void setAppVehicleStatus(List<AppVehicleStatusBean> appVehicleStatus) {
                this.appVehicleStatus = appVehicleStatus;
            }

            public List<VehicleOrstatusBean> getVehicleOrstatus() {
                return vehicleOrstatus;
            }

            public void setVehicleOrstatus(List<VehicleOrstatusBean> vehicleOrstatus) {
                this.vehicleOrstatus = vehicleOrstatus;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(statusId);
                dest.writeString(statusName);
                dest.writeString(createTime);
                dest.writeInt(status);
                dest.writeInt(parentId);
                dest.writeString(province);
                dest.writeString(city);
            }

            public static class AppVehicleStatusBean implements Parcelable, MultiItemEntity {
                /**
                 * statusId : 14
                 * statusName : 轮胎
                 * damagedCost : 50.0
                 * createTime : 2019-05-27 20:21:24
                 * status : 1
                 * parentId : 3
                 * appVehicleStatus : null
                 * region : null
                 * province : null
                 * city : null
                 * area : null
                 * vehicleOrstatus : null
                 */

                private int statusId;
                private String statusName;
                private double damagedCost;
                private String createTime;
                private int status;
                private int parentId;
                private Object appVehicleStatus;
                private Object region;
                private Object province;
                private Object city;
                private Object area;
                private Object vehicleOrstatus;
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

                public Object getRegion() {
                    return region;
                }

                public void setRegion(Object region) {
                    this.region = region;
                }

                public Object getProvince() {
                    return province;
                }

                public void setProvince(Object province) {
                    this.province = province;
                }

                public Object getCity() {
                    return city;
                }

                public void setCity(Object city) {
                    this.city = city;
                }

                public Object getArea() {
                    return area;
                }

                public void setArea(Object area) {
                    this.area = area;
                }

                public Object getVehicleOrstatus() {
                    return vehicleOrstatus;
                }

                public void setVehicleOrstatus(Object vehicleOrstatus) {
                    this.vehicleOrstatus = vehicleOrstatus;
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

                @Override
                public int getItemType() {
                    return itemType;
                }
            }

            public static class VehicleOrstatusBean implements Parcelable, MultiItemEntity {
                /**
                 * orstatusId : 781
                 * vestatusName : 轮胎
                 * damagedCost : 50
                 * status : 2
                 * orderId : 67
                 * statusId : 9
                 * userId : null
                 * createTime : 2019-06-05 10:17:51
                 * type : null
                 * parentId : 4
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
                private int parentId;
                private int itemType;

                public void setItemType(int itemType) {
                    this.itemType = itemType;
                }

                public VehicleOrstatusBean() {
                    super();
                }

                public VehicleOrstatusBean(Parcel in) {
                    orstatusId = in.readInt();
                    vestatusName = in.readString();
                    damagedCost = in.readInt();
                    status = in.readInt();
                    orderId = in.readInt();
                    statusId = in.readInt();
                    createTime = in.readString();
                    parentId = in.readInt();
                }

                public static final Creator<VehicleOrstatusBean> CREATOR = new Creator<VehicleOrstatusBean>() {
                    @Override
                    public VehicleOrstatusBean createFromParcel(Parcel in) {
                        return new VehicleOrstatusBean(in);
                    }

                    @Override
                    public VehicleOrstatusBean[] newArray(int size) {
                        return new VehicleOrstatusBean[size];
                    }
                };

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

                public int getParentId() {
                    return parentId;
                }

                public void setParentId(int parentId) {
                    this.parentId = parentId;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeInt(orstatusId);
                    dest.writeString(vestatusName);
                    dest.writeInt(damagedCost);
                    dest.writeInt(status);
                    dest.writeInt(orderId);
                    dest.writeInt(statusId);
                    dest.writeString(createTime);
                    dest.writeInt(parentId);
                }

                @Override
                public int getItemType() {
                    return itemType;
                }
            }
        }
    }
}
