package fitnessTracker;

import java.io.Serializable;

/**
 * @author Denis Cunha n49284
 * @author Hernani Luz n41827
 */

public interface Workouts extends Serializable{

	
	/**
	 * Devolve o idTracker do atleta que fez o treino
	 * @return idTracker
	 */
	public String getIdTracker();

	
	/**
	 * Altera o idTracker do atleta que fez o treino
	 * @param idTracker
	 */
	public void setIdTracker(String idTracker);

	
	/**
	 * Devolve o idActividade do treino
	 * @return idActividade
	 */
	public String getIdActividade();

	
	/**
	 * Altera o idActividade do treino
	 * @param idActividade
	 */
	public void setIdActividade(String idActividade);

	
	/**
	 * Devolve a duracao do treino, em horas
	 * @return duracao
	 */
	public int getDuracao();

	
	/**
	 * Altera a duracao do treino
	 * @param duracao
	 */
	public void setDuracao(int duracao);
	
	
	/**
	 * Devolve as calorias do treino
	 * @return calorias
	 */
	public int getCalorias();

	
	/**
	 * Altera as calorias do treino
	 * @param calorias
	 */
	public void setCalorias(int calorias);
	
	
	/**
	 * Devolve a ordem de insercao do treino 
	 * @return inorder
	 */
	public int getInorder();

	
	/**
	 * Altera a ordem de insercao do treino
	 * @param inorder
	 */
	public void setInorder(int inorder);
}
