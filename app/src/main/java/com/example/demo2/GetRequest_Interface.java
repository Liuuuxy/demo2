package com.example.demo2;

import com.example.demo2.model.Bean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * author : Liuxy
 * date : 2020/9/26 9:19
 * description :用于描述网络请求
 */
public interface GetRequest_Interface {
    @GET("api/v7/index/tab/discovery?udid=fa53872206ed42e3857755c2756ab683fc22d64a&vc=591&vn=6.2.1&size=720X1280&deviceModel=Che1-CL20&first_channel=eyepetizer_zhihuiyun_market&last_channel=eyepetizer_zhihuiyun_market&system_version_code=19")
    Call<Bean> getCall();
}
