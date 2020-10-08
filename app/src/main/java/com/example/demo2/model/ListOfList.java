package com.example.demo2.model;

import com.example.demo2.ItemList;

import java.util.ArrayList;
import java.util.List;

/**
 * author : Liuxy
 * date : 2020/10/3 15:25
 * description :
 */
public class ListOfList {
    List<Data> hor1 = new ArrayList<>();//horizontalScrollCard   banner 轮播图
    List<Data> itemLists2 = new ArrayList<>();//specialSquareCardCollection 热门分类
    List<Data> column = new ArrayList<>();//columnCardList 专题策划
    List<ItemList.ChildData> textCards = new ArrayList<>();//textCard  相应标题
    List<Data> banners = new ArrayList<>();//banner   开眼栏目
    List<ItemList.ChildData> videos = new ArrayList<>();//videoSmallCard 本周榜单
    List<ItemList.ChildData> briefCards = new ArrayList<>();///briefCard 推荐主题

    public List<Data> getHor1() {
        return hor1;
    }

    public void setHor1(List<Data> hor1) {
        this.hor1 = hor1;
    }

    public List<Data> getItemLists2() {
        return itemLists2;
    }

    public void setItemLists2(List<Data> itemLists2) {
        this.itemLists2 = itemLists2;
    }

    public List<Data> getColumn() {
        return column;
    }

    public void setColumn(List<Data> column) {
        this.column = column;
    }

    public List<ItemList.ChildData> getTextCards() {
        return textCards;
    }

    public void setTextCards(List<ItemList.ChildData> textCards) {
        this.textCards = textCards;
    }

    public List<ItemList.ChildData> getVideos() {
        return videos;
    }

    public void setVideos(List<ItemList.ChildData> videos) {
        this.videos = videos;
    }

    public List<ItemList.ChildData> getBriefCards() {
        return briefCards;
    }

    public void setBriefCards(List<ItemList.ChildData> briefCards) {
        this.briefCards = briefCards;
    }

    public List<Data> getBanners() {
        return banners;
    }

    public void setBanners(List<Data> banners) {
        this.banners = banners;
    }

}
