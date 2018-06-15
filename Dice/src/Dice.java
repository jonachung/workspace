import java.util.Random;

public class Dice {
		
	private Random roll;
	
	public int rolls;
	
	public Dice()
	{
		roll = new Random();
	}

	public int rollDie()
	{
		return roll.nextInt(6) + 1;
	}
	
	public int rollDice()
	{
		return this.rollDie() + this.rollDie();
	}
	
}
