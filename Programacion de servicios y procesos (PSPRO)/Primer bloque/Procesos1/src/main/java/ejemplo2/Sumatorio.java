package ejemplo2;

/**
 *
 * @author Alejandro
 */

public class Sumatorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.exit(sumatorio(Integer.parseInt( args[0] ),Integer.parseInt( args[1] )));
    }
    
    public static int sumatorio(int num1, int num2){
        int suma=0;
        for(int cont = num1; cont <= num2; cont++){
            suma = suma + cont;
        }
        return suma;
    }
}
