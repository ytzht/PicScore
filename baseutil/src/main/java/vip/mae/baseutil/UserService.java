package vip.mae.baseutil;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by zht on 2017/08/16 15:43
 */

public class UserService {

    private static final String DeviceToken = "_deviceToken";
    private static final String Token = "_token";
    private static final String UserName = "_userName";
    private static final String UserGroup = "_userGroup";
    private static final String UserGroupName = "_userGroupName";
    private static final String Phone = "_phone";
    private static final String Password = "_password";
    private static final String UserId = "_userId";
    private static final String HeadURL = "_headURL";
    private static final String SearchHistory = "_searchHistory";
    private static final String SearchHistorys = "_searchHistorys";
    private Context context;

    public static UserService service(Context context) {
        return new UserService(context);
    }

    public UserService(Context context) {
        this.context = context;
    }

    public String getDeviceToken() {
        SharedPreferences memberPrefs = context.getSharedPreferences(
                DeviceToken, Context.MODE_PRIVATE);
        return memberPrefs.getString(DeviceToken, "");
    }

    public void setDeviceToken(String deviceToken) {
        SharedPreferences memberPrefs = context.getSharedPreferences(
                DeviceToken, Context.MODE_PRIVATE);
        memberPrefs.edit().putString(DeviceToken, deviceToken).apply();
    }

    public String getToken() {
        SharedPreferences memberPrefs = context.getSharedPreferences(
                Token, Context.MODE_PRIVATE);
        return memberPrefs.getString(Token, "-1");
    }

    public void setToken(String token) {
        SharedPreferences memberPrefs = context.getSharedPreferences(
                Token, Context.MODE_PRIVATE);
        memberPrefs.edit().putString(Token, token).apply();
    }

    public String getUserName() {
        SharedPreferences memberPrefs = context.getSharedPreferences(
                UserName, Context.MODE_PRIVATE);
        return memberPrefs.getString(UserName, "");
    }

    public void setUserName(String userName) {
        SharedPreferences memberPrefs = context.getSharedPreferences(
                UserName, Context.MODE_PRIVATE);
        memberPrefs.edit().putString(UserName, userName).apply();
    }

    public String getUserGroup() {
        SharedPreferences memberPrefs = context.getSharedPreferences(
                UserGroup, Context.MODE_PRIVATE);
        return memberPrefs.getString(UserGroup, "");
    }

    public void setUserGroup(String group) {
        SharedPreferences memberPrefs = context.getSharedPreferences(
                UserGroup, Context.MODE_PRIVATE);
        memberPrefs.edit().putString(UserGroup, group).apply();
    }

    public String getUserGroupName() {
        SharedPreferences memberPrefs = context.getSharedPreferences(
                UserGroupName, Context.MODE_PRIVATE);
        return memberPrefs.getString(UserGroupName, "");
    }

    public void setUserGroupName(String groupName) {
        SharedPreferences memberPrefs = context.getSharedPreferences(
                UserGroupName, Context.MODE_PRIVATE);
        memberPrefs.edit().putString(UserGroupName, groupName).apply();
    }

    public int getUserId() {
        SharedPreferences memberPrefs = context.getSharedPreferences(
                UserId, Context.MODE_PRIVATE);
        return memberPrefs.getInt(UserId, -1);
    }

    public void setUserId(int userId) {
        SharedPreferences memberPrefs = context.getSharedPreferences(
                UserId, Context.MODE_PRIVATE);
        memberPrefs.edit().putInt(UserId, userId).apply();
    }

    public String getHeadURL() {
        SharedPreferences memberPrefs = context.getSharedPreferences(
                HeadURL, Context.MODE_PRIVATE);
        return memberPrefs.getString(HeadURL, "");
    }

    public void setHeadURL(String headURL) {
        SharedPreferences memberPrefs = context.getSharedPreferences(
                HeadURL, Context.MODE_PRIVATE);
        memberPrefs.edit().putString(HeadURL, headURL).apply();
    }

    public String getPhone() {
        SharedPreferences memberPrefs = context.getSharedPreferences(
                Phone, Context.MODE_PRIVATE);
        return memberPrefs.getString(Phone, "");
    }

    public void setPhone(String phone) {
        SharedPreferences memberPrefs = context.getSharedPreferences(
                Phone, Context.MODE_PRIVATE);
        memberPrefs.edit().putString(Phone, phone).apply();
    }

    public String getPassword() {
        SharedPreferences memberPrefs = context.getSharedPreferences(
                Password, Context.MODE_PRIVATE);
        return memberPrefs.getString(Password, "");
    }

    public void setPassword(String password) {
        SharedPreferences memberPrefs = context.getSharedPreferences(
                Password, Context.MODE_PRIVATE);
        memberPrefs.edit().putString(Password, password).apply();
    }

    public String getSearchHistory() {
        SharedPreferences memberPrefs = context.getSharedPreferences(
                SearchHistory, Context.MODE_PRIVATE);
        return memberPrefs.getString(SearchHistory, "");
    }

    public void saveSearchHistory(String searchHistory) {
        SharedPreferences memberPrefs = context.getSharedPreferences(
                SearchHistory, Context.MODE_PRIVATE);
        memberPrefs.edit().putString(SearchHistory, searchHistory).apply();
    }

    public String getSearchHistorys() {
        SharedPreferences memberPrefs = context.getSharedPreferences(
                SearchHistorys, Context.MODE_PRIVATE);
        return memberPrefs.getString(SearchHistorys, "");
    }

    public void saveSearchHistorys(String searchHistorys) {
        SharedPreferences memberPrefs = context.getSharedPreferences(
                SearchHistorys, Context.MODE_PRIVATE);
        memberPrefs.edit().putString(SearchHistorys, searchHistorys).apply();
    }


    public boolean isLogin(){
        return !getToken().equals("-1");
    }

}
