package com.ipd.jianghuzuchebusiness.bean;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/10.
 */
public class TestBean {

    /**
     * user : {"userId":7,"telPhone":"18502994087","password":"74e4e50701161c4d481d41ca837f1864","userName":"jhzc427601","userCall":"","parentId":0,"balance":3600,"invitationCode":"dogj6yvx","avatar":"picture/profile/JYJY191039252520190702125143.jpeg","userType":1,"status":2,"idPositive":"picture/profileID/JYJY192701404720190520174110.jpeg","idOpposite":"picture/profileID/JYJY192734900920190520174113.jpeg","idHold":"picture/profileID/JYJY192775710020190520174117.jpeg","createTime":"2019-05-20 17:41:04","telPhones":null,"oppenId":null,"params":{},"storeId":0}
     */

    private UserBean user;

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean {
        /**
         * userId : 7
         * telPhone : 18502994087
         * password : 74e4e50701161c4d481d41ca837f1864
         * userName : jhzc427601
         * userCall :
         * parentId : 0
         * balance : 3600.0
         * invitationCode : dogj6yvx
         * avatar : picture/profile/JYJY191039252520190702125143.jpeg
         * userType : 1
         * status : 2
         * idPositive : picture/profileID/JYJY192701404720190520174110.jpeg
         * idOpposite : picture/profileID/JYJY192734900920190520174113.jpeg
         * idHold : picture/profileID/JYJY192775710020190520174117.jpeg
         * createTime : 2019-05-20 17:41:04
         * telPhones : null
         * oppenId : null
         * params : {}
         * storeId : 0
         */

        private int userId;
        private String telPhone;
        private String password;
        private String userName;
        private String userCall;
        private int parentId;
        private double balance;
        private String invitationCode;
        private String avatar;
        private int userType;
        private int status;
        private String idPositive;
        private String idOpposite;
        private String idHold;
        private String createTime;
        private Object telPhones;
        private Object oppenId;
        private ParamsBean params;
        private int storeId;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getTelPhone() {
            return telPhone;
        }

        public void setTelPhone(String telPhone) {
            this.telPhone = telPhone;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserCall() {
            return userCall;
        }

        public void setUserCall(String userCall) {
            this.userCall = userCall;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public String getInvitationCode() {
            return invitationCode;
        }

        public void setInvitationCode(String invitationCode) {
            this.invitationCode = invitationCode;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getIdPositive() {
            return idPositive;
        }

        public void setIdPositive(String idPositive) {
            this.idPositive = idPositive;
        }

        public String getIdOpposite() {
            return idOpposite;
        }

        public void setIdOpposite(String idOpposite) {
            this.idOpposite = idOpposite;
        }

        public String getIdHold() {
            return idHold;
        }

        public void setIdHold(String idHold) {
            this.idHold = idHold;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getTelPhones() {
            return telPhones;
        }

        public void setTelPhones(Object telPhones) {
            this.telPhones = telPhones;
        }

        public Object getOppenId() {
            return oppenId;
        }

        public void setOppenId(Object oppenId) {
            this.oppenId = oppenId;
        }

        public ParamsBean getParams() {
            return params;
        }

        public void setParams(ParamsBean params) {
            this.params = params;
        }

        public int getStoreId() {
            return storeId;
        }

        public void setStoreId(int storeId) {
            this.storeId = storeId;
        }

        public static class ParamsBean {
        }
    }
}
