# SharedPreferences
SharedPreferences Utils

## Java

```java
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
```

## Kotlin

```kotlin
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
        Log.e("users", users?.first()?.email)   // kevicsalazar@gmail.com
```
