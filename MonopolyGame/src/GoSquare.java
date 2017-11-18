public class GoSquare extends Square {
	public GoSquare(String name) {
		super(name);
	}
	
	@Override
	public void doAction(Player player, GameBoard board) {
		player.getMoney().addMoney(200);
		System.out.println("[Position: " + (player.getCurrentPosition()+1) + "] [Total Money: $" + player.getMoney().getMoney() + "] " + player.getName() + " is at Go... Giving $200");
	}
}