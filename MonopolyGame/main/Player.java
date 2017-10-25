import java.util.Arrays;

/**
 * @author 
 *
 */
public class Player {
	String playerName;
	String color[];
	boolean inJail=false;
	int money;
	Square position;


	public Player() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the playerName
	 */
	public String getPlayerName() {
		return playerName;
	}


	/**
	 * @param playerName the playerName to set
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}


	/**
	 * @return the color
	 */
	public String[] getColor() {
		return color;
	}


	/**
	 * @param color the color to set
	 */
	public void setColor(String[] color) {
		this.color = color;
	}


	/**
	 * @return the inJail
	 */
	public boolean isInJail() {
		return inJail;
	}


	/**
	 * @param inJail the inJail to set
	 */
	public void setInJail(boolean inJail) {
		this.inJail = inJail;
	}


	/**
	 * @return the money
	 */
	public int getMoney() {
		return money;
	}


	/**
	 * @param money the money to set
	 */
	public void setMoney(int money) {
		this.money = money;
	}


	/**
	 * @return the position
	 */
	public Square getPosition() {
		return position;
	}


	/**
	 * @param position the position to set
	 */
	public void setPosition(Square position) {
		this.position = position;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Player [playerName=" + playerName + ", color=" + Arrays.toString(color) + ", inJail=" + inJail
				+ ", money=" + money + ", position=" + position + ", getPlayerName()=" + getPlayerName()
				+ ", getColor()=" + Arrays.toString(getColor()) + ", isInJail()=" + isInJail() + ", getMoney()="
				+ getMoney() + ", getPosition()=" + getPosition() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
