package fitnessTracker;

import java.io.Serializable;

/**
 * @author Denis Cunha n49284
 * @author Hernani Luz n41827
 */

public class WorkoutsClass implements Workouts, Serializable{

	private static final long serialVersionUID = 1L;
	private String idTracker;
	private String idActividade;
	private int duracao;
	private int calorias;
	private int inorder;
	
	public WorkoutsClass(String idTracker, String idActividade, int duracao, int calorias,int inorder){
		this.idTracker = idTracker;
		this.idActividade = idActividade;
		this.duracao = duracao;
		this.calorias= calorias;
		this.inorder=inorder;
		
	}
	
	@Override
	public String getIdTracker() {
		return idTracker;
	}

	@Override
	public void setIdTracker(String idTracker) {
		this.idTracker = idTracker;
	}

	@Override
	public String getIdActividade() {
		return idActividade;
	}

	@Override
	public void setIdActividade(String idActividade) {
		this.idActividade = idActividade;
	}

	@Override
	public int getDuracao() {
		return duracao;
	}

	@Override
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	@Override
	public int getCalorias() {
		return calorias;
	}

	@Override
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	
	public int getInorder() {
		return inorder;
	}

	public void setInorder(int inorder) {
		this.inorder = inorder;
	}

	
	
}
