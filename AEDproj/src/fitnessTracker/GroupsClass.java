package fitnessTracker;

import dataStructures.DoublyLinkedList;
/**
 * @author Denis Cunha n49284
 * @author Hernani Luz n41827
 */

public class GroupsClass implements Groups{

	private static final long serialVersionUID = 1L;
	private String idGrupo;
	private String nome;
	private int inorder;
	private int passostotal;
	private int uppassosnum;
	private int calorias;
	private int caloriasup;

	private DoublyLinkedList<UsersClass> usersOfGroup;
	
	public GroupsClass(String idGrupo,String nome,int inorder)
	{	usersOfGroup = new DoublyLinkedList<UsersClass>();
		this.idGrupo = idGrupo;
		this.nome = nome;
		this.inorder=inorder;
		this.passostotal=0;
		this.uppassosnum=0;
		this.calorias=0;
	}
	
	@Override
	public String getId() {
		return idGrupo;
	}
	
	@Override
	public String getNome(){
		return nome;
	}
	
	@Override
	public DoublyLinkedList<UsersClass> getUsers(){
		return usersOfGroup;
	}
	
	@Override
	public void setId(String idGrupo) {
		this.idGrupo=idGrupo;
	}
	
	@Override
	public void setNome(String nome){
		this.nome=nome;
	}
	
	@Override
	public void setUsers(DoublyLinkedList<UsersClass> users){
		this.usersOfGroup=users;
	}
	
	@Override
	public int getInorder() {
		return inorder;
	}

	@Override
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
	
	public int getCaloriasup() {
		return caloriasup;
	}

	public void setCaloriasup(int caloriasup) {
		this.caloriasup = caloriasup;
	}
	
}
