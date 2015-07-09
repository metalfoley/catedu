package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import program.Student;
import program.Teacher;

public class TeacherTest {
	Teacher t;
	Student s1 = new Student();
	Student s2 = new Student();

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
	public void testAddStudentsPos() {
		t = new Teacher(0, null, null, null, null, null, null, null, null, null, null, false);
		t.addStudent(s1);
		t.addStudent(s2);
		int len = t.getStudents().size();
		assertEquals(2,len);
	}
	
	@Test
	public void testAddStudentsNeg() {
		t = new Teacher(0, null, null, null, null, null, null, null, null, null, null, false);
		t.addStudent(s1);
		t.addStudent(s2);
		int len = t.getStudents().size();
		assertNotEquals(1,len);
	}
	
	@Test
	public void testRemoveStudentsPos() {
		t = new Teacher(0, null, null, null, null, null, null, null, null, null, null, false);
		s1 = new Student();
		s2 = new Student();
		t.addStudent(s1);
		t.addStudent(s2);
		t.removeStudent(s1);
		t.removeStudent(s2);
		int len = t.getStudents().size();
		assertEquals(0,len);
	}
	
	@Test
	public void testRemoveStudentsNeg() {
		t = new Teacher(0, null, null, null, null, null, null, null, null, null, null, false);
		t.addStudent(s1);
		t.addStudent(s2);
		t.removeStudent(s1);
		t.removeStudent(s2);
		int len = t.getStudents().size();
		assertNotEquals(1,len);
	}

}
