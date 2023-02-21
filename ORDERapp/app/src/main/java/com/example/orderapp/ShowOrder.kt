package com.example.orderapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_show_order.*

class ShowOrder : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_order)
//is bar hume pehle wale activity se data lena h ie to read that data ie  intent se data lena hai
//getintent use kiya jo khud intent ke anddar tha so intent me hi badal gya
        val ordersofCustomer=intent.getStringExtra(MainActivity.KEY)
        //textvieworder.gettext kiya fir
        textVieworder.text="Order Place " + ordersofCustomer.toString()
    }
}