
public class Square {
 
	private String name = "KADIKÖY";
	private int address = 40;
	boolean isOccupied = false;
	public int lineUp;
	public int squareID;
	public Square(int id) {
		setSquareID(id);
	}
	public Square() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public int getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(int address) {
		this.address = address;
	}
	
	public String toString() {
		return "The name of the square that are located in the address: " + getAddress() + " is: " + getName();  
	}
	public void setSquare(int nextCellLoc) {
		// TODO Auto-generated method stub
		
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
