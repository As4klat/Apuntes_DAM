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
    private List<String> chat;
    
    public SalaChat(){
        chat = new LinkedList<>();
    }
    
    public void add(String msn){
        chat.add(msn);
    }
    
    public synchronized String getList(){
        
        String salaChat = "";
        
        for(int i = 0; i < chat.size(); i++){
            salaChat += chat.get(i) + ",";
        }
        return salaChat;
    }
}
