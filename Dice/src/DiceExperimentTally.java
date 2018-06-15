
public class DiceExperimentTally {

	private int counter;
	
	private String name;
	
	public DiceExperimentTally(String tallytype)
	{
		name = tallytype;
		counter = 0;
	}
	
	public void display()
	{
		String tallies = "";
		for (int asterisk = 0; asterisk < counter; asterisk++)
		{
			tallies += "*";
		}
		System.out.println(this.name + " " + "-" + " " + this.counter + " " + tallies);
	}
	
	public void reset()
	{
		this.counter = 0;
	}
	
	public void click()
	{
		this.counter = this.counter + 1;
	}
}
