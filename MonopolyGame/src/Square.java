public class Square {
 
	private String squareName = "";
	boolean isOccupied = false;
	public int lineUp=1;
	private int squareID;
	
	/**
	 * @param squareID
	 * @param squareName
	 */
	public Square(int squareID, String squareName) {
		super();
		this.squareName = squareName;
		this.squareID = squareID;
	}
	/**
	 * @param squareID
	 */
	public Square(int squareID) {
		super();
		this.squareID = squareID;
	}

	/**
	 * @return the squareName
	 */
	public String getSquareName() {
		return squareName;
	}

	/**
	 * @param squareName the squareName to set
	 */
	public void setSquareName(String squareName) {
		this.squareName = squareName;
	}

	/**
	 * @return the squareID
	 */
	public int getSquareID() {
		return squareID;
	}

	/**
	 * @param squareID the squareID to set
	 */
	public void setSquareID(int squareID) {
		this.squareID = squareID;
	}
}