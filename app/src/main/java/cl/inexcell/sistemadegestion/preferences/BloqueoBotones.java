package cl.inexcell.sistemadegestion.preferences;


import android.content.Context;
import android.content.SharedPreferences;

public class BloqueoBotones {
    public static final String NAME = "BLOQUEO_BOTONES";


    public Context mContext;
    public SharedPreferences sharedPreferences;

    public BloqueoBotones(Context context) {
        super();
        mContext = context;
        sharedPreferences = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
    }

    public void setBloqueo(String boton, Boolean estado, String msg){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(boton, estado);
        editor.putString(boton+"MSG", msg);
        editor.apply();

    }




    public Boolean getState(String boton){
        return sharedPreferences.getBoolean(boton, false);
    }

    public String getMsg(String boton){
        return sharedPreferences.getString(boton+"MSG", "");
    }



}
