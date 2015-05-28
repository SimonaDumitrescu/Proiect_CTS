package testing;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({testing.TestUtileQueries.class, testing.TestUtileSimpleOperations.class, testing.TestUtileObjects.class, testing.TestUtileValidation.class, testing.TestUtileOperations.class, testing.TestUtileConnectionDatabase.class,testing.TestUtileFisier.class})
public class AllTests {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
