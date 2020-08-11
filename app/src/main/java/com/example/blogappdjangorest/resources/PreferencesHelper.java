package com.example.blogappdjangorest.resources;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.firebase.auth.FirebaseAuth;

public class PreferencesHelper {
    public static SharedPreferences sharedPreferences;
    public static final String PREF_NAME = "Blog_data";
    public SharedPreferences.Editor editor;

    public PreferencesHelper(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void setToken(String token)
    {
        editor=sharedPreferences.edit();
        editor.putString("token",token);
        editor.apply();
    }
    public String gettoken()
    {
        return sharedPreferences.getString("token","NA");
    }
    public void setid(String id)
    {
        editor=sharedPreferences.edit();
        editor.putString("id",id);
        editor.apply();
    }
    public String getid()
    {
        return sharedPreferences.getString("id","NA");
    }
    public boolean islogin()
    {
        return sharedPreferences.getBoolean("islogin",false);
    }
    public void setlogin()
    {
        editor=sharedPreferences.edit();
        editor.putBoolean("islogin",true);
        editor.apply();
    }
    public boolean is_login()
    {
        if (FirebaseAuth.getInstance().getCurrentUser().getUid().equals(null))
        {
            return false;
        }
        else
            return true;
    }
}
