package com.example.examoptions

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.examoptions.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.tv1.setOnClickListener{
            val builder1=AlertDialog.Builder(this)
            val options=arrayOf("from","at","in","on")
            builder1.setTitle("Select any one option")
            builder1.setSingleChoiceItems(options,0,DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this,"you clicked ${options[i]}",Toast.LENGTH_SHORT).show()

            })
            builder1.setPositiveButton("Accept",DialogInterface.OnClickListener { dialogInterface, i ->
                //what action should be performed when yes is clicked


            })
            builder1.setNegativeButton("Decline",DialogInterface.OnClickListener { dialogInterface, i ->
                //what action should be performed when yes is clicked
            })
            builder1.show()


        }
        binding.tv2.setOnClickListener{
            val builder2=AlertDialog.Builder(this)
            val options=arrayOf("am","have","had","is")
            builder2.setTitle("Select any one option")
            builder2.setSingleChoiceItems(options,0,DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this,"you clicked ${options[i]}",Toast.LENGTH_SHORT).show()

            })
            builder2.setPositiveButton("Accept",DialogInterface.OnClickListener { dialogInterface, i ->
                //what action should be performed when yes is clicked


            })
            builder2.setNegativeButton("Decline",DialogInterface.OnClickListener { dialogInterface, i ->
                //what action should be performed when yes is clicked
            })
            builder2.show()

        }
        binding.tv3.setOnClickListener{
            val builder2=AlertDialog.Builder(this)
            val options=arrayOf("Fatima's","Fatima is","Fatimas","Fatimas'")
            builder2.setTitle("Select any one option")
            builder2.setSingleChoiceItems(options,0,DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this,"you clicked ${options[i]}",Toast.LENGTH_SHORT).show()

            })
            builder2.setPositiveButton("Accept",DialogInterface.OnClickListener { dialogInterface, i ->
                //what action should be performed when yes is clicked


            })
            builder2.setNegativeButton("Decline",DialogInterface.OnClickListener { dialogInterface, i ->
                //what action should be performed when yes is clicked
            })
            builder2.show()

        }
        binding.button.setOnClickListener{
            finish()
        }


    }
}