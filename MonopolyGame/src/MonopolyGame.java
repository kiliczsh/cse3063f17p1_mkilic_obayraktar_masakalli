import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MonopolyGame {

	public static int numOfPlayers;
	public static Player[] playerList;
	
	//main method
	public static void main(String[] args) {
		
		final int MAX_PLAYER=8;
		final int MIN_PLAYER=2;
		Scanner input = new Scanner(System.in);
		
		GameBoard gameBoard = new GameBoard();
		
		Square[] squareList = createSquares();
		gameBoard.addCells(squareList);
		
		getNumberOfPlayer(input, MAX_PLAYER, MIN_PLAYER);
		Player[] playerList = createPlayers(numOfPlayers);
		gameBoard.addPlayers(playerList);
		
		Player[] playingOrder=gameBoard.diceTournament();
		
		startGame(playingOrder);
		
		
	}
	




	public static void startGame(Player[] playingOrder,GameBoard gameBoard) {
		final int GAME_TURN=5;
		for(int i=0;i<numOfPlayers;i++) {
			Player currentPlayer = playingOrder[i];
			currentPlayer.toString();
			gameBoard.dice1.rollDice();
			gameBoard.dice2.rollDice();
			boolean goJailStatus = gameBoard.checkDoubleCounter(currentPlayer, gameBoard.dice1,gameBoard.dice2);
			if(goJailStatus==false) {
				currentPlayer.setCurrentposition(gameBoard.jail);
			}else {
				int turnTotalMovement = gameBoard.dice1.getFaceValue()+gameBoard.dice2.getFaceValue();
				move(gameBoard,currentPlayer,turnTotalMovement);
				
			}
		}
		
		
		
	}
	
	public static void move(GameBoard gameBoard,Player player,int turnTotalMovement) {
		// TODO Auto-generated method stub
		Square currentCell= player.getCurrentposition();
		Square nextCell;
		int nextCellLoc=currentCell.lineUp+turnTotalMovement;
		nextCell.setSquare(nextCellLoc);
		
		
		player.setCurrentposition(nextCell);
		
		
		
	}





	private static Square[] createSquares() {
		// TODO Auto-generated method stub
		return null;
	}



	@SuppressWarnings({ "unchecked", "rawtypes", "resource" })
	public static Player[] createPlayers(int numOfPlayers) {
		
		int createdPlayerNumber=0;
		String playerName;
		ArrayList<Player> playerList = new ArrayList();

			for(createdPlayerNumber=0;createdPlayerNumber<numOfPlayers;createdPlayerNumber++) {
				Scanner scan = new Scanner(System.in);
				int id = createdPlayerNumber+1;
				System.out.println("ID: "+id);
				System.out.println("Enter "+id+ ". Player's name: ");
				String line = null;
				while(scan.hasNextLine()){
					line=scan.nextLine();//not working yet
				}
				playerName=line;
				Player player= new Player(id,playerName);
				playerList.add(player);
			}
			Player[] playerArray = playerList.toArray(new Player[numOfPlayers]);
		return playerArray;
		
	}




	private static Object Player(int i, String playerName) {
		// TODO Auto-generated method stub
		return null;
	}





	public static int getNumberOfPlayer(Scanner input,int MAX_PLAYER, int MIN_PLAYER) {
		input= new Scanner(System.in);
		System.out.print("Enter number of players(2~8): ");
		if(input.hasNextInt()) {
		    numOfPlayers = input.nextInt();
		    if (numOfPlayers<=MAX_PLAYER && numOfPlayers>=MIN_PLAYER) {
		    	System.out.println(numOfPlayers+" players will be on this game.");
		    	input.close();
		    }else {
		    	System.out.println("No way you don't deserve to play. First learn Math.");
		    	getNumberOfPlayer(input, MAX_PLAYER, MIN_PLAYER);
		    }
		}else {
			System.out.println("No way you don't deserve to play. First learn Math.");
			getNumberOfPlayer(input, MAX_PLAYER, MIN_PLAYER);
		}
		return numOfPlayers;

	}

	
	
}
