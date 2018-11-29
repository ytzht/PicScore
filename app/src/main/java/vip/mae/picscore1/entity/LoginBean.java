package vip.mae.picscore1.entity;

public class LoginBean {

    /**
     * msg : 登录成功
     * code : 0
     * data : {"birthday":" ","qq":" ","img":"http://pic.mae.vip/default_head_boy1532568082620.png","address":" ","role":"2","sex":"无","wechat":" ","remark":"本宝宝还没想到个性签名","token":" ","update_time":1541670524000,"balance":0,"user_id":3271,"integral":0,"name":"常任组一号","tel":"changren1","land_type":"后台","pwd":"ZjVmYmQ3YjQ5NTA2ZDc5ZDQ0NDVmN2VlN2NlYjBkNmE=","sina":" ","three_num":" ","group":"常任组"}
     */

    private String msg;
    private int code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * birthday :
         * qq :
         * img : http://pic.mae.vip/default_head_boy1532568082620.png
         * address :
         * role : 2
         * sex : 无
         * wechat :
         * remark : 本宝宝还没想到个性签名
         * token :
         * update_time : 1541670524000
         * balance : 0
         * user_id : 3271
         * integral : 0
         * name : 常任组一号
         * tel : changren1
         * land_type : 后台
         * pwd : ZjVmYmQ3YjQ5NTA2ZDc5ZDQ0NDVmN2VlN2NlYjBkNmE=
         * sina :
         * three_num :
         * group : 常任组
         */

        private String birthday;
        private String qq;
        private String img;
        private String address;
        private String role;
        private String sex;
        private String wechat;
        private String remark;
        private String token;
        private long update_time;
        private int balance;
        private int user_id;
        private int integral;
        private String name;
        private String tel;
        private String land_type;
        private String pwd;
        private String sina;
        private String three_num;
        private String group;

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getWechat() {
            return wechat;
        }

        public void setWechat(String wechat) {
            this.wechat = wechat;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public long getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(long update_time) {
            this.update_time = update_time;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getIntegral() {
            return integral;
        }

        public void setIntegral(int integral) {
            this.integral = integral;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getLand_type() {
            return land_type;
        }

        public void setLand_type(String land_type) {
            this.land_type = land_type;
        }

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }

        public String getSina() {
            return sina;
        }

        public void setSina(String sina) {
            this.sina = sina;
        }

        public String getThree_num() {
            return three_num;
        }

        public void setThree_num(String three_num) {
            this.three_num = three_num;
        }

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }
    }
}
