package Demo;

public class Task {
	
	private String name;
	private double reward;
	private double completionCost;
	private boolean isStarted;
	private boolean isComplete;
	private int untilComplete;
	
	
	Task(String name, int reward, double completionCost, int untilComplete){
		this.name = name;
		this.reward = reward;
		this.completionCost = completionCost;
		this.untilComplete = untilComplete;
		
		this.isStarted = false;
		this.isComplete = false;
	}
	
	int getWeeksUntilComplete() {
		return this.untilComplete;
	}
	
	boolean getIsStarted() {
		return this.isStarted;
	}
	
	boolean getIsComplete() {
		return this.isComplete;
	}
	
	String getTaskName() {
		return this.name;
	}
	
	double getReward() {
		return this.reward;
	}
	
	double completionCost() {
		return this.completionCost;
	}
	
	boolean toggleStarted() {
		this.isStarted = true;
		return true;
	}
	
	boolean toggleComplete() {
		this.isComplete = true;
		this.isStarted = false;
		return true;
	}
}
