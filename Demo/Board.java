package Demo;

import java.util.ArrayList;

public class Board {
	
	public static ArrayList<Square> board = new ArrayList<Square>();

	public void addLevels(Square square) {
		board.add(square);
	}
	
	public String getLocationOf(int squareNum) {
		return board.get(squareNum).getLocation();
	}
	
	public int getBoardSize() { 
		return board.size();
	}
}
