import java.io.PrintWriter;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GameBoard {
	int activePlayers;
	int currentTurn = 0;
	int totalPlayer = 0;
	Player[] players;
	Square[] squares = new Square[40];
	
	public GameBoard(int totalPlayer,int initialCash, String[][] squareInfo,PrintWriter printer) {
		activePlayers=totalPlayer;
		players = new Player[totalPlayer];
		this.totalPlayer = totalPlayer;
		for(int i = 0;i < players.length;i++){
			players[i] = new Player(i, "Player " + (i + 1));
		}
		shuffleArray(players);
		int a =1;
		System.out.println("Dice Tournament Results");
		printer.write("Dice Tournament Results\n");
		for(Player player:players) {
			System.out.print(a+": "+player.getName()+"\n");
			printer.write(a+": "+player.getName()+"\n");
			player.getMoney().setMoney(initialCash);
			a++;
		}
		System.out.println();
		for(int i = 0;i < squares.length;i++){
			if(i == 0){
				squares[i] = new GoSquare("GO",i);
			}else if(i == 5) {
				squares[i] = new IncomeTaxSquare("Income Tax",i);
			}else if(i == 6) {
				squares[i] = new RailroadSquare("RailRoad1",i,200);
			}else if(i == 11){
				squares[i] = new JailSquare("Jail",i);
			}else if(i == 13){
				squares[i] = new UtilitySquare("ElectricUtility",i,150);
			}else if(i == 16) {
				squares[i] = new RailroadSquare("RailRoad2",i,200);
			}else if(i == 21){
				squares[i] = new FreeParkingSquare("Free Parking",i);
			}else if(i == 26) {
				squares[i] = new RailroadSquare("RailRoad3",i,200);
			}else if(i == 29){
				squares[i] = new UtilitySquare("WaterUtility",i,150);
			}else if(i == 31){
				squares[i] = new GoToJailSquare("Go to Jail",i);
			}else if(i == 36) {
				squares[i] = new RailroadSquare("RailRoad4",i,200);
			}else if(i == 39) {
				squares[i] = new LuxuryTaxSquare("Luxury Tax",i);
			}else {
				for(int c=0;c<39;c++) {

					if(Objects.equals(i, squareInfo[c][0])) {
						String sName="Square"+squareInfo[i][0];
						int sPosition= Integer.parseInt(squareInfo[i][0]);
						int sPrice=Integer.parseInt(squareInfo[i][1]);
						int sRent=Integer.parseInt(squareInfo[i][2]);
						squares[i] = new NormalSquare(sName,sPosition,sPrice,sRent);
						
					}else {
						squares[i] = new NormalSquare("Square"+i,i,200,100);
					}
				}
				
			}
		}
	}
	
	public Square movePlayer(Player player, int face,PrintWriter printer) {
		return movePlayer(player, face, true,printer);
	}
	
	public Square movePlayer(Player player, int face, boolean count,PrintWriter printer) {
		if(player.isBrokeOut() ){
			return squares[player.getCurrentPosition()]; 
		}
		int newPosition = normalizePosition(player.getCurrentPosition() + face);
		player.setPosition(newPosition);
		System.out.println("[Position: " + (player.getCurrentPosition()+1) + "] [Total Money: $" + player.getMoney().getMoney() + "] " +  player.getName() + " goes to " + squares[player.getCurrentPosition()].getName());
		printer.write("[Position: " + (player.getCurrentPosition()+1) + "] [Total Money: $" + player.getMoney().getMoney() + "] " +  player.getName() + " goes to " + squares[player.getCurrentPosition()].getName()+"\n");
		squares[newPosition].doAction(player, this, printer);
		if(player.getMoney().isBrokeOut()){
			System.out.println("\nTurn : "+(player.getTotalWalk() + 1)+ " - "+player.name+"\n");
			printer.write("\nTurn : "+(player.getTotalWalk() + 1)+ " - "+player.name+"\n");
			System.out.println("[Position: " + (player.getCurrentPosition()+1) + "] [Total Money: $" + player.getMoney().getMoney() + "] " + player.getName() + " has been broke out!");
			printer.write("[Position: " + (player.getCurrentPosition()+1) + "] [Total Money: $" + player.getMoney().getMoney() + "] " + player.getName() + " has been broke out!\n");
			player.setBrokeOut(true);
			activePlayers--;
			for(int a=0;a<squares.length;a++) {// free squares of broken player
				if(squares[a].owner==null || squares[a].owner.getID()==player.getID()) {
					squares[a].owner=null;
				}
			}
		}else{
			if(count){
				player.nextTurn();
			}
		}
		return squares[newPosition];
	}
	
	public boolean hasWinner() {
		int ingame = 0;
		for(Player player:players){
			if(!player.isBrokeOut()){
				ingame++;
			}
		}
		return ingame <= 1;
	}
	
	public Player getWinner() {
		if(!hasWinner()){ return null; }
		for(Player player:players){
			if(!player.isBrokeOut()){ return player; }
		}
		return null;
	}
	
	public Player getMaxMoneyPlayer() {
		Player maxplayer = null;
		for(Player player:players){
			if(maxplayer == null || maxplayer.getMoney().getMoney() < player.getMoney().getMoney()){
				maxplayer = player;
			}
		}
		return maxplayer;
	}
	
	public int normalizePosition(int position) {
		return position % squares.length;
	}
	
	public Player getCurrentPlayer() {
		return players[currentTurn];
	}
	
	public Player[] getPlayers() {
		return players;
	}
	
	public void nextTurn() {
		if(++currentTurn >= players.length){
			currentTurn = 0;
		}
	}
	
	public Player getPlayer(int id) {
		return players[id];
	}
	
	public int getTotalSquare() {
		return squares.length;
	}
	
	public void shuffleArray(Player[] players2)
	  {
	    Random rnd = ThreadLocalRandom.current();
	    for (int i = players2.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      Player a = players2[index];
	      players2[index] = players2[i];
	      players2[i] = a;
	    }
	  }
}
