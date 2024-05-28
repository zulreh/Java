package fitnessTracker;

import java.io.Serializable;
/**
 * @author Denis Cunha n49284
 * @author Hernani Luz n41827
 */

public interface Fittracker extends Serializable{
	

	/**
	 * Adiciona um novo atleta ao sistema
	 * @param idTracker - idTracker do novo atleta
	 * @param peso - peso do novo atleta
	 * @param altura - altura do novo atleta
	 * @param idade - idade do novo atleta
	 * @param sexo - sexo do novo atleta
	 * @param nome - nome do novo atleta
	 * @throws AtletaExistenteException
	 * @throws ValException
	 */
	public void addUser(String idTracker,int peso,int altura, int idade, char sexo, String nome)throws AtletaExistenteException, ValException;
	
	
	/**
	 * Modifica os parametros de um atleta ja existente no sistema
	 * @param idTracker - idTracker do atleta ja existente
	 * @param peso - novo peso do atleta
	 * @param altura - nova altura do atleta
	 * @param idade - nova idade do atleta
	 * @throws ValException
	 * @throws AtletaInexistenteException
	 */
	public void updateUser(String idTracker,int peso,int altura,int idade)throws ValException,AtletaInexistenteException ;

	
	/**
	 * Remove um atleta ja existente no sistema
	 * @param idTracker - idTracker do atleta
	 * @throws AtletaInexistenteException
	 */
	public void removeUser(String idTracker)throws AtletaInexistenteException;

	
	/**
	 * Adiciona uma nova actividade 
	 * @param idActividade - id da nova actividade
	 * @param MET - MET da nova actividade
	 * @param nome - nome da nova actividade
	 * @throws METException
	 * @throws ActividadeExistenteException
	 */
	public void addActivity(String idActividade, int MET, String nome) throws METException,ActividadeExistenteException;

	
	/**
	 * Adiciona um novo treino
	 * @param idTracker - idTracker do atleta ja existente no sistema
	 * @param idActividade - idActividade da actividade existente no sistema
	 * @param duracao - duracao da actividade
	 * @throws DurationException
	 * @throws ActividadeInexistenteException
	 * @throws AtletaInexistenteException
	 */
	public void addWorkout(String idTracker, String idActividade, int duracao) throws DurationException,ActividadeInexistenteException,AtletaInexistenteException ;

	
	/**
	 * Adiciona um novo grupo ao sistema
	 * @param idGroup - idGroup do novo grupo
	 * @param nome - nome do novo grupo
	 * @throws GrupoExistenteException
	 */
	public void addGroup(String idGroup, String nome)throws GrupoExistenteException;

	
	/**
	 * Modifica os passos de um atleta
	 * @param idTracker - idTracker do atleta ja existente no sistema
	 * @param passos - novos passos do atleta
	 * @throws AtletaInexistenteException
	 * @throws NonPositiveStepsException
	 */
	public void updateSteps(String idTracker, int passos)throws AtletaInexistenteException,NonPositiveStepsException;

	
	/**
	 * Adiciona um atleta a um grupo ja existente no sistema
	 * @param idTracker - idTracker do atleta
	 * @param idGrupo - idGrupo do grupo
	 * @throws AtletaInexistenteException
	 * @throws GrupoInexistenteException
	 * @throws AtletaComGrupoException
	 */
	public void addAtheleteToGroup(String idTracker, String idGrupo)throws AtletaInexistenteException,GrupoInexistenteException,AtletaComGrupoException;

	
	/**
	 * Retira um atleta de um grupo
	 * @param idTracker - idTracker do atleta
	 * @param idGrupo - idGrupo do grupo
	 */
	public void delFromGroup(String idTracker, String idGrupo);

	
	/**
	 * Consulta os dados de um grupo existente no sistema
	 * @param idGrupo - idGrupo do grupo
	 * @return informacao do grupo
	 * @throws GrupoInexistenteException
	 */
	public String consultGroup(String idGrupo) throws GrupoInexistenteException;

	
	/**
	 * Consulta os dados de um atleta ja existente no sistema
	 * @param idTracker - idTracker do atleta
	 * @return informacao do atleta
	 * @throws AtletaInexistenteException
	 * @throws NoGroupException
	 */
	public String listUserData(String idTracker) throws AtletaInexistenteException, NoGroupException;

	
	/**
	 * Listagem da ordenacaoo atual dos grupos para o concurso Guerreiros do ano
	 * @return listagem dos Guerreiros do ano
	 * @throws NoGroupException
	 */
	public String listWarriors() throws NoGroupException;

	
	/**
	 * Listagem da ordenacao atual dos grupos para o concurso Caminhantes do ano
	 * @return listagem dos Caminhantes do ano
	 * @throws NoGroupException
	 */
	public String listWalkers() throws NoGroupException;

	
	/**
	 * Listagem das actividades de um user ja existente no sistema
	 * @param idTracker - idTracker do user
	 * @param tipo - tipo 'T' ordem	cronologica (mais recente para mais antigo), tipo 'C' ordem decrescente pelo total de calorias de cada actividade
	 * @return informacao da actividade
	 * @throws AtletaInexistenteException
	 * @throws InvalidOptionException
	 * @throws AtletaSemTreinosException
	 */
	public String consultWorkout(String idTracker, char tipo) throws AtletaInexistenteException,InvalidOptionException,AtletaSemTreinosException;

	
	/**
	 * Listagem dos atletas existentes no grupo que contem idGroup
	 * @param idGroup - idGroup do grupo
	 * @return
	 */
	public String listGroup(String idGroup);
}
