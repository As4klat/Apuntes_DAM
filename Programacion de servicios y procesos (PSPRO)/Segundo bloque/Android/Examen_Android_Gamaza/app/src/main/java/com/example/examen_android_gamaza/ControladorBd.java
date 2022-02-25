package com.example.examen_android_gamaza;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ControladorBd extends SQLiteOpenHelper {

    private static final String NOMBRE_BD = "examen.bd";
    private static final int VERSION_BD = 1;
    private static final String TABLA_PALABRAS = "CREATE TABLE PALABRAS(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "palabra_espanol TEXT," +
            "palabra_ingles TEXT," +
            "fecha_creado TEXT," +
            "fecha_consulta TEXT," +
            "contador_aciertos INTEGER)";

    public ControladorBd(@Nullable Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_PALABRAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS PALABRAS");
        sqLiteDatabase.execSQL(TABLA_PALABRAS);
    }

    public void agregarPalabra(Palabra palabra){
        SQLiteDatabase bd = getWritableDatabase();
        if(bd!=null){
            bd.execSQL("INSERT INTO PALABRAS (palabra_espanol,palabra_ingles,fecha_creado,fecha_consulta,contador_aciertos) VALUES(" +
                    "'"+palabra.getPalabra_espanol()+"'," +
                    "'"+palabra.getPalabra_ingles()+"'," +
                    "'"+palabra.getFecha_creado()+"'," +
                    "'"+palabra.getFecha_consulta()+"'," +
                    ""+palabra.getContador_aciertos()+")");
            bd.close();
        }
    }

    public void editarPalabra(Palabra palabra){
        SQLiteDatabase bd = getWritableDatabase();
        if(bd!=null){
            bd.execSQL("UPDATE PALABRAS SET " +
                    "palabra_espanol = '"+palabra.getPalabra_espanol()+"'," +
                    "palabra_ingles = '"+palabra.getPalabra_ingles()+"'," +
                    "fecha_creado = '"+palabra.getFecha_creado()+"'," +
                    "fecha_consulta = '"+palabra.getFecha_consulta()+"'," +
                    "contador_aciertos = "+palabra.getContador_aciertos() +
                    " WHERE id = "+ palabra.getId() + ";");
            bd.close();
        }
    }

    public List<Palabra> mostrarPalabras(){
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM PALABRAS",null);
        List<Palabra>palabras = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                palabras.add(new Palabra(
                        cursor.getInt(0),
                        cursor.getInt(5),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)
                ));
            }while (cursor.moveToNext());
        }
        bd.close();
        return palabras;
    }

    public Palabra buscarPalabra(String palabra_espanol){
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM PALABRAS WHERE palabra_espanol = '"+palabra_espanol+"'",null);
        Palabra palabra = null;
        if(cursor.moveToFirst()){
            do{
                palabra = new Palabra(
                        cursor.getInt(0),
                        cursor.getInt(5),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)
                );
            }while (cursor.moveToNext());
        }
        bd.close();
        return palabra;
    }
}
