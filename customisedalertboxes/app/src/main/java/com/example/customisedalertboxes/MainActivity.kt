package com.example.customisedalertboxes

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    //create a variable of type dialog
    //dialog is built in class and we will initialise it  in oncreate ie afterwards
    lateinit var dialog:Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var mybutton=findViewById<Button>(R.id.btnClick)
        dialog=Dialog(this)//so dialog variable bana liya and initalise bhi kar diya hai
        dialog.setContentView(R.layout.custom_dialog)//and we will show this dialog box when click me is cllicked
        //jo bg_alert_box ie bacckground jobnaya vo bhi toh use karna hai
        //dialog.getwindow ie kitni jagah m vo dilaog box h
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.bg_alert_box))



        //creating variables which are inside custom_dialog .xml design
        //jo dialog initialise kiya tha pehle now we will use it
        var buttonGood=dialog.findViewById<Button>(R.id.btnGood)
        var buttonFeedback=dialog.findViewById<Button>(R.id.btnFeedback)
        buttonGood.setOnClickListener{
            dialog.dismiss()
        }
        buttonFeedback.setOnClickListener{
            //intents
            //or
            //toasts show karlo
        }
        mybutton.setOnClickListener{
            dialog.show()
        }






    }
}