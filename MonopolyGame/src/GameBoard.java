import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 
 *
 */
public class GameBoard {
	public static int numOfPlayers;
	final int MAX_PLAYER=8;
	final int MIN_PLAYER=2;
	
	Scanner input = new Scanner(System.in);
	GameBoard gameBoard;
	Dice dice1 = new Dice();
	Dice dice2 = new Dice();
	Square jail= new Square(10);
	Player[] playerList = createPlayers(numOfPlayers);
	//Player[] playingOrder = gameBoard.diceTournament();
	Square[] squareList= createCells();
	
	
	public  Square[] createCells() {
		
		int createdPlayerNumber=0;
		ArrayList<Square> squareList = new ArrayList<Square>();

			for(createdPlayerNumber=0;createdPlayerNumber<40;createdPlayerNumber++) {
				int id = createdPlayerNumber+1;
				Square square= new Square(id);
				squareList.add(square);
			}
			Square[] squareArray = squareList.toArray(new Square[40]);
		return squareArray;
	}
	
	public void move(GameBoard gameBoard,Player player,int turnTotalMovement) {
		// TODO Auto-generated method stub
		Square currentCell= player.getCurrentposition();
		Square nextCell = new Square();
		int nextCellLoc=currentCell.lineUp+turnTotalMovement;
		nextCell.setSquare(nextCellLoc);
		
		player.setCurrentposition(nextCell);

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
	

	public Player[] createPlayers(int numOfPlayers) {
		ArrayList<Player> playerList = new ArrayList<Player>();
		for(int i=1;i<=8;i++) {
			Player player= new Player(i);
			playerList.add(player);
		}
			Player[] playerArray = playerList.toArray(new Player[8]);
		return playerArray;
	}

	public int getNumberOfPlayer(Scanner input,int MAX_PLAYER, int MIN_PLAYER) {
		input= new Scanner(System.in);
		int numberOfPlayers = 0;
		System.out.print("Enter number of players(2~8): ");
		if(input.hasNextInt()) {
			
		    numberOfPlayers = input.nextInt();
		    if (numberOfPlayers<=MAX_PLAYER && numberOfPlayers>=MIN_PLAYER) {
		    	System.out.println(numberOfPlayers+" players will be on this game.");
		    	input.close();
		    }else {
		    	System.out.println("No way you don't deserve to play. First learn Math.");
		    	getNumberOfPlayer(input, MAX_PLAYER, MIN_PLAYER);
		    }
		}else {
			System.out.println("No way you don't deserve to play. First learn Math.");
			getNumberOfPlayer(input, MAX_PLAYER, MIN_PLAYER);
		}
		setNumOfPlayers(numberOfPlayers);
		return numberOfPlayers;
	}

	/**
	 * @return the numOfPlayers
	 */
	public static int getNumOfPlayers() {
		return numOfPlayers;
	}

	/**
	 * @param numOfPlayers the numOfPlayers to set
	 */
	public static void setNumOfPlayers(int numOfPlayers) {
		GameBoard.numOfPlayers = numOfPlayers;
	}

	/**
	 * @return the squares
	 */
	public ArrayList<Square> getSquares() {
		return getSquares();
	}

	/**
	 * @param squares the squares to set
	 */
	public void setSquares(Square[] squares) {
		this.squareList = squares;
	}
	/**
	 * @return the squareList
	 */
	public Square[] getSquareList() {
		return squareList;
	}

	public boolean checkDoubleCounter(Player player,int dice1Value, int dice2Value) {
		int value1=dice1Value;
		int value2=dice2Value;
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
	
}
