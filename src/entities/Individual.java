package entities;

public class Individual extends TaxPayer {
	
	private Double healthExpenditures;
	
	public Individual() {
		super();
	}
	
	public Individual(String name, double annualIncome, double healthExpenditures) {
		super(name, annualIncome);
		this.healthExpenditures = healthExpenditures;
	}	

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public double tax() {
		double discount = 0.0;
		if (healthExpenditures > 0) {
			discount = healthExpenditures * 0.5;
		}
		if (annualIncome < 20000.0) {
			return annualIncome * 0.15 - discount;
		}
		else {
			return annualIncome * 0.25 - discount;
		}
	}

}
