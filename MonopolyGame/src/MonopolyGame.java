
public class MonopolyGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Object Oriented");
		Dice dice1 = new Dice();
		Dice dice2 = new Dice();
		dice1.rollDice();
		dice2.rollDice();
		System.out.println(""+dice1.toString());
		System.out.println(""+dice2.toString());
		
	}

}
