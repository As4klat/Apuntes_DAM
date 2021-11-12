/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

/**
 *
 * @author Alejandro
 */
public class LimitePiscinaExcedidoException extends Exception{
    public LimitePiscinaExcedidoException(){
        super("Cantidad de litros introducido esta por encima de lo permitido por la piscina.");
    }
}
