public class GoToJailSquare extends Square {
	public GoToJailSquare(String name) {
		super(name);
	}
	
	public GoToJailSquare(String string, int i) {
		// TODO Auto-generated constructor stub
		super(string,i);
	}

	@Override
	public void doAction(Player player, GameBoard board) {
		player.setPosition(11);
		System.out.println("[Position: " + (player.getCurrentPosition()+1) + "] [Total Money: $" + player.getMoney().getMoney() + "] " + player.getName() + " is in Jail");
	}
}
