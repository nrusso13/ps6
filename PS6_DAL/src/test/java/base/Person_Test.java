package base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {
	
	
	private static PersonDomainModel p1 = new PersonDomainModel();
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
		
		
		p1.setFirstName("Natalie");
		//p1.setMiddleName("Rose");
		p1.setLastName("Russo");
		p1.setBirthday(new Date(0));
		p1.setCity("Philadelphia");
		p1.setStreet("Stallion Lane");
		p1.setPostalCode(19455);
		
		PersonDAL.addPerson(p1);
		PersonDomainModel p2 = PersonDAL.getPerson(p1.getPersonID());
		assertNotNull(p2);
		
		
		
	}

	
		
	


	@Test
	public void testUpdateDelete(){
		PersonDomainModel p2 = PersonDAL.getPerson(p1.getPersonID());
		assertEquals(p1.getPersonID(), p2.getPersonID());
		//P1 nad p2 should be same
		p2.setLastName("Smith");
		//change something of p2 to test update
		PersonDAL.updatePerson(p2);
		
		PersonDomainModel p3 = PersonDAL.getPerson(p1.getPersonID());
		assertEquals(p2.getLastName(), p3.getLastName()); 
		assertNotEquals(p1.getLastName(),p3.getLastName());
		
		
		PersonDAL.deletePerson(p1.getPersonID());
		
		PersonDomainModel p4 = PersonDAL.getPerson(p1.getPersonID());
		
		assertNull(p4);
		//if deleted it should be null.
		 
		
		
	}
	@Test 
	public void testGetAll(){
		ArrayList<PersonDomainModel> pers = PersonDAL.getPersons();
		assertNotNull(pers);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		PersonDAL.deletePerson(p1.getPersonID());
		//just in case
		
	}
	

}
