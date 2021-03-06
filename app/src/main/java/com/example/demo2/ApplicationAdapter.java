package com.example.demo2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo2.databinding.RecyclerItemImageBinding;
import com.example.demo2.databinding.RecyclerItemSquareBinding;
import com.example.demo2.model.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * author : Liuxy
 * date : 2020/9/26 21:32
 * description :
 */
public class ApplicationAdapter extends RecyclerView.Adapter {

    private static final int VIEW_TYPE_HORIZONTAL = 0;
    private static final int VIEW_TYPE_SQUARE = 1;

    private List<Data> mData = new ArrayList<Data>();
    //private int layoutId;

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //
        if (getItemViewType(position) == VIEW_TYPE_HORIZONTAL) {
            // 绑定数据....
            ViewHolderOne headerViewHodlder = (ViewHolderOne) holder;
            Data data = mData.get(position);
            headerViewHodlder.bind(data);
        } else if (getItemViewType(position) == VIEW_TYPE_SQUARE) {
            ViewHolderTwo addressViewHolder = (ViewHolderTwo) holder;
            // 绑定数据...
        }
        // ..
    }

    public ApplicationAdapter(List<Data> data) {
        //this.layoutId = layoutId;
        this.mData = data;
    }

    public void updateData(List<Data> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    /*private int getLayoutIdForPosition(int position) {
        return layoutId;
    }*/

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (viewType == VIEW_TYPE_HORIZONTAL) {
            RecyclerItemImageBinding binding1 = DataBindingUtil.inflate(layoutInflater, R.layout.recycler_item_image, parent, false);
            return new ViewHolderOne(binding1);
        } else if (viewType == VIEW_TYPE_SQUARE) {
            RecyclerItemSquareBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.recycler_item_square, parent, false);
            return new ViewHolderTwo(binding);
        }
        return null;
    }


    @Override
    public int getItemCount() {
        return mData==null?0:mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        Data data = mData.get(position);
        if (data.getDataType().equals("Banner")) {
            return VIEW_TYPE_HORIZONTAL;
        } else if (data.getDataType().equals("SquareCard")) {
            return VIEW_TYPE_SQUARE;
        }
        return position;
    }

    /**
     * 第一种布局类型ViewHolder
     * horizontalScrollCard   banner 轮播图
     */
    public static class ViewHolderOne extends RecyclerView.ViewHolder {
        RecyclerItemImageBinding binding;

        public ViewHolderOne(RecyclerItemImageBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Data data) {
            binding.setVariable(BR.model, data);
            binding.executePendingBindings();
        }
    }

    /**
     * 第二种布局类型ViewHolder
     * specialSquareCardCollection   热门分类
     */
    public static class ViewHolderTwo extends RecyclerView.ViewHolder {
        RecyclerItemSquareBinding binding;

        public ViewHolderTwo(RecyclerItemSquareBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Data data) {
            binding.setVariable(BR.model, data);
            binding.executePendingBindings();
        }
    }

    /**
     * 第三种布局类型viewholder
     */
    public static class ViewHolderThree extends RecyclerView.ViewHolder {

        public ViewHolderThree(View itemView) {
            super(itemView);
        }
    }
}
