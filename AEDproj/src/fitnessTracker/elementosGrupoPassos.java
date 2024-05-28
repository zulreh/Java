package fitnessTracker;

import java.util.Comparator;
/**
 * @author Denis Cunha n49284
 * @author Hernani Luz n41827
 */

public class elementosGrupoPassos implements Comparator<elementosGrupoPassos>{
	private String nome;
	private int inorder=0;
	private int passostotal=0;
	private int uppassosnum =0;
	private int calorias =0;
	
	

	elementosGrupoPassos(){}
	
	elementosGrupoPassos(String n, int a, int b, int c, int d){
		nome=n;
		inorder=a;
		passostotal=b;
		uppassosnum=c;
		calorias=d;
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

	public int getUppassosnum() {
		return uppassosnum;
	}

	public void setUppassosnum(int uppassosnum) {
		this.uppassosnum = uppassosnum;
	}
	
	public int getCalorias() {
		return calorias;
	}

	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	
	public int compare(elementosGrupoPassos o2, elementosGrupoPassos o1) {
		if(o1.passostotal>o2.passostotal){
			return 1;
		}else{
			if(o1.passostotal<o2.passostotal){
				return -1;
			}else{
				return 0;
			}
		
		}
	}

}