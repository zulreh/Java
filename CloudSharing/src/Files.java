package poo;

/**
 * @author Hernani
 *
 */
public interface Files {

	String getFileName();
	
	/**
	 * Faz upload de um ficheiro
	 * @param mail mail da conta que quer fazer o upload
	 * @param filename nome do ficheiro 
	 * @param size tamanho do ficheiro
	 */
	void upload(String mail, String filename, int size);
	
	/**
	 * Partilha um ficheiro com outro ulitizador
	 * @param mail1 mail da conta que tem o ficheiro
	 * @param mail2 mail da conta com que quer fazer a partilha
	 * @param filename nome do ficheiro
	 */
	void share(String mail1, String mail2, String filename);
	
	/**
	 * Faz update de um ficheiro
	 * @param mail1 mail da conta que tem o ficheiro
	 * @param mail2 mail da conta com quem é partilhado o ficheiro
	 * @param filename nome do ficheiro
	 */
	void update(String mail1, String mail2, String filename);
	
	/**
	 * Devolve a lista de ficheiros do utulizador e os seus ficheiros que estao a ser partilhados
	 * @param mail - mail do utilizador que se quer saber os ficheiros 
	 * @return a lista de ficheiros do utilizador e os ficheiros partilhados
	 */
	String listAllFiles(String mail);
	
	/**
	 * Devolve a conta que fez a ultima alteracao no ficheiro
	 * @param mail mail da conta que é proprietaria do ficheiro
	 * @param filename nome do ficheiro
	 * @return
	 */
	String lastUpdate(String mail, String filename);
	
}
