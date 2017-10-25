public class MonopolyGame {
	//main method
	public static void main(String[] args) {
		GameBoard gameBoard=new GameBoard();
		startGame(gameBoard);
	}
	public static void startGame(GameBoard gameBoard) {
		GameBoard.numOfPlayers=gameBoard.getNumberOfPlayer(gameBoard.input, gameBoard.MAX_PLAYER, gameBoard.MIN_PLAYER);
		for(int turn=1;turn<=5;turn++) {
			System.out.println("This is "+turn+". Round.\n\n\n");
			for(int i=0;i<GameBoard.numOfPlayers;i++) {
				Player currentPlayer;
				gameBoard.playerList[1].toString();//GameBoard line:87 createPlayers metodunda hata var
				currentPlayer = gameBoard.playerList[i];
				System.out.println("\nBefore rolling dices: \n\n"+currentPlayer.toString()+"\n\n");
				int dice1Value=gameBoard.dice1.rollDice();
				int dice2Value=gameBoard.dice2.rollDice();
				boolean goJailStatus = gameBoard.checkDoubleCounter(currentPlayer,dice1Value,dice2Value);
				if(goJailStatus==false) {
					currentPlayer.setCurrentposition(gameBoard.jail);
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