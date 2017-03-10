package com.liyaqing.lovegossip.net;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.liyaqing.lovegossip.BuildConfig;
import com.liyaqing.lovegossip.util.LogInterceptor;
import com.liyaqing.lovegossip.util.LogUtil;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by liyaqing on 2017/3/8.
 */

public class AndroidHttp {
    private static AndroidHttp mInstance;

    private Retrofit retrofit;
    private Retrofit juheRetrofit;

    private OkHttpClient okHttpClient;


    private AndroidHttp() {

    }

    /**
     * 获取单例
     */
    public static AndroidHttp getInstance()
    {
        if (mInstance == null)
        {
            synchronized (AndroidHttp.class)
            {
                if (mInstance == null)
                {
                    mInstance = new AndroidHttp();
                }
            }
        }
        return mInstance;
    }



    /**
     * 获取pgyer retrofit
     * @return
     */
    public Retrofit retrofit(String baseUrl){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(getOkHttpClient())
                    .build();
        }
        return retrofit;
    }
    public Retrofit juheRetrofit(String baseUrl){
        if (juheRetrofit == null){
            juheRetrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(getOkHttpClient())
                    .build();
        }
        return juheRetrofit;
    }


    /**
     * 获取OkHttpClient
     * @return
     */
    public OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (BuildConfig.DEBUG) {//打印请求体
                LogUtil.i("log================");
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//                builder.addInterceptor(interceptor);
                builder.addNetworkInterceptor(new StethoInterceptor());//配合chrome监听网络请求
                builder.addInterceptor(new LogInterceptor());
            }
            builder.connectTimeout(15000, TimeUnit.SECONDS);
            builder.retryOnConnectionFailure(false);
            okHttpClient = builder.build();
        }
        return okHttpClient;
    }
}
