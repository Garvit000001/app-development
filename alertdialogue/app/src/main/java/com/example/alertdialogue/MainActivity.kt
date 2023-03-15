package com.example.alertdialogue

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.alertdialogue.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener{
            val builder1=AlertDialog.Builder(this)
            builder1.setTitle("are you sure")
            builder1.setMessage("do you want to close the app")
            builder1.setIcon(R.drawable.baseline_exit_to_app_24)
            builder1.setPositiveButton("yes",DialogInterface.OnClickListener { dialogInterface, i ->
                //what action should be performed when yes is clicked
                finish()
            })
            builder1.setNegativeButton("no",DialogInterface.OnClickListener { dialogInterface, i ->
                //what action should be performed when yes is clicked


            })
            builder1.show()
        }
        binding.btn2.setOnClickListener{
            val options= arrayOf("gulab jamun","rasmallai","Kaju Katli")
            val builder2=AlertDialog.Builder(this)
            builder2.setTitle("which is your favourite sweet")
            builder2.setSingleChoiceItems(options,0,DialogInterface.OnClickListener { dialogInterface, which ->
                //what action should be performed when user clicks on the item
                Toast.makeText(this,"You clicked on ${options[which]}",Toast.LENGTH_SHORT).show()

            })
            builder2.setPositiveButton("Accept",DialogInterface.OnClickListener { dialogInterface, i ->
                //what action should be performed when yes is clicked

            })
            builder2.setNegativeButton("Decline",DialogInterface.OnClickListener { dialogInterface, i ->
                //what action should be performed when yes is clicked


            })
            builder2.show()
        }
        binding.btn3.setOnClickListener{
            //it is another function or method so we can create builder2 var again

            val options= arrayOf("gulab jamun","rasmallai","Kaju Katli")
            val builder2=AlertDialog.Builder(this)
            builder2.setTitle("which is your favourite sweet")
            builder2.setMultiChoiceItems(options,null,DialogInterface.OnMultiChoiceClickListener { dialogInterface, which, ischecked ->
                Toast.makeText(this,"You clicked on ${options[which]}",Toast.LENGTH_SHORT).show()

            })
            builder2.setPositiveButton("Accept",DialogInterface.OnClickListener { dialogInterface, i ->
                //what action should be performed when yes is clicked


            })
            builder2.setNegativeButton("Decline",DialogInterface.OnClickListener { dialogInterface, i ->
                //what action should be performed when yes is clicked


            })
            builder2.show()

        }
    }
}