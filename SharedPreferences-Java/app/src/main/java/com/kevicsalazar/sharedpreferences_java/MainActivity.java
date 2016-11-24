package com.kevicsalazar.sharedpreferences_java;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creating Data

        JsonObject joUser1 = new JsonObject();
        joUser1.addProperty("name", "Kevin Salazar");
        joUser1.addProperty("email", "kevicsalazar@gmail.com");

        JsonObject joUser2 = new JsonObject();
        joUser2.addProperty("name", "Kelly Salazar");
        joUser2.addProperty("email", "kellysalazar@gmail.com");

        JsonArray jaUsers = new JsonArray();
        jaUsers.add(joUser1);
        jaUsers.add(joUser2);

        // Saving Data

        PreferencesUtils pref = new PreferencesUtils(this);

        pref.putJsonObject("user1", joUser1);
        pref.putJsonObject("user2", joUser2);
        pref.putJsonArray("users", jaUsers);

        // Getting Data

        User user1 = pref.getAny("user1", new TypeToken<User>() {});
        User user2 = pref.getAny("user2", new TypeToken<User>() {});
        List<User> users = pref.getAny("users", new TypeToken<List<User>>() {});

        Log.e("user1", user1.name);             // Kevin Salazar
        Log.e("user2", user2.name);             // Kelly Salazar
        Log.e("users", users.get(0).email);     // kevicsalazar@gmail.com

    }

}
