/**
 * 
 */
package poo;

/**
 * @author Hernani
 *
 */
public interface CloudSharing {
	
	/**
	 *Adiciona uma conta com um determinado mail definido pelo utilizador 
	 * @param mail mail definido pelo utilizador
	 * @param type tipo de conta(basic/premium) definido pelo utilizador
	 */
	boolean addAccount(String mail, String type);
	
	/**
	 * Faz o upload do ficheiro
	 * @param mail mail da conta que faz o upload
	 * @param filename nome do ficheiro
	 * @param size tamanho do ficheiro
	 */
	boolean uploadFile(String mail,String filename , int size);
	
	/**
	 * Partilha um ficheiro
	 * @param mail1 mail da conta que é a proprietaria do ficheiro
	 * @param mail2 mail da conta com quem é partilhado o ficheiro
	 * @param filename nome do ficheiro
	 */
	boolean shareFile(String mail1, String mail2, String filename);
	
	/**
	 * Faz uma actualizacao num ficheiro
	 * @param mail1 mail da conta que possui o ficheiro
	 * @param mail2 mail da conta com que é partilhado o ficheiro
	 * @param filename noem do ficheiro
	 */
	void updateFile(String mail1, String mail2, String filename);
	
	/**
	 * Lista as contas todas
	 * @return todas as contas criadas
	 */
	String listAccounts();
	
	/**
	 * Lista os ficheiros de um determinado mail
	 * @param mail mail da conta que é listado os ficheiros
	 * @return ficheiros do utilizador(proprios e partilhados)
	 */
	String listFiles(String mail);
	
	/**
	 * Lista os mails das contas por tipo de conta, basic ou premium
	 * @return os mails das contas
	 */
	String listByTypeOfAccounts();
	
	/**
	 * Lista a conta que fez a ultima actualizacao num ficheiro
	 * @param mail mail da conta do proprietario do ficheiro
	 * @param filename nome do ficheiro
	 * @return mail que fez a ultima alteracao
	 */
	String lastUpdate(String mail, String filename);
		
	/**
	 * Verifica se existe uma conta com o mail introduzido
	 * @param mail mail que vai ser verificado se exite conta ou nao
	 * @return <code>true</code>, se existe,
	 * <code>false</code> caso contrário
	 */
	boolean hasAccount(String mail);
	
	/**
	 * Verifica se existe um ficheiro com o nome introduzido
	 * @param filename nome do ficheiro
	 * @param mail email do utilizador que se quer verificar se existe o ficheiro
	 * @return <code>true</code>, se existe,
	 * <code>false</code> caso contrário
	 */
	boolean hasFile(String mail,String filename);
	
	/**
	 * Verifica se o ficheiro esta a ser partilhado pelas duas contas
	 * @param mail1 mail da conta que é proprietaria do ficheiro
	 * @param mail2 mail da conta com que é partilhado o ficheiro
	 * @param filename nome do ficheiro
	 * @return <code>true</code>, se existe,
	 * <code>false</code> caso contrário
	 */
	boolean checkSharingFile(String mail1, String mail2, String filename);
	
	Iterator allAccounts();
	
	boolean exceedsCap(String mail ,String filename,int filesize);
	
	boolean exists2Files(String mail, String filename);
}
