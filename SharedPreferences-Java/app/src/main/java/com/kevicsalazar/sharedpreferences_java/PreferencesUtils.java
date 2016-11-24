package com.kevicsalazar.sharedpreferences_java;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.Date;

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */

public class PreferencesUtils {

    private SharedPreferences pref;

    public PreferencesUtils(Context context) {
        this.pref = PreferenceManager.getDefaultSharedPreferences(context);
    }

    // Primitive

    public void putInt(String key, int value) {
        pref.edit().putInt(key, value).apply();
    }

    public int getInt(String key, int def) {
        return pref.getInt(key, def);
    }

    public void putLong(String key, long value) {
        pref.edit().putLong(key, value).apply();
    }

    public long getLong(String key, long def) {
        return pref.getLong(key, def);
    }

    public void putFloat(String key, float value) {
        pref.edit().putFloat(key, value).apply();
    }

    public float getFloat(String key, float def) {
        return pref.getFloat(key, def);
    }

    public void putBoolean(String key, boolean value) {
        pref.edit().putBoolean(key, value).apply();
    }

    public boolean getBoolean(String key, boolean def) {
        return pref.getBoolean(key, def);
    }

    public void putString(String key, String value) {
        pref.edit().putString(key, value).apply();
    }

    public String getString(String key, String def) {
        return pref.getString(key, def);
    }

    // Date

    public void putDate(String key, Date date) {
        pref.edit().putLong(key, date.getTime()).apply();
    }

    public Date getDate(String key) {
        return new Date(pref.getLong(key, 0));
    }

    // Gson

    public void putJsonObject(String key, JsonObject value) {
        pref.edit().putString(key, value.toString()).apply();
    }

    public JsonObject getJsonObject(String key) {
        return new JsonParser().parse(pref.getString(key, null)).getAsJsonObject();
    }

    public void putJsonArray(String key, JsonArray value) {
        pref.edit().putString(key, value.toString()).apply();
    }

    public JsonArray getJsonArray(String key) {
        return new JsonParser().parse(pref.getString(key, null)).getAsJsonArray();
    }


    // No funciona u.u

    public <T> void putAny(String key, T value) {
        pref.edit().putString(key, new Gson().toJson(value)).apply();
    }

    public <T> T getAny(String key) {
        String value = pref.getString(key, null);
        return value != null ? (T) new Gson().fromJson(value, new TypeToken<T>() {
        }.getType()) : null;
    }

   /* public <T> List<T> getList(String key) {
        String value = pref.getString(key, null);
        return (List<T>) new Gson().fromJson(value, new TypeToken<T>() {
        }.getType());
    }*/

    /*public <T> List<T> getList(String key, Class<T> elementType) {
        String value = pref.getString(key, null);
        TypeToken<ArrayList<T>> token = new TypeToken<ArrayList<T>>() {
        };
        return new Gson().fromJson(value, token.getType());
    }

    public <T> T getSomething(String key) {
        String value = pref.getString(key, null);
        TypeToken<T> token = new TypeToken<T>() {};
        return new Gson().fromJson(value, token.getType());
    }

    public List<User> getUserList(String key){
        String value = pref.getString(key, null);
        return new Gson().fromJson(value, new TypeToken<List<User>>() {}.getType());
    }*/

}
