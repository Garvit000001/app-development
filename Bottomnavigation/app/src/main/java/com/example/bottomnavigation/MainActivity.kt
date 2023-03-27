package com.example.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val bottomView=findViewById<BottomNavigationView>(R.id.bottomNavigation)
        //whenever we use bottomnavigatioinview then we use fragments and we
        //link them with corresponding icons

        //fragments basically are similar to activity with some different property
        replacetheViewwithFragment(Home())
        //by default home fragment should be visible to user

        bottomView.setOnItemSelectedListener {
            when(it.itemId){//when itemId is item1 then do corresponding task
                R.id.item1 -> replacetheViewwithFragment(Home())
                R.id.item2 -> replacetheViewwithFragment(Search())
                R.id.item3 -> replacetheViewwithFragment(Profile())
                else->{

                }
            }
            //true ie items are clickable ie actions will be performed after clicking it
            true
        }

    }

    private fun replacetheViewwithFragment(fragment:Fragment) {
        //aapko chuti chaiye toh HR manager approve karta hai usi tarah

        var fragmentManager=supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()



    }
}