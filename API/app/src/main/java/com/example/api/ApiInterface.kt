package com.example.api

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {


    //step no 3 , hum interface bana rhe hai ye yaad rkhna hai kyun bana rhe hai kyunki retrofit ka rule h yaar
    //isko hume batana odega ki hum api se get kar rhe hai jankari le rhe hai
    @GET("products")
    fun getProductData() : Call<MyData>

}