import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GameBoard {
	int currentTurn = 0;
	int totalPlayer = 0;
	Player[] players;
	Square[] squares = new Square[40];
	//String[] names = new String[] { "Property", "Community Chest", "Railway", "City", "Peace", "Village"};
	
	public GameBoard(int totalPlayer) {
		players = new Player[totalPlayer];
		this.totalPlayer = totalPlayer;
		for(int i = 0;i < players.length;i++){
			players[i] = new Player(i, "Player " + (i + 1));
		}
		shuffleArray(players);
		int a =1;
		System.out.println("Dice Tournament Results");
		for(Player player:players) {
			System.out.print(a+": "+player.getName()+"\n");
			a++;
		}
		System.out.println();
		Random rand = new Random();
		for(int i = 0;i < squares.length;i++){
			if(i == 0){
				squares[i] = new GoSquare("GO");
			}else if(i == 5) {
				squares[i] = new IncomeTaxSquare("Income Tax");
			}else if(i == 6) {
				squares[i] = new RailroadSquare("RailRoad1");
			}else if(i == 11){
				squares[i] = new JailSquare("Jail");
			}else if(i == 13){
				squares[i] = new UtilitySquare("ElectricUtility");
			}else if(i == 16) {
				squares[i] = new RailroadSquare("RailRoad2");
			}else if(i == 21){
				squares[i] = new FreeParkingSquare("Free Parking");
			}else if(i == 26) {
				squares[i] = new RailroadSquare("RailRoad3");
			}else if(i == 29){
				squares[i] = new UtilitySquare("WaterUtility");
			}else if(i == 31){
				squares[i] = new GoToJailSquare("Go to Jail");
			}else if(i == 36) {
				squares[i] = new RailroadSquare("RailRoad4");
			}else if(i == 39) {
				squares[i] = new LuxuryTaxSquare("Luxury Tax");
			}else{
				squares[i] = new NormalSquare("Square"+i, 400 + rand.nextInt(300));
			}
		}
	}
	
	public Square movePlayer(Player player, int face) {
		return movePlayer(player, face, true);
	}
	
	public Square movePlayer(Player player, int face, boolean count) {
		if(player.isBrokeOut() ){
			return squares[player.getCurrentPosition()]; 
		}
		int newPosition = normalizePosition(player.getCurrentPosition() + face);
		player.setPosition(newPosition);
		System.out.println("[Position: " + (player.getCurrentPosition()+1) + "] [Total Money: $" + player.getMoney().getMoney() + "] " +  player.getName() + " goes to " + squares[player.getCurrentPosition()].getName());
		squares[newPosition].doAction(player, this);
		if(player.getMoney().isBrokeOut()){
			System.out.println("\nTurn : "+(player.getTotalWalk() + 1)+ " - "+player.name+"\n");
			System.out.println("[Position: " + (player.getCurrentPosition()+1) + "] [Total Money: $" + player.getMoney().getMoney() + "] " + player.getName() + " has been broke out!");
			player.setBrokeOut(true);
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
