import java.io.PrintWriter;

public class JailSquare extends Square {
	public JailSquare(String name) {
		super(name);
	}
	
	public JailSquare(String string, int i) {
		// TODO Auto-generated constructor stub
		super(string,i);
	}

	@Override
	public void doAction(Player player, GameBoard board,PrintWriter printer) {
		player.getMoney().substractMoney(500);
		System.out.println("[Position: " + (player.getCurrentPosition()+1) + "] [Total Money: $" + player.getMoney().getMoney() + "] " + player.getName() + " has been Jail and lost 500 money");
		printer.write("[Position: " + (player.getCurrentPosition()+1) + "] [Total Money: $" + player.getMoney().getMoney() + "] " + player.getName() + " has been Jail and lost 500 money\n");
	}
}
