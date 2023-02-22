 package com.example.databaseuiandux

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

 class MainActivity : AppCompatActivity() {


     private lateinit var database:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val signButton=findViewById<Button>(R.id.btnsignup)
        val etname=findViewById<TextInputEditText>(R.id.etname)
        val etmail=findViewById<TextInputEditText>(R.id.etmail)
        val userPassword=findViewById<TextInputEditText>(R.id.etpassword)
        val userId=findViewById<TextInputEditText>(R.id.etusername)

        signButton.setOnClickListener{
            val name=etname.text.toString()
            val mail=etmail.text.toString()
            val uniqueId=userId.text.toString()
            val password=userPassword.text.toString()
            val user=User(name , mail , password , uniqueId)
            database=FirebaseDatabase.getInstance().getReference("Users")
            database.child(uniqueId).setValue(user).addOnSuccessListener {
                etname.text?.clear()
                etmail.text?.clear()
                userId.text?.clear()
                userPassword.text?.clear()

// we are seting text to 0 ie by doing etname.settext.clear()

                Toast.makeText(this,"database running successfully and user registered",Toast.LENGTH_SHORT).show()

            }.addOnFailureListener{
                Toast.makeText(this,"database running failed and user not registered",Toast.LENGTH_SHORT).show()


            }
        }
    }
}