package program;

import java.util.ArrayList;
import java.util.HashMap;

public class Lesson extends LessonPlan{
	
	private String enhancements;
	private String extensions;
	private String details;
	private String materials;
	private int LeadID;
	private String leadLesson;
	private String assessType;
	private String assessLink;
	private String assessInfo;
	private boolean isAdvanced;
	private Person author;
	private HashMap<String, ArrayList<String>> classCoreLink;
	
	public Lesson() {}
	
	public Lesson(String name, boolean isAdvanced) {
		super(name);
		this.isAdvanced = isAdvanced;
		classCoreLink= new HashMap<String, ArrayList<String>>();
	}

	public String getEnhancements() {
		return enhancements;
	}

	public void setEnhancements(String enhancements) {
		this.enhancements = enhancements;
	}

	public String getExtensions() {
		return extensions;
	}

	public void setExtensions(String extensions) {
		this.extensions = extensions;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getMaterials() {
		return materials;
	}

	public void setMaterials(String materials) {
		this.materials = materials;
	}

	public boolean isAdvanced() {
		return isAdvanced;
	}

	public void setAdvanced(boolean isAdvanced) {
		this.isAdvanced = isAdvanced;
	}

	public HashMap<String, ArrayList<String>> getClassCoreLink() {
		return classCoreLink;
	}

	public void setClassCoreLink(HashMap<String, ArrayList<String>> classCoreLink) {
		this.classCoreLink = classCoreLink;
	}

	public String getLeadLesson() {
		return leadLesson;
	}

	public void setLeadLesson(String leadLesson) {
		this.leadLesson = leadLesson;
	}

	public String getAssessType() {
		return assessType;
	}

	public void setAssessType(String assessType) {
		this.assessType = assessType;
	}

	public String getAssessLink() {
		return assessLink;
	}

	public void setAssessLink(String assessLink) {
		this.assessLink = assessLink;
	}

	public String getAssessInfo() {
		return assessInfo;
	}

	public void setAssessInfo(String assessInfo) {
		this.assessInfo = assessInfo;
	}

	public Person getAuthor() {
		return author;
	}

	public void setAuthor(Person author) {
		this.author = author;
	}

	public int getLeadID() {
		return LeadID;
	}

	public void setLeadID(int leadID) {
		LeadID = leadID;
	}
	
}
