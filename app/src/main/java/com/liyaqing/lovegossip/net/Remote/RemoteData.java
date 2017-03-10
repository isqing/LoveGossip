package com.liyaqing.lovegossip.net.Remote;

import com.liyaqing.lovegossip.entity.MyResponse;
import com.liyaqing.lovegossip.entity.News;
import com.liyaqing.lovegossip.entity.ResultBean;

import rx.Observable;

/**
 * Created by liyaqing on 2017/3/9.
 */

public interface RemoteData {
    Observable<MyResponse<ResultBean<News>>> getNews(String type);

}
