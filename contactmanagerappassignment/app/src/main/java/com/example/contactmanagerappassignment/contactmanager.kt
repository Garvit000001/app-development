package com.example.contactmanagerappassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class contactmanager : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactmanager)

        val name=findViewById<TextInputEditText>(R.id.name)
        val contactnumber=findViewById<TextInputEditText>(R.id.contact)
        val addcontact=findViewById<Button>(R.id.button)

        addcontact.setOnClickListener{
            val name1=name.text.toString()
            val contactno1=contactnumber.text.toString()
            val Contact=contact(name1,contactno1)

            databaseReference=FirebaseDatabase.getInstance().getReference("contact")
            databaseReference.child(contactno1).setValue(Contact).addOnSuccessListener {
                name.text?.clear()
                contactnumber.text?.clear()

                Toast.makeText(this,"database running successfully and user registered", Toast.LENGTH_SHORT).show()

            }.addOnFailureListener{
                Toast.makeText(this,"database running failed and user not registered",Toast.LENGTH_SHORT).show()

            }

        }






    }
}