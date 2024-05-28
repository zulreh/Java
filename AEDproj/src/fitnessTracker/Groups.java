package fitnessTracker;

import java.io.Serializable;

import dataStructures.DoublyLinkedList;

/**
 * @author Denis Cunha n49284
 * @author Hernani Luz n41827
 */

public interface Groups extends Serializable{

		/**
		 * Devolve o Id do grupo
		 * @return idGrupo
		 */
		public String getId();
		
		
		/**
		 * Devolve o nome do grupo
		 * @return nome do grupo
		 */
		public String getNome();
		
		
		/**
		 * Devolve um DoublyLinkedList de todos os atletas existentes num grupo
		 * @return DoublyLinkedList atletas do grupo
		 */
		public DoublyLinkedList<UsersClass> getUsers();
		
		
		/**
		 * Altera  o idGrupo
		 * @param idGrupo - novo idGrupo
		 */
		public void setId(String idGrupo); 
		
		
		/**
		 * Altera o nome do grupo
		 * @param nome - nome do grupo
		 */
		public void setNome(String nome);
		
		
		/**
		 * Guarda os atletas numa DoublyLinkedList 
		 * @param users DoublyLinkedList dos atletas
		 */
		public void setUsers(DoublyLinkedList<UsersClass> users);
		
		
		/**
		 * Devolve a variavel que indica a ordem de insercao do grupo
		 * @return inorder
		 */
		public int getInorder();
		
		
		/**
		 * Altera a variavel que indica a ordem de insercao do grupo
		 * @param inorder
		 */
		public void setInorder(int inorder);
		
		
		/**
		 * Devolve os passos totais do grupo
		 * @return passos
		 */
		public int getPassostotal();

		
		/**
		 * Altera os passos totais do grupo
		 * @param passostotal
		 */
		public void setPassostotal(int passostotal);
		
		
		/** 
		 * Devolve o numero de vezes que os passos foram alterados
		 * @return uppassosnum
		 */
		public int getUppassosnum();

		
		/**
		 * Altera o numero de vezes que os passos foram alterados
		 * @param uppassosnum
		 */
		public void setUppassosnum(int uppassosnum);
		
		
		/**
		 * Devolve as calorias totais do grupo
		 * @return calorias
		 */
		public int getCalorias();

		
		/**
		 * Altera as calorias totais do grupo
		 * @param calorias
		 */
		public void setCalorias(int calorias);
		
		
		/**
		 * Devolve o numero de vezes que as calorias foram alteradas
		 * @return caloriasup
		 */
		public int getCaloriasup();
		
		
		/**
		 * Altera o numero de vezes que as calorias foram alteradas
		 * @param caloriasup
		 */
		public void setCaloriasup(int caloriasup);
		
}
