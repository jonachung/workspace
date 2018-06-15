
public class DiceExperiment {
	
	public static void main(String[] args) {
		Dice pairOfdice = new Dice();
		
		DiceExperimentTally twoTally = new DiceExperimentTally("Two");
		DiceExperimentTally threeTally = new DiceExperimentTally("Three");
		DiceExperimentTally fourTally = new DiceExperimentTally("Four");
		DiceExperimentTally fiveTally = new DiceExperimentTally("Five");
		DiceExperimentTally sixTally = new DiceExperimentTally("Six");
		DiceExperimentTally sevenTally = new DiceExperimentTally("Seven");
		DiceExperimentTally eightTally = new DiceExperimentTally("Eight");
		DiceExperimentTally nineTally = new DiceExperimentTally("Nine");
		DiceExperimentTally tenTally = new DiceExperimentTally("Ten");
		DiceExperimentTally elevenTally = new DiceExperimentTally("Eleven");
		DiceExperimentTally twelveTally = new DiceExperimentTally("Twelve");
		
		for (int roll = 0; roll < 300; roll++)
		{
			int rolls = pairOfdice.rollDice(); // create variable to store value of dice roll. use switch case. 
			switch (rolls)
			{
				case 2:
					twoTally.click();
					break;
				case 3:
					threeTally.click();
					break;
				case 4:
					fourTally.click();
					break;
				case 5:
					fiveTally.click();
					break;
				case 6:
					sixTally.click();
					break;
				case 7: 
					sevenTally.click();
					break;
				case 8:
					eightTally.click();
					break;
				case 9:
					nineTally.click();
					break;
				case 10:
					tenTally.click();
					break;
				case 11:
					elevenTally.click();
					break;
				default:
					twelveTally.click();
					break;
			}
		}
		
		twoTally.display();
		threeTally.display();
		fourTally.display();
		fiveTally.display();
		sixTally.display();
		sevenTally.display();
		eightTally.display();
		nineTally.display();
		tenTally.display();
		elevenTally.display();
		twelveTally.display();
	}

}
