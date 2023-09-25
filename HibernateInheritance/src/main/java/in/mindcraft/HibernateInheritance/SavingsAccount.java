package in.mindcraft.HibernateInheritance;

import javax.persistence.Entity;

@Entity
public class SavingsAccount extends Account {
	
	private int interestRate;

	public int getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}


}
