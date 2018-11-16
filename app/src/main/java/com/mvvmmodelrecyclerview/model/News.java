package com.mvvmmodelrecyclerview.model;

/**
 * Created by lenovo on 2/17/2018.
 */

public class News {

    public String Title,Desc,Imagepath;


    public News(String title, String desc ) {
        Title = title;
        Desc = desc;
        Imagepath = Imagepath;

    }

    public News() {
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }



}
