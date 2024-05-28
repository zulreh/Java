package fitnessTracker;

import java.io.Serializable;
/**
 * @author Denis Cunha n49284
 * @author Hernani Luz n41827
 */

public interface Users extends Serializable{

	/**
	 * Adiciona um user ao sistema
	 * @param idTracker
	 * @param peso
	 * @param altura
	 * @param sexo
	 * @param nome
	 */
	
	/**
	 * @return id dos users
	 */
	public String getId();
	
	
	public int getPeso();
	
	public int getAltura();
	
	public int getIdade();
	
	public char getSexo();
	
	public int getPassos();
	
	public String getNome();
	
	public String getIdGrupo();
	
	public void setIdGrupo(String grupoid);
	
	/**
	 * 
	 * @param peso
	 */
	public void setPeso(int peso);
	
	/**
	 * 
	 * @param altura
	 */
	public void setAltura(int altura);
	/**
	 * 
	 * @param idade
	 */
	public void setIdade(int idade);
	
	public void setNome(String peso);
	
	public void setPassos(int passos);
	
	public int getCalorias();

	public void setCalorias(int calorias);
	
	public int getCaloriasupdate();

	public void setCaloriasupdate();
}
