package com.ayushgjl.vehicleservicing.API;

import com.ayushgjl.vehicleservicing.Model.BikeBooking;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface BikeBookingAPI {
    @POST("bikebooking")
    Call<BikeBooking> registerbiekbooking(@Body BikeBooking bikebooking);




}
