package Demo;

import java.util.ArrayList;

public class Square {
	private static int squareCount = 1;
	private final int squareID;
	private final String squareLocation;
	private ProblemAreas squareMainIssueArea; 
	private boolean squareIsOwned;
	private String squareOwnerName;
	private ArrayList<Task> squareTaskList;
	private SquareType squareType;

	Square(String location, ProblemAreas mainIssueArea, ArrayList<Task> squareTaskList, SquareType squareType, String initOwner) {
		this.squareOwnerName = initOwner;
		this.squareIsOwned = false;
		this.squareLocation = location;
		this.squareMainIssueArea = mainIssueArea;
		this.squareTaskList = squareTaskList;
		this.squareType = squareType;
		
		this.squareID = squareCount;
		squareCount++;
	}
	
	public String getSquareLocation() {
		return this.squareLocation;
	}
	
	public int getSquareID() {
		return this.squareID;
	}
	
	public boolean getSquareIsOwned() {
		return this.squareIsOwned;
	}
	
	public String getSquareType() {
		return this.squareType.toString();
	}
	
	public String getSquareOwner() {
		return this.squareOwnerName;
	}
	
	public ArrayList<Task> getSquareTaskList(){
		return this.squareTaskList;
	}
	
	public String getSquareIssueArea() {
		return this.squareMainIssueArea.toString();
	}
	
	public void setNewOwner(String newOwner) {
		this.squareOwnerName = newOwner;
	}
	
	public boolean squareIsNowOwned() {
		this.squareIsOwned = true;
		return true;
	}
	
	public boolean squareIsNowNotOwned() {
		this.squareIsOwned = false;
		return true;
	}
	
	public String toString() {
		String squareInfo = "";
		
		squareInfo += ""
				+ "*****************************\r\n"
				+ "Square ID: " + this.squareID + "\r\n"
				+ "Location: " + this.squareLocation + "\r\n"
				+ "Main Issue Area: " + this.squareMainIssueArea.toString() + "\r\n"
				+ "Is Owned: " + this.squareIsOwned +	"\r\n"
				+ "Square Owner Name: " + this.squareOwnerName + "\r\n"
				+ "SquareType: " + this.squareType.toString() + "\r\n"
				+ "*****************************";
		
		return squareInfo;
	}
}
