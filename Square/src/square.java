
public class square {

	private double side;
	
	public square(double length)
	{
		side = length;
	}
	
	public double getSide()
	{
		return side;
	}
	
	public double getArea()
	{
		return this.side * this.side;
	}
	
	public void changeLength(double len)
	{
		side = len;
	}
	
}
