package Enums;

public enum Pais {
    ESPAÑA("España"), FRANCIA("Francia"), ITALIA("Italia"), ALEMANIA("Alemania"), SUIZA("Suiza");
    
    private String nombrePais;
    
    private Pais(String nombrePais){
        this.nombrePais = nombrePais;
    }
    
    public String getNombrePais(){
        return this.nombrePais;
    }
}
