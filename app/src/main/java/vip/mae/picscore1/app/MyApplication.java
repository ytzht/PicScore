package vip.mae.picscore1.app;

import android.app.Application;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.cookie.CookieJarImpl;
import com.lzy.okgo.cookie.store.DBCookieStore;
import com.lzy.okgo.cookie.store.MemoryCookieStore;
import com.lzy.okgo.cookie.store.SPCookieStore;
import com.lzy.okgo.https.HttpsUtils;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.HttpParams;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;
import vip.mae.baseutil.MD5Util;
import vip.mae.baseutil.UserService;

public class MyApplication extends Application {

    private static final String TAG = "app=====";

    private static MyApplication instance;

    public static MyApplication instance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        initOkGo(this);
    }


    public static void initOkGo(Application context) {
//        OkGo.getInstance().init(this);
//        initRetrofit(context);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor("OkGo=====");
//log打印级别，决定了log显示的详细程度
        loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY);
//log颜色级别，决定了log在控制台显示的颜色
        loggingInterceptor.setColorLevel(Level.WARNING);
        builder.addInterceptor(loggingInterceptor);

        //全局的读取超时时间
        builder.readTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
//全局的写入超时时间
        builder.writeTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
//全局的连接超时时间
        builder.connectTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        CertificatePinner pinner = new CertificatePinner.Builder()
                .add("*.mae.vip", "sha256/l4hWEkgSNZPDMlBeoZixJUoDG3bjN6cs+CQiKDLGQ6g=")
                .build();
//        builder.certificatePinner(pinner);
//        builder.proxy(Proxy.NO_PROXY);
        //使用sp保持cookie，如果cookie不过期，则一直有效
        builder.cookieJar(new CookieJarImpl(new SPCookieStore(context)));
//使用数据库保持cookie，如果cookie不过期，则一直有效
        builder.cookieJar(new CookieJarImpl(new DBCookieStore(context)));
//使用内存保持cookie，app退出后，cookie消失
        builder.cookieJar(new CookieJarImpl(new MemoryCookieStore()));

        //方法一：信任所有证书,不安全有风险
        HttpsUtils.SSLParams sslParams1 = HttpsUtils.getSslSocketFactory();
//方法二：自定义信任规则，校验服务端证书
//        HttpsUtils.SSLParams sslParams2 = HttpsUtils.getSslSocketFactory(new SafeTrustManager());
//方法三：使用预埋证书，校验服务端证书（自签名证书）
//        try {
//            HttpsUtils.SSLParams sslParams3 = HttpsUtils.getSslSocketFactory(new InputStream[]{getResources().getAssets().open("www.mae.vip.cer")});
////            builder.sslSocketFactory(sslParams3.sSLSocketFactory, sslParams3.trustManager);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//方法四：使用bks证书和密码管理客户端证书（双向认证），使用预埋证书，校验服务端证书（自签名证书）
//        try {
//            HttpsUtils.SSLParams sslParams4 = HttpsUtils.getSslSocketFactory(getAssets().open("www_mae.bks"), "MaYiApp2018@723", getAssets().open("www.mae.vip.cer"));
////            builder.sslSocketFactory(sslParams4.sSLSocketFactory, sslParams4.trustManager);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        vip.mae.app.HttpsUtils.SSLParams sslParams5 = vip.mae.app.HttpsUtils.getSslSocketFactory(getApplicationContext(),
//                R.raw.www_mae, "MaYiApp2018@723", "defualt");
//        builder.sslSocketFactory(sslParams5.sSLSocketFactory, sslParams5.trustManager);
        builder.sslSocketFactory(sslParams1.sSLSocketFactory, sslParams1.trustManager);
//配置https的域名匹配规则，详细看demo的初始化介绍，不需要就不要加入，使用不当会导致https握手失败
//        builder.hostnameVerifier(new SafeHostnameVerifier());


//---------这里给出的是示例代码,告诉你可以这么传,实际使用的时候,根据需要传,不需要就不传-------------//
        HttpHeaders headers = new HttpHeaders();
//        headers.put("commonHeaderKey1", "commonHeaderValue1");    //header不支持中文，不允许有特殊字符
        HttpParams params = new HttpParams();
//        params.put("commonParamsKey1", "commonParamsValue1");     //param支持中文,直接传,不要自己编码
        if (!UserService.service(context).getToken().equals("-1") && UserService.service(context).getToken().length() == 18) {
            params.put("token", MD5Util.tokenMD5(UserService.service(context).getToken()));

        } else {
            params.put("token", "");
        }
//        if (UserService.service(context).getUserId() > 0)
        params.put("userId", UserService.service(context).getUserId());

        OkGo.getInstance().init(context)                       //必须调用初始化
                .setOkHttpClient(builder.build())               //建议设置OkHttpClient，不设置将使用默认的
                .setCacheMode(CacheMode.NO_CACHE)               //全局统一缓存模式，默认不使用缓存，可以不传
                .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)   //全局统一缓存时间，默认永不过期，可以不传
                .setRetryCount(3)                               //全局统一超时重连次数，默认为三次，那么最差的情况会请求4次(一次原始请求，三次重连请求)，不需要可以设置为0
                .addCommonHeaders(headers)                      //全局公共头
                .addCommonParams(params);                       //全局公共参数
    }
}
