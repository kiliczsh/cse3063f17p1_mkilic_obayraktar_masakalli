public class IncomeTaxSquare extends Square {

	public IncomeTaxSquare(String name) {
		super(name);
	}

	@Override
	public void doAction(Player player, GameBoard board) {
		int taxAmount=(int)((player.playerMoney.getMoney()/100)*10);
		player.getMoney().substractMoney(taxAmount);
		System.out.println("[Position: " + (player.getCurrentPosition()+1) + "] [Total Money: $" + player.getMoney().getMoney() + "] " + player.getName() + ", will pay " + taxAmount +" income tax.");
	}

}
