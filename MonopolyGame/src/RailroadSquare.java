import java.io.PrintWriter;

public class RailroadSquare extends Square {
	int price=200;
	public RailroadSquare(String name) {
		super(name);

	}

	public RailroadSquare(String string, int i, int price) {
		// TODO Auto-generated constructor stub
		super(string,i,price);
	}

	public void doAction(Player player, GameBoard board,PrintWriter printer) {
		int faceDice = 0;
		if(owner==null){
			System.out.println("There is no owner of "+getName()+".");
			printer.write("There is no owner of "+getName()+".\n");
			if(player.getMoney().money >= price) {
				Dice newDice=new Dice();
				 faceDice=newDice.getFace();
				if(faceDice>=4){
					System.out.println("[Dice Value: "+faceDice+"] "+player.getName() + " buy " + getName() + " for " + price);
					printer.write("[Dice Value: "+faceDice+"] "+player.getName() + " buy " + getName() + " for " + price+"\n");
					board.squares[player.getCurrentPosition()].owner=player;
					player.getMoney().substractMoney(price);
				}else{
					System.out.println(player.getName() + " don't want to buy " + getName());
					printer.write(player.getName() + " don't want to buy " + getName()+"\n");
				}
			}else {
				System.out.println(player.getName() + " can't buy " + getName());
				printer.write(player.getName() + " can't buy " + getName()+"\n");
			}
		}else{//if there is an owner
			if(owner.getID()!=player.getID()){
				rent =(5* faceDice)+25;
				System.out.println(player.getName() + " paid $" + rent + " rent to owner " + board.squares[player.getCurrentPosition()].owner.getName()+".");
				printer.write(player.getName() + " paid $" + rent + " rent to owner " + board.squares[player.getCurrentPosition()].owner.getName()+".\n");
				player.getMoney().substractMoney(rent);
				board.squares[player.getCurrentPosition()].owner.getMoney().addMoney(rent);
			}
		}
	
	System.out.println(player.getName()+": [Position: " + (player.getCurrentPosition()+1) + "] [Total Money: $" + player.getMoney().getMoney() + "] " );
	printer.write(player.getName()+": [Position: " + (player.getCurrentPosition()+1) + "] [Total Money: $" + player.getMoney().getMoney() + "] \n" );
	}

	}


