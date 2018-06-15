
public class MakeSquare {

	public static void main(String[] args) {
		square square1 = new square(3);
		square square2 = new square(40);
		square square3 = new square(90);
		System.out.println("Side Lengths");
		System.out.println(square1.getSide());
		System.out.println(square2.getSide());
		System.out.println(square3.getSide());
		System.out.println("Areas");
		System.out.println(square1.getArea());
		System.out.println(square2.getArea());
		System.out.println(square3.getArea());
	}

}
