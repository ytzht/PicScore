package vip.mae.picscore1.entity;

import java.util.List;

public class AllLand {

    /**
     * msg : 请求成功
     * code : 0
     * data : [{"name":"颐和园","id":3023},{"name":"天崮山旅游风景区","id":1472},{"name":"蓬莱阁","id":1222},{"name":"虎丘","id":6046}]
     */

    private String msg;
    private int code;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * name : 颐和园
         * id : 3023
         */

        private String name;
        private int count;
        private int yipingjia;
        private int id;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getYipingjia() {
            return yipingjia;
        }

        public void setYipingjia(int yipingjia) {
            this.yipingjia = yipingjia;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
