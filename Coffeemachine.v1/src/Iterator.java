/**
 * 
 */
package poo;

/**
 * @author Jo�o Pedro Teixeira
 *
 */
public interface Iterator {

	void init();
	boolean hasNext();
	CapsuleOfCoffee next();
}