package com.ayushgjl.vehicleservicing.API;

import com.ayushgjl.vehicleservicing.Model.UpdateProfile;
import com.ayushgjl.vehicleservicing.Model.User;
import com.ayushgjl.vehicleservicing.Model.Usercrud;
import com.ayushgjl.vehicleservicing.Model.username;
import com.ayushgjl.vehicleservicing.UpdateActivity;
import com.ayushgjl.vehicleservicing.serverresponse.ImageResponse;
import com.ayushgjl.vehicleservicing.serverresponse.SignUpResponse;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;

import static com.ayushgjl.vehicleservicing.URL.url.token;

public interface UserAPI {
    @POST("users/signup")
    Call<SignUpResponse> registerUser(@Body User users);


    @POST("users/login")
    Call<SignUpResponse> checklogin(@Body username Username);

    @Multipart
    @POST("upload")
    Call<ImageResponse> uploadImage(@Part MultipartBody.Part img);

    @GET("users/me")
    Call<User> getUserDetails(@Header("Authorization")String token);

//    @GET("users/me")
//    Call<Usercrud> getupdate (@Header("Authorization") String token, @Body Usercrud usercrud );

    @GET("users/images")
    Call<ImageResponse> getImage(@Part MultipartBody.Part img);

    @PUT("users/me")
    Call<UpdateProfile> edituser(@Header("Authorization") String token, @Body UpdateProfile updateProfile);
}
