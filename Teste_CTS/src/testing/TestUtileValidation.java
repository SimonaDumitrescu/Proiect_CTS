package testing;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import utils.Utils;


public class TestUtileValidation extends TestCase {

    String code = null;

    public TestUtileValidation() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        code = "090909";
    }

    @After
    public void tearDown() {
        code = null;
    }

   

   
    @Test
    public void test_cnpFormatDinCifre_corect() {
        boolean rezultat = Utils.validateCnpOnlyDigits("1234565676765");
        assertTrue(rezultat);
    }

    @Test
    public void test_cnpPrimaCifra1sau2_corect() {
        boolean rezultat = Utils.validateCnpFirstDigit("1234565676765");
        assertTrue(rezultat);
    }

    @Test
    public void test_cnpPrimaCifra1sau2_incorect() {
        boolean rezultat = Utils.validateCnpFirstDigit("5234565676765");
        assertFalse(rezultat);
    }

  

    @Test
    public void test_formatData_corect() {
        boolean rezultat = Utils.validateDate("31/12/2014");
        assertTrue(rezultat);
    }

    @Test
    public void test_formatDataZiInInterval_corect() {
        boolean rezultat = Utils.validateDateFormatDay("31/12/2014");
        assertTrue(rezultat);
    }

    @Test
    public void test_formatDataLunaInInterval_corect() {
        boolean rezultat = Utils.validateDateFormatMonth("31/12/2014");
        assertTrue(rezultat);
    }

    @Test
    public void test_formatDataAnInInterval_corect() {
        boolean rezultat = Utils.validateDateFormatYear("31/12/2014");
        assertTrue(rezultat);
    }

    @Test
    public void test_formatDataZiLunaAn_corect() {
        boolean rezultat = Utils.validateDateDayMonthYear("31/12/2014");
        assertTrue(rezultat);
    }

  
    @Test
    public void test_nrTelefon10Cifre_corect() {
        boolean rezultat = Utils.validateNrCharactersPhone("0789564534");
        assertTrue(rezultat);
    }

   
    @Test
    public void test_convertStringToInt_incorect() {
        boolean rezultat = Utils.validateConvertStringToInt("14df");
        assertFalse(rezultat);
    }

    
    @Test
    public void test_convertStringToDouble_corect() {
        boolean rezultat = Utils.validateConvertStringToDouble("14.98");
        assertTrue(rezultat);
    }

  
    @Test
    public void test_convertStringToLong_corect() {
        boolean rezultat = Utils.validateConvertStringToInt("147576567");
        assertTrue(rezultat);
    }

   
    @Test
    public void test_convertStringToIntFail() {
        String text = null;
        int rezultat = 0;
        try {
            rezultat = Utils.convertireIntegerCuExceptie(text);
            fail("Trebuia sa fie exceptie!");
        } catch (Exception i) {
            System.out.println(rezultat);
        }
    }
    
    public static void main(String []args){
    	TestSuite ts = new TestSuite();
    	ts.addTest(new TestUtileValidation("test_formatData_corect"));
    	ts.addTest(new TestUtileValidation("test_nrTelefon10Cifre_corect"));
    	TestRunner.run(ts);
    	
    }
     public TestUtileValidation(String nume){
    	 super(nume);
     }

}
