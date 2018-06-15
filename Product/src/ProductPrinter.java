
public class ProductPrinter {

	public static void main(String[] args) {
		Product shoes = new Product("shoes", 40, 3);
		Product basketballs = new Product("basketballs", 20, 5);
		System.out.println(shoes.getName());
		System.out.println(shoes.getPrice());
		System.out.println(shoes.getQuantity());
		System.out.println(basketballs.getName());
		System.out.println(basketballs.getPrice());
		System.out.println(basketballs.getQuantity());
		shoes.reducePrice(0.25 * shoes.getPrice());
		basketballs.reducePrice(0.25 * basketballs.getPrice());
		System.out.println(shoes.getPrice());
		System.out.println(basketballs.getPrice());
		System.out.println(shoes.total());
		System.out.println(basketballs.total());

	}

}
