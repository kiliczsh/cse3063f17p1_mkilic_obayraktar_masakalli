import java.util.Scanner;

public class Monopoly {
	Dice die1 = new Dice();
	Dice die2 = new Dice();
	GameBoard gameBoard;
	
	public Monopoly(int totalPlayer) {
		gameBoard = new GameBoard(totalPlayer);
	}
	
	public static void main(String[] args) {
		System.out.println("\tMonopoly\n");
		Scanner scanner = new Scanner(System.in);
		int totalPlayer = 0;
		int turnNumber = 10;
		while (totalPlayer < 2 || totalPlayer > 8) {
			try {
				System.out.println("How many people are playing?");
				System.out.print("Players (2 - 8): ");
				totalPlayer = scanner.nextInt();
				System.out.println("Enter number of turns you want to simulate:");
				turnNumber = scanner.nextInt();
				
				
				if(!(turnNumber>=1 && turnNumber<=100)) {
					turnNumber=10;
				}
				System.out.println(turnNumber+" turns will be simulated...");
			}
			catch(Exception e) {
				System.err.println("Error: Number too large.");
				continue;
			}
			if(totalPlayer > 8) {
				System.err.println("Error: Invalid player count.");
			}
		}
		scanner.close();
		Monopoly game = new Monopoly(totalPlayer);
		game.startGame(turnNumber);
	}
	
	public void startGame(int turnNumber) {
		System.out.println("----------");
		
		while (!isGameEnd(turnNumber) && !gameBoard.hasWinner()){
			if(!gameBoard.getCurrentPlayer().isBrokeOut()){
				int face = gameBoard.getCurrentPlayer().tossDie(die1,die2);
				if(gameBoard.getCurrentPlayer().doubleCounter >= 3) {
					System.out.println("\nTurn : "+(gameBoard.getCurrentPlayer().getTotalWalk() + 1)+ " - "+gameBoard.getCurrentPlayer().name+"\n");
					System.out.println("[Position: " + (gameBoard.getCurrentPlayer().getCurrentPosition()+1) + "] [Total Money: $" + gameBoard.getCurrentPlayer().getMoney().getMoney() + "] " + gameBoard.getCurrentPlayer().getName() + " rolled double 3 times.");
					gameBoard.getCurrentPlayer().setPosition(11);
					gameBoard.getCurrentPlayer().doubleCounter=0;
					System.out.println("[Position: " + (gameBoard.getCurrentPlayer().getCurrentPosition()+1) + "] [Total Money: $" + gameBoard.getCurrentPlayer().getMoney().getMoney() + "] " + gameBoard.getCurrentPlayer().getName() + " is in Jail now.");
				
				
				}else {
					gameBoard.movePlayer(gameBoard.getCurrentPlayer(), face);
				}
				
			}
			gameBoard.nextTurn();
		}
		System.out.println("----------");
		if(gameBoard.hasWinner()){
			System.out.println(gameBoard.getWinner().getName() + " is won by don't brokeout!");
		}else{
			System.out.println(gameBoard.getMaxMoneyPlayer().getName() + " is won by have most money!");
		}
		System.out.println("Game over!");
	}
	
	public boolean isGameEnd(int turnNumber) {
		for(Player player:gameBoard.getPlayers()){
			if(player.getTotalWalk() < turnNumber){ return false; }
		}
		return true;
	}
}
