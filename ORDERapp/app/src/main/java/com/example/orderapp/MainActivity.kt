package com.example.orderapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //creating key
    companion object{
        const val KEY="com.example.orderapp.MainActivity.KEY"
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnOrder.setOnClickListener {
            //isme et1.gettext.tostring()
            val orderplaced = et1.text.toString() + " " + et2.text.toString() + " " +
                    et3.text.toString() + " " + et4.text.toString()


//in kotlin companion object works like static of java ie global variable bnane ke kam ata hai
            intent = Intent(this, ShowOrder::class.java)
            intent.putExtra(KEY, orderplaced)//these are key value pairs which we have given inside it using comma
            startActivity(intent)


        }



    }
}