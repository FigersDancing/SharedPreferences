package com.kevicsalazar.sharedpreferences_kotlin


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import com.github.salomonbrys.kotson.jsonArray
import com.github.salomonbrys.kotson.jsonObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Creating Data

        val joUser1 = jsonObject("name" to "Kevin Salazar", "email" to "kevicsalazar@gmail.com")
        val joUser2 = jsonObject("name" to "Kelly Salazar", "email" to "kellysalazar@gmail.com")
        val jaUsers = jsonArray(joUser1, joUser2)

        // Saving Data

        val pref = PreferenceManager.getDefaultSharedPreferences(this)

        pref.put("user1", joUser1)
        pref.put("user2", joUser2)
        pref.put("users", jaUsers)

        // Getting Data

        val user1 = pref.any<User>("user1")
        val user2 = pref.any<User>("user2")
        val users = pref.any<List<User>>("users")

        Log.e("user1", user1?.name)             // Kevin Salazar
        Log.e("user2", user2?.name)             // Kelly Salazar
        Log.e("users", users?.get(0)?.email)  // kevicsalazar@gmail.com

    }

}