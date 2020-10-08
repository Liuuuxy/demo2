package com.example.demo2;

import com.example.demo2.model.Data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * author : Liuxy
 * date : 2020/9/22 22:20
 * description :
 */
public class ItemList {

    @SerializedName("type")
    String type;

    @SerializedName("data")
    @Expose
    private ChildData data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ChildData getData() {
        return data;
    }

    public void setData(ChildData data) {
        this.data = data;
    }

    public static class ChildData {
        @SerializedName("dataType")
        @Expose
        private String dataType;

        @SerializedName("itemList")
        @Expose
        private List<ItemList2> itemList;

        @SerializedName("text")
        String text;

        @SerializedName("actionUrl")
        String actionUrl;

        @SerializedName("title")
        String title;

        @SerializedName("description")
        String description;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getActionUrl() {
            return actionUrl;
        }

        public void setActionUrl(String actionUrl) {
            this.actionUrl = actionUrl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDataType() {
            return dataType;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

        public List<ItemList2> getItemList() {
            return itemList;
        }

        public void setItemList(List<ItemList2> itemList) {
            this.itemList = itemList;
        }

        public static class ItemList2 {
            //private String type;

            @SerializedName("data")
            @Expose
            private Data data;

           /* public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }*/

            public Data getData() {
                return data;
            }

            public void setData(Data data) {
                this.data = data;
            }
        }

    }
}

