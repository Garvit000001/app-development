package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.fragments.ui.login.LoginFragment
import java.sql.BatchUpdateException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonClock=findViewById<Button>(R.id.btnTime)
        val buttonExam=findViewById<Button>(R.id.btnExam)
        val buttonvalidate=findViewById<Button>(R.id.btnValidate)

        buttonClock.setOnClickListener {
            replaceframewithfragment(Clock_Fragment())

        }
        buttonExam.setOnClickListener {
            replaceframewithfragment(Exam_Fragment())

        }
        buttonvalidate.setOnClickListener {
            replaceframewithfragment(LoginFragment())
        }

    }

    private fun replaceframewithfragment(frag: Fragment) {
        val fragManager=supportFragmentManager
        val fragTransaction=fragManager.beginTransaction()
        fragTransaction.replace(R.id.frameLayout,frag)
        fragTransaction.commit()

    }
}