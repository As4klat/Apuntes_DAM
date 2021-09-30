package Enums;

public enum Responsabilidad {
    MUYBAJA("Muy baja"), BAJA("Baja"), MEDIA("Media"), ALTA("Alta"), MUYALTA("Muy alta");
    
    private String responsabilidad;
    
    private Responsabilidad(String responsabilidad){
        this.responsabilidad = responsabilidad;
    }
    
    public String getResponsabilidad(){
        return this.responsabilidad;
    }
}
