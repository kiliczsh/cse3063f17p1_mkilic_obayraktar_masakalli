import java.io.PrintWriter;

public class IncomeTaxSquare extends Square {

	public IncomeTaxSquare(String name) {
		super(name);
	}

	public IncomeTaxSquare(String string, int i) {
		super(string,i);
	}

	@Override
	public void doAction(Player player, GameBoard board,PrintWriter printer) {
		int taxAmount=(int)((player.playerMoney.getMoney()/100)*10);
		player.getMoney().substractMoney(taxAmount);
		System.out.println("[Position: " + (player.getCurrentPosition()+1) + "] [Total Money: $" + player.getMoney().getMoney() + "] " + player.getName() + ", will pay " + taxAmount +" income tax.");
		printer.write("[Position: " + (player.getCurrentPosition()+1) + "] [Total Money: $" + player.getMoney().getMoney() + "] " + player.getName() + ", will pay " + taxAmount +" income tax.\n");
	}

}
