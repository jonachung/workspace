
public class Circle {
	
	private double radius;
	
	public Circle(double length)
	{
		radius = length;
	}
	
	public double getRadius()
	{
		return radius;
	}
	
	public double getArea()
	{
		return this.radius * this.radius * Math.PI; 
	}
	
	public double getCircumference()
	{
		return 2 * this.radius * Math.PI;
	}
	
	public void changeRadius(double len)
	{
		radius = len;
	}

}
