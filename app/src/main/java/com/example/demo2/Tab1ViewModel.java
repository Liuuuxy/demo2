package com.example.demo2;

import android.widget.ImageView;

import androidx.databinding.ObservableArrayMap;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.demo2.model.Data;
import com.example.demo2.model.ListOfList;

import java.util.List;

public class Tab1ViewModel extends ViewModel {

    private ApplicationAdapter applicationAdapter;
    private ImageModel imageModel=new ImageModel();
    private ListOfList list;
    public ObservableArrayMap<String, String> images;
    public MutableLiveData<List<Data>> dataHor=new MutableLiveData<>();
    public MutableLiveData<List<Data>> dataSqu=new MutableLiveData<>();

    public Fragment fragment;

    public void setDataHor(){
        dataHor.setValue(imageModel.setHttp().getHor1());
    }

    public void setDataSqu() {
        dataSqu.setValue(imageModel.setHttp().getItemLists2());
    }

    public void fetchHorImageAt(Integer index) {
        String url = list.getHor1().get(index).getImage();
        //images.put(getImage(),url);
    }

    public void fetchSquareImageAt(Integer index) {
        String url = list.getItemLists2().get(index).getImage();

    }

}