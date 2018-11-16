package com.mvvmmodelrecyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mvvmmodelrecyclerview.R;
import com.mvvmmodelrecyclerview.databinding.NewsBinding;
import com.mvvmmodelrecyclerview.listeners.ClickListener;
import com.mvvmmodelrecyclerview.model.News;
import com.mvvmmodelrecyclerview.viewmodel.NewsModel;

import java.util.List;

/**
 * Created by lenovo on 2/17/2018.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomView> {


    List<NewsModel> newsList;
    private LayoutInflater layoutInflater;


    public CustomAdapter(List<NewsModel> newsList)
    {
        this.newsList = newsList;
    }

    @Override
    public CustomView onCreateViewHolder(final ViewGroup parent, final int viewType) {


        if(layoutInflater == null)
        {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        final NewsBinding newsBinding  = NewsBinding.inflate(layoutInflater,parent,false);

        newsBinding.setPresenter(new ClickListener() {
            @Override
            public void onclickListener() {

                Log.d("click me ","click me "+newsBinding.getNewsview().Title);
                Toast.makeText(parent.getContext(),""+newsBinding.getNewsview().Title,Toast.LENGTH_LONG).show();

            }
        });

      //  View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.innerlayout,parent,false);
       return new CustomView(newsBinding);
    }

    @Override
    public void onBindViewHolder(CustomView holder, int position) {

      //  News news = newsList.get(position);
       // holder.title.setText(news.getTitle());
       // holder.desc.setText(news.getDesc());

        NewsModel newsModel = newsList.get(position);
        holder.bind(newsModel);




    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class CustomView extends RecyclerView.ViewHolder {

        private NewsBinding newsBinding;
       // TextView title, desc;
        public CustomView(NewsBinding newsBinding) {
            super(newsBinding.getRoot());

            this.newsBinding = newsBinding;
            //title = (TextView)itemView.findViewById(R.id.titleval);
            //desc =(TextView)itemView.findViewById(R.id.descval);

        }

        public void bind(NewsModel newsModel)
        {
            this.newsBinding.setNewsview(newsModel);
        }

        public NewsBinding getNewsBinding()
        {
            return newsBinding;
        }

    }
}
