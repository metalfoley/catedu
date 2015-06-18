package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import program.Lesson;
import dao.DaoLesson;

public class LessonTest {
	DaoLesson dl;
	Lesson lesson;

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
	public void testCreateLessonPos() {
		dl = new DaoLesson();
		lesson = dl.createLesson(2);
		assertEquals(lesson.getName(), "Memoir Techniques");
	}
	
	@Test
	public void testCreateLessonNeg(){
		dl = new DaoLesson();
		lesson = dl.createLesson(1);
		assertNotEquals(lesson.getName(), "Memoir Techniques");
	}

}
