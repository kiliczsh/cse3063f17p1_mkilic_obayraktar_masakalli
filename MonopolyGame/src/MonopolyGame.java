import java.util.Scanner;
public class MonopolyGame {
	//main method
	public static String playerNames[];
	//Main Method
	public static void main(String[] args) {
		
		GameBoard gameBoard = new GameBoard();
		final int MAX_PLAYER=8;
		final int MIN_PLAYER=2;
		Scanner input= new Scanner(System.in);
		int numberOfPlayers = 0;
		//Take Number of Players
		System.out.print("Enter number of players(2~8): ");
		if(input.hasNextInt()) {
		    numberOfPlayers = input.nextInt();
		    if (numberOfPlayers<=MAX_PLAYER && numberOfPlayers>=MIN_PLAYER) {
		    	System.out.println(numberOfPlayers+" players will be on this game.");		    	
		    	
		    }else {
		    	System.out.println("No way you don't deserve to play. First learn Math.");
		    }
		}else {
			System.out.println("No way you don't deserve to play. First learn Math.");
		}
		playerNames = new String[numberOfPlayers];
		for(int i=0;i<numberOfPlayers;i++) {
			System.out.print("Please enter the name of player"+(i+1)+":  ");
			playerNames[i] = input.next();
			gameBoard.playerList[i].setPlayerName(playerNames[i]);
        }
		System.out.println("Game will start soon...");
		gameBoard.numOfPlayers = numberOfPlayers;
		System.out.println("Enter number of iterations:");
		int iterationNumber= input.nextInt();
		startGame(gameBoard,iterationNumber);
	}
	//starting game
	public static void startGame(GameBoard gameBoard,int iterationNumber) {

		for(int turn=1;turn<=iterationNumber;turn++) {
			System.out.println("This is "+turn+". Round.\n\n\n");
			for(int i=0;i<gameBoard.numOfPlayers;i++) {
				Player currentPlayer;
				gameBoard.playingOrder[i].toString();
				currentPlayer = gameBoard.playingOrder[i];
				gameBoard.playerList[i].toString();
				currentPlayer = gameBoard.playerList[i];
				System.out.println("\nBefore rolling dices: \n\n"+currentPlayer.toString()+"\n\n");
				if(currentPlayer.isInJail==true) {//in Jail
					System.out.println(currentPlayer.getPlayerName()+" is in Jail. Do you want to pay fine? (Type Yes): ");
					Scanner answersc= new Scanner(System.in);
					String answer= answersc.nextLine();
					if(answer.equalsIgnoreCase("Yes")) {
						currentPlayer.decreaseMoney(50);
						int dice1Value=gameBoard.dice1.rollDice();
						int dice2Value=gameBoard.dice2.rollDice();
						System.out.println("{Dice 1 Value: "+dice1Value+" - Dice 2 Value: "+dice2Value+ "} [Dice Total: "+(dice1Value+dice2Value)+"]");
						boolean goJailStatus = gameBoard.checkDoubleCounter(currentPlayer,dice1Value,dice2Value);
						if(goJailStatus==false) {
							currentPlayer.setCurrentposition(gameBoard.getSquaresByID(11));//11-> Jail
						}else {
							int turnTotalMovement = gameBoard.dice1.getFaceValue()+gameBoard.dice2.getFaceValue();
							gameBoard.move(gameBoard,currentPlayer,turnTotalMovement);
						}
						currentPlayer.checkGo();
						currentPlayer.checkJail();
						
					}else {
						int dice1Value=gameBoard.dice1.rollDice();
						int dice2Value=gameBoard.dice2.rollDice();
						boolean flag=false;
						int jailDiceCounter=1;
						while(!flag && jailDiceCounter <=3) {
							flag = (dice1Value==dice2Value);
							if(flag) {
								System.out.println("{Dice 1 Value: "+dice1Value+" - Dice 2 Value: "+dice2Value+ "} [Dice Total: "+(dice1Value+dice2Value)+"]");
								boolean goJailStatus = gameBoard.checkDoubleCounter(currentPlayer,dice1Value,dice2Value);
								if(goJailStatus==false) {
									currentPlayer.setCurrentposition(gameBoard.getSquaresByID(11));//11-> Jail
								}else {
									int turnTotalMovement = gameBoard.dice1.getFaceValue()+gameBoard.dice2.getFaceValue();
									gameBoard.move(gameBoard,currentPlayer,turnTotalMovement);
								}
								currentPlayer.checkGo();
								currentPlayer.checkJail();
							}else {
								dice1Value=gameBoard.dice1.rollDice();
								dice2Value=gameBoard.dice2.rollDice();
								System.out.println("{Dice 1 Value: "+dice1Value+" - Dice 2 Value: "+dice2Value+ "} [Dice Total: "+(dice1Value+dice2Value)+"]");
								jailDiceCounter++;
							}
						}
						if(jailDiceCounter>3) {
							System.out.println("Still in Jail...");
						}
						System.out.println("\n\n**After rolling dices: \n\n"+currentPlayer.toString());
					}
				
				
				
				}else {//not in Jail
					
					if( currentPlayer.getCurrentposition().getSquareID()==gameBoard.squareList[39].getSquareID() ) {
						currentPlayer.payTax();
					}else if(currentPlayer.getCurrentposition().getSquareID()==gameBoard.squareList[5].getSquareID()) {
						currentPlayer.payTax();
					}else {
						System.out.println("Nothing");
					}
					
					int dice1Value=gameBoard.dice1.rollDice();
					int dice2Value=gameBoard.dice2.rollDice();
					System.out.println("{Dice 1 Value: "+dice1Value+" - Dice 2 Value: "+dice2Value+ "} [Dice Total: "+(dice1Value+dice2Value)+"]");
					boolean goJailStatus = gameBoard.checkDoubleCounter(currentPlayer,dice1Value,dice2Value);
					if(goJailStatus==false) {
						currentPlayer.setCurrentposition(gameBoard.getSquaresByID(11));//11-> Jail
					}else {
						int turnTotalMovement = gameBoard.dice1.getFaceValue()+gameBoard.dice2.getFaceValue();
						gameBoard.move(gameBoard,currentPlayer,turnTotalMovement);
					}
					currentPlayer.checkGo();
					currentPlayer.checkJail();
				}
				
				System.out.println("\n\n***After rolling dices: \n\n"+currentPlayer.toString());
			}
			System.out.println("\n\n");
		}
	}
}