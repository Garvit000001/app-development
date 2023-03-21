package com.example.contactmanagerappassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class signin : AppCompatActivity() {

    lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val signInButton=findViewById<Button>(R.id.btnsignin)
        val username=findViewById<TextInputEditText>(R.id.etusernamedittext)
        signInButton.setOnClickListener{
            val uniqueId=username.text.toString()
            if(uniqueId.isNotEmpty()){
                readData(uniqueId)
            }
            else{
                Toast.makeText(this,"Please enter the User Name", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun readData(uniqueId: String) {
        databaseReference=FirebaseDatabase.getInstance().getReference("Users")
//        child("uniqueId") likhunga toh wrong ho jaega as uniqueid is itself a string
        databaseReference.child(uniqueId).get().addOnSuccessListener {
            if (it.exists()) {
                val email = it.child("Email").value
                val name = it.child("Name").value
                val userId = it.child("UniqueId").value

                val intent = Intent(this, contactmanager::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "User does not exists", Toast.LENGTH_SHORT).show()

            }
        }.addOnFailureListener{
            Toast.makeText(this,"FAILED in gettind data from database",Toast.LENGTH_SHORT).show()

        }

    }

}