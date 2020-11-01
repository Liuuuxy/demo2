package com.example.demo2.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
 * author : Liuxy
 * date : 2020/9/22 22:16
 * description :
 */
public class Data extends BaseObservable {
    private String dataType;
    private String image;
    private String title;

    @Bindable
    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Bindable
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
        notifyChange();
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Data(String dt, String image, String title){
        this.dataType=dt;
        this.image=image;
        this.title=title;
    }
}
