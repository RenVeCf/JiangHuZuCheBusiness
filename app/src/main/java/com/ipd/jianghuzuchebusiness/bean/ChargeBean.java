package com.ipd.jianghuzuchebusiness.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/14.
 */
public class ChargeBean implements Parcelable{
    /**
     * code : 200
     * msg : 操作成功
     * data : {"chargeList":[{"chargeId":1,"title":"充电包天","cost":99,"icon":"图标","createTime":"2019-04-23 13:37:11","remark":"备注","chargeNum":null,"status":null,"flag":true},{"chargeId":2,"title":"充电包月","cost":999,"icon":"图标","createTime":"2019-04-23 13:37:35","remark":"备注","chargeNum":null,"status":null,"flag":true},{"chargeId":3,"title":"充电一年","cost":9999,"icon":"图标","createTime":"2019-04-23 13:37:58","remark":"备注","chargeNum":null,"status":null,"flag":true}]}
     */

    private int code;
    private String msg;
    private DataBean data;

    protected ChargeBean(Parcel in) {
        code = in.readInt();
        msg = in.readString();
    }

    public static final Creator<ChargeBean> CREATOR = new Creator<ChargeBean>() {
        @Override
        public ChargeBean createFromParcel(Parcel in) {
            return new ChargeBean(in);
        }

        @Override
        public ChargeBean[] newArray(int size) {
            return new ChargeBean[size];
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

    public static class DataBean implements Parcelable{
        private List<ChargeListBean> chargeList;

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

        public List<ChargeListBean> getChargeList() {
            return chargeList;
        }

        public void setChargeList(List<ChargeListBean> chargeList) {
            this.chargeList = chargeList;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
        }

        public static class ChargeListBean implements Parcelable{
            /**
             * chargeId : 1
             * title : 充电包天
             * cost : 99.0
             * icon : 图标
             * createTime : 2019-04-23 13:37:11
             * remark : 备注
             * chargeNum : null
             * status : null
             * flag : true
             */

            private int chargeId;
            private String title;
            private double cost;
            private String icon;
            private String createTime;
            private String remark;
            private Object chargeNum;
            private Object status;
            private boolean flag;

            protected ChargeListBean(Parcel in) {
                chargeId = in.readInt();
                title = in.readString();
                cost = in.readDouble();
                icon = in.readString();
                createTime = in.readString();
                remark = in.readString();
                flag = in.readByte() != 0;
            }

            public static final Creator<ChargeListBean> CREATOR = new Creator<ChargeListBean>() {
                @Override
                public ChargeListBean createFromParcel(Parcel in) {
                    return new ChargeListBean(in);
                }

                @Override
                public ChargeListBean[] newArray(int size) {
                    return new ChargeListBean[size];
                }
            };

            public int getChargeId() {
                return chargeId;
            }

            public void setChargeId(int chargeId) {
                this.chargeId = chargeId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public double getCost() {
                return cost;
            }

            public void setCost(double cost) {
                this.cost = cost;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public Object getChargeNum() {
                return chargeNum;
            }

            public void setChargeNum(Object chargeNum) {
                this.chargeNum = chargeNum;
            }

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }

            public boolean isFlag() {
                return flag;
            }

            public void setFlag(boolean flag) {
                this.flag = flag;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(chargeId);
                dest.writeString(title);
                dest.writeDouble(cost);
                dest.writeString(icon);
                dest.writeString(createTime);
                dest.writeString(remark);
                dest.writeByte((byte) (flag ? 1 : 0));
            }
        }
    }
}
