package com.example.demo2;

import android.util.Log;

import androidx.databinding.ObservableArrayMap;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.demo2.model.Data;
import com.example.demo2.model.ListOfList;

import java.util.ArrayList;
import java.util.List;

public class Tab1ViewModel extends ViewModel {


    private ImageModel imageModel = new ImageModel();
    private ListOfList list;
    public ObservableArrayMap<String, String> images;
    public MutableLiveData<List<Data>> dataHor = new MutableLiveData<>();
    public MutableLiveData<List<Data>> dataSqu = new MutableLiveData<>();
    public MutableLiveData<List<Data>> dataCol = new MutableLiveData<>();
    List<Data> hor1 = new ArrayList<>();//horizontalScrollCard   banner 轮播图
    List<Data> itemLists2 = new ArrayList<>();//specialSquareCardCollection 热门分类
    List<Data> column = new ArrayList<>();//columnCardList 专题策划

    public Fragment fragment;



    public void setDataHor() {
        //Log.d("================",String.valueOf(imageModel.setHttp().getHor1()==null));
        imageModel.setHttp(itemLists -> {
            for (ItemList itemList : itemLists) {
                //Log.d("response========>type", itemList.getType());
                if (itemList.type.equals("horizontalScrollCard")) {
                    for (ItemList.ChildData.ItemList2 l2 : itemList.getData().getItemList())
                        hor1.add(l2.getData());
                    Log.i("hor", hor1.get(0).getDataType());
                    dataHor.setValue(hor1);
                }
            }
        });
        //Log.d("vmdataHor========>", String.valueOf(dataHor.getValue() == null));
    }

    public void setDataSqu() {
        imageModel.setHttp(itemLists -> {
            for (ItemList itemList : itemLists) {
                if (itemList.type.equals("specialSquareCardCollection")) {
                    for (ItemList.ChildData.ItemList2 l2 : itemList.getData().getItemList())
                        itemLists2.add(l2.getData());
                    Log.i("square", itemLists2.get(0).getDataType());
                    dataSqu.setValue(itemLists2);
                }
            }
        });
    }

    public void setDataCol() {
        //Log.d("================",String.valueOf(imageModel.setHttp().getHor1()==null));
        imageModel.setHttp(itemLists -> {
            for (ItemList itemList : itemLists) {
                Log.d("response========>type", itemList.getType());
                if (itemList.type.equals("columnCardList")) {
                    for (ItemList.ChildData.ItemList2 l2 : itemList.getData().getItemList())
                        column.add(l2.getData());
                    Log.i("Col", column.get(0).getDataType());
                    dataCol.setValue(column);
                }
            }
        });
        Log.d("vmdatacol========>", String.valueOf(dataCol.getValue() == null));
    }


}