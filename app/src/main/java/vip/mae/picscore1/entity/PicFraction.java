package vip.mae.picscore1.entity;

public class PicFraction {

    /**
     * msg : 请求成功
     * code : 0
     * data : {"option_c_point":0,"option_a_point":0,"id":305,"total_point":0,"userId":3271,"picId":9,"option_b_point":0}
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
         * option_c_point : 0
         * option_a_point : 0
         * id : 305
         * total_point : 0
         * userId : 3271
         * picId : 9
         * option_b_point : 0
         */

        private int option_c_point;
        private int option_a_point;
        private int id;
        private int total_point;
        private int userId;
        private int picId;
        private int option_b_point;

        public int getOption_c_point() {
            return option_c_point;
        }

        public void setOption_c_point(int option_c_point) {
            this.option_c_point = option_c_point;
        }

        public int getOption_a_point() {
            return option_a_point;
        }

        public void setOption_a_point(int option_a_point) {
            this.option_a_point = option_a_point;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getTotal_point() {
            return total_point;
        }

        public void setTotal_point(int total_point) {
            this.total_point = total_point;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getPicId() {
            return picId;
        }

        public void setPicId(int picId) {
            this.picId = picId;
        }

        public int getOption_b_point() {
            return option_b_point;
        }

        public void setOption_b_point(int option_b_point) {
            this.option_b_point = option_b_point;
        }
    }
}
