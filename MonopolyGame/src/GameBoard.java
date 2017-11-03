import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GameBoard {
	//Declarations and Initilizations
	public static int numOfPlayers;
	Scanner input = new Scanner(System.in);
	GameBoard gameBoard;
	Dice dice1 = new Dice();
	Dice dice2 = new Dice();
	Player[] playerList = createPlayers(input,numOfPlayers);
	Player[] playingOrder = diceTournament(gameBoard,playerList);
	Square[] squareList= createCells();

	public  Square[] createCells() {
		//List of Squares
		ArrayList<Square> squareList = new ArrayList<Square>();
		Square  square1,square2,square3,square4,square5,square6,square7,square8,square9,square10,
		square11,square12,square13,square14,square15,square16,square17,square18,square19,square20,
		square21,square22,square23,square24,square25,square26,square27,square28,square29,square30,
		square31,square32,square33,square34,square35,square36,square37,square38,square39,square40;
		squareList.add((square1 = new Square(1,"GO")));
		squareList.add((square2 = new Square(2,"Property")));
		squareList.add((square3 = new Square(3,"Community Chest")));
		squareList.add((square4 = new Square(4,"Property")));
		squareList.add((square5 = new Square(5,"Income Tax")));//must pay %10 of total
		squareList.add((square6 = new Square(6,"Railway")));
		squareList.add((square7 = new Square(7,"Property")));
		squareList.add((square8 = new Square(8,"Chance")));
		squareList.add((square9 = new Square(9,"Property")));
		squareList.add((square10 = new Square(10,"Property")));
		squareList.add((square11 = new Square(11,"Jail")));// first exit 
		squareList.add((square12 = new Square(12,"Property")));
		squareList.add((square13 = new Square(13,"Electric")));
		squareList.add((square14 = new Square(14,"Property")));
		squareList.add((square15 = new Square(15,"Property")));
		squareList.add((square16 = new Square(16,"Railway")));
		squareList.add((square17 = new Square(17,"Property")));
		squareList.add((square18 = new Square(18,"Community Chest")));
		squareList.add((square19 = new Square(19,"Property")));
		squareList.add((square20 = new Square(20,"Property")));
		squareList.add((square21 = new Square(21,"Free Parking")));
		squareList.add((square22 = new Square(22,"Property")));
		squareList.add((square23 = new Square(23,"Chance")));
		squareList.add((square24 = new Square(24,"Property")));
		squareList.add((square25 = new Square(25,"Property")));
		squareList.add((square26 = new Square(26,"Railway")));
		squareList.add((square27 = new Square(27,"Property")));
		squareList.add((square28 = new Square(28,"Property")));
		squareList.add((square29 = new Square(29,"Water")));
		squareList.add((square30 = new Square(30,"Property")));
		squareList.add((square31 = new Square(31,"Go To Jail"))); // go to square 11
		squareList.add((square32 = new Square(32,"Property")));
		squareList.add((square33 = new Square(33,"Property")));
		squareList.add((square34 = new Square(34,"Community Chest)")));
		squareList.add((square35 = new Square(35,"Property")));
		squareList.add((square36 = new Square(36,"Railway")));
		squareList.add((square37 = new Square(37,"Chance")));
		squareList.add((square38 = new Square(38,"Property")));// Park Place
		squareList.add((square39 = new Square(39,"Luxury Tax")));
		squareList.add((square40 = new Square(40,"Property")));//Boardwalk
		Square[] squareArray = squareList.toArray(new Square[40]);
		return squareArray;
	}

	public void move(GameBoard gameBoard,Player player,int turnTotalMovement) {
		Square currentCell= player.getCurrentposition();
		int nextCellLoc=currentCell.getSquareID()+turnTotalMovement;
		if(nextCellLoc>40) {
			player.increaseMoney(200);
			nextCellLoc= nextCellLoc%40;
		}
		player.checkGo();
		if(player.getCurrentposition().getSquareID()==31 || player.getCurrentposition().getSquareID()==11 ) {//Go To Jail
			player.goToJail();
		}
		player.isInJail = player.checkJail();
		if(player.isInJail) {
			System.out.println(player.getPlayerName()+" is in Jail now.");
		}else {
			player.setCurrentposition(getSquaresByID(nextCellLoc));
		}
		
	}

	public Player[] diceTournament(GameBoard gameBoard,Player[] playerList) {
		for(int i=0;i<playerList.length;i++) {
			playerList[i].diceTournamentValue = dice1.rollDice() + dice2.rollDice();
			for (Player player : playerList) {
				   for(int j=0;j<playerList.length;j++){
					   if(player.getPlayerID() != playerList[i].getPlayerID()) {
						   while(playerList[i].diceTournamentValue == player.diceTournamentValue) {
							   playerList[i].diceTournamentValue = dice1.rollDice() + dice2.rollDice();
						   }
					   }
				   }
			}
		}		
		Player[] playingList = new Player[playerList.length];
		int max=playerList[0].diceTournamentValue;
		int min=playerList[0].diceTournamentValue;
		for(int k=0;k<playerList.length;k++) {
			if(playerList[k].diceTournamentValue>max) {
				max=playerList[k].diceTournamentValue;
			}else if(playerList[k].diceTournamentValue<min) {
				min=playerList[k].diceTournamentValue;
			}
		}
		Integer[][] diceValues= new Integer[playerList.length][2];
		for(int t=0;t<playerList.length;t++) {
			diceValues[t][0]=playerList[t].diceTournamentValue;
			diceValues[t][1]=playerList[t].getPlayerID();
		}
		Arrays.sort(diceValues, new ArrayComparator(0, true));

		for(int i=0;i<playerList.length;i++) {
			for(int j=0;j<diceValues.length;j++) {
					if( diceValues[j][0] == playerList[i].diceTournamentValue && diceValues[j][1] == playerList[i].getPlayerID()) {
					playingList[i]=playerList[i];
				}
			}
		}
		return playingList;
	}

	public Player[] createPlayers(Scanner input,int numOfPlayers) {
		ArrayList<Player> playerList = new ArrayList<Player>();
		int i=0;
		for(i=1;i<=8;i++) {
			Player player= new Player(i);
			playerList.add(player);
		}
		Player[] playerArray = playerList.toArray(new Player[8]);
		return playerArray;
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