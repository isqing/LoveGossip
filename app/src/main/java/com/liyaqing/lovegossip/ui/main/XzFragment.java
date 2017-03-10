package com.liyaqing.lovegossip.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.liyaqing.lovegossip.R;
import com.liyaqing.lovegossip.entity.MyResponse;
import com.liyaqing.lovegossip.entity.News;
import com.liyaqing.lovegossip.entity.ResultBean;
import com.liyaqing.lovegossip.net.Remote.RemoteDataImpl;
import com.liyaqing.lovegossip.recyclerview.itemdecoration.DividerItemDecoration;
import com.liyaqing.lovegossip.ui.adapter.NewsListAdapter;
import com.liyaqing.lovegossip.ui.base.BaseFragment;
import com.liyaqing.lovegossip.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class XzFragment extends BaseFragment {

    @BindView(R.id.new_list)
    RecyclerView newList;
    List<News> dataList;
    private NewsListAdapter newsListAdapter;

    public XzFragment() {
        // Required empty public constructor
    }

    public static XzFragment newInstance() {
        XzFragment fragment = new XzFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new, container, false);
        ButterKnife.bind(this, view);
        dataList=new ArrayList<>();
        newList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        newList.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL_LIST));
        newsListAdapter = new NewsListAdapter(dataList,getContext());
        newList.setAdapter(newsListAdapter);


        getNews("");


        return view;
    }
    private void getNews(String type){
        Subscription subscription= RemoteDataImpl.Instance().getNews(type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyResponse<ResultBean<News>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();

                    }

                    @Override
                    public void onNext(MyResponse<ResultBean<News>> resultBeanMyResponse) {
                        LogUtil.i("listsize",resultBeanMyResponse.getError_code()+"");
                        dataList.clear();
                        dataList.addAll(resultBeanMyResponse.getResult().getData());
                        newsListAdapter.notifyDataSetChanged();

                    }
                });
        mSubscriptions.add(subscription);
    }

}
