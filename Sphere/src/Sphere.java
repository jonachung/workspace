
public class Sphere {
	
	private double radius;
	
	public Sphere(double length)
	{
		radius = length;
	}
	
	public double getRadius()
	{
		return radius;
	}
	
	public double getVolume()
	{
		return 4.0 / 3.0 * Math.PI * this.radius * this.radius * this.radius;
	}
	
	public void changeRadius(double len)
	{
		radius = len;
	}
	
	public double getSurfaceArea()
	{
		return 4 * Math.PI * this.radius * this.radius;
	}
}
