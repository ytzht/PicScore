package vip.mae.picscore1.global;

/**
 * Created by zht on 2017/08/03 16:58
 */

public interface Apis {

    String Base = "https://www.mae.vip/MaYiAPP1.2";
//    String Base = "http://192.168.1.101:8080/Mayi";

    String BasePic = "http://pic.mae.vip/";

    String Login = Base + "/ScoreC/login";//String account,String pwd

    String getAllLand = Base + "/ScoreC/getAllLand";//获取所有待评分的景点

    String getAllPicByLandId = Base + "/ScoreC/getAllPicByLandId";//通过景点id查询所有的待评分照片

    String getPicFraction = Base + "/ScoreC/getPicFraction";//通过照片id查询照片评分结果

    String submitFraction = Base + "/ScoreC/submitFraction";//提交评价结果



}
