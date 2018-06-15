
public class Test {
	
	
	
	/*public int roundOff(int number)
	{
		return Math.round(number);
	}
	
	public double roundOff(double number)
	{
		return Math.round(number * 10) / 10.0;
	}
	
	public double max(double number1, double number2, double number3)
	{
		double max = 0;
		if (number1 > number2)
		{
			max = number1;
		} else
		{
			max = number2;
		}
		if (max < number3)
		{
			max = number3;
		}
		return max;
	}
	
	public void string_order(String string1, String string2, String string3)
	{
		String temp; // temporary placeholder variable
		
		if(string1.compareTo(string2) > 0) 
		{ 
		    temp = string1;    
		    string1 = string2;   
		    string2 = temp;
		}
		
		if(string1.compareTo(string3) > 0) 
		{ 
		    temp = string1;    
		    string1 = string3;   
		    string3 = temp;    
		}
		
		if(string2.compareTo(string3) > 0) 
		{ 
		    temp = string2;    
		    string2 = string3; 
		    string3 = temp;    
		}
		
		//System.out.println(string1 + " " + string2 + " " + string3);
		
		public void dayInMonth(int month)
		{
			if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
			{
				System.out.println("31 days.");
			} else if (month == 4 || month == 6 || month == 9 || month == 11)
			{
				System.out.println("30 days.");
			} else if (month == 2)
			{
				System.out.println("28 days");
			} else
			{
				System.out.println("Error.");
			}
		}
		
		public void vowelOrConsonant(String letter) // 9 if statements if / else statements instead of switch / case
		{ // Read instructions really carefully.
			switch (letter.toUpperCase())
			{
				case "A":
				case "E":
				case "I":
				case "O":
				case "U":
				case "Y":
					System.out.println("Vowel");
					break;
				case "B":
				case "C":
				case "D":
				case "F":
				case "G":
				case "H":
				case "J":
				case "L":
				case "M":
				case "N":
				case "P":
				case "Q":
				case "R":
				case "S":
				case "T":
				case "V":
				case "W":
				case "X":
				case "Z":
					System.out.println("Consonant");
					break;
				default:
					System.out.println("Error");
					break;
			}
		}
		
		public void gradeForClass(double grade)
		{
			String letterGrade = "A";
			if ((grade >= 80) && (grade < 90.00))
			{
				letterGrade = "B";
			} else if ((grade >= 70) && (grade < 80))
			{
				letterGrade = "C";
			} else if ((grade >= 60) && (grade < 70))
			{
				letterGrade = "D";
			} else if (grade < 60)
			{
				letterGrade = "F";
			}
			System.out.println(letterGrade);
		}
		
		public void consonantOrVowel(String letter)
		{
			if ((letter != null) && (letter.length() == 1) && (((letter.compareTo("A") >= 0) && (letter.compareTo("Z") <= 0)) || ((letter.compareTo("a") >= 0) && (letter.compareTo("z") <= 0))))  // four comparisons 
			{
				letter = letter.toUpperCase();
				if (letter.equals("A") || letter.equals("E") || letter.equals("I") || letter.equals("O") || letter.equals("U"))
				{
					System.out.println("Vowel");
				} else
				{
					System.out.println("Consonant");
				} 
			} else
			{
				System.out.println("Error");
			}
		}*/
	
		public int firstSpace(String string)
		{
			int index = 0;
			while ((index < string.length()) && (string.charAt(index) != ' '))
			{
				index++;
			}
			if (index >= string.length())
			{
				return -1;
			} else
			{
				return index;
			}
		}
		
		public int lastSpace(String string)
		{
			int index = string.length() - 1;
			while ((string.charAt(index) != ' ') && (index >= 0))
			{
				--index;
			}
			if (index < 0)
			{
				return -1;
			} else
			{
				return index;
			}
		}
		
		public int numberOfSpaces(String string)
		{
			int index = 0;
			int spaces = 0;
			while (index < string.length())
			{
				if ((string.charAt(index) == ' '))
				{
					spaces++;
				} 
				index++;
			}
			return spaces;
		}
		
		public int sentenceCount(String string)
		{
			int sentences = 0;
			int index = 0;
			while (index < string.length())
			{
				if ((string.charAt(index) == ' ') && ((string.charAt(index - 1) == '.') || (string.charAt(index - 1) == '!') || (string.charAt(index - 1) == '?')) && ((string.charAt(index + 1) >= 'A') && (string.charAt(index + 1) <= 'Z')))
				{
					sentences++;
				}
				index++;
			}
			sentences = sentences + 1;
			return sentences;
		}
		
	}
