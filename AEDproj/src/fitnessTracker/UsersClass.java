package fitnessTracker;

import java.io.Serializable;
/**
 * @author Denis Cunha n49284
 * @author Hernani Luz n41827
 */

public class UsersClass implements Users, Serializable  {
	
	private static final long serialVersionUID = 1L;
	private String idTracker;
	private int peso;
	private int altura;
	private int idade;
	private char sexo;
	private String nome;
	private int passos;
	private String idGrupo;
	private int calorias;
	private int caloriasupdate;

	

	public UsersClass(String idTracker,int peso, int altura,int idade, char sexo, String nome){
		this.idTracker= idTracker;
		this.peso = peso;
		this.altura = altura;
		this.idade = idade;
		this.sexo = sexo;
		this.nome = nome;
		passos=0;
		idGrupo="";
		calorias=0;
		caloriasupdate=0;
	}
	

	@Override
	public String getId() {
		return this.idTracker;
	}
	
	@Override
	public int getPeso(){
		return this.peso;
	}
	
	@Override
	public int getAltura(){
		return this.altura;
	}
	
	@Override
	public int getIdade(){
		return this.idade;
	}
	
	@Override
	public char getSexo(){
		return this.sexo;
	}
	
	@Override
	public int getPassos(){
		return this.passos;
	}
	
	@Override
	public String getNome(){
		return this.nome;
	}
	
	@Override
	public void setNome(String peso){
		this.nome=peso;
	}
	
	@Override
	public void setPeso(int peso){
		this.peso = peso;
	}
	
	@Override
	public void setAltura(int altura){
		this.altura= altura;
	}
	
	@Override
	public void setIdade(int idade){
		this.idade=idade;
	}
	
	@Override
	public void setPassos(int passos){
		this.passos+= passos;
	}
	
	@Override
	public String getIdGrupo() {
		return this.idGrupo;
	}

	@Override
	public void setIdGrupo(String idGrupo) {
		this.idGrupo = idGrupo;
	}
	
	public int getCalorias() {
		return calorias;
	}

	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	
	public int getCaloriasupdate() {
		return caloriasupdate;
	}

	public void setCaloriasupdate() {
		caloriasupdate++;
	}


	
}
