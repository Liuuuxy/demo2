package com.example.demo2;

/**
 * author : Liuxy
 * date : 2020/10/3 16:10
 * description :
 */

import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.LayoutRes;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.demo2.model.Data;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CustomViewBinding {
    @BindingAdapter(value = {"data", "type"}, requireAll = false)
    public static void bindRecyclerViewAdapter(RecyclerView recyclerView,
                                               MutableLiveData<List<Data>> data, String type) {
        if (recyclerView.getAdapter() == null) {
            recyclerView.setAdapter(new ApplicationAdapter(data.getValue()));
            recyclerView.setHasFixedSize(true);
            if (type.equals("Banner"))
                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.HORIZONTAL, false));
            else if (type.equals("SquareCard")) {
                recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 3, GridLayoutManager.HORIZONTAL, false));
            }
        } else {
            if (recyclerView.getAdapter() instanceof ApplicationAdapter) {
                ((ApplicationAdapter) recyclerView.getAdapter()).updateData(data.getValue());
            }
        }
    }

    @BindingAdapter(value = "imageUrl")
    public static void bindRecyclerViewAdapter(@NotNull ImageView imageView, String imageUrl) {

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
