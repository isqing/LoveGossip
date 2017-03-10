package com.liyaqing.lovegossip.net;

import com.liyaqing.lovegossip.entity.MyResponse;
import com.liyaqing.lovegossip.entity.News;
import com.liyaqing.lovegossip.entity.ResultBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by liyaqing on 2017/3/9.
 */

public interface MyTestApi {
    public static String BASE_URL="http://v.juhe.cn/";
    @GET("/toutiao/index?key=69bde3e9041f66b9009af510193bec92")
    Observable<MyResponse<ResultBean<News>>> getNews(@Query("type") String type);
}
