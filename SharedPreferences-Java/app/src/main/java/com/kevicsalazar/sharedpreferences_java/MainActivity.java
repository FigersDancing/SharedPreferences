package com.kevicsalazar.sharedpreferences_java;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PreferencesUtils pref = new PreferencesUtils(this);

        JsonObject user1 = new JsonObject();
        user1.addProperty("name", "Kevin Salazar");
        user1.addProperty("email", "kevicsalazar@gmail.com");

        JsonObject user2 = new JsonObject();
        user2.addProperty("name", "Kelly Salazar");
        user2.addProperty("email", "kellysalazar@gmail.com");

        JsonArray users = new JsonArray();
        users.add(user1);
        users.add(user2);

        pref.putJsonArray("users", users);

        List<User> userList = pref.getAny("users");

        Log.e("as", "as" + userList.size());
        Log.e("as", "as" + userList.toString());
        Log.e("as", "as" + pref.getJsonArray("users"));

        //Log.e("name", userList.get(0).name);

    }

}
