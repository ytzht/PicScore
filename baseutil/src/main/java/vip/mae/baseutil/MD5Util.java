package vip.mae.baseutil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    /**
     * 生成32位md5码
     * @param password 需要加密的内容
     * @return 密文
     */
    public static String md5Password(String password) {
        try {
            // 得到一个信息摘要器
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(password.getBytes());
            StringBuffer buffer = new StringBuffer();
            // 把每一个byte 做一个与运算 0xff;
            for (byte b : result) {
                // 与运算
                int number = b & 0xff;// 加盐
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    buffer.append("0");
                }
                buffer.append(str);
            }

            // 标准的md5加密后的结果
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
    /**
     * token加密
     * @param token
     * @return
     */
    public static String tokenMD5(String token){
        String d = MD5Util.md5Password(token.substring(3, 6)).substring(7, 13);
        String e = MD5Util.md5Password(token.substring(5, 9)).substring(2, 6);
        String f = MD5Util.md5Password(token.substring(11, 17)).substring(15, 30);
        return MD5Util.md5Password(d+e+f);
    }

}
