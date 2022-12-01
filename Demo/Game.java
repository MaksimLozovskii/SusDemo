package Demo;
import java.util.ArrayList;
import java.util.Random;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
	private final static int MAX_SIZE = 8;
	private final static int MIN_SIZE = 3;
	private static int currentSize = 0;

	private static boolean mainMenuEnd = false;
	
	private static int roundCount = 0;
	
	public static ArrayList<Player> players = new ArrayList<>();
	public static ArrayList<Square> board = new ArrayList<>();
	public static ArrayList<Task> unusedSquareTasks = new ArrayList<>();
	
	// ALL CURRENT MENUS
	private static final String[] playerColourSelection = {"Red", "Blue", "Green", "Yellow", "Pink", "Black"};
	private static final String[] mainMenuOptions = { "Add Player", "Remove Player", "Start Game", "Exit" };
	private static final String[] squareOptions_none = { "Buy square", "View Square info", "View other players", "End turn"};
	private static final String[] squareOptions_owns = { "View Tasks", "View Square info", "View other players", "End turn"};
	private static final String[] squareOptions_other = { "Contribute to active task", "View Square info", "View other players", "End turn"};
	private static final String[] cardDiceOptions = { "Roll dice", "Draw chance card"};
	
	private boolean gameLoop() {
		if(!fillBoard()){
			System.out.println("Unable to fill board");
			return false;
		}

		boolean gameEnd = false;
		while (!gameEnd) {
					for (int currentPlayer = 0; currentPlayer < players.size(); currentPlayer++) {
						printPlayerCurrentLocation(currentPlayer);

						switch (runCardDiceMenu()) {
							case 1 -> {
								int rolledNum = rollDice();
								System.out.println("You have rolled: " + rolledNum);
								if (!movePlayerBy(currentPlayer, rolledNum))
									System.out.println("Unable to move player");
								if (!printPlayerCurrentLocation(currentPlayer))
									System.out.println("Unable to print current location");

								// if the square the player is currently on is owned by the player
								if (playerOwnsSquare(currentPlayer)) {
									boolean endTurn = false;
									while (!endTurn) {
										switch (runSquareMenu("other")) {
											case 1:
												System.out.println("Contribute to other task - In Development");
												break;
											case 2:
												if (!printSquareInfo(currentPlayer))
													System.out.println("Unable to print square info");
												break;
											case 3:
												if (!viewOtherPlayers()) System.out.println("Unable to view players");
												break;
											case 4:
												endTurn = true;
												break;
										}
									}

									// if the square the player is currently on is owned by No one
								} else if ((board.get(players.get(currentPlayer).getPlayerPosition()).getSquareOwner()).equals("Noone")) {
									boolean endTurn = false;
									while (!endTurn) {
										switch (runSquareMenu("noone")) {
											case 1:
												if(!purchaseSquare(currentPlayer, players.get(currentPlayer).getPlayerPosition())) System.out.println("Square not purchased");
												break;

											case 2:
												if (!printSquareInfo(currentPlayer))
													System.out.println("Unable to print Square info");
												break;

											case 3:
												if (!viewOtherPlayers()) System.out.println("Unable to view players");
												break;

											case 4:
												endTurn = true;
												break;
										}
									}

									// if the square the player is currently on is owned by other player
								} else {
									boolean endTurn = false;
									while (!endTurn) {
										switch (runSquareMenu("owns")) {
											case 1:
												System.out.println("View Tasks - In Development");
												break;
											case 2:
												if (!printSquareInfo(currentPlayer))
													System.out.println("Unable to print Square info");
												break;
											case 3:
												if (!viewOtherPlayers())
													System.out.println("Unable to view other players");
												break;
											case 4:
												endTurn = true;
												break;
										}
									}
								}
							}
							case 2 -> {
								if (!drawChanceCard()) System.out.println("Unable to draw card");
							}
						}
					}
					if(endRound()) System.out.println("** Round " + roundCount + " end **");

					// TEST = ENDS ON ROUND 100
					if(roundCount == 100) gameEnd = true;
			}
		return true; // success
	}
	
	private boolean fillBoard() {
		try {
			// SWAP TO CSV
			Square sq0 = new Square("Start",  ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND, "Game");
			Square sq1 = new Square("Govan-1",  ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND, "Noone");
			Square sq2 = new Square("Govan-2",  ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND, "Noone");
			Square sq3 = new Square("Govan-3",  ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND, "Noone");
			Square sq4 = new Square("Govan-4",  ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND, "Noone");
			Square sq5 = new Square("Govan-5",  ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND, "Noone");
			Square sq6 = new Square("Govan-6",  ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND, "Noone");
			
			Square sq7 = new Square("Govan-7",  ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND, "Noone");
			Square sq8 = new Square("Govan-8",  ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND, "Noone");
			Square sq9 = new Square("Govan-9",  ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND, "Noone");
			Square sq10 = new Square("Govan-10",  ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND, "Noone");
			Square sq11 = new Square("Govan-11",  ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND, "Noone");
			Square sq12 = new Square("Govan-12",  ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND, "Noone");
			Square sq13 = new Square("Govan-13",  ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND, "Noone");
			
			Square sq14 = new Square("Govan-14",  ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND, "Noone");
			Square sq15 = new Square("Govan-15", ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND, "Noone");
			Square sq16 = new Square("Govan-16", ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND, "Noone");
			Square sq17 = new Square("Govan-17", ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND, "Noone");
			Square sq18 = new Square("Govan-18", ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND, "Noone");
			Square sq19 = new Square("Govan-19", ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND, "Noone");
			Square sq20 = new Square("Govan-21", ProblemAreas.FOOD, unusedSquareTasks, SquareType.UNUSED_LAND, "Noone");

			board.add(sq0);
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
			
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	private int rollDice() {
		Random rand = new Random();
		return rand.nextInt(12) + 1;
	}
	
	private boolean addPlayer(String playerName) {
		try {
			// CHECK IF PLAYER NAME IS NOT VALID
			if(playerName.equals("Noone")) {
				System.out.println("Invalid Player name");
				return false;
			}
			
			// CHECK IF THE NUMBER OF PLAYERS IS AT MAX
			if(currentSize == MAX_SIZE) {
				System.out.println("Player Limit Reached");
				return false;
			}
			
			// CHECK IF PLAYER NAME IS LONG ENOUGH
			if(playerName.length() < 3) {
				System.out.println("Name has to be at least 4 characters in length");
				return false;
			}
			
			// CHECK IF THE PLAYER WITH THIS NAME ALREADY EXISTS
			for (Player player : players) {
				if ((player.getPlayerName()).equals(playerName)) {
					System.out.println("Player already exists");
					return false;
				}
			}
			System.out.println("======================");
			System.out.println("=Choose player colour=");
			System.out.println("======================");
			
			String playerColour;

			switch (runPlayerColourMenu()) {
				case 1 -> playerColour = "Red";
				case 2 -> playerColour = "Blue";
				case 3 -> playerColour = "Green";
				case 4 -> playerColour = "Yellow";
				case 5 -> playerColour = "Pink";
				case 6 -> playerColour = "Black";
				default -> playerColour = "None";
			}
			
			// INSTANTIATE NEW PLAYER
			try {
				Player newPlayer = new Player(playerName, playerColour);
				currentSize++;
				players.add(newPlayer);
				return true;
			} catch (InputMismatchException e) {
				return false;
			}
			
		} catch (Exception e) {
			return false;
		}
	}
		// ENABLES USER TO REMOVE PLAYER FROM LOBBY

	private boolean setCurrencyBalance(int playerID, double amount) {
		try{
			players.get(playerID).setPlayerCurrencyBalance(players.get(playerID).getPlayerCurrencyBalance() + amount);
			return true;
		}catch(Exception e){
			return false;
		}
	}

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
			return false;
		}
	}
	
	// ENABLES PLAYER TO DRAW A CHANCE CARD
	private boolean drawChanceCard() {
		try{
			System.out.println("Drawn chance card - something happens");
			return true;
		}catch(Exception e){
			return false;
		}
	}

	// RUNS AT THE END OF EACH ROUND
	private boolean endRound() {	
		try {

			if(!manageRoundFunds()) return false;
			if(!generateRoundSummary()) return false;
			System.out.println();
			
			roundCount++;
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	// USED TO ALLOCATE FUNDS TO PEOPLE DEPENDING ON THEIR INCOME AND OUTGOING
	private boolean manageRoundFunds() {
		for (Player player : players) {
			double roundResult = player.getPlayerIncome() - player.getPlayerOutgoing();
			if(!setCurrencyBalance(player.getPlayerID(), roundResult)) return false;
		}
		return true;
	}
	
	// GENERATES A SUMMARY OF ALL PLAYERS FROM THE ROUND 
	private boolean generateRoundSummary() {
		try {
			System.out.println("Round summary generated");

			for (Player player : players) {
				System.out.println(player.toString());
			}

			return true;
		}catch(Exception e) {
			return false;
		}
	}	//  GENERATES A SUMMARY OF ALL PLAYERS FROM THE GAME
	// LOADS TASKS INTO A PARTICULAR SQUARE

	// ENABLES TO VIEW OTHER PLAYER'S STATISTICS
	private boolean viewOtherPlayers() {
		try{
			for (Player player : players) {
				System.out.println(player.toString());
			}
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	// RUNS MAIN MENU
	private int runMainMenu() {
		Menu gameMenu = new Menu(mainMenuOptions);

		System.out.println("===Current Lobby===");
		if (players.size() == 0) {
			System.out.println("#Empty#");
		} else {
			System.out.println("-------------------");
			for (Player player : players) {
				System.out.println(player.getPlayerID() + ": " + player.getPlayerName());
			}
			System.out.println("-------------------");
		}
		return gameMenu.getUserChoice();
	}
	
	// PRINT CURRENT PLAYER LOCATION
	private boolean printPlayerCurrentLocation(int playerID) {
		try{
			System.out.println(players.get(playerID).getPlayerName() + " is now on "
					+ board.get( players.get(playerID).getPlayerPosition() ).getSquareLocation() + " - "
					+ board.get( players.get(playerID).getPlayerPosition() ).getSquareOwner() + " owns this square");

			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	// MOVES PLAYER(by id) BY THE PASSED AMOUNT
	private boolean movePlayerBy(int playerID, int rolledNum) {
        try{
			for(int i = 0; i < rolledNum; i++) {

				if((board.get(players.get(playerID).getPlayerPosition()).getSquareLocation()).equals("Start")) {
					if(!giveStartBonus(playerID)) return false;
				}

				if(players.get(playerID).getPlayerPosition() + 1 > board.size() - 1)
				{
					players.get(playerID).setPlayerPosition(board.get(0).getSquareID());
				}
				else
				{
					players.get(playerID).setPlayerPosition(players.get(playerID).getPlayerPosition() + 1);
				}
			}

			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	// PRINTS MAIN INFORMATION ABOUT THE SQUARE
	private boolean printSquareInfo(int playerID) {
		try {
			System.out.println((board.get( players.get(playerID).getPlayerPosition()).toString()));
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	// ENABLES PLAYER(by id) TO BUY A SQUARE(by id)
	private boolean purchaseSquare(int playerID, int squareID) {	
		
		// CHECK IF SQUARE ALREADY OWNED
		if(board.get(squareID).getSquareIsOwned()) {
			System.out.println("Square already owned");
			return false;
		}
		
		try {
			System.out.println("Are you sure? y/n");
			Scanner input = new Scanner(System.in);
			String confirmation = input.nextLine();

			String stringFix = confirmation.trim().toLowerCase();

			if(stringFix.equals("y")) {
				// CHANGE SQUARE OWNERSHIP TO PLAYER
				board.get(squareID).setNewOwner(players.get(playerID).getPlayerName());
				board.get(squareID).squareIsNowOwned();
				// ADD SQUARE TO PLAYER OWNED SQUARE LIST
				players.get(playerID).addPlayerOwnedSquare(board.get(squareID));

				System.out.println("Purchased " + board.get(players.get(playerID).getPlayerPosition()).getSquareLocation() + " Successfully");

				return true;
			}else if(stringFix.equals("n")) {
				System.out.println("Operation cancelled - back to Square Menu");
				return false;
			}else {
				System.out.println("Invalid answer");
				return false;
			}
		}catch(InputMismatchException e) {
			System.out.println("Invalid response");
			return false;
		}
	}
	
	// GIVES START SQUARE BONUS TO THE ONE CROSSING THE START SQUARE
	private boolean giveStartBonus(int playedID) {
		try{
			System.out.println("=============================");
			System.out.println("Start bonus given to " + players.get(playedID).getPlayerName());
			System.out.println("=============================");
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	// CHECKS IF THE PLAYER OWNS THE SQUARE THEY ARE CURRENTLY ON
	private boolean playerOwnsSquare(int playerID) {
		return players.get(playerID).getPlayerName().equals(board.get( players.get(playerID).getPlayerPosition() ).getSquareOwner());
	}
	
	// MENU PRINTED WHEN PLAYER REACHES A SQUARE
	private int runSquareMenu(String type) {
		switch (type) {
			case "owns" -> {
				Menu squareMenu = new Menu(squareOptions_owns);
				return squareMenu.getUserChoice();
			}
			case "other" -> {
				Menu squareMenu = new Menu(squareOptions_other);
				return squareMenu.getUserChoice();
			}
			case "noone" -> {
				Menu squareMenu = new Menu(squareOptions_none);
				return squareMenu.getUserChoice();
			}
		}
		
		return -1;
	}
	
	// MENU PRINTED WHEN ITS PLAYER'S TURN
	private int runPlayerColourMenu() { 
			Menu playerColourMenu = new Menu(playerColourSelection);

		return playerColourMenu.getUserChoice();
	}

	// MENU PRINTED WHEN ITS PLAYER'S TURN
	private int runCardDiceMenu() { 
		Menu cardDiceMenu = new Menu(cardDiceOptions);

		return cardDiceMenu.getUserChoice();
	}
	
	// STARTS THE GAME
	public boolean mainMenu() {
		while (!mainMenuEnd) {
			switch (runMainMenu()) {
			case 1:
				Scanner input = new Scanner(System.in);
				System.out.print("Type name: ");
				String playerName = input.nextLine();
				if(!addPlayer(playerName)) System.out.println("Unable to add player");
				break;
			
			case 2:
				Scanner rm_input = new Scanner(System.in);
				System.out.print("Type name: ");
				String rm_playerName = rm_input.nextLine();	
				if(!removePlayer(rm_playerName)) System.out.println("Unable to remove player");
				break;

			case 3:
				if(currentSize < MIN_SIZE) {
					System.out.println("Not enough players (Min 3)");
				}else {
					if(!gameLoop()) System.out.println("Unable to run game loop");
				}
				break;

			case 4:
				mainMenuEnd = true;
				System.out.println("Goodbye");
				break;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Game newGame = new Game();
		if(!newGame.mainMenu()){
			System.out.println("Unable to start game");
		}
	}
}
