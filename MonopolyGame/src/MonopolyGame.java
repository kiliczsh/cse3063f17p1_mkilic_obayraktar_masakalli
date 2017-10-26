import java.util.Scanner;
public class MonopolyGame {
	//main method
	public static void main(String[] args) {
		final int MAX_PLAYER=8;
		final int MIN_PLAYER=2;
		

		Scanner input= new Scanner(System.in);
		int numberOfPlayers = 0;
		GameBoard gameBoard=new GameBoard();
		System.out.print("Enter number of players(2~8): ");
		if(input.hasNextInt()) {
		    numberOfPlayers = input.nextInt();
		    if (numberOfPlayers<=MAX_PLAYER && numberOfPlayers>=MIN_PLAYER) {
		    	System.out.println(numberOfPlayers+" players will be on this game.");		    	
		    	System.out.println("Game will start soon...");
		    }else {
		    	System.out.println("No way you don't deserve to play. First learn Math.");
		    }
		}else {
			System.out.println("No way you don't deserve to play. First learn Math.");
		}
		
		String playerNames[] = new String[numberOfPlayers];
		
		for(int i=0;i<numberOfPlayers;i++) {
			System.out.print("Please enter the name of player"+(i+1)+":  ");
			playerNames[i] = input.next();
        }
		GameBoard.numOfPlayers = numberOfPlayers;
		startGame(gameBoard);
	}

	public static void startGame(GameBoard gameBoard) {

		// GameBoard.numOfPlayers yukarda gelen inputa eþitlendi, bu satýra gerek yok.
		//GameBoard.numOfPlayers=gameBoard.getNumberOfPlayer(gameBoard.input, gameBoard.MAX_PLAYER, gameBoard.MIN_PLAYER);
		for(int turn=1;turn<=5;turn++) {
			System.out.println("This is "+turn+". Round.\n\n\n");
			for(int i=0;i<GameBoard.numOfPlayers;i++) {
				Player currentPlayer;
				
<<<<<<< HEAD
				gameBoard.playingOrder[i].toString();
				currentPlayer = gameBoard.playingOrder[i];
=======
				
			
				gameBoard.playerList[i].toString();
				currentPlayer = gameBoard.playerList[i];
>>>>>>> fb76ad32b59364a660a5dd5d25b65e4ad427496f
				System.out.println("\nBefore rolling dices: \n\n"+currentPlayer.toString()+"\n\n");
				int dice1Value=gameBoard.dice1.rollDice();
				int dice2Value=gameBoard.dice2.rollDice();
				boolean goJailStatus = gameBoard.checkDoubleCounter(currentPlayer,dice1Value,dice2Value);
				if(goJailStatus==false) {
					currentPlayer.setCurrentposition(gameBoard.getSquaresByID(11));//11-> Jail
				}else {
					int turnTotalMovement = gameBoard.dice1.getFaceValue()+gameBoard.dice2.getFaceValue();
					gameBoard.move(gameBoard,currentPlayer,turnTotalMovement);
				}
				System.out.println("\n\nAfter rolling dices: \n\n"+currentPlayer.toString());
			}
			System.out.println("\n\n");
		}
	}
}


