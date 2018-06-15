
public class MakeCircles {

	public static void main(String[] args) {
		Circle circle1 = new Circle(4);
		Circle circle2 = new Circle(1);
		Circle circle3 = new Circle(0);
		System.out.println("Radius");
		System.out.println(circle1.getRadius());
		System.out.println(circle2.getRadius());
		System.out.println(circle3.getRadius());
		System.out.println("Circumference");
		System.out.println(circle1.getCircumference());
		System.out.println(circle2.getCircumference());
		System.out.println(circle3.getCircumference());
		System.out.println("Area");
		System.out.println(circle1.getArea());
		System.out.println(circle2.getArea());
		System.out.println(circle3.getArea());
		circle1.changeRadius(5);
		circle2.changeRadius(1);
		circle3.changeRadius(8);
		System.out.println("");
		System.out.println("New Radius");
		System.out.println(circle1.getRadius());
		System.out.println(circle2.getRadius());
		System.out.println(circle3.getRadius());
		System.out.println("New Circumference");
		System.out.println(circle1.getCircumference());
		System.out.println(circle2.getCircumference());
		System.out.println(circle3.getCircumference());
		System.out.println("New Area");
		System.out.println(circle1.getArea());
		System.out.println(circle2.getArea());
		System.out.println(circle3.getArea());

	}

}
