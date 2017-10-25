
public class Player {
	private	int id;
	int doubleCounter;
	private	String playercolor;
	private	Square currentposition;
	private	Money money;
		
		/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the playercolor
	 */
	public String getPlayercolor() {
		return playercolor;
	}

	/**
	 * @param playercolor the playercolor to set
	 */
	public void setPlayercolor(String playercolor) {
		this.playercolor = playercolor;
	}

	/**
	 * @return the currentposition
	 */
	public Square getCurrentposition() {
		return currentposition;
	}

	/**
	 * @param currentposition the currentposition to set
	 */
	public void setCurrentposition(Square currentposition) {
		this.currentposition = currentposition;
	}

	/**
	 * @return the money
	 */
		
	void myTurn() {
		//deciding player turn
		
	}

	void addPlayer(Player player) {
		
		System.out.print("Player");
	}

	void removePlayer(Player player) {
		
		//remove players from the game
		
	   }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		System.out.println( "Player [id=" + id + ", playercolor=" + playercolor + ", money=" + money + "]");
		return "Player [id=" + id + ", playercolor=" + playercolor + ", money=" + money + "]";
	}

}
