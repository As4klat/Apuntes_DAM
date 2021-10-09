
import Enums.Pais;
import Enums.Responsabilidad;
import Enums.Zona;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/*Simulacion de BBDD*/
public class DAOPersonas {
    private List<Persona> listaPersonas;
    
    public DAOPersonas(){
        this.listaPersonas = new LinkedList<>();
    }
    
    public DAOPersonas(int numeroTripulantes, int numeroPasajeros){
        this();
        int i;
        for (i=1; i <= numeroTripulantes; i++){
            Tripulante t = new Tripulante(dniRandom(), paisRandom(), zonaRandom(),
                    nombreRandom(), minusvaliaRandom(), fechaNacRandom(), 0, responsabilidadRandom());
            this.listaPersonas.add(t);
        }
        for (i=1; i <= numeroPasajeros; i++){
            Pasajero p = new Pasajero(dniRandom(), paisRandom(), zonaRandom(),
                    nombreRandom(), minusvaliaRandom(), fechaNacRandom(), 1, habitacionRandom());
            this.listaPersonas.add(p);
        }
    }
    
    
    /*Generar personas random*/
    private String dniRandom(){
        Random r = new Random();
        String dni = "";
        
        for(int i = 0; i < 8; i++ ){
            dni += String.valueOf(r.nextInt(9)+1);
        }
        
        String[] letras = {"A","B","C","D","E","F","G","H","J","K","L",
            "M","N","O","P","Q","R","S","T","U","V","W","X","Z"};
        
        dni += letras[r.nextInt(9)+1];
        
        while(compDni(dni)){
            dniRandom();
        }
        return dni;
    }
    private Pais paisRandom(){
        Random r = new Random();
        return Pais.values()[r.nextInt(5)];
    }
    private Zona zonaRandom(){
        Random r = new Random();
        return Zona.values()[r.nextInt(4)];
    }
    private String nombreRandom(){
        Random r = new Random();
        String nombre = "";
        String[] nombreArray = {
            "Alejandro",
            "Juan",
            "Antonio",
            "Paco",
            "Santi",
            "Adrian",
            "Manolo",
            "Mario",
            "David",
            "Elena",
            "Ana",
            "Maribel",
            "Maria",
            "Laura",
            "Rocio",
            "Verónica",
            "Paula",
        };
        String[] apellidoArray = {
            "Gamaza",
            "Martínez",
            "Setó",
            "Rubio",
            "Amarillo",
            "García",
            "Rodríguez",
            "Fernández",
            "Sánchez",
            "Alonso",
            "Torres",
            "Blanco",
            "Suarez",
        };
        
        nombre += nombreArray[r.nextInt(nombreArray.length)];
        nombre += " " + apellidoArray[r.nextInt(apellidoArray.length)] + " ";
        nombre += apellidoArray[r.nextInt(apellidoArray.length)];
        
        return nombre;
    }
    private boolean minusvaliaRandom(){
        Random r = new Random();
        boolean minusvalido;
        return minusvalido = r.nextBoolean();
    }
    private LocalDate fechaNacRandom(){
        Random r = new Random();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("d/M/yyyy");
        int dia = r.nextInt(31)+1;
        int mes = r.nextInt(11)+1;
        int anno = r.nextInt(2021-1850) + 1850;
        String fecha = String.valueOf(dia)+"/"+String.valueOf(mes)+"/"+String.valueOf(anno);
        LocalDate fechaNac = LocalDate.parse(fecha, formato);
        return fechaNac;
    }
    private Responsabilidad responsabilidadRandom(){
        Random r = new Random();
        return Responsabilidad.values()[r.nextInt(5)];
    }
    private int habitacionRandom(){
        Random r = new Random();
        int nHabitacion = r.nextInt(20)+1;
        return nHabitacion;
    }
    
    public Persona getPersona(int posicion){
        return this.listaPersonas.get(posicion);
    }
    /*Metodo de ayuda*/
    public List<Persona> getPerosnasPorZona(Zona zona){
        List<Persona> listaPersonasZona = new LinkedList<>();
        for(int i=0; i < this.listaPersonas.size(); i++){
            if(this.listaPersonas.get(i).getZona().equals(zona)){
                listaPersonasZona.add(this.listaPersonas.get(i));
            }
        }
        return listaPersonasZona;
    }
    private boolean compDni(String dni){
        boolean repetido = false;
        for(int i=0; i < this.listaPersonas.size(); i++){
            if(this.listaPersonas.get(i).equals(dni)){
                repetido =true;
            }
        }
        return repetido;
    }
    public String toString(){
        String texto = "";
        for(int i = 0; i < this.listaPersonas.size(); i++){
            texto += this.listaPersonas.get(i).toString();
        }
        return texto;
    }
}
