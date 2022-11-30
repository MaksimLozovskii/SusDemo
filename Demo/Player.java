package Demo;

import java.util.ArrayList;

public class Player {
	private static int playerCounter = 0;
	private int playerID;
	
	private String name;
	private double score;
	private double currencyBalance;
	private double resourceBalance;
	

	private double playerIncome;
	private double playerOutgoing; 
	private int playerSquarePosition;
	
	private String playerColourHEX;
	private String playerColour;
	
	private ArrayList<Square> playerOwnedSquares = new ArrayList<Square>();
	
	
	public Player(String name) {
		this.score = 0;
		this.currencyBalance = 0;
		this.resourceBalance = 0;
		this.playerIncome = 0;
		this.playerOutgoing = 0;
		
		this.playerSquarePosition = 0; // i.e. at the start
		
		playerCounter++;
		this.playerID = playerCounter;
		this.setPlayerName(name);
	}
	public double getPlayerCurrencyBalance() {
		return this.currencyBalance;
	}
	public double getPlayerResourceBalance() {
		return this.resourceBalance;
	}
	public double getPlayerCurrentScore() {
		return this.score;
	}
	
	public boolean changePlayerScore(double amount) {
		return true;
	}
	
	public String getPlayerName() {
		return this.name;
	}
	public int getPlayerID() {
		return this.playerID;
	}
	public void setPlayerCurrencyBalance(double newCurrBalance) {
		this.currencyBalance = newCurrBalance;
	}
	public void setPlayerResourceBalance(double newResBalance) {
		this.resourceBalance = newResBalance;
	}
	public void setPlayerScore(double newScore) {
		this.score = newScore;
	}
	public void setPlayerName(String newName) {
		this.name = newName;
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
	
	public int getPlayerSquarePosition() {
		return this.playerSquarePosition;
	}
	
	public void setPlayerSquarePosition(int squareID) {
		this.playerSquarePosition = squareID;
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
}
