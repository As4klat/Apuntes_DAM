
import Enums.Pais;
import Enums.Zona;
import java.time.LocalDate;
import java.time.Period;

public class Persona {
    
    protected String dni;
    protected Pais pais;
    protected Zona zona;
    protected String nombre;
    protected boolean minusvalia;
    protected LocalDate fechaNac;
    protected int edad;
    protected int tipo;

    public Persona(String dni, Pais pais, Zona zona, 
            String nombre, boolean minusvalia, LocalDate fechaNac, int tipo){
        this.dni = dni;
        this.pais = pais;
        this.zona = zona;
        this.nombre = nombre;
        this.minusvalia = minusvalia;
        this.fechaNac = fechaNac;
        this.tipo = tipo;
        
        LocalDate hoy = LocalDate.now();
        Period edad = Period.between(fechaNac, hoy);
        this.edad = edad.getYears();
    }

    /*
    Getters
    */
    public String getDni() {
        return dni;
    }
    public Pais getPais() {
        return pais;
    }
    public Zona getZona() {
        return zona;
    }
    public String getNombre() {
        return nombre;
    }
    public boolean isMinusvalia() {
        return minusvalia;
    }
    public LocalDate getFechaNac() {
        return fechaNac;
    }
    public int getEdad() {
        return edad;
    }
    public int getTipo() {
        return tipo;
    } 
}
