public class IncomeTaxSquare extends Square {

	public IncomeTaxSquare(String name) {
		super(name);
	}

	public IncomeTaxSquare(String string, int i) {
		// TODO Auto-generated constructor stub
		super(string,i);
	}

	@Override
	public void doAction(Player player, GameBoard board) {
		int taxAmount=(int)((player.playerMoney.getMoney()/100)*10);
		player.getMoney().substractMoney(taxAmount);
		System.out.println("[Position: " + (player.getCurrentPosition()+1) + "] [Total Money: $" + player.getMoney().getMoney() + "] " + player.getName() + ", will pay " + taxAmount +" income tax.");
	}

}
