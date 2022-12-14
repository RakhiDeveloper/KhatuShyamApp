package com.example.khatushyamapp;



import android.graphics.ColorSpace;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("index?action=wallpapers&page=1")
    Call<BhaktiMyModal> getWallPaper();
}
