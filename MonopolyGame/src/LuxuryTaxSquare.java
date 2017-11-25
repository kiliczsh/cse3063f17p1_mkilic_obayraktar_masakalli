import java.io.PrintWriter;

public class LuxuryTaxSquare extends Square {

	public LuxuryTaxSquare(String name) {
		super(name);
	}

	public LuxuryTaxSquare(String string, int i) {
		// TODO Auto-generated constructor stub
		super(string,i);
	}

	@Override
	public void doAction(Player player, GameBoard board,PrintWriter printer) {
		int taxAmount= 75;
		player.getMoney().substractMoney(taxAmount);
		System.out.println("[Position: " + (player.getCurrentPosition()+1) + "] [Total Money: $" + player.getMoney().getMoney() + "] " + player.getName() + ", will pay " + taxAmount +" luxury tax.");
		printer.write("[Position: " + (player.getCurrentPosition()+1) + "] [Total Money: $" + player.getMoney().getMoney() + "] " + player.getName() + ", will pay " + taxAmount +" luxury tax.\n");
	}

}
