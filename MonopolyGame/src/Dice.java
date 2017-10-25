
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
		System.out.println(newFaceValue);
	}
	
	public void checkDoubleCounter(Player player,Dice dice1,Dice dice2) {
		int value1,value2;
		value1=dice1.getFaceValue();
		value2=dice2.getFaceValue();
		if(value1==value2) {
			player.doubleCounter++;
			if(player.doubleCounter >=3) {
			//	player.setCurrentPosition("Jail"); // will added soon
			}
		}else {
			player.doubleCounter=0;
		}
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

