public class Player {
	int doubleCounter;
	int diceTournamentValue=-1;
	private	int playerID;
	private String playerName="Computer";
	private	String playercolor="Red";
	private	Square currentposition = new Square(1,"GO");
	private	int money=1500;
	
	public Player(int playerID) {
		//super();
		this.playerID = playerID;
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
	
	public void increaseMoney(int m) {
		this.money+=m;
	}
	
	public void decreaseMoney(int m) {
		this.money-=m;
	}
	
	@Override
	public String toString() {
		return "Player: "+ getPlayerName() + " [ doubleCounter=" + doubleCounter + ", playerID=" + playerID + 
				 ", currentposition=" + currentposition.getSquareID()+"--"+
				currentposition.getSquareName() + ", money=" + money + " ]";
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
	 * @return the playerID
	 */
	public int getPlayerID() {
		return playerID;
	}

	/**
	 * @param playerID the playerID to set
	 */
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}
}