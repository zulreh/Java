package fitnessTracker;

import java.io.Serializable;

/**
 * @author Denis Cunha n49284
 * @author Hernani Luz n41827
 */

public interface Activitys extends Serializable{

	/**
	 * Devolve o Id da actividade
	 * @return idActividade
	 */
	public String getId();
	
	
	/**
	 * Devolve o nome da actividade
	 * @return nome da actividade
	 */
	public String getNome();
	
	
	/**
	 * Devolve o MET da actividade
	 * @return MET 
	 */
	public int getMET();
	
	
	/**
	 * Altera o id da actividade
	 * @param idact
	 */
	public void setId(String idact);
	
	/**
	 * Altera o nome da actividade
	 * @param nome
	 */
	public void setNome(String nome);
	
	
	/**
	 * Altera o MET da actividade
	 * @param met
	 */
	public void setMET(int met);
	
}
