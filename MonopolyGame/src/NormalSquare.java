import java.util.Random;

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
		//player.getMoney().substractMoney(1);
		System.out.println("[Position: " + (player.getCurrentPosition()+1) + "] [Total Money: $" + player.getMoney().getMoney() + "] " + "This is a normal square with no action.");
		
		if(owner < 0){
			//Util.print(player, player.getName() + ", do you want to buy " + getName() + "?");
			System.out.println(player.getName() + ", do you want to buy " + getName() + "?");
			Random rand = new Random();
			if(rand.nextBoolean()){
				//Util.print(player, player.getName() + " buy " + getName() + " for " + price);
				System.out.println(player.getName() + " buy " + getName() + " for " + price);
				owner = player.getID();
				player.getMoney().substractMoney(price);
			}else{
				//Util.print(player, player.getName() + " don't want to buy " + getName());
				System.out.println(player.getName() + " don't want to buy " + getName());
			}
		}else{
			if(owner != player.getID()){
				int lost = price * 70 / 100;
				//Util.print(player, player.getName() + " lost " + lost + " money to " + board.getPlayer(owner).getName());
				System.out.println(player.getName() + " lost " + lost + " money to " + board.getPlayer(owner).getName());
				player.getMoney().substractMoney(lost);
				board.getPlayer(owner).getMoney().addMoney(lost);
			}
		}
	}
}
