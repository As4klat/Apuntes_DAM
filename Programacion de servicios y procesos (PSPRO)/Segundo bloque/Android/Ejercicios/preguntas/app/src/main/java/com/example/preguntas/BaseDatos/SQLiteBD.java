package com.example.preguntas.BaseDatos;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.preguntas.Clases.Pregunta;
import com.example.preguntas.Clases.Respuesta;
import com.example.preguntas.Clases.Usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SQLiteBD extends SQLiteOpenHelper {

    private Map<String, String> conexion = new HashMap<String, String>();

    private static final String NOMBRE_BD = "preguntas.bd";
    private static final int VERSION_BD = 1;
    private static final String TABLA_PALABRAS = "CREATE TABLE PREGUNTAS(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "pregunta TEXT NOT NULL," +
            "respuestas TEXT NOT NULL)";
    private static final String TABLA_USUARIO = "CREATE TABLE USUARIO(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nombre TEXT," +
            "email TEXT NOT NULL UNIQUE," +
            "password TEXT NOT NULL)";

    public SQLiteBD(@Nullable Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
        conexion.put("status",null);
        conexion.put("mensaje",null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_USUARIO);
        sqLiteDatabase.execSQL(TABLA_PALABRAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS PREGUNTAS");
        sqLiteDatabase.execSQL(TABLA_PALABRAS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS USUARIO");
        sqLiteDatabase.execSQL(TABLA_USUARIO);
    }

    //
    //Gestión Usuarios
    //
    public HashMap agregarUsuario(Usuario usuario){
        SQLiteDatabase bd = getWritableDatabase();
        if(bd!=null){
            try{
                bd.execSQL("INSERT INTO USUARIO (email,password) VALUES(" +
                        "'"+usuario.getEmail()+"'," +
                        "'"+usuario.getPassword()+"');");
                bd.close();
                conexion.remove("status");
                conexion.put("status", "ok");
                conexion.remove("mensaje");
                conexion.put("mensaje", "Usuario creado saticfactoriamente.");
            }catch (SQLiteConstraintException ex){
                conexion.remove("status");
                conexion.put("status", "error");
                conexion.remove("mensaje");
                conexion.put("mensaje", "Ya existe el usuario.");
            }
            catch (SQLException ex){
                conexion.remove("status");
                conexion.put("status", "error");
                conexion.remove("mensaje");
                conexion.put("mensaje", "Error en la conexion.");
            }
        }
        return (HashMap) conexion;
    }

    public HashMap editarUsuario(Usuario usuario){
        SQLiteDatabase bd = getWritableDatabase();
        if(bd!=null){
            try{
                bd.execSQL("UPDATE USUARIO SET " +
                        "nombre = '"+usuario.getNombre()+"',"+
                        "email = '"+usuario.getEmail()+"',"+
                        "password = '"+usuario.getPassword()+"'"+
                        " WHERE id = "+ usuario.getId() + ";");
                bd.close();
                conexion.remove("status");
                conexion.put("status", "ok");
                conexion.remove("mensaje");
                conexion.put("mensaje", "Usuario modificado saticfactoriamente.");
            }catch (SQLiteConstraintException ex){
                conexion.remove("status");
                conexion.put("status", "error");
                conexion.remove("mensaje");
                conexion.put("mensaje", "Ya existe el email.");
            }
            catch (SQLException ex){
                conexion.remove("status");
                conexion.put("status", "error");
                conexion.remove("mensaje");
                conexion.put("mensaje", "Error en la conexion.");
            }
        }
        return (HashMap) conexion;
    }

    public Usuario buscarUsuario(String email, String password){
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM USUARIO" +
                " WHERE email = '"+email+"' AND password = '"+password+"'"
                ,null);
        Usuario usuario = null;
        if(cursor.moveToFirst()){
            do{
                usuario = new Usuario(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3)
                );
            }while (cursor.moveToNext());
        }
        bd.close();
        return usuario;
    }

    //
    // Gestión Preguntas
    //
    public void agregarPregunta(Pregunta pregunta){
        SQLiteDatabase bd = getWritableDatabase();
        if(bd!=null){
            bd.execSQL("INSERT INTO PREGUNTAS (pregunta,respuestas) VALUES(" +
                    "'"+pregunta.getPregunta()+"'," +
                    "'"+pregunta.respuestasToString()+"');");
            bd.close();
        }
    }

    public void editarPregunta(Pregunta pregunta){
        SQLiteDatabase bd = getWritableDatabase();
        if(bd!=null){
            bd.execSQL("UPDATE PREGUNTAS SET " +
                    "pregunta = '"+pregunta.getPregunta()+"',"+
                    "respuestas = '"+pregunta.respuestasToString()+"'"+
                    " WHERE id = "+ pregunta.getId() + ";");
            bd.close();
        }
    }

    public List<Pregunta> listarPreguntas(){
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM PREGUNTAS",null);
        List<Pregunta> preguntas = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                List<Respuesta> respuestas = new ArrayList<>();
                String[] respuestasString = cursor.getString(2).split(";");
                respuestas.add(new Respuesta(respuestasString[0],true));
                for(int i = 1; i < respuestasString.length; i++){
                    respuestas.add(new Respuesta(respuestasString[i],false));
                }
                preguntas.add(new Pregunta(
                        cursor.getInt(0),
                        cursor.getString(1),
                        respuestas));
            }while (cursor.moveToNext());
        }
        bd.close();
        return preguntas;
    }

    public boolean isInitPreguntas(){
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT COUNT(1) FROM PREGUNTAS",null);
        return cursor.moveToFirst();
    }
}
