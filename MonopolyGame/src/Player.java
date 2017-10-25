
public class Player {
	int doubleCounter;
	private	int playerID;
	private String playerName="Computer";
	private	String playercolor="Red";
	private	Square currentposition = new Square();
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
		
	}
	
	public void decreaseMoney(int m) {
		
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Player [doubleCounter=" + doubleCounter + ", playerID=" + playerID + ", playerName=" + playerName
				+ ", playercolor=" + playercolor + ", currentposition=" + currentposition + ", money=" + money + "]";
	}



}
