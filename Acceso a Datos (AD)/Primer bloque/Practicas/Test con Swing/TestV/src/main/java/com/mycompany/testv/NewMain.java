/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testv;

import Clases.DAOPreguntas;
import Clases.Pregunta;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Alejandro
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*      Codigo de pruba de una sola pregunta y por terminal
        Scanner sc = new Scanner(System.in);
        String pregunta = "¿Cuanto es 2+2?";
        List<Respuesta> rList = new ArrayList<>();
        rList.add(new Respuesta("1",false));
        rList.add(new Respuesta("3",false));
        rList.add(new Respuesta("4",true));
        rList.add(new Respuesta("5",false));
        
        Pregunta p = new Pregunta(pregunta, rList);
        
        System.out.println(p.toString());
        String sol = sc.next();
        
        List<String> letras = new ArrayList<>();
        letras.add("A");
        letras.add("B");
        letras.add("C");
        letras.add("D");
        int posicion = letras.indexOf(sol);
        
        if(p.esValida(posicion)){
            System.out.println("Acertada");
        }
        else
        {
            System.out.println("Mal");
        }*/
        DAOPreguntas daoPreguntas = new DAOPreguntas();
        List<Pregunta> listaPreguntas = daoPreguntas.getListPreguntas();
        for(int i = 0; i < listaPreguntas.size(); i++){
            System.out.println(listaPreguntas.get(i).toString());
            String sol = sc.next();
            List<String> letras = new ArrayList<>();
            letras.add("A");
            letras.add("B");
            letras.add("C");
            letras.add("D");
            int posicion = letras.indexOf(sol);
        
            if(listaPreguntas.get(i).esValida(posicion)){
                System.out.println("Acertada");
            }
            else
            {
                System.out.println("Mal");
            }
        }
        
    }
    
}
