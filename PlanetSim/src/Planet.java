
public class Planet {

	public double x;
	
	public double y;
	
	public double xVelocity;
	
	public double yVelocity;
	
	public double mass;
	
	public String img;
	
	public double xNetForce;
	
	public double yNetForce;
	
	public double xAccel;
	
	public double yAccel;
	
	
	public Planet(double inputX, double inputY, double inputXVelocity, double inputYVelocity, double inputMass, String inputImg)
	{
		x = inputX;
		y = inputY;
		xVelocity = inputXVelocity;
		yVelocity = inputYVelocity;
		mass = inputMass;
		img = inputImg;
		xNetForce = 0;
		yNetForce = 0;
		xAccel = 0;
		yAccel = 0;
	}
	
	public double calcDistance(Planet planet)
	{
		double distance = Math.sqrt((this.x - planet.x)*(this.x - planet.x) + (this.y - planet.y)*(this.y - planet.y));
		return distance;
	}
	
	public double calcPairwiseForce(Planet planet)
	{
		double G = 6.67e-11;
		double r = this.calcDistance(planet);
		double pairwiseForce = (G * this.mass * planet.mass)/(r*r);
		return pairwiseForce;
	}
	
	public double calcPairwiseForceX(Planet planets)
	{
		double pairwiseForceX = this.calcPairwiseForce(planets) * (planets.x - this.x) / (this.calcDistance(planets));
		return pairwiseForceX;		
	}
	
	public double calcPairwiseForceY(Planet planet)
	{
		double pairwiseForceY = this.calcPairwiseForce(planet) * (planet.y - this.y) / (this.calcDistance(planet));
		return pairwiseForceY;
	}
	
	public void setNetForce(Planet[] planetArray)
	{	
		xNetForce = 0;
		yNetForce = 0;
		for(Planet each : planetArray)
		{
			if (each != this)
			{
				xNetForce = xNetForce + this.calcPairwiseForceX(each);
				yNetForce = yNetForce + this.calcPairwiseForceY(each);
			}
		}
	}
	
	public void update(double dt)
	{
		this.xAccel = this.xNetForce / this.mass;
		this.yAccel = this.yNetForce / this.mass;
		this.xVelocity = this.xVelocity + dt * this.xAccel;
		this.yVelocity = this.yVelocity + dt * this.yAccel;
		this.x = this.x + dt * xVelocity;
		this.y = this.y + dt * yVelocity;	
	}
	
	public void draw()
	{
		StdDraw.picture(x, y, img);
	}
	
	
}
