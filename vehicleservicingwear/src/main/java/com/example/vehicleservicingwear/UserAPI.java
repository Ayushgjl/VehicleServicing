package com.example.vehicleservicingwear;



import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;

public interface UserAPI {



    @POST("users/login")
    Call<SignUpResponse> checklogin(@Body username Username);


}
