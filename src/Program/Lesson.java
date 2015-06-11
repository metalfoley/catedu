package program;

import java.util.ArrayList;
import java.util.HashMap;

public class Lesson {
	
	private int id;
	private String name;
	private String shortDescription;
	private String fullDescription;
	private String enhancements;
	private String extensions;
	private String details;
	private String materials;	
	private boolean isAdvanced;
	private HashMap<String, ArrayList<String>> classCoreLink;
	
	public Lesson(String name, boolean isAdvanced) {
		this.name = name;
		this.isAdvanced = isAdvanced;
		classCoreLink= new HashMap<String, ArrayList<String>>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HashMap<String, ArrayList<String>> getClassCoreLink() {
		return classCoreLink;
	}

	public void setClassCoreLink(HashMap<String, ArrayList<String>> classCoreLink) {
		this.classCoreLink = classCoreLink;
	}
	
}
