package base;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import domain.PersonDomainModel;
import domain.StudentDomainModel;
import util.HibernateUtil;
public class PersonTest {

	static PersonDomainModel sampleperson = new PersonDomainModel();	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sampleperson.setFirstName("Sean");
		sampleperson.setLastName("Connery");
		sampleperson.setCity("London");
		sampleperson.setPostalCode(00700);
		sampleperson.setStreet("MI6");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		PersonDAL.deletePerson(sampleperson);
		assertNull("Removing from the Database per instructions!",sampleperson);
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void AddPersontest(){
		PersonDAL.addPerson(sampleperson);
	}
	@Test
	public void UpdatePerson(){
		sampleperson.setFirstName("James");
		PersonDAL.updatePerson(sampleperson);
	}
}
