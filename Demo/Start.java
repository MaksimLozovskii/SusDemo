package Demo;

import java.util.ArrayList;
import java.util.Random;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Start {
	public static ArrayList<Player> registeredPlayers = new ArrayList<Player>();

	private int maxSize = 8;
	private int minSize = 2;
	private int currentSize = 0;

	private static String mainMenuOptions[] = { "Add Player", "Start Game", "Exit" };
	private static String playerSquareOptions[] = { "Option1", "Option2", "Option3" };
	private Scanner input;

	private int rollDice() {
		int num = 0;
		System.out.print("Type 1 to roll dice: ");
		int diceRollChoice = input.nextInt();
		if (diceRollChoice == 1) {
			Random rand = new Random();
			num = rand.nextInt(6);
			num += 1; // fix num
			System.out.println("You have rolled: " + num);
		}
		return num;
	}

	private Board createBoard() {
		try {
			Square sq1 = new Square("Govan-one", 1200, 3, ProblemAreas.FOOD);
			Square sq2 = new Square("Govan-two", 1200, 3, ProblemAreas.FOOD);
			Square sq3 = new Square("Govan-three", 1200, 3, ProblemAreas.FOOD);
			Square sq4 = new Square("Govan-four", 1200, 3, ProblemAreas.FOOD);
			Square sq5 = new Square("Govan-five", 1200, 3, ProblemAreas.FOOD);
			Square sq6 = new Square("Govan-six", 1200, 3, ProblemAreas.FOOD);
			Square sq7 = new Square("Govan-seven", 1200, 3, ProblemAreas.FOOD);

			Board board = new Board();
			board.addLevels(sq1);
			board.addLevels(sq2);
			board.addLevels(sq3);
			board.addLevels(sq4);
			board.addLevels(sq5);
			board.addLevels(sq6);
			board.addLevels(sq7);
			return board;
		} catch (Exception e) {
			return null;
		}
	}

	private boolean addPlayer() {
		try {
			this.input = new Scanner(System.in);
			System.out.print("Enter player name: ");
			try {
				String name = input.nextLine();
				Player newPlayer = new Player(name);
				this.currentSize++;
				registeredPlayers.add(newPlayer);
				return true;
			} catch (InputMismatchException e) {
				System.out.println(e);
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	private int runGameMenu() {
		Menu gameMenu = new Menu(mainMenuOptions);

		System.out.println("===Current Lobby===");
		if (registeredPlayers.size() == 0) {
			System.out.println("#Currently Empty#");
		} else {
			System.out.println("-------------------");
			for (int i = 0; i < registeredPlayers.size(); i++) {
				System.out.println(registeredPlayers.get(i).getPlayerID() + ": " + registeredPlayers.get(i).getName());
			}
			System.out.println("-------------------");
		}
		int gameMenuChoice = gameMenu.getUserChoice();
		return gameMenuChoice;
	}

	private int runSquareMenu() {
		Menu squareMenu = new Menu(playerSquareOptions);
		int squareChoice = squareMenu.getUserChoice();

		return squareChoice;
	}

	private void gameLoop() {
		Board board = createBoard();
		boolean gameEnd = false;
		while (!gameEnd) {
			for (int currentSquare = 0; currentSquare <= board.getBoardSize(); currentSquare++) {
				for (int currentPlayer = 0; currentPlayer < registeredPlayers.size(); currentPlayer++) {
					// Prompt player turn
					System.out.println("Its " + registeredPlayers.get(currentPlayer).getName() + "'s turn");
					// print current square
					System.out.println(registeredPlayers.get(currentPlayer).getName() + " is currently in "
							+ board.getLocationOf(0));

					// Roll dice
					int rolledNum = rollDice();
					System.out.println(registeredPlayers.get(currentPlayer).getName() + " is now in "
							+ board.getLocationOf(0 + rolledNum));

					// Print square choice
					switch (runSquareMenu()) {
					case 1:
						System.out.println("Option1");
						break;
					case 2:
						System.out.println("Option2");
						break;
					case 3:
						System.out.println("Option3");
						break;
					}
				}
			}
			System.out.println("All players went - end");
			gameEnd = true;
		}
	}

	public void startGame() {
		boolean menuLoop = false;
		while (!menuLoop) {
			switch (runGameMenu()) {
			case 1:
				if (currentSize != maxSize) {
					if (addPlayer()) {
						System.out.println("Successfully added!");
						System.out.println("Slots left: " + (maxSize - currentSize));
					}else {
						System.out.println("Failed to add player");
					}
				}
				System.out.println("Player limit reached");
				break;

			case 2:
				if (registeredPlayers.size() <= this.minSize) {
					System.out.println("Not enough players to start a game");
				} else {
					gameLoop();
				}
				break;

			case 3:
				System.out.println("--GoodBye--");
				menuLoop = true;
				break;
			}
		}
	}

	public static void main(String[] args) {
		Start newGame = new Start();
		newGame.startGame();
	}
}
