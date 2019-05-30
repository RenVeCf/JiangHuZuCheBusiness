package com.ipd.jianghuzuchebusiness.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/14.
 */
public class RepairProjectHorizontalBean implements Parcelable {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"repairType":[{"repairId":1,"repairCost":null,"repairName":"大灯","status":null,"createTime":"2019-05-20 10:00:47","selectStatus":0,"params":{},"parentId":0,"appRepairs":[{"repairId":2,"repairCost":99,"repairName":"灯头","status":null,"createTime":"2019-05-20 10:00:58","selectStatus":0,"params":{},"parentId":1,"appRepairs":null},{"repairId":3,"repairCost":99,"repairName":"灯尾","status":null,"createTime":"2019-05-20 10:01:09","selectStatus":0,"params":{},"parentId":1,"appRepairs":null}]},{"repairId":4,"repairCost":null,"repairName":"轮胎","status":null,"createTime":"2019-05-20 10:01:22","selectStatus":0,"params":{},"parentId":0,"appRepairs":[{"repairId":5,"repairCost":99,"repairName":"轮胎01","status":null,"createTime":"2019-05-20 10:01:46","selectStatus":0,"params":{},"parentId":4,"appRepairs":null},{"repairId":6,"repairCost":99,"repairName":"轮胎02","status":null,"createTime":"2019-05-20 10:01:56","selectStatus":0,"params":{},"parentId":4,"appRepairs":null}]},{"repairId":7,"repairCost":null,"repairName":"玻璃","status":null,"createTime":"2019-05-20 21:08:02","selectStatus":0,"params":{},"parentId":0,"appRepairs":[{"repairId":8,"repairCost":99,"repairName":"钢化玻璃","status":null,"createTime":"2019-05-20 21:08:14","selectStatus":0,"params":{},"parentId":7,"appRepairs":null},{"repairId":9,"repairCost":99,"repairName":"普通玻璃","status":null,"createTime":"2019-05-20 21:08:22","selectStatus":0,"params":{},"parentId":7,"appRepairs":null}]},{"repairId":10,"repairCost":null,"repairName":"车牌","status":null,"createTime":"2019-05-20 21:08:31","selectStatus":0,"params":{},"parentId":0,"appRepairs":[{"repairId":11,"repairCost":99,"repairName":"普通车牌","status":null,"createTime":"2019-05-20 21:10:56","selectStatus":0,"params":{},"parentId":10,"appRepairs":null},{"repairId":12,"repairCost":99,"repairName":"高级车牌","status":null,"createTime":"2019-05-20 21:11:03","selectStatus":0,"params":{},"parentId":10,"appRepairs":null}]},{"repairId":13,"repairCost":null,"repairName":"外观件","status":null,"createTime":"2019-05-21 20:11:12","selectStatus":0,"params":{},"parentId":0,"appRepairs":[{"repairId":14,"repairCost":65,"repairName":"前泥瓦","status":null,"createTime":"2019-05-21 20:11:51","selectStatus":0,"params":{},"parentId":13,"appRepairs":null}]},{"repairId":15,"repairCost":null,"repairName":"机油","status":null,"createTime":"2019-05-22 17:27:43","selectStatus":0,"params":{},"parentId":0,"appRepairs":[]},{"repairId":16,"repairCost":null,"repairName":"机油","status":null,"createTime":"2019-05-22 17:28:48","selectStatus":0,"params":{},"parentId":0,"appRepairs":[]}]}
     */

    private int code;
    private String msg;
    private DataBean data;

    protected RepairProjectHorizontalBean(Parcel in) {
        code = in.readInt();
        msg = in.readString();
    }

    public static final Creator<RepairProjectHorizontalBean> CREATOR = new Creator<RepairProjectHorizontalBean>() {
        @Override
        public RepairProjectHorizontalBean createFromParcel(Parcel in) {
            return new RepairProjectHorizontalBean(in);
        }

        @Override
        public RepairProjectHorizontalBean[] newArray(int size) {
            return new RepairProjectHorizontalBean[size];
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
        private List<RepairTypeBean> repairType;

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

        public List<RepairTypeBean> getRepairType() {
            return repairType;
        }

        public void setRepairType(List<RepairTypeBean> repairType) {
            this.repairType = repairType;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
        }

        public static class RepairTypeBean implements Parcelable {
            /**
             * repairId : 1
             * repairCost : null
             * repairName : 大灯
             * status : null
             * createTime : 2019-05-20 10:00:47
             * selectStatus : 0
             * params : {}
             * parentId : 0
             * appRepairs : [{"repairId":2,"repairCost":99,"repairName":"灯头","status":null,"createTime":"2019-05-20 10:00:58","selectStatus":0,"params":{},"parentId":1,"appRepairs":null},{"repairId":3,"repairCost":99,"repairName":"灯尾","status":null,"createTime":"2019-05-20 10:01:09","selectStatus":0,"params":{},"parentId":1,"appRepairs":null}]
             */

            private int repairId;
            private Object repairCost;
            private String repairName;
            private Object status;
            private String createTime;
            private int selectStatus;
            private ParamsBean params;
            private int parentId;
            private List<AppRepairsBean> appRepairs;

            protected RepairTypeBean(Parcel in) {
                repairId = in.readInt();
                repairName = in.readString();
                createTime = in.readString();
                selectStatus = in.readInt();
                parentId = in.readInt();
            }

            public static final Creator<RepairTypeBean> CREATOR = new Creator<RepairTypeBean>() {
                @Override
                public RepairTypeBean createFromParcel(Parcel in) {
                    return new RepairTypeBean(in);
                }

                @Override
                public RepairTypeBean[] newArray(int size) {
                    return new RepairTypeBean[size];
                }
            };

            public int getRepairId() {
                return repairId;
            }

            public void setRepairId(int repairId) {
                this.repairId = repairId;
            }

            public Object getRepairCost() {
                return repairCost;
            }

            public void setRepairCost(Object repairCost) {
                this.repairCost = repairCost;
            }

            public String getRepairName() {
                return repairName;
            }

            public void setRepairName(String repairName) {
                this.repairName = repairName;
            }

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public int getSelectStatus() {
                return selectStatus;
            }

            public void setSelectStatus(int selectStatus) {
                this.selectStatus = selectStatus;
            }

            public ParamsBean getParams() {
                return params;
            }

            public void setParams(ParamsBean params) {
                this.params = params;
            }

            public int getParentId() {
                return parentId;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }

            public List<AppRepairsBean> getAppRepairs() {
                return appRepairs;
            }

            public void setAppRepairs(List<AppRepairsBean> appRepairs) {
                this.appRepairs = appRepairs;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(repairId);
                dest.writeString(repairName);
                dest.writeString(createTime);
                dest.writeInt(selectStatus);
                dest.writeInt(parentId);
            }

            public static class ParamsBean implements Parcelable {
                protected ParamsBean(Parcel in) {
                }

                public static final Creator<ParamsBean> CREATOR = new Creator<ParamsBean>() {
                    @Override
                    public ParamsBean createFromParcel(Parcel in) {
                        return new ParamsBean(in);
                    }

                    @Override
                    public ParamsBean[] newArray(int size) {
                        return new ParamsBean[size];
                    }
                };

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                }
            }

            public static class AppRepairsBean implements Parcelable, MultiItemEntity {
                /**
                 * repairId : 2
                 * repairCost : 99.0
                 * repairName : 灯头
                 * status : null
                 * createTime : 2019-05-20 10:00:58
                 * selectStatus : 0
                 * params : {}
                 * parentId : 1
                 * appRepairs : null
                 */

                private int repairId;
                private double repairCost;
                private String repairName;
                private Object status;
                private String createTime;
                private int selectStatus;
                private ParamsBeanX params;
                private int parentId;
                private Object appRepairs;
                private int itemType;

                public void setItemType(int itemType) {
                    this.itemType = itemType;
                }

                protected AppRepairsBean(Parcel in) {
                    repairId = in.readInt();
                    repairCost = in.readDouble();
                    repairName = in.readString();
                    createTime = in.readString();
                    selectStatus = in.readInt();
                    parentId = in.readInt();
                }

                public static final Creator<AppRepairsBean> CREATOR = new Creator<AppRepairsBean>() {
                    @Override
                    public AppRepairsBean createFromParcel(Parcel in) {
                        return new AppRepairsBean(in);
                    }

                    @Override
                    public AppRepairsBean[] newArray(int size) {
                        return new AppRepairsBean[size];
                    }
                };

                public int getRepairId() {
                    return repairId;
                }

                public void setRepairId(int repairId) {
                    this.repairId = repairId;
                }

                public double getRepairCost() {
                    return repairCost;
                }

                public void setRepairCost(double repairCost) {
                    this.repairCost = repairCost;
                }

                public String getRepairName() {
                    return repairName;
                }

                public void setRepairName(String repairName) {
                    this.repairName = repairName;
                }

                public Object getStatus() {
                    return status;
                }

                public void setStatus(Object status) {
                    this.status = status;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public int getSelectStatus() {
                    return selectStatus;
                }

                public void setSelectStatus(int selectStatus) {
                    this.selectStatus = selectStatus;
                }

                public ParamsBeanX getParams() {
                    return params;
                }

                public void setParams(ParamsBeanX params) {
                    this.params = params;
                }

                public int getParentId() {
                    return parentId;
                }

                public void setParentId(int parentId) {
                    this.parentId = parentId;
                }

                public Object getAppRepairs() {
                    return appRepairs;
                }

                public void setAppRepairs(Object appRepairs) {
                    this.appRepairs = appRepairs;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeInt(repairId);
                    dest.writeDouble(repairCost);
                    dest.writeString(repairName);
                    dest.writeString(createTime);
                    dest.writeInt(selectStatus);
                    dest.writeInt(parentId);
                }

                @Override
                public int getItemType() {
                    return itemType;
                }

                public static class ParamsBeanX implements Parcelable {
                    protected ParamsBeanX(Parcel in) {
                    }

                    public static final Creator<ParamsBeanX> CREATOR = new Creator<ParamsBeanX>() {
                        @Override
                        public ParamsBeanX createFromParcel(Parcel in) {
                            return new ParamsBeanX(in);
                        }

                        @Override
                        public ParamsBeanX[] newArray(int size) {
                            return new ParamsBeanX[size];
                        }
                    };

                    @Override
                    public int describeContents() {
                        return 0;
                    }

                    @Override
                    public void writeToParcel(Parcel dest, int flags) {
                    }
                }
            }
        }
    }
}
