package com.example.loginregister;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.loginregister.model.login.LoginData;

import java.util.HashMap;

public class SessionManager {
    private Context _context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private static final String IS_LOGGED_IN = "IsLoggedIn";
    private static final String ID = "id";
    private static final String USERNAME = "username";
    private static final String NAME = "name";

    public SessionManager (Context context){
        this._context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(LoginData user){
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.putString(ID, user.getId());
        editor.putString(USERNAME, user.getUsername());
        editor.putString(NAME, user.getName());
        editor.commit();
    }

    public HashMap<String,String> getUserDetail(){
        HashMap<String,String> user = new HashMap<>();
        user.put(ID, sharedPreferences.getString(ID, null));
        user.put(USERNAME, sharedPreferences.getString(USERNAME, null));
        user.put(NAME, sharedPreferences.getString(NAME, null));
        return user;
    }

    public void logoutSession(){
        editor.clear();
        editor.commit();
    }

    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }

}
