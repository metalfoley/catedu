package program;

import java.util.ArrayList;

public class LessonPlan {

	protected int id;
	protected String name;
	protected String shortDescription;
	protected String fullDescription;
	private ArrayList<Lesson> lessons = new ArrayList<Lesson>();
	private int subjectId;
	
	public LessonPlan() {}
	
	protected LessonPlan(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(ArrayList<Lesson> lessons) {
		this.lessons = lessons;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getFullDescription() {
		return fullDescription;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subject) {
		this.subjectId = subject;
	}
	
}
