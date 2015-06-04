package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Modele.Date;
import Modele.ExceptionDate;
/**
 * Classe de test JUnit qui test la methode intervalleFestival
 * @author Benjamin, Loïc
 *
 */
public class testDate {

	@Test
	public void testIntervalleFestival() throws ExceptionDate {
		// Test 1 : 1 Juillet
		Date date1 = new Date(1,7,2015);
		Date date2 = new Date(1,7,2015);
		Date[] dateTab = date1.intervalleFestival(date2);
		Date[] dateTabTest ={date1};
		assertTrue("Date Differente",dateTab[0].precede(dateTabTest[0])==0&& dateTab.length==dateTabTest.length);
		
		// Test 2 : 2 Juillet - 1 Juillet
		date1 = new Date(2,7,2015);
		date2 = new Date (1,7,2015);
		dateTab = date1.intervalleFestival(date2);
		assertTrue("Date Differente",dateTab == null);
		
		// Test 3 31 Juillet - 1 Août 
		date1 = new Date(31,7,2015);
		date2 = new Date (1,8,2015);
		dateTab = date1.intervalleFestival(date2);
		Date[] dateTabTest2 ={date1,date2};
		assertTrue("Date Differente",dateTab[0].precede(dateTabTest2[0])==0&&dateTab[1].precede(dateTabTest2[1])==0&&dateTab.length==dateTabTest2.length);
		
		//Test 4 1 Août - 31 Juillet
		date1 = new Date(1,8,2015);
		date2 = new Date (31,7,2015);
		dateTab = date1.intervalleFestival(date2);
		assertTrue("Date Differente",dateTab == null);
		
		//Test 5 1 Août - 2 Août 
		date1 = new Date(1,8,2015);
		date2 = new Date (2,8,2015);
		dateTab = date1.intervalleFestival(date2);
		Date[] dateTabTest3 ={date1,date2};
		assertTrue("Date Differente",dateTab[0].precede(dateTabTest3[0])==0&&dateTab[1].precede(dateTabTest3[1])==0&&dateTab.length==dateTabTest3.length);
		
		// Test 6 2 Août - 1 Août
		date1 = new Date(2,8,2015);
		date2 = new Date (1,8,2015);
		dateTab = date1.intervalleFestival(date2);
		assertTrue("Date Differente",dateTab == null);
	
	
	}

}
