/**
 * 
 */
package poo;

/**
 * @author João Pedro Teixeira
 *
 */
public class IteratorClass implements Iterator{

		//Variables
		private CapsuleOfCoffee[] capsules;
		private int current;
		private int counter;
		private String type;
	
	public IteratorClass(CapsuleOfCoffee[] capsules, int counter){
		
		this.capsules = capsules;
		this.counter = counter;
		this.type = null;
		init();
	}
	
	public IteratorClass(CapsuleOfCoffee[] capsules, int counter, String type){
		
		this.capsules = capsules;
		this.counter = counter;
		this.type = type;
		init();
	}
	
	public void init(){
		
		current = 0;
		if(type != null)
			while( (current < counter)  && !capsules[current].getCoffeeType().equals(type))
				current++;
	}
	
	public boolean hasNext(){
		
		return (current < counter);
	}
	
	public CapsuleOfCoffee next(){
		
		CapsuleOfCoffee res = capsules[current++];
		if(type != null)
			while((current < counter) && !capsules[current].getCoffeeType().equalsIgnoreCase(type))
				current++;
		return res;
	}
}