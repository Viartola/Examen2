
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

import java.util.Date;
import java.math.BigDecimal;
 

public class ATestJUnit {  
	private A a;
	
	@Before
	public void setUp() throws Exception {
		a = new A();
		
	}
  
    @Test  
    public void TestdateGreaterThanAWeek() { 
    	Date fechaUno = new Date(0,4,1);
    	assertEquals(a.dateGreaterThanAWeek(fechaUno), true);
    	Date fechaDos = new Date(16,5,1);
    	assertEquals(a.dateGreaterThanAWeek(fechaDos), true);
    	Date fechaTres = new Date(2016,25,1);
    	assertEquals(a.dateGreaterThanAWeek(fechaTres), false);
    	try {
    		a.dateGreaterThanAWeek(null);
			Assert.fail("Nunca se deberia ejecutar este codigo");
		} catch (Exception e) {}
    } 
    
    @Test  
    public void TestdateBigIsGreaterThanSmall() { 
    	Date fechaUno = new Date(2016,04,20);
    	Date fechaDos = new Date(2016,05,26);
    	assertEquals(a.dateBigIsGreaterThanSmall(fechaUno, fechaDos), true);
    	try {
	    	Date fechaTres = new Date(2016,05,25);
	    	Date fechaCuatro = new Date(2016,04,26);
	    	a.dateBigIsGreaterThanSmall(fechaTres, fechaCuatro);
	    	Assert.fail("Nunca se deberia ejecutar este codigo");
    	} catch (Exception e) {}	
    }  
    
    @Test  
    public void TestvalueIsDivisibleByNumber() { 
    	BigDecimal Uno = new BigDecimal(4);
    	BigDecimal Dos = new BigDecimal(2);
    	BigDecimal resultado1 = new BigDecimal(0);
    	assertEquals(a.valueIsDivisibleByNumber(Uno, Dos), resultado1);
    	BigDecimal Tres = new BigDecimal(16);
    	BigDecimal Cuatro = new BigDecimal(8);
    	BigDecimal resultado2 = new BigDecimal(0);
    	assertEquals(a.valueIsDivisibleByNumber(Tres, Cuatro), resultado2);
    	BigDecimal Cinco = new BigDecimal(25);
    	BigDecimal Seis = new BigDecimal(3);
    	BigDecimal resultado3 = new BigDecimal(1);
    	assertEquals(a.valueIsDivisibleByNumber(Cinco, Seis), resultado3);
    }  
}  