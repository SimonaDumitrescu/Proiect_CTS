package testing;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utils.Utils;

public class TestUtileFisier {
	
     BufferedReader bf;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	 
	}

	@Before
	public void setUp() throws Exception {
		File f = new File("Valori");
	    bf = new BufferedReader(new FileReader(f));
	}

	@After
	public void tearDown() throws Exception {
		  bf.close();
	}

	@Test
	public void test() throws IOException {
	     
		 String linie = null;
		
		 while ((linie = bf.readLine())!=null){
			 if (linie.startsWith("#"))
				 continue;
			 linie=linie.trim();
			 if (linie.isEmpty())
				 continue;
			 String [] sir = linie.split("\t");
			 if(sir.length<3) continue;
			 double x = Double.parseDouble(sir[0]);
			 int y = Integer.parseInt(sir[1]);
			 double rezultat = Double.parseDouble(sir[2]);
			 
			 System.out.println(rezultat);
		assertEquals(rezultat, Utils.calculeazaValoareComandaFaraTVA(x, y));
			 
		 }
	}

}
