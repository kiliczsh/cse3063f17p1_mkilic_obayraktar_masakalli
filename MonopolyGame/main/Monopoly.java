import java.util.Arrays;

/**
 * 
 */

/**
 * @author 
 *
 */
public class Monopoly {

	//Variables
	final int MAX_PLAYER=8;
	Dice dice;
	Player players[];
	int gameTurn=0;
	
	public Monopoly() {

	}


	public static void main(String[] args) {


	}


	/**
	 * @return the dice
	 */
	public Dice getDice() {
		return dice;
	}


	/**
	 * @param dice the dice to set
	 */
	public void setDice(Dice dice) {
		this.dice = dice;
	}


	/**
	 * @return the players
	 */
	public Player[] getPlayers() {
		return players;
	}


	/**
	 * @param players the players to set
	 */
	public void setPlayers(Player[] players) {
		this.players = players;
	}


	/**
	 * @return the gameTurn
	 */
	public int getGameTurn() {
		return gameTurn;
	}


	/**
	 * @param gameTurn the gameTurn to set
	 */
	public void setGameTurn(int gameTurn) {
		this.gameTurn = gameTurn;
	}


	/**
	 * @return the mAX_PLAYER
	 */
	public int getMAX_PLAYER() {
		return MAX_PLAYER;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Monopoly [MAX_PLAYER=" + MAX_PLAYER + ", dice=" + dice + ", players=" + Arrays.toString(players)
				+ ", gameTurn=" + gameTurn + ", getDice()=" + getDice() + ", getPlayers()="
				+ Arrays.toString(getPlayers()) + ", getGameTurn()=" + getGameTurn() + ", getMAX_PLAYER()="
				+ getMAX_PLAYER() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
