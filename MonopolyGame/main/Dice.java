/**
 * 
 */

/**
 * @author 
 *
 */
public class Dice {
	int faceValue;
	
	
	public Dice() {
		// TODO Auto-generated constructor stub
	}
	//rolling method
	public void getRoll() {
		
	}
	/**
	 * @return the faceValue
	 */
	public int getFaceValue() {
		return faceValue;
	}
	/**
	 * @param faceValue the faceValue to set
	 */
	public void setFaceValue(int faceValue) {
		this.faceValue = faceValue;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Dice [faceValue=" + faceValue + ", getFaceValue()=" + getFaceValue() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	

}
