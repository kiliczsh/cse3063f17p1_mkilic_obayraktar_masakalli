import java.io.PrintWriter;

public class GoSquare extends Square {
	public GoSquare(String name) {
		super(name);
	}

	public GoSquare(String string, int i) {
		super(string,i);
	}

	@Override
	public void doAction(Player player, GameBoard board,PrintWriter printer) {
		player.getMoney().addMoney(200);
		System.out.println("[Position: " + (player.getCurrentPosition()+1) + "] [Total Money: $" + player.getMoney().getMoney() + "] " + player.getName() + " is at Go... Giving $200");
		printer.write("[Position: " + (player.getCurrentPosition()+1) + "] [Total Money: $" + player.getMoney().getMoney() + "] " + player.getName() + " is at Go... Giving $200\n");
	}
}
