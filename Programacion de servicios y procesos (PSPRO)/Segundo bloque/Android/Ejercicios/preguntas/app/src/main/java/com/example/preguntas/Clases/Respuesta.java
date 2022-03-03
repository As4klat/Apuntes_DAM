package com.example.preguntas.Clases;

public class Respuesta {
    private String respuesta;
    private boolean valida;

    public Respuesta(String respuesta, boolean valida){
        this.respuesta = respuesta;
        this.valida = valida;
    }

    public String getRespuesta(){
        return this.respuesta;
    }
    public boolean getValida(){
        return this.valida;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public void setValida(boolean valida) {
        this.valida = valida;
    }
}
