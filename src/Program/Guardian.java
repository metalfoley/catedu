package program;

public class Guardian extends Person {
	
	String relationship;
	int guardianID;
	
	public Guardian() {}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public int getGuardianID() {
		return guardianID;
	}

	public void setGuardianID(int guardianID) {
		this.guardianID = guardianID;
	}
	
}
