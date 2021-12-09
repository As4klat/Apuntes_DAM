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
public class RestaTest {
    
    public RestaTest() {
    }

    @Test
    public void testGetResta() {
        System.out.println("getResta");
        int a = 5;
        int b = 2;
        Resta instance = new Resta();
        int expResult = 3;
        int result = instance.getResta(a, b);
        assertEquals(expResult, result, 0);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testDecrementar() {
        System.out.println("decrementar");
        int a = 5;
        Resta instance = new Resta();
        int expResult = 4;
        int result = instance.decrementar(a);
        assertEquals(expResult, result, 0);
        //fail("The test case is a prototype.");
    }
    
}
