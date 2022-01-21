package com.example.calculadora;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Calculadora {
    private static List<String> listaCadena;

    public static String calcular(String cadena){
        String resultado = "";
        listaCadena = new ArrayList<>();
        sacaNumeros(cadena);
        boolean estoyOperando = true;
        boolean multiOdivi = false;
        int cont = 0;
        while (estoyOperando){
            String caracter = "";
            if(cadena.contains("x") || cadena.contains("/")){

                for(int i = 0; i < listaCadena.size();i++){
                    if(listaCadena.get(i).equals("x") || listaCadena.get(i).equals("/")){
                        cont = i;
                        multiOdivi = true;
                        if(listaCadena.get(i).equals("x")){
                            caracter = "x";
                        }
                        else {
                            caracter = "/";
                        }
                        i=listaCadena.size();
                    }
                }

            }
            else{
                    if(!listaCadena.get(cont).matches("\\d+?")){
                        caracter = listaCadena.get(cont);
                    }
            }
            String sol = "";
            switch (caracter){
                case "+":
                    sol = sumar(listaCadena.get(cont-1),listaCadena.get(cont+1));

                    break;
                case "-":
                    sol = restar(listaCadena.get(cont-1),listaCadena.get(cont+1));
                    break;
                case "x":
                    sol = multiplicar(listaCadena.get(cont-1),listaCadena.get(cont+1));
                    break;
                case "/":
                    sol = dividr(listaCadena.get(cont-1),listaCadena.get(cont+1));
                    break;
                default:
            }
            if(!sol.equals("")){
                cadena = "";
                for(int i  = 0; i < listaCadena.size(); i++){
                    if(i != cont-1){
                        cadena += listaCadena.get(i);
                    }
                    else {
                        listaCadena.remove(i);
                        listaCadena.remove(i);
                        listaCadena.remove(i);
                        listaCadena.add(i,sol);
                        cont=0;
                        cadena += sol;
                    }
                }
            }

            if(cadena.matches("^-?[0-9]+([.][0-9]+)?$")) {
                estoyOperando=false;
                resultado = cadena;
            }
            if(multiOdivi){
                multiOdivi=false;
            }else {
                cont++;
            }

        }
        return resultado;
    };

    private static String sumar(String n1, String n2){
        return formatDecimal((Double.valueOf(n1) + Double.valueOf(n2)));
    }
    private static String restar(String n1, String n2){
        return formatDecimal((Double.valueOf(n1) - Double.valueOf(n2)));
    }
    private static String dividr(String n1, String n2){
        return formatDecimal((Double.valueOf(n1) / Double.valueOf(n2)));
    }
    private static String multiplicar(String n1, String n2){
        return formatDecimal((Double.valueOf(n1) * Double.valueOf(n2)));
    }
    private static void porciento(){

    }

    private static String formatDecimal(double num){
        String numString;
        if(num%1==0){
            DecimalFormat d =new DecimalFormat("#.#");
            numString = d.format(num);
        }
        else {
            DecimalFormat d =new DecimalFormat("#.##");
            numString = d.format(num);
        }
        return numString;
    }

    private static void sacaNumeros(String cadena){
        

        String[] arr = cadena.split("");
        int j = 0;
        for(int i = 0; i < arr.length;i++){
            if(arr[i].matches("\\d")){
                if(listaCadena.isEmpty()){
                    listaCadena.add(arr[i]);
                }
                else
                {
                    if(!arr[i-1].matches("-?\\d")){
                        listaCadena.add(arr[i]);
                    }
                    else
                    {
                        listaCadena.set(j,listaCadena.get(j) + arr[i]);
                    }

                }
            }
            else
            {
                listaCadena.add(arr[i]);
                j=j+2;
            }
        }
    }

}
