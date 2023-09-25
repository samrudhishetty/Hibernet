package in.mindcraft.HibernateInheritance;

import javax.persistence.Entity;

@Entity
public class CurrentAccount extends Account {
	//who can withdraw beyond amount
	private double overLimit;

	public double getOverLimit() {
		return overLimit;
	}

	public void setOverLimit(double overLimit) {
		this.overLimit = overLimit;
	}

	

}
