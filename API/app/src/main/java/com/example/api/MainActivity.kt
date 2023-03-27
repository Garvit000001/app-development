package com.example.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView=findViewById(R.id.recyclerview)

//        4stepsforapi
        //step 1 set depemdency of gson and corresponding api
        //strp 2 crete class using extension
        //stepm 3 create interface aur end point likhna usme
        //step 4 create retrofit builder
        val retrofitBuilder=Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
        //till now we have created retrofit builder

        //ab hum data bhi to leele
        val retrofitData=retrofitBuilder.getProductData()

        //ab ya to api ka bulana ka kaam successful ho jae ya fail ho jae
//        ctrl+shift+space
        retrofitData.enqueue(object : Callback<MyData?> {//response ke response<MyData > hoga ie object hoga MyData wala
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                //if api call is a success,then use the data of Api  and show in your app what u want to do with that api
                var responseBody=response.body()
                val productlist=responseBody?.products!!

            val myAdapter=MyAdapter(this@MainActivity,productlist)
            recyclerView.adapter=myAdapter
            recyclerView.layoutManager=LinearLayoutManager(this@MainActivity)

//                val collectdatainstringbuilder=StringBuilder()
//            if (productlist != null) {//we can also use products!! above if we da=ont want to write thisline
//                for(myData in productlist){
//                    collectdatainstringbuilder.append(myData.title+ " ")
//                }
//            val tv=findViewById<TextView>(R.id.textview)
//            tv.text=collectdatainstringbuilder
//            }
        }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                //if apicall fails,then kya error ya image show karvado hum error dekhenge kya error hai using log
                Log.d("Main Activity", "onFailure: "+ t.message)
            }
        })


    }
}