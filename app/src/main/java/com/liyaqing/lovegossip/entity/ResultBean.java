package com.liyaqing.lovegossip.entity;

import java.util.List;

/**
 * Created by liyaqing on 2017/3/9.
 */

public  class ResultBean<T> {
    private String stat;
    /**
     * uniquekey : c793995d2cf150cd7fd1a49be4c04e36
     * title : 【两会全视点】长城保护难又难 贫困地区是重点
     * date : 2017-03-09 12:09
     * category : 头条
     * author_name : 央视网
     * url : http://mini.eastday.com/mobile/170309120900848.html
     * thumbnail_pic_s : http://06.imgmini.eastday.com/mobile/20170309/20170309120900_12e49b07a16587b8f2e864a9dc831683_1_mwpm_03200403.jpeg
     * thumbnail_pic_s02 : http://06.imgmini.eastday.com/mobile/20170309/20170309120900_12e49b07a16587b8f2e864a9dc831683_2_mwpm_03200403.jpeg
     * thumbnail_pic_s03 : http://06.imgmini.eastday.com/mobile/20170309/20170309120900_12e49b07a16587b8f2e864a9dc831683_3_mwpm_03200403.jpeg
     */

    private List<T> data;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}