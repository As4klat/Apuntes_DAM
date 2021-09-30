
import Enums.Pais;
import Enums.Responsabilidad;
import Enums.Zona;
import java.time.LocalDate;

public class Pasajero extends Persona {
    private int habitacion;
    
    public Pasajero(String dni, Pais pais, Zona zona, 
            String nombre, boolean minusvalia, LocalDate fechaNac, int tipo, int habitacion){
        
        super(dni, pais, zona, nombre, minusvalia, fechaNac, tipo);
        this.habitacion = habitacion;
    }

    /*
    Getter
    */
    public int gethabitacion() {
        return this.habitacion;
    }
    
    public String toString()
    {
        return "\n---------------------------------" +
                "\nNombre: " + this.nombre +
                "\nDni: " + this.dni +
                "\nPais: " + this.pais.getNombrePais() +
                "\nZona: " + this.zona.getNombreZona() +
                "\nMinusvalia: " + this.minusvalia +
                "\nFecha de nacimiento: " + this.fechaNac +
                "\nEdad: " + this.edad +
                "\nHabitación: " + this.habitacion;
    }
}
