package Demo;

public class Task {
	
	private final String taskName;
	private final double taskReward;
	private final double taskCompletionCost;
	private boolean taskIsStarted;
	private boolean taskIsComplete;
	private int weeksUntilComplete;
	
	
	Task(String name, int reward, double completionCost, int untilComplete){
		this.taskName = name;
		this.taskReward = reward;
		this.taskCompletionCost = completionCost;
		this.weeksUntilComplete = untilComplete;
		
		this.taskIsStarted = false;
		this.taskIsComplete = false;
	}
	
	int getWeeksUntilComplete() {
		return this.weeksUntilComplete;
	}
	
	boolean getIsStarted() {
		return this.taskIsStarted;
	}
	
	boolean getIsComplete() {
		return this.taskIsComplete;
	}
	
	String getTaskName() {
		return this.taskName;
	}
	
	double getReward() {
		return this.taskReward;
	}
	
	double completionCost() {
		return this.taskCompletionCost;
	}
	
	boolean toggleStarted() {
		this.taskIsStarted = true;
		return true;
	}
	
	boolean toggleComplete() {
		this.taskIsComplete = true;
		this.taskIsStarted = false;
		return true;
	}
}
