
public class JailSquare extends Square {
	public JailSquare(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	private Money charge;
	private int period;
	

	/**
	 * @return the charge
	 */
	public Money getCharge() {
		return charge;
	}

	/**
	 * @param charge the charge to set
	 */
	public void setCharge(Money charge) {
		this.charge = charge;
	}

	/**
	 * @return the period
	 */
	public int getPeriod() {
		return period;
	}

	/**
	 * @param period the period to set
	 */
	public void setPeriod(int period) {
		this.period = period;
	}

	
	
	
	
}
