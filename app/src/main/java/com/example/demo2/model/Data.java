package com.example.demo2.model;

/**
 * author : Liuxy
 * date : 2020/9/22 22:16
 * description :
 */
public class Data {
    String dataType;
    private String image;
    private String title;

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

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
