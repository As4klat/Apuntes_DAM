/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package calculadoranb;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alejandro Gamaza
 */
public class CalculadoraTest {
    
    public CalculadoraTest() {
    }

    @Test
    public void testGetSuma() {
        System.out.println("getSuma");
        int a = 5;
        int b = 5;
        Calculadora instance = new Calculadora();
        int expResult = 10;
        int result = instance.getSuma(a, b);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testIncrementar() {
        System.out.println("incrementar");
        int a = 4;
        Calculadora instance = new Calculadora();
        int expResult = 5;
        int result = instance.incrementar(a);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetResta() {
        System.out.println("getResta");
        int a = 10;
        int b = 9;
        Calculadora instance = new Calculadora();
        int expResult = 1;
        int result = instance.getResta(a, b);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testDecrementar() {
        System.out.println("decrementar");
        int a = 6;
        Calculadora instance = new Calculadora();
        int expResult = 5;
        int result = instance.decrementar(a);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    
}
