import java.util.ArrayList;
import java.util.Scanner;

public class GameBoard {
	public static int numOfPlayers;
	final int MAX_PLAYER=8;
	final int MIN_PLAYER=2;
	Scanner input = new Scanner(System.in);
	GameBoard gameBoard;
	Dice dice1 = new Dice();
	Dice dice2 = new Dice();
	Player[] playerList = createPlayers(numOfPlayers);
	//Player[] playingOrder = gameBoard.diceTournament();
	Square[] squareList= createCells();
	
	
	public  Square[] createCells() {
		ArrayList<Square> squareList = new ArrayList<Square>();
		Square  square1,square2,square3,square4,square5,square6,square7,square8,square9,square10,
		square11,square12,square13,square14,square15,square16,square17,square18,square19,square20,
		square21,square22,square23,square24,square25,square26,square27,square28,square29,square30,
		square31,square32,square33,square34,square35,square36,square37,square38,square39,square40;
		squareList.add((square1 = new Square(1,"GO")));
		squareList.add((square2 = new Square(2,"Property")));
		squareList.add((square3 = new Square(3,"Community Chest")));
		squareList.add((square4 = new Square(4,"Property")));
		squareList.add((square5 = new Square(5,"Tax")));
		squareList.add((square6 = new Square(6,"Railway")));
		squareList.add((square7 = new Square(7,"Property")));
		squareList.add((square8 = new Square(8,"Chance")));
		squareList.add((square9 = new Square(9,"Property")));
		squareList.add((square10 = new Square(10,"Property")));
		squareList.add((square11 = new Square(11,"Jail")));
		squareList.add((square12 = new Square(12,"Property")));
		squareList.add((square13 = new Square(13,"Electric")));
		squareList.add((square14 = new Square(14,"Property")));
		squareList.add((square15 = new Square(15,"Property")));
		squareList.add((square16 = new Square(16,"Railway")));
		squareList.add((square17 = new Square(17,"Property")));
		squareList.add((square18 = new Square(18,"Community Chest")));
		squareList.add((square19 = new Square(19,"Property")));
		squareList.add((square20 = new Square(20,"Property")));
		squareList.add((square21 = new Square(21,"FreeParking")));
		squareList.add((square22 = new Square(22,"Property")));
		squareList.add((square23 = new Square(23,"Chance")));
		squareList.add((square24 = new Square(24,"Property")));
		squareList.add((square25 = new Square(25,"Property")));
		squareList.add((square26 = new Square(26,"Railway")));
		squareList.add((square27 = new Square(27,"Property")));
		squareList.add((square28 = new Square(28,"Property")));
		squareList.add((square29 = new Square(29,"Water")));
		squareList.add((square30 = new Square(30,"Property")));
		squareList.add((square31 = new Square(31,"GoJail")));
		squareList.add((square32 = new Square(32,"Property")));
		squareList.add((square33 = new Square(33,"Property")));
		squareList.add((square34 = new Square(34,"Community Chest)")));
		squareList.add((square35 = new Square(35,"Property")));
		squareList.add((square36 = new Square(36,"Railway")));
		squareList.add((square37 = new Square(37,"Chance")));
		squareList.add((square38 = new Square(38,"Property")));
		squareList.add((square39 = new Square(39,"Tax")));
		squareList.add((square40 = new Square(40,"Property")));

		Square[] squareArray = squareList.toArray(new Square[40]);
		return squareArray;
	}

	public void move(GameBoard gameBoard,Player player,int turnTotalMovement) {
		Square currentCell= player.getCurrentposition();
		int nextCellLoc=currentCell.getSquareID()+turnTotalMovement;
		if(nextCellLoc>40) {
			nextCellLoc= nextCellLoc%40;
		}
		player.setCurrentposition(getSquaresByID(nextCellLoc));
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
		    	System.out.println("Game will start soon...");
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
		}else{
			player.doubleCounter=0;
			return true;
		}
	}

	public Square getSquaresByID(int squareID) {
		for(Square square : squareList) { 
			   if( square.getSquareID()==squareID ) { 
			       return square;
			   }
			}
		return null;
	}
}