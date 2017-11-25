import java.io.PrintWriter;

public abstract class Square {
	
	int price=0;
	String name;
	Player owner=null;
	int squareID;
	int rent;
	
	public Square(String name) {
		this.name = name;
	}
	
	public Square(String name,int squareID) {
		this.name=name;
		this.squareID=squareID;
	}
	public Square(String name,int squareID,int price,int rent) {
		this.name=name;
		this.squareID=squareID;
		this.price=price;
		this.rent=rent;
	}
	
	public Square(String name, int squareID, int price) {
		this.name=name;
		this.squareID=squareID;
		this.price=price;
	}

	public String getName() {
		return name;
	}
	
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
	public Player getOwner() {
		return owner;
	}
	
	public abstract void doAction(Player player, GameBoard board,PrintWriter printer);
}
