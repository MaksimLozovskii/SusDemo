package Demo;

public class Player {
	private static int playerCounter = 0;
	private int playerID;
	
	private String name;
	private double score;
	private double currencyBalance;
	private double resourceBalance;
	
	public Player(String name) {
		this.score = 0;
		this.currencyBalance = 0;
		this.resourceBalance = 0;
		
		this.playerCounter++;
		this.playerID = this.playerCounter;
		this.setName(name);
	}
	public double getCurrencyBalance() {
		return this.currencyBalance;
	}
	public double getResourceBalance() {
		return this.resourceBalance;
	}
	public double getScore() {
		return this.score;
	}
	public String getName() {
		return this.name;
	}
	public int getPlayerID() {
		return this.playerID;
	}
	
	
	public void setCurrencyBalance(double newCurrBalance) {
		this.currencyBalance = newCurrBalance;
	}
	public void setResourceBalance(double newResBalance) {
		this.resourceBalance = newResBalance;
	}
	public void setScore(double newScore) {
		this.score = newScore;
	}
	public void setName(String newName) {
		this.name = newName;
	}

}
