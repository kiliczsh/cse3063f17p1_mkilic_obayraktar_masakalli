
public class Money {
 private int initialAmount;
 private int salaryAmount;
 
 public Money() {
	 
 }
 /**
 * @return the initialAmount
 */
public int getInitialAmount() {
	return initialAmount;
}


/**
 * @param initialAmount the initialAmount to set
 */
public void setInitialAmount(int initialAmount) {
	this.initialAmount = initialAmount;
}


/**
 * @return the salaryAmount
 */
public int getSalaryAmount() {
	return salaryAmount;
}


/**
 * @param salaryAmount the salaryAmount to set
 */
public void setSalaryAmount(int salaryAmount) {
	this.salaryAmount = salaryAmount;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Money [initialAmount=" + initialAmount + ", salaryAmount=" + salaryAmount + "]";
}



}
