/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class ChatSala {
    List<String> chat;

    public ChatSala() {
        chat = new ArrayList<>();
    }
    
    synchronized List<String> leerChat(){
        return chat;
    }
    
    synchronized void escribir(String texto){
        chat.add(texto);
    }
}
