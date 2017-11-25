import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Monopoly {
	Dice die1 = new Dice();
	Dice die2 = new Dice();
	//static String toFile="";
	GameBoard gameBoard;
	int activePlayers;
	public Monopoly(int totalPlayer,int initialCash, String[][] squareInfo,PrintWriter printer) {
		gameBoard = new GameBoard(totalPlayer,initialCash,squareInfo,printer);
	}
	
	public static void main(String[] args) throws IOException {
		String[][] squareInfo;
		//File I/O part
		
		  List<String> lines = new ArrayList<String>(); 
		  File inputFile = new File("Monopoly-Lots.csv");
		  File outputFile = new File("monopoly-output.txt");
		  PrintWriter printer = new PrintWriter(outputFile);
		  printer.write("Hello");
		  
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
		printer.write("\tMonopoly\n");    
		Scanner scanner = new Scanner(System.in);
		int totalPlayer = 0;
		int initialCash=5000;
		while (totalPlayer < 2 || totalPlayer > 8) {
			try {
				System.out.println("How many people are playing?");
				printer.write("How many people are playing?\n");
				System.out.print("Players (2 - 8): ");
				printer.write("Players (2 - 8): ");
				totalPlayer = scanner.nextInt();
				printer.write(""+totalPlayer+"\n");
				System.out.println("Enter initial cash value: ");
				printer.write("Enter initial cash value: ");
				initialCash=scanner.nextInt();
				printer.write(" $"+initialCash+"\n");
			}
			catch(Exception e) {
				System.err.println("Error: Number too large.");
				printer.write("Error: Number too large.");
				continue;
			}
			if(totalPlayer > 8) {
				System.err.println("Error: Invalid player count.");
				printer.write("Error: Invalid player count.");
			}
		}
		scanner.close();
		Monopoly game = new Monopoly(totalPlayer,initialCash,squareInfo,printer);
		game.startGame(totalPlayer,printer);
		printer.flush();
	}
	
	public void startGame(int totalPlayer,PrintWriter printer) {
		System.out.println("----------");
		printer.write("----------\n");
		activePlayers=totalPlayer;
		while (!isGameEnd(activePlayers) && !gameBoard.hasWinner()){
			if(!gameBoard.getCurrentPlayer().isBrokeOut()){
				int face = gameBoard.getCurrentPlayer().tossDie(die1,die2,printer);
				if(gameBoard.getCurrentPlayer().doubleCounter >= 3) {
					System.out.println("\nTurn : "+(gameBoard.getCurrentPlayer().getTotalWalk() + 1)+ " - "+gameBoard.getCurrentPlayer().name+"\n");
					printer.write("\nTurn : "+(gameBoard.getCurrentPlayer().getTotalWalk() + 1)+ " - "+gameBoard.getCurrentPlayer().name+"\n");
					System.out.println("[Position #: " + (gameBoard.getCurrentPlayer().getCurrentPosition()+1) + "] [Total Money: $" + gameBoard.getCurrentPlayer().getMoney().getMoney() + "] " + gameBoard.getCurrentPlayer().getName() + " rolled double 3 times.");
					printer.write("[Position #: " + (gameBoard.getCurrentPlayer().getCurrentPosition()+1) + "] [Total Money: $" + gameBoard.getCurrentPlayer().getMoney().getMoney() + "] " + gameBoard.getCurrentPlayer().getName() + " rolled double 3 times.\n");
					gameBoard.getCurrentPlayer().setPosition(11);
					gameBoard.getCurrentPlayer().doubleCounter=0;
					System.out.println("[Position #: " + (gameBoard.getCurrentPlayer().getCurrentPosition()+1) + "] [Total Money: $" + gameBoard.getCurrentPlayer().getMoney().getMoney() + "] " + gameBoard.getCurrentPlayer().getName() + " is in Jail now.");
					printer.write("[Position #: " + (gameBoard.getCurrentPlayer().getCurrentPosition()+1) + "] [Total Money: $" + gameBoard.getCurrentPlayer().getMoney().getMoney() + "] " + gameBoard.getCurrentPlayer().getName() + " is in Jail now.\n");
				
				}else {
					gameBoard.movePlayer(gameBoard.getCurrentPlayer(), face,printer);
				}
				
			}
			gameBoard.nextTurn();
		}
		System.out.println("----------");
		if(gameBoard.hasWinner()){
			System.out.println(gameBoard.getWinner().getName() + " is won by don't brokeout!");
			printer.write(gameBoard.getWinner().getName() + " is won by don't brokeout!\n");
		}else{
			System.out.println(gameBoard.getMaxMoneyPlayer().getName() + " is won by have most money!");
			printer.write(gameBoard.getMaxMoneyPlayer().getName() + " is won by have most money!\n");
		}
		System.out.println("Game over!");
		printer.write("Game over!\n");
	}
	
	public boolean isGameEnd(int activePlayers) {
			if(1 <= activePlayers){ return false; }
		return true;
	}
}
