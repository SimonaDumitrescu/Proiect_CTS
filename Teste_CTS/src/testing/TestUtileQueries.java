package testing;

import java.util.ArrayList;
import model.Angajat;
import model.Echipament;
import model.PersoanaFizica;
import model.PersoanaJuridica;
import model.User;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import server.MainController;
import utils.QueryDatabase;


public class TestUtileQueries {

    Angajat angajat1 = null;

    public TestUtileQueries() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        angajat1 = new Angajat();
        angajat1.setCnp("2134567898765");
        angajat1.setFunctie("Operator PC");
        angajat1.setNume("Dumitrescu");
        angajat1.setPrenume("Simona");
    }

    @After
    public void tearDown() {
    	
    }

    @Test
    public void test_getNextIdPersoanaFizica_corect() {
        int nextId = QueryDatabase.getIdPersoanaFizica();
        assertTrue(nextId > 0);
    }

    @Test
    public void test_loadUsers_corect() {
        ArrayList<User> lista = QueryDatabase.loadUsers();
        assertTrue(lista.size() > 0);
    }

    @Test
    public void test_loadAngajati_corect() {
        ArrayList<Angajat> angajati = MainController.getInstance().getAngajat();
        assertNotNull(angajati);
    }

    @Test
    public void test_loadAngajatById_corect() {
        Angajat angajat = MainController.getInstance().getAngajatById(1);
        assertNotNull(angajat);
    }

    @Test
    public void test_insertAngajat_corect() {
        ArrayList<Angajat> angajatiBeforeInsert = MainController.getInstance().getAngajat();
        MainController.getInstance().adaugaAngajat(angajat1.getNume(), angajat1.getPrenume(), angajat1.getCnp(), angajat1.getFunctie());
        ArrayList<Angajat> angajatiAfterInsert = MainController.getInstance().getAngajat();
        assertTrue(angajatiBeforeInsert.size() < angajatiAfterInsert.size());
    }
    
  
    @Test
    public void test_verificaFunctieUtilizator_corect() {
        boolean rezultat = QueryDatabase.verificaFunctieUtilizator(4);
        assertTrue(rezultat);

    }

    @Test
    public void test_verificaStocCurentEchipamente_corect() {
        //Stocul curent al echipamentelor trebuie sa fie mai mare ca 0, pentru a fi adaugate in lista.
        //Prin acest test se verifica daca se face in mod corect selectarea echipamentelor din baza de date.
        ArrayList<Echipament> lista = QueryDatabase.loadStocEchipamente();
        boolean stocCorect = true;
        for (Echipament e : lista) {
            if (e.getStocCurent() <= 0) {
                stocCorect = false;
                break;
            }
        }
        assertTrue(stocCorect);
    }

    @Test
    public void test_insertUser_incorect() {
        //nu se poate insera un user cu un username existent
        ArrayList<User> usersBeforeInsert = MainController.getInstance().getUsers();
        MainController.getInstance().inregistrare("simona", "1"); //username existent
        ArrayList<User> usersAfterInsert = MainController.getInstance().getUsers();
        assertSame(usersBeforeInsert.size(), usersAfterInsert.size());
    }

    @Test
    public void test_conectare_corect() {
        User user = MainController.getInstance().conectare("simona", "1234"); //user existent
        assertNotNull(user);
    }

    @Test
    public void test_conectare_incorect() {
        User user = MainController.getInstance().conectare("simona", "1"); //username corect, parola incorecta
        assertNull(user);
    }

    @Test
    public void test_loadClienti_corect() {
        ArrayList<PersoanaFizica> listaPF = MainController.getInstance().getPF();
        ArrayList<PersoanaJuridica> listaPJ = MainController.getInstance().getPJ();
        assertTrue(listaPF.size() > 0 && listaPJ.size() > 0);
    }

    @Test
    public void test_getPFById_incorect() {
        PersoanaFizica pf = MainController.getInstance().getPFById(700);
        //Persoana fizica cu acest id nu exista in baza de date
        assertNull(pf);
    }

    @Test
    public void test_getPJById_corect() {
        PersoanaJuridica pj = MainController.getInstance().getPJById(1);
        //Persoana Juridica cu acest id exista in baza de date
        assertNotNull(pj);
    }

    @Test
    public void test_getEchipamentById_corect() {
        Echipament echipamentActual = MainController.getInstance().getEchipamentById(1);
        Echipament echipamentExpected = new Echipament(1, "Antena Parabolica", 100, 300);
        assertEquals(echipamentActual, echipamentExpected);
    }

    @Test
    public void test_getEchipamentById_incorect() {
        Echipament echipamentActual = MainController.getInstance().getEchipamentById(1);
        Echipament echipamentExpected = new Echipament(1, "Antena Parabolica", 500, 300);
        assertNotSame(echipamentActual, echipamentExpected);
    }

}
