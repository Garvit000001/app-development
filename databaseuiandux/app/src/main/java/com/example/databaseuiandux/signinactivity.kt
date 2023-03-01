package com.example.databaseuiandux

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.getValue

class signinactivity : AppCompatActivity() {
//lateinit var banaya ie basdme inittialise kara jaega tujhe database
    private lateinit var databaseReference: DatabaseReference
    companion object{
        const val KEY1 ="com.example.databaseuiandux.siginactivity.mail"
        const val KEY2 ="com.example.databaseuiandux.siginactivity.name"
        const val KEY3 ="com.example.databaseuiandux.siginactivity.id"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signinactivity)

        val signInButton=findViewById<Button>(R.id.btnsignin)
        val userName=findViewById<TextInputEditText>(R.id.etusernameedittext)

        signInButton.setOnClickListener{

            val uniqueId=userName.text.toString()
            if(uniqueId.isNotEmpty()){
                readData(uniqueId)
            }else{
                Toast.makeText(this,"Please enter the User Name",Toast.LENGTH_SHORT).show()
            }

        }
    }//on create method over

    private fun readData(uniqueId: String) {
        //database ko ab intitalise kar diya
        databaseReference=FirebaseDatabase.getInstance().getReference("Users")
        //earlier we were setting value of child this time we will get and check if data exists or not
        //to jo input ki h uiqueId humne in inputedittext m vo pass kiya aur get kiya  and if vo child mil gya as
        //humne uniqueid se child bnaye the toh hume unke andar ki sari informaiton mil jaegi otherwise nhi h present
        databaseReference.child(uniqueId).get().addOnSuccessListener {
            //it represent child ie uniueId

            //if user exists or not
            if(it.exists()){
                //welcome user to your app with intent and also pass
                //.val jo kar rha hoon -> getvalue kar rha hai voh jo email
                //it.child represents uniqueId ke bhi jo children hai voh unhe correspond kar rha hai
                val email=it.child("Email").value
                val name=it.child("Name").value
                val userId=it.child("UniqueId").value

                val intentWelcome= Intent(this,welcomeactivity::class.java)
                //so now we need to pass values to intent which we can use in next page we can do it using  putExtra
                intentWelcome.putExtra(KEY1,email.toString())
                intentWelcome.putExtra(KEY2,name.toString())
                intentWelcome.putExtra(KEY3,userId.toString())
                startActivity(intentWelcome)



            }else{
                Toast.makeText(this,"User does not exists",Toast.LENGTH_SHORT).show()


            }



        }.addOnFailureListener{
            //database m jakr kya hum get kar pae hain agar nhi toh addonfailurelistener call hoega
            Toast.makeText(this,"FAILED in gettind data from database",Toast.LENGTH_SHORT).show()
        }

    }
}