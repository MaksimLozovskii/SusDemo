package Demo;

import java.util.ArrayList;

public class Player {
	private static int playerCounter = 0;
	private int playerID;
	
	private String playerName;
	private double playerScore;
	private double playerCurrencyBalance;
	private double playerResourceBalance;
	

	private double playerIncome;
	private double playerOutgoing; 
	private int playerPosition;
	
	private String playerColourHEX;
	private String playerColour;
	
	private ArrayList<Square> playerOwnedSquares = new ArrayList<Square>();
	
	public Player(String name, String colour) {
		this.playerColour = colour;
		this.playerScore = 0;
		this.playerCurrencyBalance = 0;
		this.playerResourceBalance = 0;
		this.playerIncome = 0;
		this.playerOutgoing = 0;
		
		this.playerPosition = 0; // i.e. at the start
		
		playerCounter++;
		this.playerID = playerCounter;
		this.setPlayerName(name);
	}
	public double getPlayerCurrencyBalance() {
		return this.playerCurrencyBalance;
	}
	public double getPlayerResourceBalance() {
		return this.playerResourceBalance;
	}
	public double getPlayerCurrentScore() {
		return this.playerScore;
	}
	
	public boolean changePlayerScore(double amount) {
		return true;
	}
	
	public String getPlayerName() {
		return this.playerName;
	}
	public int getPlayerID() {
		return this.playerID;
	}
	public void setPlayerCurrencyBalance(double newCurrBalance) {
		this.playerCurrencyBalance = newCurrBalance;
	}
	public void setPlayerResourceBalance(double newResBalance) {
		this.playerResourceBalance = newResBalance;
	}
	public void setPlayerScore(double newScore) {
		this.playerScore = newScore;
	}
	public void setPlayerName(String newName) {
		this.playerName = newName;
	}
	
	public double getPlayerIncome() {
		return this.playerIncome;
	}
	
	public double getPlayerOutgoing() {
		return this.playerOutgoing;
	}
	
	public boolean changePlayerIncome(double amount) {
		return true;
	}
	
	public boolean changePlayerOutgoing(double amount) {
		return true;
	}
	
	public int getPlayerPosition() {
		return this.playerPosition;
	}
	
	public void setPlayerPosition(int squareID) {
		this.playerPosition = squareID;
	}
	
	public String getPlayerColour() {
		return this.playerColour;
	}
	public boolean setPlayerColour(String colour) {
		return true;
	}
	public boolean offerOwnedSquare(int squareID) {
		return true;
	}
	public boolean purchaseSquare(int squareID) {
		return true;
	}
	
	public boolean addPlayerOwnedSquare(Square square){
		
		playerOwnedSquares.add(square);
		
		return true;
	}
	
	public String toString() {
		String playerInfo = "";
		
		playerInfo += ""
				+ "*****************************\r\n"
				+ "ID: " + this.playerID + "\r\n"
				+ "Name: " + this.playerName + "\r\n"
				+ "Score: " + this.playerScore + "\r\n"
				+ "Currency Balance: " + this.playerCurrencyBalance + "\r\n"
				+ "Resource Balance: " + this.playerResourceBalance +	"\r\n"
				+ "Income: " + this.playerIncome + "\r\n"
				+ "Outgoing: " + this.playerOutgoing + "\r\n"
				+ "Current Position: " + this.playerPosition + "\r\n"
				+ "Colour: " + this.playerColour + "\r\n"
				+ "Owned Squares: " + "THERE WILL BE LIST HERE" + "\r\n"
				+ "*****************************\r\n";
		
		return playerInfo;
		
	}
}
