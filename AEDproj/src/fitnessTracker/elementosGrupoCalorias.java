package fitnessTracker;

import java.util.Comparator;
/**
 * @author Denis Cunha n49284
 * @author Hernani Luz n41827
 */

public class elementosGrupoCalorias implements Comparator<elementosGrupoCalorias> {
	private String nome;
	private int inorder=0;
	private int passostotal=0;;
	private int calorias =0;
	private int caloriasup =0;
	
	
	elementosGrupoCalorias(){}
	
	elementosGrupoCalorias(String n, int a, int b, int c, int d){
		nome=n;
		inorder=a;
		passostotal=b;
		calorias=c;
		caloriasup=d;
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getInorder() {
		return inorder;
	}

	public void setInorder(int inorder) {
		this.inorder = inorder;
	}

	public int getPassostotal() {
		return passostotal;
	}

	public void setPassostotal(int passostotal) {
		this.passostotal = passostotal;
	}
	
	public int getCalorias() {
		return calorias;
	}

	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	
	public int getCaloriasup() {
		return caloriasup;
	}

	public void setCaloriasup(int caloriasup) {
		this.caloriasup = caloriasup;
	}

	
	public int compare(elementosGrupoCalorias o2, elementosGrupoCalorias o1) {

		if(o1.calorias>o2.calorias){
			return 1;
		}else{
			if(o1.calorias<o2.calorias){
				return -1;
			}else{
				return 0;
			}
		
		}
		
	}
	
	
	
}