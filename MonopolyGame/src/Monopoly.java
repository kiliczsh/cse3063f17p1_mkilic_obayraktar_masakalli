import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Monopoly {
	Dice die1 = new Dice();
	Dice die2 = new Dice();
	static String toFile="";
	GameBoard gameBoard;
	int activePlayers;
	public Monopoly(int totalPlayer,int initialCash, String[][] squareInfo) {
		gameBoard = new GameBoard(totalPlayer,initialCash,squareInfo);
	}
	
	public static void main(String[] args) throws IOException {
		String[][] squareInfo;
		//File I/O part
		
		  List<String> lines = new ArrayList<String>(); 
		  File inputFile = new File("input.txt");
		  File outputFile = new File("monopoly-output.txt");
		    if(inputFile.exists()){
		        try {
		            lines = Files.readAllLines(inputFile.toPath(),Charset.defaultCharset());
		        } catch (IOException ex) {
		            ex.printStackTrace();
		        }
		      if(lines.isEmpty())
		          return;
		    }
		    //Files.write(outputFile.toPath(), toFile.getBytes());
		    squareInfo = new String[40][3];
			String[] lineArray = new String[lines.size()];
			lineArray= lines.toArray(lineArray);
			String row[]=new String[lines.size()];
			String squareElements[]=new String[3];
		    for(int a=0;a<lines.size();a++) {
		    	row[a]=lines.get(a);
				squareElements=row[a].split(",");
				for(int b=0;b<squareElements.length;b++) {
					if(a==Integer.parseInt(squareElements[0])) {
						squareInfo[a][b]=squareElements[b];
					}else {
						squareInfo[a][b]=null;
					}
					
				}
		    }
			
		    
		
		System.out.println("\tMonopoly\n");
		toFile=toFile.concat("\tMonopoly\n");    
		Scanner scanner = new Scanner(System.in);
		int totalPlayer = 0;
		int initialCash=5000;
		while (totalPlayer < 2 || totalPlayer > 8) {
			try {
				System.out.println("How many people are playing?");
				//toFile=toFile.concat("How many people are playing?\n");
				System.out.print("Players (2 - 8): ");
				//toFile=toFile.concat("Players (2 - 8): ");
				totalPlayer = scanner.nextInt();
				//toFile=toFile.concat(""+totalPlayer+"\n");
				System.out.println("Enter initial cash value: ");
				//toFile=toFile.concat("Enter initial cash value: ");
				initialCash=scanner.nextInt();
				//toFile=toFile.concat(" $"+initialCash+"\n");
			}
			catch(Exception e) {
				System.err.println("Error: Number too large.");
				//toFile=toFile.concat("Error: Number too large.");
				continue;
			}
			if(totalPlayer > 8) {
				System.err.println("Error: Invalid player count.");
				//toFile=toFile.concat("Error: Invalid player count.");
			}
		}
		scanner.close();
		Monopoly game = new Monopoly(totalPlayer,initialCash,squareInfo);
		game.startGame(totalPlayer);
	}
	
	public void startGame(int totalPlayer) {
		System.out.println("----------");
		//toFile=toFile.concat("----------");
		activePlayers=totalPlayer;
		while (!isGameEnd(activePlayers) && !gameBoard.hasWinner()){
			if(!gameBoard.getCurrentPlayer().isBrokeOut()){
				int face = gameBoard.getCurrentPlayer().tossDie(die1,die2);
				if(gameBoard.getCurrentPlayer().doubleCounter >= 3) {
					System.out.println("\nTurn : "+(gameBoard.getCurrentPlayer().getTotalWalk() + 1)+ " - "+gameBoard.getCurrentPlayer().name+"\n");
					//toFile=toFile.concat("\nTurn : "+(gameBoard.getCurrentPlayer().getTotalWalk() + 1)+ " - "+gameBoard.getCurrentPlayer().name+"\n");
					System.out.println("[Position #: " + (gameBoard.getCurrentPlayer().getCurrentPosition()+1) + "] [Total Money: $" + gameBoard.getCurrentPlayer().getMoney().getMoney() + "] " + gameBoard.getCurrentPlayer().getName() + " rolled double 3 times.");
					//toFile=toFile.concat("[Position #: " + (gameBoard.getCurrentPlayer().getCurrentPosition()+1) + "] [Total Money: $" + gameBoard.getCurrentPlayer().getMoney().getMoney() + "] " + gameBoard.getCurrentPlayer().getName() + " rolled double 3 times.");
					gameBoard.getCurrentPlayer().setPosition(11);
					gameBoard.getCurrentPlayer().doubleCounter=0;
					System.out.println("[Position #: " + (gameBoard.getCurrentPlayer().getCurrentPosition()+1) + "] [Total Money: $" + gameBoard.getCurrentPlayer().getMoney().getMoney() + "] " + gameBoard.getCurrentPlayer().getName() + " is in Jail now.");
					//toFile=toFile.concat("[Position #: " + (gameBoard.getCurrentPlayer().getCurrentPosition()+1) + "] [Total Money: $" + gameBoard.getCurrentPlayer().getMoney().getMoney() + "] " + gameBoard.getCurrentPlayer().getName() + " is in Jail now.");
				
				}else {
					gameBoard.movePlayer(gameBoard.getCurrentPlayer(), face);
				}
				
			}
			gameBoard.nextTurn();
		}
		System.out.println("----------");
		if(gameBoard.hasWinner()){
			System.out.println(gameBoard.getWinner().getName() + " is won by don't brokeout!");
			//toFile=toFile.concat(gameBoard.getWinner().getName() + " is won by don't brokeout!");
		}else{
			System.out.println(gameBoard.getMaxMoneyPlayer().getName() + " is won by have most money!");
			//toFile=toFile.concat(gameBoard.getMaxMoneyPlayer().getName() + " is won by have most money!");
		}
		System.out.println("Game over!");
		//toFile=toFile.concat("Game over!");
	}
	
	public boolean isGameEnd(int activePlayers) {
			if(1 <= activePlayers){ return false; }
		return true;
	}
}
