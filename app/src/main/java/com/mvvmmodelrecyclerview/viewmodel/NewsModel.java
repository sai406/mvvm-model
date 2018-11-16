package com.mvvmmodelrecyclerview.viewmodel;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.mvvmmodelrecyclerview.R;
import com.mvvmmodelrecyclerview.model.News;
import com.squareup.picasso.Picasso;

/**
 * Created by lenovo on 2/17/2018.
 */

public class NewsModel {

    public String Title, Desc, Imagepath;


    public NewsModel() {
    }

    public String getImagepath() {
        // The URL will usually come from a model (i.e Profile)
        return Imagepath;
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.with(view.getContext())
                .load(imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .into(view);
    }

    public NewsModel(News news) {

        this.Title = news.Title;
        this.Desc = news.Desc;
        this.Imagepath = news.Imagepath;

    }
}
