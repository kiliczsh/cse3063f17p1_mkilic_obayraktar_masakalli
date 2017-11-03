public class Player {
	int doubleCounter;
	int diceTournamentValue=-1;
	boolean onGame=true;
	boolean isInJail=false;
	private	int playerID;
	private String playerName="Computer";
	private	String playercolor="Red";
	private	Square currentposition = new Square(1,"GO"); //beginning square
	private	int playerMoney=200;//200$ cash
	
	public Player(int playerID) {
		//super();
		this.playerID = playerID;
	}
	
	public void checkGo() {
		Square goSquare=new Square(1,"GO");
		if(this.currentposition.equals(goSquare)) {
			increaseMoney(200);
		}
	}
	public boolean checkJail() {
		Square jailSquare = new Square(11,"Jail");
		if(this.currentposition.equals(jailSquare)) {
			System.out.println(this.playerName + " is in Jail. ");
			return true;
		}else {
			return false;
		}
	}
	public void goToJail() {
		this.currentposition= new Square(11,"Jail");// Jail
	}
	
	public void payTax() {
		int taxAmount=0;
		if(this.currentposition.getSquareID()==39) {//Luxury Tax
			taxAmount=75;
		}else if(this.currentposition.getSquareID()==5) {//Income Tax
			taxAmount=Math.round(this.playerMoney/100);
		}else {
			System.err.println("Error at Tax charging in Player Class");
		}
		
		System.out.println(this.playerName + " will pay "+ taxAmount +" $ tax at " +this.currentposition.getSquareName()+".\n Charging...");
		decreaseMoney(taxAmount);
		if(this.playerMoney<=0) {
			System.out.println(this.playerName+" is out of money.");
			
		}
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
	
	public void increaseMoney(int amount) {
		this.playerMoney+=amount;
	}
	
	public void decreaseMoney(int amount) {
		this.playerMoney-=amount;
	}
	
	@Override
	public String toString() {
		return "Player ID: "+ playerID + " Name: "+ getPlayerName()+" Position: "+currentposition.getSquareID()+"--"+
				currentposition.getSquareName() + " [Money: "+ playerMoney+"]";

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