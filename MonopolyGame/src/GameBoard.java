import java.util.ArrayList;

/**
 * @author 
 *
 */
public class GameBoard {
	Dice dice1 = new Dice();
	Dice dice2 = new Dice();
	Square jail= new JailSquare();
	ArrayList<Square> squares = new ArrayList<Square>();

	
	
	
	public boolean checkDoubleCounter(Player player,Dice dice1,Dice dice2) {
		int value1,value2;
		value1=dice1.getFaceValue();
		value2=dice2.getFaceValue();
		if(value1==value2) {
			player.doubleCounter++;
			if(player.doubleCounter >=3) {
				return false;
			}else {
				return true;
			}
		}else {
			player.doubleCounter=0;
			return true;
		}
	}
	
	
	
	/**
	 * @return the squares
	 */
	public ArrayList<Square> getSquares() {
		return squares;
	}

	/**
	 * @param squares the squares to set
	 */
	public void setSquares(ArrayList<Square> squares) {
		this.squares = squares;
	}

	public void addCells(Square[] squareList) {

		
	}

	public void addPlayers(Player[] playerList) {
		// TODO Auto-generated method stub
		
	}

	public void addDices(Dice dice1, Dice dice2) {
		// TODO Auto-generated method stub
		
	}

	public Player[] diceTournament() {
		// TODO Auto-generated method stub
		return null;
	}


}
