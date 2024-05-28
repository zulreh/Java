/**
 * 
 */
package poo;

/**
 * @author Hernani
 *
 */

public interface Account {

	/**
	 * Adiciona uma conta com um determinado mail
	 * @param mail mail da conta
	 */
	public void setAccount(String mail);
	
	/**
	 * Devolve o mail da conta criada
	 * @return mail
	 */
	public String getAccount();
		
	/**
	 * Devolve o tipo da conta 
	 * @return tipo da conta (basic/premium)
	 */
	public String getType();
	
	/**
	 * Lista todas as contas criadas
	 * @return todos os mails das contas criadas
	 */
	public String listAllAccounts();
	
	/**
	 * Adiciona um ficheiro
	 * @param  mail nome da conta do utilizador que adiciona o ficheiro
	 * @param filename nome do ficheiro
	 * @param filesize tamanho do ficheiro
	 */
	public void addFile(String mail, String filename, int filesize);
	
	/**
	 * Devolve o espaco disponivel na conta
	 * @return o espaco disponivel
	 */
	public int getSize();
}
