
public class LuxuryTaxSquare extends Square {

	public LuxuryTaxSquare(String name) {
		super(name);
	}

	@Override
	public void doAction(Player player, GameBoard board) {
		int taxAmount= 75;
		player.getMoney().substractMoney(taxAmount);
		System.out.println("[Position: " + (player.getCurrentPosition()+1) + "] [Total Money: $" + player.getMoney().getMoney() + "] " + player.getName() + ", will pay " + taxAmount +" luxury tax.");
	}

}
