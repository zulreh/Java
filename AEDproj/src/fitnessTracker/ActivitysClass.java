package fitnessTracker;

import java.io.Serializable;
/**
 * @author Denis Cunha n49284
 * @author Hernani Luz n41827
 */

public class ActivitysClass implements Activitys, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idActividade;
	private int MET;
	private String  nome;
	
	public ActivitysClass(String idActividade, int MET, String nome){
		this.idActividade = idActividade;
		this.MET = MET;
		this.nome = nome;
	}
	
	@Override
	public String getId(){
		return this.idActividade;
	}
	
	@Override
	public String getNome(){
		return this.nome;
	}
	
	@Override
	public int getMET(){
		return this.MET;
	}
	
	@Override
	public void setId(String idact){
		this.idActividade=idact;
	}
	
	@Override
	public void setNome(String nome){
		this.nome=nome;
	}
	
	@Override
	public void setMET(int met){
		this.MET=met;
	}
	
}
