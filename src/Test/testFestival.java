package Test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Modele.Date;
import Modele.ExceptionDate;
import Modele.Festival;
/**
 * Classe de test JUnit qui test le méthode toStringReservation et nombreDePlacesTotal
 * @author Benjamin, Loïc
 *
 */
public class testFestival {

	@Test
	public void testToStringReservation() throws ExceptionDate {
		//Test 1 
		Date date1 = new Date(1,7,2015);
		Date date2 = new Date(1,7,2015);
		Festival festival = new Festival("test", "test", date1, date2, "test", 50, "test", 50);
		assertTrue("To string Faux",festival.toStringReservation().equals("le Festival test \nAura lieu à test \nLe 1 Juillet"));
		//Test 2 
		date1 = new Date(1,8,2015);
		date2 = new Date(1,8,2015);
		festival = new Festival("test", "test", date1, date2, "test", 50, "test", 50);
		assertTrue("To string Faux",festival.toStringReservation().equals("le Festival test \nAura lieu à test \nLe 1 Août"));
		//Test 3
		date1 = new Date(12,7,2015);
		date2 = new Date(15,8,2015);
		festival = new Festival("test", "test", date1, date2, "test", 50, "test", 50);
		//System.out.println(festival.toStringReservation());
		assertTrue("To string Faux",festival.toStringReservation().equals("le Festival test \nAura lieu à \ntest \nDu 12 Juillet au 15 Août"));
		//Test 4
		date1 = new Date(1,7,2015);
		date2 = new Date(19,7,2015);
		festival = new Festival("test", "test", date1, date2, "test", 50, "test", 50);
		assertTrue("To string Faux",festival.toStringReservation().equals("le Festival test \nAura lieu à test \nDu 1 au 19 Juillet"));
		//Test 5
		date1 = new Date(2,8,2015);
		date2 = new Date(15,8,2015);
		festival = new Festival("test", "test", date1, date2, "test", 50, "test", 50);
		assertTrue("To string Faux",festival.toStringReservation().equals("le Festival test \nAura lieu à test \nDu 2 au 15 Août"));
	}
	@Test
	public void testnombreDePlaceTotal() throws ExceptionDate{
		//Test 1
		Date date1 = new Date(1,7,2015);
		Date date2 = new Date(2,7,2015);
		Festival festival = new Festival("test", "test", date1, date2, "test", 10, "test", 50);
		assertTrue("Nombre de place ne correspond pas",festival.nombreDePlaceTotal()==20);
		//Test 2 
		date1 = new Date(1,7,2015);
		date2 = new Date(2,7,2015);
		festival = new Festival("test", "test", date1, date2, "test", 0, "test", 50);
		assertTrue("Nombre de place ne correspond pas",festival.nombreDePlaceTotal()==0);
		//Test 3
		date1 = new Date(1,7,2015);
		festival = new Festival("test", "test", date1, date1, "test", 10, "test", 50);
		assertTrue("Nombre de place ne correspond pas",festival.nombreDePlaceTotal()==10);
		//Test 4
		date1 = new Date(1,7,2015);
		festival = new Festival("test", "test", date1, date1, "test", 0, "test", 50);
		assertTrue("Nombre de place ne correspond pas",festival.nombreDePlaceTotal()==0);
	}
}
