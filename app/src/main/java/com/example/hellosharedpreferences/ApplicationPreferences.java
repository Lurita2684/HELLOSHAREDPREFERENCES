package com.example.hellosharedpreferences;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class ApplicationPreferences {

    private static SharedPreferences mSharedPref;
    static final String KEYNAME = "nombre";

    private ApplicationPreferences() {

    }

    // Asigna la base de datps que se llama MYPREFS
    public static void init(Context context) {

        if(mSharedPref == null){
            mSharedPref = context.getSharedPreferences("MYPREFS", Activity.MODE_PRIVATE);
        }
    }

    // guarda lo que hay dentro del edittext
    public static void  saveName(String name) {

        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putString(KEYNAME, name);
        prefsEditor.apply();
    }

    public static String loadName() {
        return mSharedPref.getString(KEYNAME, "");
    }
}
