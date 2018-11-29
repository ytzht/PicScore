package vip.mae.picscore1.entity;

import java.util.List;

public class AllPicByLandId {


    /**
     * msg : 请求成功
     * code : 0
     * data : [{"land_id":1222,"picId":2,"url":"http://pic.mae.vip/51538230093598.%E3%80%90%E6%95%88%E6%9E%9C%E5%9B%BE%E3%80%91%E6%96%AD%E6%A1%A5%E6%AE%8B%E9%9B%AA-%E7%99%BD%E5%A0%A4"},{"land_id":1222,"picId":3,"url":"http://pic.mae.vip/51538229810106.%E3%80%90%E6%95%88%E6%9E%9C%E5%9B%BE%E3%80%91%E6%83%9C%E5%88%AB%E7%99%BD%E5%85%AC%E6%97%81%E8%B5%B0%E5%BB%8A"},{"land_id":1222,"picId":4,"url":"http://pic.mae.vip/51538229568047.%E3%80%90%E6%95%88%E6%9E%9C%E5%9B%BE%E3%80%91%E6%B9%96%E7%95%94%E5%B1%85"},{"land_id":1222,"picId":6,"url":"http://pic.mae.vip/51538229237377.%E3%80%90%E6%95%88%E6%9E%9C%E5%9B%BE%E3%80%91%E9%94%A6%E5%B8%A6%E6%A1%A5%E6%97%81"},{"land_id":1222,"picId":7,"url":"http://pic.mae.vip/51538224821792.%E3%80%90%E6%95%88%E6%9E%9C%E5%9B%BE%E3%80%91%E6%B0%B4%E6%9C%88%E5%BB%8A"},{"land_id":1222,"picId":8,"url":"http://pic.mae.vip/51538224740728.%E3%80%90%E6%95%88%E6%9E%9C%E5%9B%BE%E3%80%91%E7%A2%A7%E8%A1%80%E4%B8%B9%E5%BF%83%E5%A4%A7%E9%97%A8%E5%90%8E%E6%96%B9"},{"land_id":1222,"picId":5,"url":"http://pic.mae.vip/61538229490283.%E3%80%90%E6%95%88%E6%9E%9C%E5%9B%BE%E3%80%91%E8%BD%AC%E8%BA%AB%E9%81%87%E8%A7%81%E4%BD%A0"}]
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
         * land_id : 1222
         * picId : 2
         * url : http://pic.mae.vip/51538230093598.%E3%80%90%E6%95%88%E6%9E%9C%E5%9B%BE%E3%80%91%E6%96%AD%E6%A1%A5%E6%AE%8B%E9%9B%AA-%E7%99%BD%E5%A0%A4
         */

        private int land_id;
        private int picId;
        private String url;

        public int getLand_id() {
            return land_id;
        }

        public void setLand_id(int land_id) {
            this.land_id = land_id;
        }

        public int getPicId() {
            return picId;
        }

        public void setPicId(int picId) {
            this.picId = picId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
