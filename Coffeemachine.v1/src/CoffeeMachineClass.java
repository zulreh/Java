/**
 * 
 */
package poo;

/**
 * @author João Pedro Teixeira
 *
 */
public class CoffeeMachineClass implements CoffeeMachine {

			//Constants
			public static final int DEFAULT = 1000;
			public static final int RESERVOIR_CAPACITY = 1000;
			public static final int WATER_FOR_SHORT = 25;
			public static final int WATER_FOR_NORMAL = 40;
			public static final int WATER_FOR_LUNGU = 110;
			public static final int RESIDUAL_CAFFEINE_EXPRESS = 15;
			public static final int RESIDUAL_CAFFEINE_DECAFFEINATED = 10;
			public static final int RESIDUAL_CAFFEINE_LUNGU = 5;
			
			//Variables
			private int watereservoir;
			private int coffeewater;
			private CapsuleOfCoffee[] capsules;
			private int counter;
			private int percentage;
			
		public CoffeeMachineClass(){
			
			watereservoir = 0;
			coffeewater = 40;
			capsules = new CapsuleOfCoffee[DEFAULT];
			counter = 0;
			percentage = 0;
		}
		
		public void servingCoffee(String type, String name, String colour){
			
			if(type.equals("Espresso")){
				capsules[counter++] = new Express(name, colour, percentage);
				watereservoir = watereservoir - coffeewater;
			}
			else if(type.equals("Decaffeinato")){
				capsules[counter++] = new Decaffeinated(name, colour, percentage);
			    watereservoir = watereservoir - coffeewater;
			}
			else if(type.equals("Lungo")){
				capsules[counter++] = new Longu(name, colour, percentage);
			    watereservoir = watereservoir - coffeewater;
			}
		}
		
		public void setShort(){
			
			percentage = 85;
			coffeewater = WATER_FOR_SHORT;
		}
		
		public void setNormal(){
			
			percentage = 90;
			coffeewater = WATER_FOR_NORMAL;
		}
		
		public void setLongu(){
			
			percentage = 95;
			coffeewater = WATER_FOR_LUNGU;
		}
		
		public int coffeeWater(){
			
			return coffeewater;
		}
		
		public int fillReservoir(){
			
			int fillit;
			
			fillit = 1000 - watereservoir;
			watereservoir = RESERVOIR_CAPACITY;
			return fillit;
		}
		
		public int waterLevelOfReservoir(){
			
			return watereservoir;
		}
		
		public Iterator allCapsules(){
			
			Iterator it;
			
			it = new IteratorClass(capsules, counter);
			return it;
		}
		
		public Iterator typeCapsule(String type){
			
			Iterator it;
			
			it = new IteratorClass(capsules, counter, type);
			return it;
		}
		
		public boolean hasCapsuleType(String type){
			
			return type.equals("Espresso") || type.equals("Lungo") || type.equals("Decaffeinato");
		}
		
		public boolean hasWaterReservoir(){
			
			return (watereservoir >= 25);
		}
		
		public boolean underLimit(){
			
			return counter < DEFAULT;
		}
		
		public int getCounter(){
			
			return counter;
		}
}