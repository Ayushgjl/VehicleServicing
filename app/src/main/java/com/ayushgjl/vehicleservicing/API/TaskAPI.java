package com.ayushgjl.vehicleservicing.API;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface TaskAPI {
    @FormUrlEncoded
    @POST("tasks")
    Call<Void> addTask(@Header("Authorization")String token, @Field("name") String task);

}
