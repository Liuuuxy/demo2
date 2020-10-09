package com.example.demo2;

/**
 * author : Liuxy
 * date : 2020/10/3 16:10
 * description :
 */

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.demo2.model.Data;

import java.util.List;

public class CustomViewBinding {
    @BindingAdapter(value={"setAdapter","data"},requireAll = false)
    public static void bindRecyclerViewAdapter(RecyclerView recyclerView, RecyclerView.Adapter<?> adapter,
                                               MutableLiveData<List<Data>> data) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter("imageUrl")
    public static void bindRecyclerViewAdapter(ImageView imageView, String imageUrl) {

        // If we don't do this, you'll see the old image appear briefly
        // before it's replaced with the current image
        RequestOptions requstOption = new RequestOptions()
                .error(R.drawable.img_load_failure)//图片加载失败后，显示的图片
                .fitCenter();
        requstOption.error(R.mipmap.ic_launcher);
        RequestOptions myOption = new RequestOptions()
                .fitCenter();
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .apply(myOption)
                .into(imageView);

    }
}
