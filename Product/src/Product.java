
public class Product {

	private String name;
	
	private int quantity;
	
	private double price;
	
	public Product(String product_name, double productPrice)
	{
		name = product_name;
		price = productPrice;
		quantity = 0;
	}
	
	public Product(String product_name, double productPrice, int productQuantity)
	{
		name = product_name;
		price = productPrice;
		quantity = productQuantity;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public double total()
	{
		return this.price * this.quantity;
	}
	
	public void reducePrice(double discount)
	{
		price = price - discount;
	}
}
