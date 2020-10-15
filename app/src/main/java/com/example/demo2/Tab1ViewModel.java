package com.example.demo2;

import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.ObservableArrayMap;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.demo2.model.Data;
import com.example.demo2.model.ListOfList;

import java.util.List;

public class Tab1ViewModel extends ViewModel {

    private ImageModel imageModel=new ImageModel();
    private ListOfList list;
    public ObservableArrayMap<String, String> images;
    public MutableLiveData<List<Data>> dataHor=new MutableLiveData<>();
    public MutableLiveData<List<Data>> dataSqu=new MutableLiveData<>();

    public Fragment fragment;

    public void setDataHor(){
        Log.d("================",String.valueOf(imageModel.setHttp().getHor1()==null));
        dataHor.setValue(imageModel.setHttp().getHor1());
        Log.d("vmdataHor========>",String.valueOf(dataHor.getValue()==null));
    }

    public void setDataSqu() {
        dataSqu.setValue(imageModel.setHttp().getItemLists2());
    }


}