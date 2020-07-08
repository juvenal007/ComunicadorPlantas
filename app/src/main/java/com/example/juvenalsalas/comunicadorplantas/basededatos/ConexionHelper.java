package com.example.juvenalsalas.comunicadorplantas.basededatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.juvenalsalas.comunicadorplantas.R;

public class ConexionHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "ComunicadorPlanta";
    private static final int VERSION = 1;

    public static final String TABLA = "planta";
    public static final String ID = "id";
    public static final String TITULO = "titulo";
    public static final String NOMBRECOMUN = "nombreComun";
    public static final String NOMBRECIENTIFICO = "nombreCientifico";
    public static final String ALTURA = "altura";
    public static final String DESCRIPCION = "descripcion";
    public static final String FOTO1 = "foto1";

    public ConexionHelper(Context context){super(context,DATABASE_NAME, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String script = "";
        script = "create table "+TABLA+"("+ID+" integer primary key autoincrement,";
        script +=TITULO+" text,";
        script +=NOMBRECOMUN+" text,";
        script +=NOMBRECIENTIFICO+" text,";
        script +=ALTURA+" text,";
        script +=DESCRIPCION+" text,";
        script +=FOTO1+" integer";
        script +=");";
        db.execSQL(script);
        db.execSQL("insert into "+TABLA+" values(null,'Lirio','Lirio cárdeno','Iris germánica','60 a 90 cm.','Los lirios son plantas perenes que poseen tallos de casi 1 metro de alto. Éstos son lo bastante fuertes y en ellos se pueden encontrar las hojas y flores del lirio.',"+R.drawable.lirio+");");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table "+TABLA);
        onCreate(db);

    }
}