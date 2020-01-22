package com.ayushgjl.vehicleservicing.API;

import com.ayushgjl.vehicleservicing.serverresponse.SignUpResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserAPI {
//    @POST("users/signup")
//    Call<SignUpResponse> registerUser(@Body User users);

    @FormUrlEncoded
    @POST("users/login")
    Call<SignUpResponse> checkUser(@Field("email") String email, @Field("password") String password);

}
