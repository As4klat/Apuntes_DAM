package com.example.examen_android_gamaza;

public class Palabra {

    private int id, contador_aciertos;
    private String palabra_espanol,palabra_ingles,fecha_creado,fecha_consulta;

    public Palabra(){}

    public Palabra(int id, int contador_aciertos, String palabra_espanol, String palabra_ingles, String fecha_creado, String fecha_consulta) {
        this.id = id;
        this.contador_aciertos = contador_aciertos;
        this.palabra_espanol = palabra_espanol;
        this.palabra_ingles = palabra_ingles;
        this.fecha_creado = fecha_creado;
        this.fecha_consulta = fecha_consulta;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContador_aciertos(int contador_aciertos) {
        this.contador_aciertos = contador_aciertos;
    }

    public void setPalabra_espanol(String palabra_espanol) {
        this.palabra_espanol = palabra_espanol;
    }

    public void setPalabra_ingles(String palabra_ingles) {
        this.palabra_ingles = palabra_ingles;
    }

    public void setFecha_creado(String fecha_creado) {
        this.fecha_creado = fecha_creado;
    }

    public void setFecha_consulta(String fecha_consulta) {
        this.fecha_consulta = fecha_consulta;
    }

    public int getId() {
        return id;
    }

    public int getContador_aciertos() {
        return contador_aciertos;
    }

    public String getPalabra_espanol() {
        return palabra_espanol;
    }

    public String getPalabra_ingles() {
        return palabra_ingles;
    }

    public String getFecha_creado() {
        return fecha_creado;
    }

    public String getFecha_consulta() {
        return fecha_consulta;
    }
}
