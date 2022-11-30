package Demo;
import java.util.ArrayList;
import java.util.Random;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
	private final static int MAX_SIZE = 8;
	private final static int MIN_SIZE = 3;
	private static int currentSize = 0;
	
	private static boolean gameEnd = false;
	private static boolean mainMenuEnd = false;
	
	private static int roundCount = 0;
	
	public static ArrayList<Player> players = new ArrayList<Player>();
	public static ArrayList<Square> board = new ArrayList<Square>();
	public static ArrayList<Task> unusedSquareTasks = new ArrayList<Task>();
	
	// ALL CURRENT MENUS
	private static String mainMenuOptions[] = { "Add Player", "Remove Player", "Start Game", "Exit" };
	private static String squareOptions_noone[] = { "Buy square", "Skip"};
	private static String squareOptions_owns[] = { "View Tasks", "Skip"};
	private static String squareOptions_other[] = { "Contribute to active task", "Skip"};
	private static String cardDiceOptions[] = { "Roll dice", "Draw chance card"};
	
	// ACTUAL GAME LOGIC
	private boolean gameLoop() {
			fillBoard();
			
			while (!gameEnd) {
					for (int currentPlayer = 0; currentPlayer < players.size(); currentPlayer++) {
						printPlayerCurrentLocation(currentPlayer);
						
							switch(runCardDiceMenu()) {
							case 1:
								int rolledNum = rollDice();
								System.out.println("You have rolled: " + rolledNum);
								
								movePlayerBy(currentPlayer, rolledNum);
								printPlayerCurrentLocation(currentPlayer);
								
								if(playerOwnsSquare(currentPlayer)) {
									switch(runSquareMenu("other")) {
									case 1:
										break;
									case 2:
										break;
									}
								}else if((board.get( players.get(currentPlayer).getPlayerSquarePosition() ).getSquareOwner()).equals("Noone")) {
									switch(runSquareMenu("noone")) {
									case 1:
										runSquarePurchase(currentPlayer, players.get(currentPlayer).getPlayerSquarePosition());
										break;
									case 2:
										break;
									}
								}else {
									switch(runSquareMenu("owns")) {
									case 1:
										break;
									case 2:
										break;
									}
								}
								break;
										
							case 2:
								drawChanceCard();
								break;
							}
						}
					if(endRound()) {
						System.out.println("Round " + roundCount + " end");
					}
//					
//					if(endGame()) {
//						System.out.println("Game end");
//						generateOverallSum();
//					}
			}
		return true; // on success
	}
	
	// UTILITY METHOD TO FILL THE BOARD WITH SQUARES FROM CSV FILE
	private boolean fillBoard() {
		try {
			// SWAP TO CSV
			Square sq1 = new Square("Start", 1200, ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND);
			Square sq2 = new Square("Govan-2", 1200, ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND);
			Square sq3 = new Square("Govan-3", 1200, ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND);
			Square sq4 = new Square("Govan-4", 1200, ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND);
			Square sq5 = new Square("Govan-5", 1200, ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND);
			Square sq6 = new Square("Govan-6", 1200, ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND);
			Square sq7 = new Square("Govan-7", 1200, ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND);
			
			Square sq8 = new Square("Govan-8", 1200, ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND);
			Square sq9 = new Square("Govan-9", 1200, ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND);
			Square sq10 = new Square("Govan-10", 1200, ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND);
			Square sq11 = new Square("Govan-11", 1200, ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND);
			Square sq12 = new Square("Govan-12", 1200, ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND);
			Square sq13 = new Square("Govan-13", 1200, ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND);
			Square sq14 = new Square("Govan-14", 1200, ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND);
			
			Square sq15 = new Square("Govan-15", 1200, ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND);
			Square sq16 = new Square("Govan-16", 1200, ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND);
			Square sq17 = new Square("Govan-17", 1200, ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND);
			Square sq18 = new Square("Govan-18", 1200, ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND);
			Square sq19 = new Square("Govan-19", 1200, ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND);
			Square sq20 = new Square("Govan-20", 1200, ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND);
			Square sq21 = new Square("Govan-21", 1200, ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND);
			
			board.add(sq1);
			board.add(sq2);
			board.add(sq3);
			board.add(sq4);
			board.add(sq5);
			board.add(sq6);
			board.add(sq7);
			board.add(sq8);
			board.add(sq9);
			board.add(sq10);
			board.add(sq11);
			board.add(sq12);
			board.add(sq13);
			board.add(sq14);
			board.add(sq15);
			board.add(sq16);
			board.add(sq17);
			board.add(sq18);
			board.add(sq19);
			board.add(sq20);
			board.add(sq21);
			
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	// ENABLES PLAYER TO GENERATE A NUMBER FROM 1-12
	private int rollDice() {
		Random rand = new Random();
		int num = rand.nextInt(12);
		return num += 1;
	}
	
	// ENABLES USER TO ADD A PLAYER TO THE GAME
	private boolean addPlayer(String playerName) {
		try {
			if(currentSize != MAX_SIZE) {
				try {
					Player newPlayer = new Player(playerName);
					currentSize++;
					players.add(newPlayer);
					return true;
				} catch (InputMismatchException e) {
					return false;
				}
			}
			System.out.println("Player Limit Reached");
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	// EXITS THE GAME
	private boolean exit(String confirmation) {
		if(confirmation.equals("y")) {
			mainMenuEnd = true;
		}else if(confirmation.equals("n")) {
			return false;
		}else {
			return false;
		}
		return true;
	}
	
	// ENABLES USER TO REMOVE PLAYER FROM LOBBY
	private boolean removePlayer(String playerName) {
		try {			
			if(currentSize > 0) {
				for(int i = 0; i < players.size(); i++) {
					if(playerName.equals(players.get(i).getPlayerName())) {
						players.remove(i);
						currentSize--;
						return true;
					}
				}
				return false;
			}
			return false;
		} catch (InputMismatchException e) {
			System.out.println(e);
			return false;
		}
	}
	
	// ENABLES PLAYER TO DRAW A CHANCE CARD
	private boolean drawChanceCard() {
		System.out.println("Drawn chance card");
		return true;
	}
	
	// UTILITY METHOD TO END THE GAME
	private boolean endGame() {		
		try {
			gameEnd = true;
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	// RUNS AT THE END OF EACH ROUND
	private boolean endRound() {	
		try {

			// manageRoundFunds()
			
			roundCount++;
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	// USED TO ALLOCATE FUNDS TO PEOPLE DEPENDING ON THEIR INCOME AND OUTGOING
	private boolean manageRoundFunds() {
		
		return true;
	}
	
	// GENERATES A SUMMARY OF ALL PLAYERS FROM THE ROUND 
	private boolean generateRoundSumry() {
		System.out.println("Round summary generated");
		return true;
	}
	
	//  GENERATES A SUMMARY OF ALL PLAYERS FROM THE GAME
	private boolean generateOverallSumry() {
		System.out.println("Overall summary generated");
		return true;
	}
	
	// LOADS TASKS INTO A PARTICULAR SQUARE
	private boolean loadSquareTasks(int squareID) {
		return true;
	}
	
	// LOADS DATA OF ALL SQUARES FROM CSV
	private boolean loadSquareData() {
		return true;
	}
	
	// ENABLES TO VIEW OTHER PLAYER'S STATISTICS
	private boolean viewOtherPlayers() {
		return true;
	}
	
	// RUNDS MAIN MENU
	private int runMainMenu() {
		Menu gameMenu = new Menu(mainMenuOptions);

		System.out.println("===Current Lobby===");
		if (players.size() == 0) {
			System.out.println("#Empty#");
		} else {
			System.out.println("-------------------");
			for (int i = 0; i < players.size(); i++) {
				System.out.println(players.get(i).getPlayerID() + ": " + players.get(i).getPlayerName());
			}
			System.out.println("-------------------");
		}
		int gameMenuChoice = gameMenu.getUserChoice();
		return gameMenuChoice;
	}
	
	// PRINT CURRENT PLAYER LOCATION
	private void printPlayerCurrentLocation(int playerID) {
		System.out.println(players.get(playerID).getPlayerName() + " is now on "
				+ board.get( players.get(playerID).getPlayerSquarePosition() ).getSquareLocation() + " - " 
				+ board.get( players.get(playerID).getPlayerSquarePosition() ).getSquareOwner() + " owns this square");
	}
	
	// MOVES PLAYER(by id) BY THE PASSED AMOUNT
	private boolean movePlayerBy(int playerID, int rolledNum) {
		try {
			for(int i = 0; i < rolledNum; i++) {
				
				try {
					players.get(playerID).setPlayerSquarePosition(players.get(playerID).getPlayerSquarePosition() + 1);
				} catch (IndexOutOfBoundsException e) {
					players.get(playerID).setPlayerSquarePosition(board.get(0).getSquareID()); // set to start
				}
			}
			
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	// ENABLES PLAYER(by id) TO BUY A SQUARE(by id)
	private boolean runSquarePurchase(int playerID, int squareID) {		
		
		if(board.get(squareID).getSquareIsOwned()) {
			System.out.println("Square already owned");
		}
		else {
			// CHANGE SQUARE OWNERSHIP TO PLAYER
			board.get(squareID).setNewOwner(players.get(playerID).getPlayerName());
			board.get(squareID).squareIsNowOwned();
			// ADD SQUARE TO PLAYER OWNED SQUARE LIST
			players.get(playerID).addPlayerOwnedSquare(board.get(squareID));
			
			System.out.println("Purchased " + board.get(players.get(playerID).getPlayerSquarePosition()).getSquareLocation() + " Successfully");
			
			return false;
		}
		return true;
	}
	
	// GIVES START SQUARE BONUS TO THE ONE CROSSING THE START SQUARE
	private boolean giveStartBonus(int playedID) {
		return true;
	}
	
	// CHECKS IF THE PLAYER OWNS THE SQUARE THEY ARE CURRENTLY ON
	private boolean playerOwnsSquare(int playerID) {
		if(players.get(playerID).getPlayerName().equals(board.get( players.get(playerID).getPlayerSquarePosition() ).getSquareOwner())) {
			return true;
		}else {
			return false;
		}	
	}
	
	// MENU PRINTED WHEN PLAYER REACHES A SQUARE
	private int runSquareMenu(String type) {
		if(type.equals("owns")) {
			Menu squareMenu = new Menu(squareOptions_owns);
			int squareChoice = squareMenu.getUserChoice();
			return squareChoice;
		}
		else if(type.equals("other")) {
			Menu squareMenu = new Menu(squareOptions_other);
			int squareChoice = squareMenu.getUserChoice();
			return squareChoice;
		}
		else if(type.equals("noone")) {
			Menu squareMenu = new Menu(squareOptions_noone);
			int squareChoice = squareMenu.getUserChoice();
			return squareChoice;
		}
		
		return -1;
	}
	
	// MENU PRINTED WHEN ITS PLAYER'S TURN
	private int runCardDiceMenu() { 
		Menu cardDiceMenu = new Menu(cardDiceOptions);
		int cardDiceChoice = cardDiceMenu.getUserChoice();
		
		return cardDiceChoice;
	}
	
	// STARTS THE GAME
	public void startGame() {
		while (!mainMenuEnd) {
			switch (runMainMenu()) {
			case 1:
				Scanner input = new Scanner(System.in);
				System.out.print("Type name: ");
				String playerName = input.nextLine();
				addPlayer(playerName);				
				break;
			
			case 2:
				Scanner rm_input = new Scanner(System.in);
				System.out.print("Type name: ");
				String rm_playerName = rm_input.nextLine();	
				removePlayer(rm_playerName);
				break;

			case 3:
				if(currentSize < MIN_SIZE) {
					System.out.println("Not enough players (Min 3)");
				}else {
					gameLoop();
				}
				break;

			case 4:
				exit("y");
				break;
			}
		}
	}
	public static void main(String[] args) {
		Game newGame = new Game();
		newGame.startGame();
	}
}
