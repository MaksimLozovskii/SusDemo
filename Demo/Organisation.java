package Demo;

public class Organisation {
	private int organisationID;
	private String organisationName;
	
	public Organisation(String name) {
		this.setName(name);
	}
	public String getName() {
		return this.organisationName;
	}
	public void setName(String newName) {
		this.organisationName = newName;
	}
}
