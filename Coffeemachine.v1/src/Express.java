/**
 * 
 */
package poo;

/**
 * @author João Pedro Teixeira
 *
 */
public class Express implements CapsuleOfCoffee{

		//Constants
		public static final int CAFFEINE = 70;
		public static final String TYPE = "Espresso";
		
		//Variables
		private String name;
		private String colour;
		private int caffeine;
	
	public Express(String name, String colour, int percentageofcaffeine){
	
		this.name = name;
		this.colour = colour;
		caffeine = (((100 - percentageofcaffeine) * CAFFEINE) / 100);
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