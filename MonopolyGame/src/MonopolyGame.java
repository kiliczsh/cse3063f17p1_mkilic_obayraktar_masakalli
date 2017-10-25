public class MonopolyGame {
	//main method
	public static void main(String[] args) {
		GameBoard gameBoard=new GameBoard();
		startGame(gameBoard);
	}
	public static void startGame(GameBoard gameBoard) {
		gameBoard.numOfPlayers=gameBoard.getNumberOfPlayer(gameBoard.input, gameBoard.MAX_PLAYER, gameBoard.MIN_PLAYER);
		for(int turn=1;turn<=5;turn++) {
			for(int i=0;i<3;i++) {
				Player currentPlayer = gameBoard.playerList[i];
				currentPlayer.toString();
				gameBoard.dice1.rollDice();
				gameBoard.dice2.rollDice();
				boolean goJailStatus = gameBoard.checkDoubleCounter(currentPlayer, gameBoard.dice1,gameBoard.dice2);
				if(goJailStatus==false) {
					currentPlayer.setCurrentposition(gameBoard.jail);
					currentPlayer.toString();
				}else {
					int turnTotalMovement = gameBoard.dice1.getFaceValue()+gameBoard.dice2.getFaceValue();
					gameBoard.move(gameBoard,currentPlayer,turnTotalMovement);
					currentPlayer.toString();
				}
			}
		}
	}
}