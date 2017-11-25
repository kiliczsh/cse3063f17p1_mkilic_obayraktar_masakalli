import java.io.PrintWriter;

public class FreeParkingSquare extends Square {
	public FreeParkingSquare(String name) {
		super(name);
	}
	
	public FreeParkingSquare(String string, int i) {
		// TODO Auto-generated constructor stub
		super(string,i);
	}

	@Override
	public void doAction(Player player, GameBoard gameBoard,PrintWriter printer) {
		System.out.println("[Position: " + (player.getCurrentPosition()+1) + "] [Total Money: $" + player.getMoney().getMoney() + "] " + player.getName() + " has to wait at " + name + " Square");
		printer.write("[Position: " + (player.getCurrentPosition()+1) + "] [Total Money: $" + player.getMoney().getMoney() + "] " + player.getName() + " has to wait at " + name + " Square.\n");
	}
}
