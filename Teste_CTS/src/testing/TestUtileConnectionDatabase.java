package testing;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utils.UtilsDatabase;


public class TestUtileConnectionDatabase {

    public TestUtileConnectionDatabase() {
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
    public void test_conectareDatabase_corect() {
        UtilsDatabase db = new UtilsDatabase();
        boolean conectare = db.ConectareDB();
        assertTrue(conectare);
    }

}
