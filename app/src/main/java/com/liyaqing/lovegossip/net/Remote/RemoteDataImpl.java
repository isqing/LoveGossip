package com.liyaqing.lovegossip.net.Remote;

import com.liyaqing.lovegossip.entity.MyResponse;
import com.liyaqing.lovegossip.entity.News;
import com.liyaqing.lovegossip.entity.ResultBean;
import com.liyaqing.lovegossip.net.AndroidHttp;
import com.liyaqing.lovegossip.net.MyTestApi;

import rx.Observable;

/**
 * Created by liyaqing on 2017/3/9.
 */

public class RemoteDataImpl implements RemoteData{
    private MyTestApi myTestApi;
    private static RemoteData remoteData;

    public RemoteDataImpl() {
        myTestApi= AndroidHttp.getInstance().juheRetrofit(MyTestApi.BASE_URL).create(MyTestApi.class);
    }
    public static RemoteData Instance() {
        if (remoteData==null){
            remoteData=new RemoteDataImpl();
        }
        return remoteData;
    }


    @Override
    public Observable<MyResponse<ResultBean<News>>> getNews(String type) {
        return myTestApi.getNews(type);
    }
}
