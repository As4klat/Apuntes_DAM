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
        System.out.println(sumatorio(2,4));
    }
    
    public static int sumatorio(int num1, int num2){
        int suma=0;
        for(int cont = num1; cont <= num2; cont++){
            suma = suma + cont;
        }
        return suma;
    }
}
