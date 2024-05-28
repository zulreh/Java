/**
 * 
 */
package poo;

/**
 * @author João Pedro Teixeira
 *
 */
public class Longu implements CapsuleOfCoffee{

		//Constants
		public static final int CAFFEINE = 80;
		public static final String TYPE = "Lungo";


		//Variables
		private String name;
		private String colour;
		private int caffeine;

	public Longu(String name, String colour, int percentageofcaffeine){
	
		this.name = name;
		this.colour = colour;
		caffeine = (percentageofcaffeine * CAFFEINE) / 100;
	}

	public String getName(){
	
		return name;
	}

	public String getColour(){
	
		return colour;
	}
	
	public String getCoffeeType(){
		
		return TYPE;
	}

	public int getResidualCaffeine(){
	
		return caffeine;
	}
}