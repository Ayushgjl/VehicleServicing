package com.ayushgjl.vehicleservicing.API;

import com.ayushgjl.vehicleservicing.Model.CarBooking;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface CarBookingAPI {
    @POST("carbooking")

    Call<CarBooking> registercarbooking(@Body CarBooking carBooking);
}
