
import Enums.Pais;
import Enums.Responsabilidad;
import Enums.Zona;
import java.time.LocalDate;

public class Tripulante extends Persona {
    private Responsabilidad responsabilidad;
    
    public Tripulante(String dni, Pais pais, Zona zona, 
            String nombre, boolean minusvalia, LocalDate fechaNac, int tipo, Responsabilidad responsabilidad){
        super(dni, pais, zona, nombre, minusvalia, fechaNac, tipo);
        this.responsabilidad = responsabilidad;
    }

    /*
    Getter
    */
    public Responsabilidad getResponsabilidad() {
        return this.responsabilidad;
    }
    
    public String toString(){
        return "\n---------------------------------" +
                "\nNombre: " + this.nombre +
                "\nDni: " + this.dni +
                "\nPais: " + this.pais.getNombrePais() +
                "\nZona: " + this.zona.getNombreZona() +
                "\nMinusvalia: " + this.minusvalia +
                "\nFecha de nacimiento: " + this.fechaNac +
                "\nEdad: " + this.edad +
                "\nResposabilidad: " + this.responsabilidad.getResponsabilidad();
    }
}
