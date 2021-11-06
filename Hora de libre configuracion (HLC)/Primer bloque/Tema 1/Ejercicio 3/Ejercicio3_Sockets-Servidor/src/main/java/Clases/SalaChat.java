/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class SalaChat {
    private String chat;
    
    public SalaChat(){
        chat = "";
    }
    
    public void add(String msn){
        chat = msn;
    }
    
    public String getChat(){
        return chat;
    }
}
