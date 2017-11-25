import java.io.PrintWriter;

public class GoToJailSquare extends Square {
	public GoToJailSquare(String name) {
		super(name);
	}
	
	public GoToJailSquare(String string, int i) {
		super(string,i);
	}

	@Override
	public void doAction(Player player, GameBoard board,PrintWriter printer) {
		player.setPosition(11);
		System.out.println("[Position: " + (player.getCurrentPosition()+1) + "] [Total Money: $" + player.getMoney().getMoney() + "] " + player.getName() + " is in Jail");
		printer.write("[Position: " + (player.getCurrentPosition()+1) + "] [Total Money: $" + player.getMoney().getMoney() + "] " + player.getName() + " is in Jail\n");
	}
}
