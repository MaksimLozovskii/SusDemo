package Demo;

public class Square {
	private String location;
	private double totalPoints;
	private int numberOfLevels;
	private ProblemAreas mainIssueArea; 

	Square(String location, int totalPoints,  int numberOfLevels, ProblemAreas mainIssueArea) {	
		this.location = location;
		this.totalPoints = totalPoints;
		this.numberOfLevels = numberOfLevels;
		this.mainIssueArea = mainIssueArea;
	}
	
	String getLocation() {
		return this.location;
	}
	
	double getTotalPoints() {
		return this.totalPoints;
	}
	
	int getNumberOfLevels() {
		return this.numberOfLevels;
	}
	
	ProblemAreas getIssueArea() {
		return this.mainIssueArea;
	}
}
