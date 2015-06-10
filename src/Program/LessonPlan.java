package program;

import java.util.ArrayList;

public class LessonPlan {

	String name;
	ArrayList<Lesson> lessons;
	
	public LessonPlan(String name) {
		this.name = name;
		lessons = new ArrayList<Lesson>();
	}
}
