package com.example.demo2;

import android.util.Log;

import com.example.demo2.model.Bean;
import com.example.demo2.model.Data;
import com.example.demo2.model.ListOfList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author : Liuxy
 * date : 2020/10/3 15:21
 * description :
 */
public class ImageModel {

    ListOfList list=new ListOfList();

    List<Data> hor1 = new ArrayList<>();//horizontalScrollCard   banner 轮播图
    List<Data> itemLists2 = new ArrayList<>();//specialSquareCardCollection 热门分类
    List<Data> column = new ArrayList<>();//columnCardList 专题策划
    List<ItemList.ChildData> textCards = new ArrayList<>();//textCard  相应标题
    List<Data> banners = new ArrayList<>();//banner   开眼栏目
    List<ItemList.ChildData> videos = new ArrayList<>();//videoSmallCard 本周榜单
    List<ItemList.ChildData> briefCards = new ArrayList<>();///briefCard 推荐主题

    public void setHttp(final DataCallBack newsCallBack) {
        final List<ItemList>[] itemLists = new List[]{new ArrayList<>()};
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://baobab.kaiyanapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final GetRequest_Interface request_interface = retrofit.create(GetRequest_Interface.class);
        Call<Bean> call = request_interface.getCall();
        call.enqueue(new Callback<Bean>() {
            @Override
            public void onResponse(Call<Bean> call, Response<Bean> response) {
                newsCallBack.onSuccess(response.body().getItemList());
            }

            @Override
            public void onFailure(Call<Bean> call, Throwable t) {
                System.out.println("请求失败");
                Log.i("aa", "onErro=====>" + t.getMessage());
            }
        });
    }
/*
* for (ItemList itemList : itemLists) {
                            Log.d("response========>type",itemList.getType());
                            if (itemList.type.equals("textCard")) {
                                textCards.add(itemList.getData());
                                //Log.i("response1===========>", textCards.get(0).getData().getActionUrl());
                            } else if (itemList.type.equals("banner")) {
                                //banners.add(itemList);
                            } else if (itemList.type.equals("videoSmallCard")) {
                                videos.add(itemList.getData());
                            } else if (itemList.type.equals("briefCard")) {
                                briefCards.add(itemList.getData());
                            } else if (itemList.type.equals("horizontalScrollCard")) {
                                for (ItemList.ChildData.ItemList2 l2 : itemList.getData().getItemList())
                                    hor1.add(l2.getData());
                                Log.i("hor",hor1.get(0).getDataType());
                            } else if (itemList.type.equals("specialSquareCardCollection")) {
                                for (ItemList.ChildData.ItemList2 l2 : itemList.getData().getItemList())
                                    itemLists2.add(l2.getData());
                            } else if (itemList.type.equals("columnCardList")) {
                                for (ItemList.ChildData.ItemList2 l2 : itemList.getData().getItemList())
                                    column.add(l2.getData());
                            }
                        }
                        list.setHor1(hor1);
                        list.setItemLists2(itemLists2);
                        list.setColumn(column);
                        list.setTextCards(textCards);
                        //list.setBanners(banners);
                        list.setVideos(videos);
                        list.setBriefCards(briefCards);
                        return list;
                    }*/

}
