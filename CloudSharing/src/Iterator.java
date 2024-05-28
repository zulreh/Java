package poo;

/**
 * @author Hernani
 *
 */
public interface Iterator {

	/**
	* Inicializa o iterador
	*/
	void init();
	
	/**
	* Verifica se existe um proximo
	* @return <code>true</code>, se existe,
	* <code>false</code> caso contrário
	*/
	boolean hasNext();
	
	/**
	* Devolve o proximo 
	* @pre hasNext()
	* @return o proximo 
	*/
	Object next();
}
