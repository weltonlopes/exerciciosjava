package entities;

public abstract class TaxPayer {

	private String name;
	protected Double annualIncome;
	
	public TaxPayer() {
	}
	
	public TaxPayer(String name, Double annualIncome) {
		this.name = name;
		this.annualIncome = annualIncome;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAnnualIncome(Double annualIncome) {
		this.annualIncome = annualIncome;
	}
	
	public Double getAnnualIncome() {
		return annualIncome;
	}
	
	public abstract double tax();
	
}
