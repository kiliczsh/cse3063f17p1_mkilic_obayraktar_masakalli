public class FreeParkingSquare extends Square {
	public FreeParkingSquare(String name) {
		super(name);
	}
	
	@Override
	public void doAction(Player player, GameBoard gameBoard) {
		System.out.println("[Position: " + (player.getCurrentPosition()+1) + "] [Total Money: $" + player.getMoney().getMoney() + "] " + player.getName() + " has to wait at " + name + " Square");
	}
}
