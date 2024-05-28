/**
 * 
 */
package poo;

/**
 * @author João Pedro Teixeira
 *
 */
public interface CoffeeMachine {

	void servingCoffee(String type, String name, String colour);
	void setShort();
	void setNormal();
	void setLongu();
	int coffeeWater();
	int fillReservoir();
	int waterLevelOfReservoir();
	Iterator allCapsules();
	Iterator typeCapsule(String type);
	boolean hasCapsuleType(String type);
	boolean hasWaterReservoir();
	boolean underLimit();
	public int getCounter();
}
