package testing;

import java.util.ArrayList;
import model.Angajat;
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
import utils.Utils;

public class TestUtileObjects {

    Angajat angajat1 = null;
    Angajat angajat2 = null;
    Angajat angajat3 = null;
    User user1 = null;
    User user2 = null;
    User user3 = null;

    public TestUtileObjects() {
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

        angajat2 = new Angajat();
        angajat2.setCnp("1234546565678");
        angajat2.setFunctie("Operator PC");
        angajat2.setNume("Mircea");
        angajat2.setPrenume("Andrei");

        angajat3 = new Angajat();
        angajat3.setCnp("1234546565678");
        angajat3.setFunctie("Operator PC");
        angajat3.setNume("Mircea");
        angajat3.setPrenume("Andrei");

        user1 = new User("admin", "admin");
        user2 = new User("admin", "admin");
        user3 = new User("admin", "parolaIncorecta");

    }

    @After
    public void tearDown() {
        angajat1 = null;
        angajat2 = null;
        angajat3 = null;
        user1 = null;
        user2 = null;
        user3 = null;
    }

    @Test
    public void test_angajatiDiferiti_corect() {
        assertNotSame(angajat1, angajat2);
    }

    @Test
    public void test_angajatiAcelasiAngajat_corect() {
        assertEquals(angajat2, angajat3);
    }

    @Test
    public void test_aceeasiFunctie_corect() {
        assertSame(angajat1.getFunctie(), angajat2.getFunctie());
    }

    @Test
    public void test_creareListaAngajati_corect() {
        Utils obiect = new Utils();
        ArrayList<Angajat> angajati = obiect.creareListaAngajati(angajat1, angajat2);
        assertNotNull(angajati);
    }

    @Test
    public void test_creareListaVidaAngajati_corect() {
        Utils obiect = new Utils();
        angajat1.setCnp("");
        angajat2.setCnp("");
        ArrayList<Angajat> angajati = obiect.creareListaAngajati(angajat1, angajat2);
        assertNull(angajati);
    }
    
     @Test
    public void test_useriDiferiti_corect() {
        assertNotSame(user1, user3);
    }

    @Test
    public void test_useriIdentici_corect() {
      
        assertEquals(user1, user2); 
    }

    @Test
    public void test_acelasiUsername_corect() {
        assertSame(user1.getFunctie(), user2.getFunctie());
    }
    
     @Test
    public void test_UseriNotNull_corect() {
            
        assertTrue( (user1 != null) && (user2 != null) && (user3 != null) );
    }
    
     @Test
    public void test_angajatiNotNull_corect() {
        
       assertTrue( (angajat1 != null) && (angajat2 != null) && (angajat3 != null) );
    }
    
    

}
