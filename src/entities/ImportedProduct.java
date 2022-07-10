package entities;

public class ImportedProduct extends Product {

	private Double customsFee;
	
	public ImportedProduct() {
		super();
	}
	
	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}
	
	public Double totalPrice() {
		return	price += price * customsFee;	
	}
	
	@Override
	public String priceTag() {
		return "Name: " + name + "Price: " + String.format("%.2f", totalPrice());		
	}
}
