package fitnessTracker;
/**
 * @author Denis Cunha n49284
 * @author Hernani Luz n41827
 */

public class ElementosWorkouts implements  Comparable<ElementosWorkouts> {
	private String nome;
	private int peso;
	private int idade;
	private char sexo;
	private int passos;
	private int calorias;
	
	

	ElementosWorkouts(){}
	
	ElementosWorkouts(String nome,int peso,int idade, char sexo, int pass, int calor){
		this.nome=nome;
		this.peso = peso;
		this.idade = idade;
		this.sexo = sexo;
		passos=pass;
		calorias=calor;
	}
	

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}


	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}


	public int getPassos() {
		return passos;
	}

	public void setPassos(int passos) {
		this.passos = passos;
	}


	public int getCalorias() {
		return calorias;
	}

	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int compareTo(ElementosWorkouts o) {
		return (this.nome).compareTo(o.nome);
	}
	
	
	
}
