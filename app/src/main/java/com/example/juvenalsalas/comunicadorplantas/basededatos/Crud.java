package com.example.juvenalsalas.comunicadorplantas.basededatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


    public class Crud {

        public Crud(){

        }

        private ConexionHelper helper;
        private SQLiteDatabase db;
        private ContentValues values;

        public Crud(Context context) {
            helper = new ConexionHelper(context);
            values = new ContentValues();

        }
        public Planta buscar(int id){
            Planta p = new Planta();
            db = helper.getReadableDatabase();
            Cursor cursor = db.rawQuery("select * from "+ConexionHelper.TABLA+" where id=?",
                    new String[]{String.valueOf(id)});
            if (cursor.moveToNext()){
                p.id = cursor.getInt(0);
                p.titulo = cursor.getString(1);
                p.nombreComun = cursor.getString(2);
                p.nombreCientifico = cursor.getString(3);
                p.altura = cursor.getString(4);
                p.descripcion = cursor.getString(5);
                p.foto1 = cursor.getInt(6);

            }
            db.close();
            return p;
        }

        public List<Planta> plantaList(){
            List<Planta> list = new ArrayList<>();
            db = helper.getWritableDatabase();
            String sql = "select * from "+ConexionHelper.TABLA;
            Cursor cursor = db.rawQuery(sql, null);

            while(cursor.moveToNext()){
                Planta p = new Planta();
                p.id = cursor.getInt(0);
                p.titulo = cursor.getString(1);
                p.nombreComun = cursor.getString(2);
                p.nombreCientifico = cursor.getString(3);
                p.altura = cursor.getString(4);
                p.descripcion = cursor.getString(5);
                p.foto1 = cursor.getInt(6);
                list.add(p);
            }
            db.close();
            return list;
        }


    }
