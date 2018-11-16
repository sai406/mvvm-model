package com.mvvmmodelrecyclerview.adapter;

/**
 * Created by lenovo on 2/22/2018.
 */

import android.databinding.BindingAdapter;
import android.util.Log;
import android.widget.ImageView;

import com.mvvmmodelrecyclerview.R;
import com.squareup.picasso.Picasso;

public class ImageBindingAdapter {

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView imageView, String url) {
        if (!url.equals("")) {
            try {
                Picasso.with(imageView.getContext()).load(url).placeholder(R.mipmap.ic_launcher).resize(80, 80).into(imageView);
            }catch (NullPointerException e)
            {
                Log.d("","image exception "+e );
            }
        }
    }
}