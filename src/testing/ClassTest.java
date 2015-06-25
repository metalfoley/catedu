package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import program.Subject;
import dao.DaoClass;

public class ClassTest {
	ArrayList<Subject> classes = DaoClass.getClasses();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetClassesPos() {
		assertEquals(classes.get(0).getName(), "Science");
		assertEquals(classes.get(0).getId(), 1);
		assertEquals(classes.get(1).getName(), "Math");
		assertEquals(classes.get(1).getId(), 2);
		assertEquals(classes.get(2).getName(), "History");
		assertEquals(classes.get(2).getId(), 3);
	}
	
	@Test
	public void testGetClassesNeg() {
		assertNotEquals(classes.get(0).getName(), "Math");
		assertNotEquals(classes.get(0).getId(), 2);
		assertNotEquals(classes.get(1).getName(), "History");
		assertNotEquals(classes.get(1).getId(), 3);
		assertNotEquals(classes.get(2).getName(), "Science");
		assertNotEquals(classes.get(2).getId(), 1);
	}

}
