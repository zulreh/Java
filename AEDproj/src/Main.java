import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import dataStructures.*;
import fitnessTracker.*;

/**
 * @author Denis Cunha n49284
 * @author Hernani Luz n41827
 */

@SuppressWarnings("unused")
public class Main {

	//comandos
	private static final String CREATEATHLETE = "IU" ;
	private static final String EDITATHLETE = "UU";
	private static final String REMOVEATLETE = "RU";
	private static final String CONSULTATHLETE = "CU";
	private static final String CREATEACTIVITY = "IA";
	private static final String ADDWORKOUT = "AW";
	private static final String CONSULTWORKOUT = "CW";
	private static final String UPDATESTEPS = "AS";
	private static final String CREATEGROUP = "IG";
	private static final String ADDATHELETEGROUP = "AG";
	private static final String DELETEFROMGROUP = "DG";
	private static final String CONSULTGROUP = "CG";
	private static final String LISTGROUP = "LG";
	private static final String LISTWALKERS = "LC";
	private static final String LISTWARRIORS = "LW";
	private static final String EXIT = "XS";
		
	//mensagens de operacoes concluidas com sucesso
	private static final String CREATEATHLETE_OK = "Insercao de atleta com sucesso.";
	private static final String EDITATHLETE_OK = "Atleta atualizado com sucesso.";
	private static final String REMOVEATHLETE_OK ="Atleta removido com sucesso.";
	private static final String CREATEACTIVITY_OK ="Atividade criada com sucesso.";
	private static final String ADDWORKOUT_OK ="Treino adicionado com sucesso.";
	private static final String ADDGROUP_OK ="Grupo criado com sucesso.";
	private static final String UPDATESTEPS_OK = "Atualizacao de passos com sucesso.";
	private static final String ADDATHELETEGROUP_OK = "Adesao realizada com sucesso.";
	private static final String DELETEFROMGROUP_OK = "Desistencia realizada com sucesso.";
	private static final String EXIT_OK = "Gravando e terminando...";
	
	
	//mensagens de erro
	private static final String ERROR1 = "Valores invalidos.";
	private static final String ERROR2 = "Atleta existente.";
	private static final String ERROR3= "Atleta inexistente.";
	private static final String ERROR4= "MET invalido.";
	private static final String ERROR5 = "Tempo invalido.";
	private static final String ERROR6 = "Atividade inexistente.";
	private static final String ERROR7 = "Opcao invalida.";
	private static final String ERROR8 = "Atleta sem treinos.";
	private static final String ERROR9 = "Numero de passos invalido.";
	private static final String ERROR10 = "Grupo existente.";
	private static final String ERROR11 = "Grupo inexistente.";
	private static final String ERROR12 = "Atleta ja tem grupo.";
	private static final String ERROR13 = "Atleta nao pertence ao grupo.";
	private static final String ERROR14 = "Grupo nao tem adesoes.";
	private static final String ERROR15 = "Nao existem grupos.";
	private static final String ERROR16 = "Atividade existente.";

	
	public static final String FILE = "save.txt";
	
	
	
	public static void main(String[] args) throws FileNotFoundException,
	IOException, ClassNotFoundException {
		Fittracker ft = load();
		if(ft ==null)
			ft = new FittrackerClass();
		Scanner in = new Scanner(System.in);
		String cmd = in.next().toUpperCase();
		while (!cmd.equals(EXIT)) {
			switch (cmd) {
			case CREATEATHLETE :
				addUser(in,ft);
				break;
			case EDITATHLETE :
				updateUser(in,ft);
				break;
			case REMOVEATLETE :
				removeUser(in,ft);
				break;
			case CONSULTATHLETE:
				listUserData(in, ft);
				break;
			case CREATEACTIVITY : 
				addActivity(in,ft);
				break;
			case ADDWORKOUT:
				addWorkout(in,ft);
				break;
			case CONSULTWORKOUT:
				consultWorkout(in,ft);
				break;
			case UPDATESTEPS:
				updateSteps(in,ft);
				break;
			case CREATEGROUP:
				addGroup(in,ft);
				break;
			case ADDATHELETEGROUP:
				addAtheleteToGroup(in,ft);
				break;
			case DELETEFROMGROUP:
				delFromGroup(in,ft);
				break;
			case CONSULTGROUP:
				consultGroup(in,ft);
				break;
			case LISTGROUP:
				listGroup(in,ft);
				break;
			case LISTWALKERS:
				listWalkers(ft);
				break;
			case LISTWARRIORS:
				listWarriors(ft);
				break;
			default: 
				break;
			}
			System.out.println();
			cmd = in.next().toUpperCase();
		}
		System.out.println(EXIT_OK + '\n');
		store(ft);
		in.close();
	}
	
	
	private static void listGroup(Scanner in, Fittracker ft) {
		String idTracker = in.next();
		
		try{
			System.out.println(ft.listGroup(idTracker));
		}catch(GrupoInexistenteException e){
			System.out.println(ERROR11);
		}catch(GrupoSemMembrosException e){
			System.out.println(ERROR14);
		}
	}


	private static void consultWorkout(Scanner in, Fittracker ft) {
		String idTracker = in.next();
		char tipo = in.next().charAt(0);
		try{
			System.out.println(ft.consultWorkout(idTracker, tipo));
		}catch(AtletaInexistenteException e){
			System.out.println(ERROR3);
		}catch(InvalidOptionException e){
			System.out.println(ERROR7);
		}catch(AtletaSemTreinosException e){
			System.out.println(ERROR8);
		}
		
	}
	
	private static void listWarriors(Fittracker ft) {
		try{
			System.out.println(ft.listWarriors());
			
		}
		catch(NoGroupException e){
			System.out.println(ERROR15);
		}
	}

	private static void listWalkers(Fittracker ft) {
		try{
			System.out.println(ft.listWalkers());
		}
		catch(NoGroupException e){
			System.out.println(ERROR15);
		}
	}
	
	private static void consultGroup(Scanner in, Fittracker ft) {
		String idGrupo = in.next();
		
		try{
			System.out.println(ft.consultGroup(idGrupo));
		}catch(GrupoInexistenteException e){
			System.out.println(ERROR11);	
		}
		
	}

	private static void listUserData(Scanner in, Fittracker ft) {
		String idTracker = in.next();		
		try{
			System.out.println(ft.listUserData(idTracker));
		}catch(AtletaInexistenteException e){
			System.out.println(ERROR3);
		}
	}
	
	
	private static void delFromGroup(Scanner in, Fittracker ft) {
		String idTracker = in.next();
		String idGrupo = in.next();
		try{
			ft.delFromGroup(idTracker,idGrupo);
			System.out.println(DELETEFROMGROUP_OK);
		}
		catch(AtletaInexistenteException e){
			System.out.println(ERROR3);
		}
		catch(GrupoInexistenteException e){
			System.out.println(ERROR11);	
		}
		catch(AtletaNaoPertenceGrupoException e){
			System.out.println(ERROR13);
		}
	}

	private static void addAtheleteToGroup(Scanner in, Fittracker ft) {
			String idTracker = in.next();
			String idGrupo = in.next();
			try{
				ft.addAtheleteToGroup(idTracker,idGrupo);
				System.out.println(ADDATHELETEGROUP_OK);
			}
			catch(AtletaInexistenteException e){
				System.out.println(ERROR3);
			}
			catch(GrupoInexistenteException e){
				System.out.println(ERROR11);
			}
			catch(AtletaComGrupoException e){
				System.out.println(ERROR12);
			}
	}

	private static void updateSteps(Scanner in, Fittracker ft) {
		String idTracker = in.next();
		int passos = in.nextInt();
		try{
			ft.updateSteps(idTracker,passos);
			System.out.println(UPDATESTEPS_OK);
		}
		catch(NonPositiveStepsException e){
			System.out.println(ERROR9);
		}
		catch (AtletaInexistenteException e){
			System.out.println(ERROR3);
		}
	}

	private static void addGroup(Scanner in, Fittracker ft) {
		String idGroup = in.next();
		String nome = in.next();
		nome=nome.trim();
		try{
			ft.addGroup(idGroup,nome);
			System.out.println(ADDGROUP_OK);
		}
		catch(GrupoInexistenteException e){
			System.out.println(ERROR11);
		}catch(GrupoExistenteException e){
			System.out.println(ERROR10);
		}
	}

	private static void addWorkout(Scanner in, Fittracker ft) {
		String idTracker= in.next();
		String idActividade = in.next();
		int duracao = in.nextInt();
		try{
			ft.addWorkout(idTracker,idActividade,duracao);
			System.out.println(ADDWORKOUT_OK);
		}
		catch(DurationException e){
		System.out.println(ERROR5);
		}
		catch(AtletaInexistenteException e){
		System.out.println(ERROR3);
		}
		catch(ActividadeInexistenteException e){
			System.out.println(ERROR6);
		}
	}

	private static void addActivity(Scanner in, Fittracker ft) {
		String idActividade = in.next();
		int MET = in.nextInt();
		String nome = in.nextLine();
		nome=nome.substring(nome.indexOf(' ')+1);
		nome=nome.trim();
		try{
		ft.addActivity(idActividade,MET, nome);
		System.out.println(CREATEACTIVITY_OK);
		}
		catch(METException e){
		 System.out.println(ERROR4);
		}
		catch(ActividadeExistenteException e){
		System.out.println(ERROR16);
		}
	}

	private static void removeUser(Scanner in, Fittracker ft) {
		String idTracker = in.next();
		try{
		ft.removeUser(idTracker);
		System.out.println(REMOVEATHLETE_OK);
		}
		catch(AtletaInexistenteException e){
			System.out.println(ERROR3);
		}
	}

	private static void updateUser(Scanner in, Fittracker ft) {
		String idTracker = in.next();
		int peso = in.nextInt();
		int altura = in.nextInt();
		int idade = in.nextInt();
		try{
		ft.updateUser( idTracker, peso, altura, idade);
		System.out.println(EDITATHLETE_OK);
		}
		catch(ValException e){
			System.out.println(ERROR1);
		}
		catch(AtletaInexistenteException e){
			System.out.println(ERROR3);
		}
		
	}

	private static void  addUser(Scanner in, Fittracker ft){
			String idTracker = in.next();
			int peso = in.nextInt();
			int altura = in.nextInt();
			int idade = in.nextInt();
			char sexo = in.next().charAt(0);
			String nome = in.nextLine();
			nome=nome.substring(nome.indexOf(' ')+1);
			nome=nome.trim();
			try{
			ft.addUser(idTracker, peso, altura, idade, sexo, nome);
			System.out.println(CREATEATHLETE_OK);
			}
			catch(AtletaExistenteException e){
				System.out.println(ERROR2);
			}
			catch(ValException e){
				System.out.println(ERROR1);
			}
	}

	/**
	 * Permite gravar o estado do sistema num ficheiro
	 * @param online
	 */
	public static void store(Fittracker ft) {
				
		try {
			ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(FILE));
			file.writeObject(ft);
			file.flush();
			file.close();
			}
		
		catch (IOException e) {}
	}
	
	/**
	 * Insere os dados do sistema
	 * @param online
	 * @return
	 */
	public static Fittracker load() {
		
		Fittracker save = null;
		
			try {
			ObjectInputStream file = new ObjectInputStream(new FileInputStream(FILE));
			save = (Fittracker) file.readObject();
			file.close();
				}
		
			catch (IOException e) {}
			catch (ClassNotFoundException e) {}
			
		return save;
	}
}
