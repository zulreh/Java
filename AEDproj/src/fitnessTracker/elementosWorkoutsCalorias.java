package fitnessTracker;
/**
 * @author Denis Cunha n49284
 * @author Hernani Luz n41827
 */

import java.util.Comparator;

public class elementosWorkoutsCalorias implements Comparator<elementosWorkoutsCalorias>/*, Comparable<elementosGrupo>*/ {
	private String nomeAct;
	private int inorder=0;
	private int calorias =0;	
	
	elementosWorkoutsCalorias(){}
	
	elementosWorkoutsCalorias(String n, int a, int c){
		nomeAct=n;
		inorder=a;
		calorias=c;		
	}
	
	public String getNome() {
		return nomeAct;
	}

	public void setNome(String nome) {
		this.nomeAct = nome;
	}

	public int getInorder() {
		return inorder;
	}

	public void setInorder(int inorder) {
		this.inorder = inorder;
	}

	public int getCalorias() {
		return calorias;
	}

	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	
	public int compare(elementosWorkoutsCalorias o2, elementosWorkoutsCalorias o1) {
		if(o1.calorias==o2.calorias){
			if(o1.inorder>o2.inorder){
			return -1;
			}
			else{
				return 0;
			}
			
		}else if(o1.calorias>o2.calorias){
			return 1;
		}
		else{
			return -1;
		}
	}
	
	
}