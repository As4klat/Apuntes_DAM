package Excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean finalizar = false;
        int opcion;

        while (!finalizar) {
            System.out.println("\n-------------- Menu ------------");
            for (int i = 1; i <= 7; i++) {
                System.out.println(i + ". Ejercicio " + i);
            }
            System.out.println("8. Salir");
            try {
                System.out.println("\nSelecion: ");
                opcion = sc.nextInt();
                System.out.println("");
                switch (opcion) {
                    case 1 -> {
                        try {
                            int numero[] = new int[5];
                            numero[7] = 1;
                        } catch (ArrayIndexOutOfBoundsException ex) {
                            System.out.println("\nError en el tamaño del array."
                                    + "\nSe ha modificado el array: ");
                            int numero[] = new int[5];
                            numero[numero.length - 1] = 1;
                            for (int i = 0; i < numero.length; i++) {
                                if (i != numero.length - 1) {
                                    System.out.print(numero[i] + ", ");
                                } else {
                                    System.out.println(numero[i]);
                                }

                            }
                        }
                        finalizar = preguntarVolver();
                    }
                    case 2 -> {
                        miMetodo();
                        mostrarPreguntas(preguntasYRespuestasEx2());
                        finalizar = preguntarVolver();
                    }
                    case 3 -> {
                        divide();
                        mostrarPreguntas(preguntasYRespuestasEx3());
                        finalizar = preguntarVolver();
                    }
                    case 4 -> {
                        divide2();
                        System.out.println("FIN");
                        finalizar = preguntarVolver();
                    }
                    case 5 -> {
                        int num[] = {4, 8, 16, 32, 64, 128, 256, 512};
                        int den[] = {2, 0, 4, 4, 0, 8};
                        for (int i = 0; i < num.length; i++) {
                            try {
                                System.out.println(num[i] + "/" + den[i] + "=" + num[i] / den[i]);
                            } catch (ArrayIndexOutOfBoundsException excepcion) {
                                System.out.println("Se ha salido del array");
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        }
                        finalizar = preguntarVolver();
                    }
                    case 6 -> {
                        int num[] = {4, 8, 16, 32, 64, 128, 256, 512};
                        int den[] = {2, 0, 4, 4, 0, 8};
                        try {
                            for (int i = 0; i < num.length; i++) {
                                try //try interno
                                {
                                    System.out.println(num[i] + "/" + den[i] + "=" + num[i] / den[i]);
                                } catch (ArithmeticException Excep) {
                                    System.out.println("División por cero " + i);
                                }
                            }
                        } catch (Throwable Excep) {
                            System.out.println("Ocurrio una excepcion fatal ");
                        }
                        System.out.println("El programa continu aqui");
                        finalizar = preguntarVolver();
                    }
                    case 7 -> {
                        
                        finalizar = preguntarVolver();
                    }
                    case 8 -> {
                        finalizar = true;
                        System.out.println("\nFinalizando tarea.");
                    }
                    default ->
                        System.out.println("\nSolo números de 1 a 8.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nDebes insertar números.");
                sc.next();
            }
            try {
                Thread.sleep(0, 75 * 1000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /*
    *    Métodos ayudas
     */
    public static boolean preguntarVolver() {
        Scanner scn = new Scanner(System.in);
        String respuesta;
        boolean finalizar = false;

        System.out.println("\n¿Quieres volver al menu? y/n");
        respuesta = scn.nextLine();
        if (respuesta.equals("y") || respuesta.equals("n")) {
            if (respuesta.equals("n")) {
                finalizar = true;
            }
        } else {
            System.out.println("\nValor introducido erroneo.");
            preguntarVolver();
        }
        return finalizar;
    }

    public static void mostrarPreguntas(String[][] arr) {
        System.out.println("\n-------- Preguntas --------");
        for (int i = 0; i < arr[0].length; i++) {
            System.out.println("\n" + arr[0][i]);
            System.out.println("-> " + arr[1][i]);
        }
        System.out.println("\n----------------------------");
    }

    /*
    *    Métodos Excepciones
     */
    // Excepcion 2
    public static void miMetodo() {
        int numero[] = new int[5];
        try {
            System.out.println("Accesando a una posicion fuera del vector");
            numero[7] = 0;
        } catch (ArrayIndexOutOfBoundsException excep) {
            System.out.println("Ocurrio una excepcion");
        }
    }

    // Excepcion 3
    public static void divide() {
        int num[] = {4, 8, 16, 32, 64, 128, 256};
        int den[] = {2, 0, 4, 4, 0, 8, 16};
        for (int i = 0; i < num.length; i++) {
            try {
                System.out.println(num[i] + "/" + den[i] + "=" + num[i] / den[i]);
            } catch (java.lang.ArithmeticException excepcion) {
                System.out.println("Dividiendo por cero");
            }
        }
    }

    //Exception 4
    public static void divide2() {
        int num[] = {4, 8, 16, 32, 64, 128, 256};
        int den[] = {2, 0, 4, 4, 0, 8};
        for (int i = 0; i < num.length + 1; i++) {
            try {
                System.out.println(num[i] + "/" + den[i] + "=" + num[i] / den[i]);
            } catch (ArithmeticException ex) {
                System.out.println("No se puede dividir entre 0");
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("El valor de array es mayor");
            }
        }
    }

    /*
    *    Métodos de respuestas y preguntas
     */
    public static String[][] preguntasYRespuestasEx2() {
        String[][] arr = {{"¿En que método se genera la excepción?", "¿Que método la captura?", "¿Vuelve el control del programa al main, despúes de la captura?"},
        {"Dentro del try de la clase y metodo miMetodo().", "El metodo de la clase.", "No."}};
        return arr;
    }

    public static String[][] preguntasYRespuestasEx3() {
        String[][] arr = {{"¿Qué ocurre despues de que el programa responda un error?"},
        {"No el programa no se detiene en el momento del error y continua con el resto de operaciones."}};
        return arr;
    }
}
