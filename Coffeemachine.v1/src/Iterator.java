/**
 * 
 */
package poo;

/**
 * @author João Pedro Teixeira
 *
 */
public interface Iterator {

	void init();
	boolean hasNext();
	CapsuleOfCoffee next();
}