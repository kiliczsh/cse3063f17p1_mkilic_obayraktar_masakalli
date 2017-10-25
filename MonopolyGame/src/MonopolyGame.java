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
		Dice dice1 = new Dice();
		Dice dice2 = new Dice();
		//get number of players from user 
		getNumberOfPlayer(input, MAX_PLAYER, MIN_PLAYER);
		
		createPlayers(numOfPlayers);
		
		
	}
	




	@SuppressWarnings({ "unchecked", "rawtypes", "resource" })
	public static ArrayList createPlayers(int numOfPlayers) {
		
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
					line=scan.nextLine();
				}
					playerName=line;
				Player player= new Player(id,playerName);
				playerList.add(player);
			}
		return playerList;
		
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
