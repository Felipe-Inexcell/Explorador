package cl.inexcell.sistemadegestion.preferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by felip on 01/10/2015.
 */
public class FactSave {
    public static final String NAME = "FACT_SAVE";
    public Context mContext;
    public SharedPreferences sharedPreferences;

    public FactSave(Context context) {
        super();
        mContext = context;
        sharedPreferences = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
    }

    public void setValue(String boton, String info) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(boton, info);
        editor.apply();
    }
    public void setValue(String boton, int info) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(boton, info);
        editor.apply();
    }


    public String getValue(String boton) {
        String value = sharedPreferences.getString(boton, "0");
        return value;
    }

    public int getIntValue(String boton) {
        int valor = sharedPreferences.getInt(boton, -1);
        return valor;
    }

    public void clearPreferences() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }


}
