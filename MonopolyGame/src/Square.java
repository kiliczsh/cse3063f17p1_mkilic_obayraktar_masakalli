
public class Square {
 
	private String squareName = "KADIKÖY";
	private int squareAddress = 40;
	boolean isOccupied = false;
	public int lineUp=1;
	public int squareID;
	
	public Square(int id) {
		setSquareID(id);
		this.lineUp=lineUp+1;
	}
	public Square() {
		this.lineUp=lineUp+1;
	}

	public void setSquare(int nextCellLocation) {
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
	 * @return the isOccupied
	 */
	public boolean isOccupied() {
		return isOccupied;
	}
	/**
	 * @param isOccupied the isOccupied to set
	 */
	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
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
