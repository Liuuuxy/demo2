package com.example.demo2;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.demo2.model.Data;
import com.example.demo2.model.ImageModel;

import java.util.ArrayList;
import java.util.List;

public class Tab1ViewModel extends ViewModel {

    public String banner="Banner";
    public String squ="SquareCard";
    private ImageModel imageModel = new ImageModel();
    public MutableLiveData<List<Data>> dataHor = new MutableLiveData<>();
    public MutableLiveData<List<Data>> dataSqu = new MutableLiveData<>();
    public MutableLiveData<List<Data>> dataCol = new MutableLiveData<>();
    public MutableLiveData<List<ItemList.ChildData>> dataVideo = new MutableLiveData<>();
    List<Data> hor1 = new ArrayList<>();//horizontalScrollCard   banner 轮播图
    List<Data> itemLists2 = new ArrayList<>();//specialSquareCardCollection 热门分类
    List<Data> column = new ArrayList<>();//columnCardList 专题策划
    List<ItemList.ChildData> videos = new ArrayList<>();//videoSmallCard 本周榜单


    public void setData() {
        imageModel.setHttp(itemLists -> {
            for (ItemList itemList : itemLists) {
                if (itemList.type.equals("horizontalScrollCard")) {
                    for (ItemList.ChildData.ItemList2 l2 : itemList.getData().getItemList())
                        hor1.add(l2.getData());
                    dataHor.setValue(hor1);
                    Log.i("horGetValue", dataHor.getValue().get(0).getDataType());
                } else if (itemList.type.equals("specialSquareCardCollection")) {
                    for (ItemList.ChildData.ItemList2 l2 : itemList.getData().getItemList())
                        itemLists2.add(l2.getData());
                    Log.i("square", itemLists2.get(0).getImage());
                    dataSqu.setValue(itemLists2);
                } else if (itemList.type.equals("columnCardList")) {
                    for (ItemList.ChildData.ItemList2 l2 : itemList.getData().getItemList())
                        column.add(l2.getData());
                    Log.i("Col", column.get(0).getDataType());
                    dataCol.setValue(column);
                } else if (itemList.type.equals("videoSmallCard")) {
                    videos.add(itemList.getData());
                    Log.i("Video", videos.get(0).getCover().feed);
                    dataVideo.setValue(videos);
                }
            }
        });
    }
}