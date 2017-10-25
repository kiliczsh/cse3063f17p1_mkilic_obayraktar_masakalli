/**
 * 
 */

/**
 * @author 
 *
 */
public class Square {
	String squareName;
	boolean available;
	Player owner;
	String squareType;
	public Square() {
		// TODO Auto-generated constructor stub
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
	 * @return the available
	 */
	public boolean isAvailable() {
		return available;
	}

	/**
	 * @param available the available to set
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}

	/**
	 * @return the owner
	 */
	public Player getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(Player owner) {
		this.owner = owner;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Square [squareName=" + squareName + ", available=" + available + ", owner=" + owner
				+ ", getSquareName()=" + getSquareName() + ", isAvailable()=" + isAvailable() + ", getOwner()="
				+ getOwner() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
