package com.liyaqing.lovegossip.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.liyaqing.lovegossip.R;
import com.liyaqing.lovegossip.entity.News;
import com.liyaqing.lovegossip.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyaqing on 2017/3/9.
 */

public class NewsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<News> newsList=new ArrayList();
    private Context context;
    public final int ONE_IMG=1;
    public final int TWO_IMG=2;
    public final int THRESS_IMG=3;

    public NewsListAdapter(List<News> newsList, Context context) {
        this.newsList = newsList;
        this.context= context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        View view=null;
        switch (viewType){
            case ONE_IMG:
                view= LayoutInflater.from(context).inflate(R.layout.news_item_1,parent,false);
                break;
            case TWO_IMG:
                view= LayoutInflater.from(context).inflate(R.layout.news_item_2,parent,false);
                break;
            case THRESS_IMG:
                view= LayoutInflater.from(context).inflate(R.layout.news_item_3,parent,false);
                break;
        }
        viewHolder=new ViewHoder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
           News news=newsList.get(position);
           ((ViewHoder) holder).author_name.setText(news.getAuthor_name());
           ((ViewHoder) holder).date.setText(news.getDate());
           ((ViewHoder) holder).title.setText(news.getTitle());
           ((ViewHoder) holder).category.setText(news.getCategory());
        int type=getItemViewType(position);
        if (type==ONE_IMG) {
            ((ViewHoder) holder).img1.setImageURI(news.getThumbnail_pic_s());
        }
        if (type==TWO_IMG) {
            ((ViewHoder) holder).img1.setImageURI(news.getThumbnail_pic_s());
            ((ViewHoder) holder).img2.setImageURI(news.getThumbnail_pic_s02());
        }
        if (type==THRESS_IMG) {
            ((ViewHoder) holder).img1.setImageURI(Uri.parse(news.getThumbnail_pic_s()));
            ((ViewHoder) holder).img2.setImageURI(Uri.parse(news.getThumbnail_pic_s02()));
            ((ViewHoder) holder).img3.setImageURI(Uri.parse(news.getThumbnail_pic_s03()));
        }
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    @Override
    public int getItemViewType(int position) {
//        return super.getItemViewType(position);
      if (newsList.get(position).getThumbnail_pic_s()!=null&&newsList.get(position).getThumbnail_pic_s02()!=null&&newsList.get(position).getThumbnail_pic_s03()!=null){
            return THRESS_IMG;
        }else if (newsList.get(position).getThumbnail_pic_s()!=null&&newsList.get(position).getThumbnail_pic_s02()!=null){
          return TWO_IMG;
      }else {
            return ONE_IMG;
        }
    }
    private class ViewHoder extends RecyclerView.ViewHolder{

        TextView author_name;
        TextView date;
        TextView category;
        TextView title;
        SimpleDraweeView img1;
        SimpleDraweeView img2;
        SimpleDraweeView img3;
        public ViewHoder(View itemView) {
            super(itemView);
            author_name=(TextView)itemView.findViewById(R.id.author_name);
            date=(TextView)itemView.findViewById(R.id.date);
            category=(TextView)itemView.findViewById(R.id.category);
            title=(TextView)itemView.findViewById(R.id.title);
            img1=(SimpleDraweeView)itemView.findViewById(R.id.img_1);
            img2=(SimpleDraweeView)itemView.findViewById(R.id.img_2);
            img3=(SimpleDraweeView)itemView.findViewById(R.id.img_3);
        }
    }
}
