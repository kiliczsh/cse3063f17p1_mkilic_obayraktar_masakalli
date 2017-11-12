public class NormalSquare extends Square {
	int price;
	int owner = -1;
	
	public NormalSquare(String name, int price) {
		super(name);
		this.price = price;
	}
	
	public void setOwner(int owner) {
		this.owner = owner;
	}
	
	public int getPrice() {
		return price;
	}
	
	@Override
	public void doAction(Player player, GameBoard board) {
		player.getMoney().substractMoney(1);
		System.out.println("[Position: " + (player.getCurrentPosition()+1) + "] [Total Money: $" + player.getMoney().getMoney() + "] " + "This is a normal square with no action.");
	}
}
