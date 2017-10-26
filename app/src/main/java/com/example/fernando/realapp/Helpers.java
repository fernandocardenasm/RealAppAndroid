package com.example.fernando.realapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by fernando on 26.10.17.
 */

public class Helpers {

    public static ArrayList<LogData> loadLogs(Context context){
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        Gson gson = new Gson();
        String json = sharedPrefs.getString("logs", null);
        Type type = new TypeToken<ArrayList<LogData>>() {}.getType();
        return gson.fromJson(json, type);
    }

    public static void saveLogs(Context context, ArrayList<LogData> logs) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        Gson gson = new Gson();

        String json = gson.toJson(logs);

        editor.putString("logs", json);
        editor.commit();
    }

    public static void printLogs(Context context, ArrayList<LogData> logs) {
        for (int i = 0; i < logs.size(); i++) {
            LogData log = logs.get(i);
            Log.v("Log", "Date: " + log.date);
            Log.v("Log2", "String: " + log.stringData);
        }
    }

    public static String getCurrentDateTime(){
        SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ", Locale.getDefault());

        String myDate = format.format(new Date());

        return myDate;
    }

}
