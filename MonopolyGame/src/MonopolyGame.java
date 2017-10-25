import java.util.Scanner;

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
		
		createPlayers(input,numOfPlayers,playerList);
		
		
	}
	



	private static Player[] createPlayers(Scanner input,int numOfPlayers) {
		// TODO Auto-generated method stub
		int createdPlayerNumber=0;
		while(createdPlayerNumber<numOfPlayers){
			System.out.println("Enter name of "+(createdPlayerNumber+1)+". Player: ");
			String playerName=input.nextLine();
			input.close();

			
			//Player playerList2[0]= new Player();
			
			
			
			createdPlayerNumber++;
			return playerList2;
		}
		
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
