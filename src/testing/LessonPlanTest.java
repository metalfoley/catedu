package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import program.LessonPlan;
import dao.DaoLessonPlan;

public class LessonPlanTest {
	ArrayList<LessonPlan> lessonPlans;
	LessonPlan lp;

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
	public void testCreateLessonPlanPos() {
		lp = DaoLessonPlan.createLessonPlanFull(6);
		assertEquals(lp.getName(), "Lesson Plan 3");
		assertEquals(lp.getLessons().size(), 3);
	}
	
	@Test
	public void testCreatLessonPlanNeg() {
		lp = DaoLessonPlan.createLessonPlanFull(6);
		assertNotEquals(lp.getName(), "Lesson Plan 2");
		assertNotEquals(lp.getLessons().size(), 2);
	}

}
