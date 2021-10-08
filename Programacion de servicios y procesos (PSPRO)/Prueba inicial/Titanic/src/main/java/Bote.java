
import Enums.Zona;
import java.util.LinkedList;
import java.util.List;


class Bote {
    private List<Persona> personasAbordo;
    private int id;
    private int numeroPlazas;
    private Zona zona;
    
    public Bote(){
        this.personasAbordo = new LinkedList<>();
    }
    public Bote(int id, int numeroPlazas, Zona zona){
        this();
        this.id = id;
        this.numeroPlazas = numeroPlazas;
        this.zona = zona;
    }
    
    /*
    Getters
    */
    public List getPersonasAbordo(){
        return this.personasAbordo;
    }
    public int getId() {
        return id;
    }
    public int getNumeroPlazas() {
        return numeroPlazas;
    }
    public Zona getZona() {
        return zona;
    }
    
    public int numeroPlazasRest(){
        return this.numeroPlazas - this.personasAbordo.size();
    }
    public void subirPersona(Persona persona){
        this.personasAbordo.add(persona);
    }
    public boolean lleno(){
        boolean lleno = false;
        if(this.personasAbordo == null){
            lleno = false;
        }
        else
        {
            if(this.personasAbordo.size() == this.numeroPlazas){
                lleno = true;
            } 
        }

        return lleno;
    }
    public String toString(){
        return "\n------------------------------" +
               "\nId:" + this.id +
               "\nNumero de plazas: " + this.numeroPlazas +
               "\nZona del bote: " + this.zona.getNombreZona();
    }
}
