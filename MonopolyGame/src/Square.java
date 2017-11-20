public abstract class Square {
	
	int price;
	String name;
	
	public Square(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract void doAction(Player player, GameBoard board);
}
