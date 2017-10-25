
/**
 * @author 
 *
 */
public class Dice {
	private int faceValue;
	//private int doubleCounter=0; //in player class
	public Dice() {
		
	}
	
	public void rollDice() {
		int newFaceValue=(int)(Math.random()*6+1);
		setFaceValue(newFaceValue);
		System.out.println("Face Value: "+newFaceValue);
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
		return "Dice [faceValue=" + faceValue + ", getFaceValue()=" + getFaceValue() + ", toString()="
				+ super.toString() + "]";
	}

	
}

