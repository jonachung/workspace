
/**
 * This class runs the planet simulator.
 * The main method uses the command prompt to get three user-specified inputs 
 * for the total simulation time, the time step for each interval, and the universe file name and runs the
 * simulation using the given inputs.
 * The other method is used to get the planets from the user-specified file.
 * @author Jonathan
 *
 */
public class Simulator {

	/**
	 * The main method uses the command prompt to get three user-specified inputs 
	 * for the total simulation time, the time step for each interval, and the universe file name and runs the
	 * simulation using the given inputs. If there are not three user-specified inputs, an statement with the correct
	 * parameters will be given out as a reminder.
	 * 
	 * @param args		The user specified inputs in the given order: total simulation time, time step per interval, and the universe file.
	 */
	public static void main(String[] args) {
		
		if (args.length == 3)
		{
			double T = Double.parseDouble(args[0]);
			double dt = Double.parseDouble(args[1]);
			String fileName = args[2];
			In file = new In(fileName);
			int numberOfPlanets = file.readInt();
			double universeRadius = file.readDouble();
			Planet[] planetArray = new Planet[numberOfPlanets];
			for (int index = 0; index < planetArray.length; index++)
			{
				planetArray[index] = getPlanet(file);
			}
			StdDraw.setScale(-universeRadius, universeRadius);
			StdDraw.picture(0, 0, "images/starfield.jpg");
			for (int index = 0; index < planetArray.length; index++) 
			{
				planetArray[index].draw();
				
			}
			StdAudio.play("audio/2001.mid");
			int time = 0;
			while (time < T)
			{
				StdDraw.picture(0, 0, "images/starfield.jpg");
				for (int index = 0; index < planetArray.length; index++)
				{
					planetArray[index].setNetForce(planetArray);
					planetArray[index].update(dt);
					planetArray[index].draw();
				}
				StdDraw.show(10);
				time += dt;
			}	
		} else
		{
			System.out.println("Usage: Simulator totalSimulationTime timeStep universeFileName");
		}
	}
	
	/**
	 * This method is used to return the planet objects created from the user-specified file.
	 * One object is created at a time.
	 * @param in		The user-specified file that has the characteristics of each planet object.
	 * @return		The planet object that is first created from the file.
	 */
	public static Planet getPlanet(In in)
	{
		double x = in.readDouble();
		double y = in.readDouble();
		double xVelocity = in.readDouble();
		double yVelocity = in.readDouble();
		double mass = in.readDouble();
		String image = "images/" + in.readString();
		return new Planet(x, y, xVelocity, yVelocity, mass, image);
	}

}
