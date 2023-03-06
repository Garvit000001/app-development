package com.example.viewbindingandcheckbox

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.viewbindingandcheckbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//ActivityMainBinding ye class h jo view binding ne bnayi hai and it is automatically generated for ever xml file
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //ek simple line of code apko vhi use krna h hmesha to intitalise krne ke liye binding ko
        //it creates instance of binding class to use it ie in simple words object is created of binding class to use
        binding= ActivityMainBinding.inflate(layoutInflater)
//binding.getroot() kiya the maine in below line
        //isse hume xml file ka root or path mil jaega ie access mil jaega
        setContentView(binding.root)

        binding.button.setOnClickListener{
            if(binding.checkBox.isChecked){
                //open a new screen
            }else{
                //and change color of checkbox to red
                binding.checkBox.buttonTintList= ColorStateList.valueOf(Color.RED)
                //ask using toast to fill the checkbox
                Toast.makeText(this,"plz accept the terms and conditions",Toast.LENGTH_SHORT).show()
            }
        }


    }
}