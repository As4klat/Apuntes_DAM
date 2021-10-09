package Enums;

public enum Zona {
    PROA("Proa",1), ESTRIBOR("Estribor",2), POPA("Popa",3), BABOR("Babor",4);
    
    private String nombreZona;
    private int escaleras;
    
    private Zona(String nombreZona, int escaleras){
        this.nombreZona = nombreZona;
    }
    
    public String getNombreZona(){
        return this.nombreZona;
    }
    public int getEscaleras(){
        return this.escaleras;
    }
}
