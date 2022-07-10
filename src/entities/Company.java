package entities;

public class Company extends TaxPayer {
	
	private int numberOfEmployees;

	public Company() {
		super();
	}

	public Company(String name, Double annualIncome, int numberOfEmployess) {
		super(name, annualIncome);
		this.numberOfEmployees = numberOfEmployess;
	}

	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public double tax() {
		if (numberOfEmployees <= 10) {
			return annualIncome * 0.16;			
		}
		else {
			return annualIncome * 0.14;
		}
	}

}
