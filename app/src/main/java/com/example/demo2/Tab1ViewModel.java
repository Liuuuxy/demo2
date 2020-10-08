package com.example.demo2;

import android.widget.ImageView;

import androidx.databinding.ObservableArrayMap;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;

import com.example.demo2.model.ListOfList;

public class Tab1ViewModel extends ViewModel {

    private ApplicationAdapter applicationAdapter;
    private ListOfList list;
    public ObservableArrayMap<String, String> images;

    public Fragment fragment;



    public void fetchHorImageAt(Integer index) {
        String url = list.getHor1().get(index).getImage();
        //images.put(getImage(),url);
    }

    public void fetchSquareImageAt(Integer index) {
        String url = list.getItemLists2().get(index).getImage();

    }

}