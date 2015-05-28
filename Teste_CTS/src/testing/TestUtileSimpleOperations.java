package testing;

import model.Echipament;

import org.junit.After;
import org.junit.AfterClass;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utils.Utils;


public class TestUtileSimpleOperations {

    public TestUtileSimpleOperations() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test_suma_corecta() {
        Utils obiect = new Utils();
        double rezultat = obiect.suma(10, 5);
        assertEquals(15, rezultat, 0);
    }

    @Test
    public void test_diferenta_corecta() {
        Utils obiect = new Utils();
        double rezultat = obiect.diferenta(10, 5);
        assertEquals(5, rezultat, 0);
    }

    @Test
    public void test_inmultire_corecta() {
        Utils obiect = new Utils();
        double rezultat = obiect.inmultire(10, 5);
        assertEquals(50, rezultat, 0);
    }
       
    @Test
    public void test_impartire_corecta() {
        Utils obiect = new Utils();
        double rezultat = obiect.impartire(10, 5);
        assertEquals(2, rezultat, 0);
    }

    @Test
    public void test_impartire_incorecta() {
        Utils obiect = new Utils();
        double rezultat = 0;

        try {
            rezultat = obiect.impartire(10, 0);
            System.out.println(rezultat);
            fail("Trebuia sa fie exceptie!");
        } catch (Exception i) {
            System.out.println(rezultat);
        }
    }
    
    @Test
    public void test_estePar() {
        Utils obiect = new Utils();
        boolean rezultat = obiect.estePar(10);
        assertTrue(rezultat);
    }
    
    @Test
    public void test_nuEstePar() {
        Utils obiect = new Utils();
        boolean rezultat = obiect.estePar(99);
        assertFalse(rezultat);
    }

   
    
    
}
