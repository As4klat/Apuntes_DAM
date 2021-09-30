
import Enums.Zona;
import java.util.List;
import java.util.Scanner;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DAOBotes listaBotes = new DAOBotes();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Simulacro de emergencia (nada de lo que ocurra es verdad)");
        System.out.println("Seleciona el numero de Pasajeros (Recuerda que solo hay 40 botes)");
        int nPasajeros = sc.nextInt();
        System.out.println("Seleciona el numero de Tripulantes");
        int nTripulacion = sc.nextInt();
        
        DAOPersonas listaPersonas = new DAOPersonas(nTripulacion,nPasajeros);
        System.out.println("Se ha creado la lista");
        
        System.out.println("¿Deseas empezar ya el simulacro? y/n");
        String respuesta = sc.next();
        
        if(respuesta.equals("y")){
            for (Zona value : Zona.values()) {
                List<Persona> personasPorZona = listaPersonas.getPerosnasPorZona(value);
                List<Bote> botesPorZona = listaBotes.getBotesZona(value);
                while (!personasPorZona.isEmpty() && !botesPorZona.isEmpty()) {
                    while(!botesPorZona.get(0).lleno()){
                        botesPorZona.get(0).subirPersona(personasPorZona.get(0));
                        personasPorZona.remove(0);
                    }
                    botesPorZona.remove(0);
                }
                personasPorZona.clear();
                botesPor
            }
            System.out.println("Todos subido");
        }
        else{
            System.out.print("Por no hacer el simulacro han muerto gente");
        }
    }
}
