package testing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.Utils;


public class TestUtileOperations {

    public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    Date dataCurenta = null;
    Date data = null;
    String dataString = null;

    public TestUtileOperations() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        dataCurenta = Calendar.getInstance().getTime();
        dataString = "10/03/2015";
        try {
            data = DATE_FORMAT.parse(dataString);
        } catch (ParseException ex) {
            System.out.println("Parsare data esuata!");
        }

    }

    @After
    public void tearDown() {
        dataCurenta = null;
        dataString = "";
        data = null;
    }

    @Test
    public void test_getDayFromDate_corect() {
        int rezultat = Utils.getDayFromDate(dataString);
        assertEquals(10, rezultat);
    }

    @Test
    public void test_getMonthFromDate_corect() {
        int rezultat = Utils.getMonthFromDate(dataString);
        assertEquals(3, rezultat);
    }
    
     @Test
    public void test_getMonthFromDate_incorect() {
        int rezultat = Utils.getMonthFromDate(dataString);
        assertNotSame(10, rezultat);
    }

    @Test
    public void test_getYearFromDate_corect() {
        int rezultat = Utils.getYearFromDate(dataString);
        assertEquals(2015, rezultat);
    }

    @Test
    public void test_addDaysToDate_corect() {
        Date rezultat = Utils.addDaysToDate(data, 5);
        Date dataCorecta = null;
        Date rezultatFormatat = null;
        try {
            dataCorecta = DATE_FORMAT.parse("15/03/2015");
            String rezultatFormatatString = DATE_FORMAT.format(rezultat);
            rezultatFormatat = DATE_FORMAT.parse(rezultatFormatatString);
        } catch (ParseException ex) {
            System.out.println("Parsare data esuata!");
        }
        assertEquals(dataCorecta, rezultatFormatat);
    }

    @Test
    public void test_addMonthsToDate_corect() {
        Date rezultat = Utils.addMonthsToDate(data, 1);
        Calendar c = Calendar.getInstance();
        Date dataCorecta = null;

        try {
            dataCorecta = DATE_FORMAT.parse("10/04/2015");
        } catch (ParseException ex) {
            System.out.println("Parsare data esuata!");
        }
        c.setTime(dataCorecta);
        assertEquals(c.getTime(), rezultat);
    }

    @Test
    public void test_addYearsToDate_corect() {
        Date rezultat = Utils.addYearsToDate(data, 2);
        Calendar c = Calendar.getInstance();
        Date dataCorecta = null;

        try {
            dataCorecta = DATE_FORMAT.parse("10/03/2017");
        } catch (ParseException ex) {
            System.out.println("Parsare data esuata!");
        }
        c.setTime(dataCorecta);
        assertEquals(c.getTime(), rezultat);
    }

    @Test
    public void test_calculeazaValoareFaraTVA_corect() {
        double rezultat = Utils.calculeazaValoareComandaFaraTVA(150, 100);
        assertEquals(15000, rezultat, 0);
    }

    @Test
    public void test_calculeazaValoareTVA_corect() {
        double rezultat = Utils.calculeazaValoareComandaCuTVA(15089);
        assertEquals(18710.36, rezultat, 0);
    }  
    
     
    
}
