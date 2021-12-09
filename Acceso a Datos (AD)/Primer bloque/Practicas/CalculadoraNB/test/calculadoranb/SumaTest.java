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
public class SumaTest {
    
    public SumaTest() {
    }

    @Test
    public void testGetSuma() {
        System.out.println("getSuma");
        int a = 1;
        int b = 2;
        Suma instance = new Suma();
        int expResult = 3;
        int result = instance.getSuma(a, b);
        assertEquals(expResult, result, 0);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testIncrementar() {
        System.out.println("incrementar");
        int a = 1;
        Suma instance = new Suma();
        int expResult = 2;
        int result = instance.incrementar(a);
        assertEquals(expResult, result, 0);
        //fail("The test case is a prototype.");
    }
    
}
