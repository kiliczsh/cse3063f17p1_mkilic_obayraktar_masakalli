public class UtilitySquare extends Square {
	int price=150;
	public UtilitySquare(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public UtilitySquare(String string, int i, int price) {
		// TODO Auto-generated constructor stub
		super(string,i,price);
	}

	public void doAction(Player player, GameBoard board) {
		int faceDice = 0;
		if(owner==null){
			System.out.println("There is no owner of "+getName()+".");
			if(player.getMoney().money >= price) {
				Dice newDice=new Dice();
				 faceDice=newDice.getFace();
				if(faceDice>=4){
					System.out.println("[Dice Value: "+faceDice+"] "+player.getName() + " buy " + getName() + " for " + price);
					board.squares[player.getCurrentPosition()].owner=player;
					player.getMoney().substractMoney(price);
				}else{
					System.out.println(player.getName() + " don't want to buy " + getName());
				}
			}else {
				System.out.println(player.getName() + " can't buy " + getName());
			}
		}else{//if there is an owner
			if(owner.getID()!=player.getID()){
				rent = 10*faceDice;
				System.out.println(player.getName() + " paid $" + rent + " rent to owner " + board.squares[player.getCurrentPosition()].owner.getName()+".");
				player.getMoney().substractMoney(rent);
				board.squares[player.getCurrentPosition()].owner.getMoney().addMoney(rent);
			}
		}
	
	System.out.println(player.getName()+": [Position: " + (player.getCurrentPosition()+1) + "] [Total Money: $" + player.getMoney().getMoney() + "] " );

	}

}
