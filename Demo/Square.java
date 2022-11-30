package Demo;

import java.util.ArrayList;

public class Square {
	private static int squareCount = 1;
	
	private int squareID;
	private String location;
	private double totalPoints;
	private ProblemAreas mainIssueArea; 
	private boolean isOwned;
	private String squareOwnerName;
	private ArrayList<Task> squareTaskList;
	private SquareType squareType;

	Square(String location, int totalPoints, ProblemAreas mainIssueArea, ArrayList<Task> squareTaskList, SquareType squareType) {
		this.squareOwnerName = "Noone";
		this.isOwned = false;
		this.location = location;
		this.totalPoints = totalPoints;
		this.mainIssueArea = mainIssueArea;
		this.squareTaskList = squareTaskList;
		this.squareType = squareType;
		
		this.squareID = squareCount;
		squareCount++;
	}
	
	String getSquareLocation() {
		return this.location;
	}
	
	double getTotalPoints() {
		return this.totalPoints;
	}
	
	int getSquareID() {
		return this.squareID;
	}
	
	boolean getSquareIsOwned() {
		return this.isOwned;
	}
	
	String getSquareType() {
		return this.squareType.toString();
	}
	
	String getSquareOwner() {
		return this.squareOwnerName;
	}
	
	ArrayList<Task> getSquareTaskList(){
		return this.squareTaskList;
	}
	
	String getSquareIssueArea() {
		return this.mainIssueArea.toString();
	}
	
	void setNewOwner(String newOwner) {
		this.squareOwnerName = newOwner;
	}
	
	boolean squareIsNowOwned() {
		this.isOwned = true;
		return true;
	}
	
	boolean squareIsNowNotOwned() {
		this.isOwned = false;
		return true;
	}
}
