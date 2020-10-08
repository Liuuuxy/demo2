package com.example.demo2.model;

import androidx.databinding.BaseObservable;

import com.example.demo2.ItemList;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * author : Liuxy
 * date : 2020/9/22 22:18
 * description :
 */

public class Bean extends BaseObservable {
    public List<ItemList> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemList> itemList) {
        this.itemList = itemList;
    }


    @SerializedName("itemList")
    private List<ItemList> itemList;


}

