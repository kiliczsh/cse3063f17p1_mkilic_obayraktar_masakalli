
public class Money {
 private int initialAmount;
 private int salaryAmount;
 
 public Money() {
	 
 }
 
 void increaseMoney(Money wage,Player player) {
	 player.money += wage;
 }
 
 void decreaseMoney(Money wage, Player player) {
	 player.money -= wage;
 }
 
 public String toString() {
	 return "New value of money of " + player + " is: " + player.money;
 }
}
