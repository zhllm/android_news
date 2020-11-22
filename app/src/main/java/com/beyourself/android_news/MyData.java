package com.beyourself.android_news;

import android.content.Context;
import android.content.SharedPreferences;

public class MyData {
    private final Context context;
    public int number;

    public MyData(Context context) {
        this.context = context;
    }

    public void save() {
        String name = context.getResources().getString(R.string.MY_DATA);
        SharedPreferences shp = context.getSharedPreferences(name, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        String key = context.getResources().getString(R.string.MY_KEY);
        editor.putInt(key, number);
        editor.apply();
    }

    public int load() {
        String name = context.getResources().getString(R.string.MY_DATA);
        SharedPreferences shp = context.getSharedPreferences(name, context.MODE_PRIVATE);
        String key = context.getResources().getString(R.string.MY_KEY);
        return shp.getInt(key, context.getResources().getInteger(R.integer.defaultValue));
    }

}
