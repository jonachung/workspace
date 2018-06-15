
public class TallyTester {
	
	public static void main(String[] args){
		
		DiceExperimentTally oneTally = new DiceExperimentTally("one");
		oneTally.reset();
		oneTally.click();
		oneTally.display();
		oneTally.click();
		oneTally.click();
		oneTally.click();
		oneTally.click();
		oneTally.click();
		oneTally.click();
		oneTally.display();
	}

}
