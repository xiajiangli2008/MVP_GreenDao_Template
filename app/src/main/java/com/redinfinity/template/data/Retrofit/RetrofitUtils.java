package com.redinfinity.template.data.Retrofit;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.redinfinity.template.app.Constants;
import com.redinfinity.template.app.MyApplication;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by weihuajian on 16/6/22.
 */
public class RetrofitUtils {
    private static Context mContext;
    public static Retrofit retrofit = null;
    private static String urlPath = "";
    private static boolean isAddToken = true;

    public static Retrofit getInstance(Context ctx) {
        return getInstance(ctx, Constants.URL_PATH,true);
    }

    /**
     *
     * @param ctx
     * @param isToken 不需要再头信息里传入token,isToken为false
     * @return
     */
    public static Retrofit getInstance(Context ctx,boolean isToken) {
        return getInstance(ctx,Constants.URL_PATH,isToken);
    }


    /**
     * 切换服务器时调用
     * @param ctx
     * @param url
     * @return
     */
    public static Retrofit getInstance(Context ctx,String url) {
        return getInstance(ctx,url,false);
    }

    public static Retrofit getInstance(Context ctx,String url,boolean isToken) {
        if(!urlPath.equals(url)) {
            retrofit = null;
            urlPath = url;
        }
        if(isAddToken!=isToken) {
            retrofit = null;
            isAddToken = isToken;
        }
        mContext = ctx;
        if (retrofit == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();

//            builder.addInterceptor(addQueryParameterInterceptor());
            builder.addInterceptor(addHeaderInterceptor());
            builder.addInterceptor(getHttpLoggingInterceptor());

            //设置缓存
//            File cacheFile = new File(mContext.getExternalCacheDir(), "RetrofitCache");
//            Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
//            builder.cache(cache).addInterceptor(addCacheInterceptor());

            //设置超时
            builder.connectTimeout(15, TimeUnit.SECONDS);
            builder.readTimeout(20, TimeUnit.SECONDS);
            builder.writeTimeout(20, TimeUnit.SECONDS);
            //错误重连
            builder.retryOnConnectionFailure(true);

            OkHttpClient client = builder.build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit;
    }

    /**
     * 开启打印连接日志
     * @return
     */
    private static HttpLoggingInterceptor getHttpLoggingInterceptor() {
        boolean isDebug= true;//是否开启
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

        if(isDebug)
        {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        }

        //开启打印连接日志
        return interceptor;
    }

    /**
     * 设置公共参数
     */
    private static Interceptor addQueryParameterInterceptor() {
        Interceptor addQueryParameterInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request request;
                HttpUrl modifiedUrl = originalRequest.url().newBuilder()
                        // Provide your custom parameter here
                        .addQueryParameter("platform", "android")
                        .addQueryParameter("version", "1.0.0")
                        .build();
                request = originalRequest.newBuilder().url(modifiedUrl).build();
                return chain.proceed(request);
            }
        };
        return addQueryParameterInterceptor;
    }

    /**
     * 设置头
     */
    private static Interceptor addHeaderInterceptor() {
        Interceptor headerInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request.Builder requestBuilder = originalRequest.newBuilder()
                        // Provide your custom header here
                        .header("token", MyApplication.getInstance().getToken())
                        .header("appType", "1")
                        .header("platformid ", "1")
                        .header("deviceid ", MyApplication.getInstance().getDeviceId())
                        .header("Accept", "application/json")
                        .method(originalRequest.method(), originalRequest.body());
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        };
        return headerInterceptor;
    }



    /**
     * 设置缓存
     */
    private static Interceptor addCacheInterceptor() {
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!isNetworkAvailable(mContext)) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response response = chain.proceed(request);
                if (isNetworkAvailable(mContext)) {
                    int maxAge = 0;
                    // 有网络时 设置缓存超时时间0个小时
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .removeHeader("Retrofit")// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                            .build();
                } else {
                    // 无网络时，设置超时为4周
                    int maxStale = 60 * 60 * 24 * 28;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("nyn")
                            .build();
                }
                return response;
            }
        };
        return cacheInterceptor;
    }


    /**
     * 判断网络
     */
    public static boolean isNetworkAvailable(Context ct) {
        Context context = ct.getApplicationContext();
        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) {
            return false;
        } else {
            NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();
            if (networkInfo != null && networkInfo.length > 0) {
                for (int i = 0; i < networkInfo.length; i++) {
                    if (networkInfo[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static Gson getGson(){

        Gson gson = new GsonBuilder().excludeFieldsWithModifiers().create();
        return gson;
    }

}
