import java.io.PrintWriter;

public class NormalSquare extends Square {

	
	public NormalSquare(String name,int squareID,int price,int rent) {
		super(name,squareID,price,rent);
	}
	

	
	public int getPrice() {
		return price;
	}
	
	@Override
	public void doAction(Player player, GameBoard board,PrintWriter printer) {
		if(owner==null){
			System.out.println("There is no owner of "+getName()+".");
			printer.write("There is no owner of "+getName()+".");
			if(player.getMoney().money >= price) {
				
				Dice newDice=new Dice();
				int faceDice=newDice.getFace();
				if(faceDice>=4){
					System.out.println("[Dice Value: "+faceDice+"] "+player.getName() + " buy " + getName() + " for " + price);
					printer.write("[Dice Value: "+faceDice+"] "+player.getName() + " buy " + getName() + " for " + price);
					board.squares[player.getCurrentPosition()].owner=player;
					player.getMoney().substractMoney(price);
				}else{
					System.out.println(player.getName() + " don't want to buy " + getName());
					printer.write(player.getName() + " don't want to buy " + getName());
				}
			}else {
				System.out.println(player.getName() + " can't buy " + getName());
				printer.write(player.getName() + " can't buy " + getName());
			}

		}else{//if there is an owner
			if(owner.getID()!=player.getID()){
				rent = price * 70 / 100;
				System.out.println(player.getName() + " paid $" + rent + " rent to owner " + board.squares[player.getCurrentPosition()].owner.getName()+".");
				printer.write(player.getName() + " paid $" + rent + " rent to owner " + board.squares[player.getCurrentPosition()].owner.getName()+".");
				player.getMoney().substractMoney(rent);
				board.squares[player.getCurrentPosition()].owner.getMoney().addMoney(rent);
			}
		}
	
	System.out.println(player.getName()+": [Position: " + (player.getCurrentPosition()+1) + "] [Total Money: $" + player.getMoney().getMoney() + "] " );
	printer.write(player.getName()+": [Position: " + (player.getCurrentPosition()+1) + "] [Total Money: $" + player.getMoney().getMoney() + "] " );

	}
}