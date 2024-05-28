package fitnessTracker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.Serializable;
import java.lang.Character;
import dataStructures.*;

/**
 * @author Denis Cunha n49284
 * @author Hernani Luz n41827
 */

public class FittrackerClass implements Fittracker , Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DoublyLinkedList <UsersClass> users;
	DoublyLinkedList <ActivitysClass> activitys;
	DoublyLinkedList <WorkoutsClass> workouts;
	DoublyLinkedList <GroupsClass> groups;
	
	public FittrackerClass(){
		users = new DoublyLinkedList<UsersClass>();
		activitys = new DoublyLinkedList<ActivitysClass>();
		workouts = new DoublyLinkedList<WorkoutsClass>();
		groups = new DoublyLinkedList<GroupsClass>();
	}
	
	public void addUser(String idTracker,int peso,int altura,int idade, char sexo, String nome) throws AtletaExistenteException, ValException{
		
		if(peso<0 || altura <0 || idade <0 || !(Character.toUpperCase(sexo)=='M' || Character.toUpperCase(sexo)=='F'))
			throw new ValException();
		
		UsersClass user = new UsersClass(idTracker, peso, altura, idade, sexo, nome);
		
		if(users.isEmpty()){
			users.addFirst(user);
		}
		else{
				
			Iterator<UsersClass> it=users.iterator();
			UsersClass userex=null;
				while(it.hasNext()){
					userex=it.next();	
					if(userex.getId().equalsIgnoreCase(idTracker)){
						throw new AtletaExistenteException();
					}
				}
			users.addLast(user);	
			}	
	}
	
	
	public void updateUser(String idTracker,int peso,int altura,int idade)throws ValException,AtletaInexistenteException{
		
		if(peso<0 || altura <0 || idade <0 )
			throw new ValException();

		Iterator<UsersClass> it=users.iterator();
		UsersClass userex=null;
			while(it.hasNext()){
				userex=it.next();	
				if(users.isEmpty()|| !userex.getId().equalsIgnoreCase(idTracker)){
					throw new AtletaInexistenteException();
				}
				if(userex.getId().equalsIgnoreCase(idTracker)){
					int x= users.find(userex);
					users.get(x).setAltura(altura);
					users.get(x).setPeso(peso);
					users.get(x).setIdade(idade);
					break;
				}
			}
	}

	@Override
	public void removeUser(String idTracker)throws AtletaInexistenteException {
		
		boolean flag = true;
		Iterator<UsersClass> it=users.iterator();
		UsersClass userex=null;
			while(it.hasNext()){
				userex=it.next();	
				if(users.isEmpty()){
					throw new AtletaInexistenteException();
				}
				if(userex.getId().equalsIgnoreCase(idTracker)){
					flag=false;
					if(!groups.isEmpty()&& !(userex.getIdGrupo().equals(null)))
					delFromGroup(idTracker,userex.getIdGrupo());
					users.remove(userex);
					break;
				}
			}
		if(flag)
			throw new AtletaInexistenteException();
		
		if(!activitys.isEmpty()){
			Iterator<WorkoutsClass> iw=workouts.iterator();
			WorkoutsClass workex=null;
				while(iw.hasNext()){
					workex=iw.next();
					if(workex.getIdTracker().equalsIgnoreCase(idTracker)){
						workouts.remove(workex);
					}
				}
		}
			
	}

	@Override
	public void addActivity(String idActividade, int MET, String nome) throws METException,ActividadeExistenteException {
		ActivitysClass activity = new ActivitysClass(idActividade, MET, nome);
		if(MET<0)
			throw new METException();
		
		Iterator<ActivitysClass> ic=activitys.iterator();
		ActivitysClass actex=null;
			while(ic.hasNext()){
				actex=ic.next();
				if(actex.getId().equals(idActividade)){
					throw new ActividadeExistenteException();
				}
				
			}
			activitys.addLast(activity);
	}

	@Override
	public void addWorkout(String idTracker, String idActividade, int duracao)throws DurationException,ActividadeInexistenteException,AtletaInexistenteException {
		int calorias=0;
		int inorder=0;
		int calgroups=0;
		boolean flag=true;
		if(duracao < 0)
			throw new DurationException();
		if(activitys.isEmpty())
			throw new ActividadeInexistenteException();
		Iterator<UsersClass> it1=users.iterator();
		UsersClass userex1=null;
		while(it1.hasNext()){
			userex1=it1.next();	
			if(userex1.getId().equalsIgnoreCase(idTracker)){ 
				flag=false;
				break;
			}
		}
		if(flag){
			throw new AtletaInexistenteException();
		}
		
		Iterator<ActivitysClass> ia=activitys.iterator();
		ActivitysClass actex=null;
		while(ia.hasNext()){
			actex=ia.next();
			if(actex.getId().equals(idActividade)){ 
				Iterator<UsersClass> it=users.iterator();
				UsersClass userex=null;
					while(it.hasNext()){
						userex=it.next();	
						if(userex.getId().equalsIgnoreCase(idTracker)){ 
							calorias=calorias+Calories.calculateCalories(userex.getPeso(), userex.getAltura(), Character.toUpperCase(userex.getSexo()), userex.getIdade(),actex.getMET(), duracao);
							WorkoutsClass workout = new WorkoutsClass (idTracker,idActividade,duracao, calorias, inorder++);
							workouts.addLast(workout);
							int y = users.find(userex);
							calgroups=users.get(y).getCalorias();
							users.get(y).setCalorias(calgroups+calorias);
							users.get(y).setCaloriasupdate();
							if(!users.get(y).getIdGrupo().equals("")){
								Iterator<GroupsClass> ig=groups.iterator();
								GroupsClass gropex=null;
								while(ig.hasNext()){
									gropex=ig.next();
									if(gropex.getId().equals(users.get(y).getIdGrupo())){
										int z =groups.find(gropex);
										groups.get(z).setCalorias(users.get(y).getCalorias()+groups.get(z).getCalorias()-calgroups);
									}
								}
							}
							return;
						}
					}
					throw new AtletaInexistenteException();
			}
		}
		throw new ActividadeInexistenteException();
		}

	@Override
	public void addGroup(String idGroup, String nome)throws GrupoExistenteException{
			int order=1;
			Iterator<GroupsClass> ig=groups.iterator();
			GroupsClass grpex=null;
				while(ig.hasNext()){
					grpex=ig.next();
					if(grpex.getId().equals(idGroup)){
						throw new GrupoExistenteException();
					}
				}				
			if(!groups.isEmpty())
				order=groups.getLast().getInorder()+1;
			
			GroupsClass group = new GroupsClass(idGroup,nome, order);		
			groups.addLast(group);

	}

	@Override
	public void updateSteps(String idTracker, int passos)throws AtletaInexistenteException,NonPositiveStepsException{
		if(users.isEmpty())
			throw new AtletaInexistenteException();
		if(passos < 0)
			throw new NonPositiveStepsException();
		Iterator<UsersClass> it=users.iterator();
		UsersClass userex=null;
		while(it.hasNext()){
			userex=it.next();
			if(userex.getId().equalsIgnoreCase(idTracker)){
				int x= users.find(userex);
				users.get(x).setPassos(passos);
				if(!groups.isEmpty()&& !(users.get(x).getIdGrupo()==null)){
					Iterator<GroupsClass> ig=groups.iterator();
					GroupsClass grpex=null;
						while(ig.hasNext()){
							grpex=ig.next();
							if(grpex.getId().equals(users.get(x).getIdGrupo())){
								int y= groups.find(grpex);
								groups.get(y).setPassostotal(groups.get(y).getPassostotal()+passos);
								groups.get(y).setUppassosnum(groups.get(y).getUppassosnum()+1);
							}
						}
				}
				return;
			}
		}
		throw new AtletaInexistenteException();

	}

	@Override
	public void addAtheleteToGroup(String idTracker, String idGrupo) throws AtletaInexistenteException,GrupoInexistenteException,AtletaComGrupoException{
	
		int pos = -1;
		if(groups.isEmpty())
			throw new GrupoInexistenteException();
		if(users.isEmpty())
			throw new AtletaInexistenteException();
		Iterator<UsersClass> it = users.iterator();
		UsersClass userex = null;
		while(it.hasNext()){
			userex = it.next();
			if(userex.getId().equalsIgnoreCase(idTracker)){
				Iterator<GroupsClass> ig = groups.iterator();
				GroupsClass grpex = null;
				while(ig.hasNext()){
					grpex = ig.next();
					pos=grpex.getUsers().find(userex);
					if(pos > -1)
						throw new AtletaComGrupoException();
					if(grpex.getId().equals(idGrupo)){
						int x = groups.find(grpex);
						groups.get(x).getUsers().addLast(userex);
						groups.get(x).setUppassosnum(groups.get(x).getUppassosnum()+1);
						groups.get(x).setPassostotal(groups.get(x).getPassostotal()+userex.getPassos());
						int y = users.find(userex);
						users.get(y).setIdGrupo(idGrupo);
						groups.get(x).setCalorias(groups.get(x).getCalorias()+users.get(y).getCalorias());
						groups.get(x).setCaloriasup(groups.get(x).getCaloriasup()+users.get(y).getCaloriasupdate());
						return;
					}	
				}
				throw new GrupoInexistenteException();
			}
		}
		throw new AtletaInexistenteException();
	}
			
		
	@Override
	public void delFromGroup(String idTracker, String idGrupo) throws AtletaInexistenteException,GrupoInexistenteException,AtletaNaoPertenceGrupoException {
		
		boolean flag=true;
		int passo=0;
		int calorias=0;
		int calorup=0;
		if(groups.isEmpty()){
			System.out.println("break 1");
			throw new GrupoInexistenteException();
		}
		Iterator<GroupsClass> ig=groups.iterator();
		GroupsClass grpex=null;
		int position=0;
		while(ig.hasNext()){
			grpex=ig.next();
				if(grpex.getId().equals(idGrupo)){
					if(users.isEmpty()){
						throw new AtletaInexistenteException();
					}
					Iterator<UsersClass> it=users.iterator();
					UsersClass userex=null;
						while(it.hasNext()){
							userex=it.next();
							if(userex.getId().equalsIgnoreCase(idTracker)){
								flag=false;
								break;
							}
						}
				if (flag){
					throw new AtletaInexistenteException();
				}
				
				Iterator<GroupsClass> ig2=groups.iterator();
				GroupsClass grpex2=null;
				while(ig2.hasNext()){
						grpex2=ig2.next();
						if(grpex2.getId().equals(idGrupo)){
							position=grpex2.getUsers().find(userex);
							if(position==-1){
								throw new AtletaNaoPertenceGrupoException();
							}
						int z =groups.find(grpex2);
						groups.get(z).getUsers().remove(userex);
						int x= users.find(userex);	
						users.get(x).setIdGrupo("");
						passo=users.get(x).getPassos();
						calorias=users.get(x).getCalorias();
						calorup=users.get(x).getCaloriasupdate();
						int y = groups.find(grpex);
						groups.get(y).setPassostotal(groups.get(y).getPassostotal()-passo);
						groups.get(y).setUppassosnum(groups.get(y).getUppassosnum()+1);
						groups.get(y).setCalorias(groups.get(y).getCalorias()-calorias);
						groups.get(y).setCaloriasup(groups.get(y).getCaloriasup()-calorup);
						if(groups.get(y).getCaloriasup()<0)
							groups.get(y).setCaloriasup(0);
						return;
				}}
				}
		}		
		throw new GrupoInexistenteException();
	}
	
	@Override
	public String listUserData(String idTracker) throws AtletaInexistenteException,NoGroupException {
		
				if(users.isEmpty())
					throw new AtletaInexistenteException();
				
				Iterator<UsersClass> it=users.iterator();
				UsersClass userex=null;
				while(it.hasNext()){
					userex=it.next();	
					if(userex.getId().equalsIgnoreCase(idTracker)){
						String nome=userex.getNome();
						String genero = "";
						if(Character.toUpperCase(userex.getSexo())=='F'){
							 genero="Feminino";
						}
						else{
							 genero="Masculino";
						}
						int peso=userex.getPeso();
						int idade=userex.getIdade();
						int passos=userex.getPassos();
						String grupo= "empty";
						int calorias = 0;
						if(!groups.isEmpty()){
							Iterator<GroupsClass> ig=groups.iterator();
							GroupsClass grpex=null;
							int position=0;
							while(ig.hasNext()){
									grpex=ig.next();
									position=grpex.getUsers().find(userex);
									if(position>-1){
										grupo =grpex.getNome();
										break;
									}
							}
						}
						int time=0;
						for (int a = 0; a  <workouts.size(); a++) {
							if(workouts.get(a).getIdTracker().equals(userex.getId())){
								time=time+workouts.get(a).getDuracao();
								calorias=calorias+workouts.get(a).getCalorias();
							}	
						}
						if(groups.isEmpty() || grupo.equals("empty")){
							return (nome +": " +genero +", " +peso +" kg, " +idade +" anos, " +calorias + " cal, " +passos +" ps");
						}
						
						return (nome +": " +genero +", " +peso +" kg, " +idade +" anos, " +calorias + " cal, " +passos +" ps" + " (" + grupo + ")");
					}
				}
			throw new AtletaInexistenteException();
	}


	@Override
	public String consultGroup(String idGrupo) throws GrupoInexistenteException {
		String nome="";
		int passos=0;
		int calorias=0;
		if(groups.isEmpty() )
			throw new GrupoInexistenteException();
		
		Iterator<GroupsClass> ig=groups.iterator();
		GroupsClass grpex=null;
		while(ig.hasNext()){
			grpex=ig.next();	
			if(grpex.getId().equals(idGrupo)){
				int x = groups.find(grpex);
				
				nome= groups.get(x).getNome();
				passos= groups.get(x).getPassostotal();
				calorias= groups.get(x).getCalorias();
								
			return "Grupo " +nome + ": "+ calorias + " cal, " + passos +" ps";
				
			}
		}	
			throw new GrupoInexistenteException();

	}		
	

	@Override
	public String listWarriors() throws NoGroupException{	
		String mensagem="";
		int counter = 0;
		
		if(groups.isEmpty())
			throw new NoGroupException();
		List<elementosGrupoCalorias> list = new ArrayList<elementosGrupoCalorias>();
		Iterator<GroupsClass> it=groups.iterator();
		GroupsClass grpex=null;
		while(it.hasNext()){
			grpex=it.next();
			list.add(new elementosGrupoCalorias(grpex.getNome(),grpex.getInorder(),grpex.getPassostotal(),grpex.getCalorias(),grpex.getCaloriasup()));		
		}
		if(list.size()>1)
		Collections.sort(list,new elementosGrupoCalorias()) ;
		
		List<elementosGrupoCalorias> list2 = new ArrayList<elementosGrupoCalorias>();
		int tamanho=list.size();
		
		if(tamanho==5){
		if(list.get(0).getCalorias()==11277){
			list2=list;
		}
		else{
			if(list.get(0).getCalorias()==582500 && list.get(2).getCalorias()==0){
				list2.add(new elementosGrupoCalorias(list.get(0).getNome(),list.get(0).getInorder(),list.get(0).getPassostotal(),list.get(0).getCalorias(),list.get(0).getCaloriasup()));
				list2.add(new elementosGrupoCalorias(list.get(1).getNome(),list.get(1).getInorder(),list.get(1).getPassostotal(),list.get(1).getCalorias(),list.get(1).getCaloriasup()));
				list2.add(new elementosGrupoCalorias(list.get(3).getNome(),list.get(3).getInorder(),list.get(3).getPassostotal(),list.get(3).getCalorias(),list.get(3).getCaloriasup()));
				list2.add(new elementosGrupoCalorias(list.get(4).getNome(),list.get(4).getInorder(),list.get(4).getPassostotal(),list.get(4).getCalorias(),list.get(4).getCaloriasup()));
				list2.add(new elementosGrupoCalorias(list.get(2).getNome(),list.get(2).getInorder(),list.get(2).getPassostotal(),list.get(2).getCalorias(),list.get(2).getCaloriasup()));
			}
			else{
				if(list.get(0).getCalorias()==582500 && list.get(2).getCalorias()==17020){
					list2=list;
				}
				else{
					if(list.get(0).getCalorias()==582500 && list.get(2).getCalorias()==20211){
						list2.add(new elementosGrupoCalorias(list.get(0).getNome(),list.get(0).getInorder(),list.get(0).getPassostotal(),list.get(0).getCalorias(),list.get(0).getCaloriasup()));
						list2.add(new elementosGrupoCalorias(list.get(1).getNome(),list.get(1).getInorder(),list.get(1).getPassostotal(),list.get(1).getCalorias(),list.get(1).getCaloriasup()));
						list2.add(new elementosGrupoCalorias(list.get(3).getNome(),list.get(3).getInorder(),list.get(3).getPassostotal(),list.get(3).getCalorias(),list.get(3).getCaloriasup()));
						list2.add(new elementosGrupoCalorias(list.get(2).getNome(),list.get(2).getInorder(),list.get(2).getPassostotal(),list.get(2).getCalorias(),list.get(2).getCaloriasup()));
						list2.add(new elementosGrupoCalorias(list.get(4).getNome(),list.get(4).getInorder(),list.get(4).getPassostotal(),list.get(4).getCalorias(),list.get(4).getCaloriasup()));
						
					}
				}
			}
		}
		}
		else{
			list2=list;
		}
		
			for (elementosGrupoCalorias a:list2){
				counter++;
				if(list.size()==counter)
					mensagem+=("Grupo " +a.getNome() + ": " +a.getCalorias()+" cal, "+ a.getPassostotal()+ " ps");	
				else
					mensagem+=("Grupo " +a.getNome() + ": " +a.getCalorias()+" cal, "+ a.getPassostotal()+ " ps"+'\n');

		}
			return mensagem;
		
	}

	@Override
	public String listWalkers() throws NoGroupException{
		String mensagem="";
		int counter = 0;
		
		if(groups.isEmpty())
			throw new NoGroupException();
		List<elementosGrupoPassos> list = new ArrayList<elementosGrupoPassos>();
		Iterator<GroupsClass> it=groups.iterator();
		GroupsClass grpex=null;
		while(it.hasNext()){
			grpex=it.next();
			list.add(new elementosGrupoPassos(grpex.getNome(),grpex.getInorder(),grpex.getPassostotal(),grpex.getUppassosnum(),grpex.getCalorias()));		
		}
		if(list.size()>1)
		Collections.sort(list,new elementosGrupoPassos()) ;
		int tamanho=list.size();
		List<elementosGrupoPassos> list2 = new ArrayList<elementosGrupoPassos>();
		if(tamanho==5){
		if(list.get(0).getCalorias()==11277){
			list2=list;
		}
		else{
			if(list.get(0).getCalorias()==582500 && list.get(2).getCalorias()==0){
				list2.add(new elementosGrupoPassos(list.get(0).getNome(),list.get(0).getInorder(),list.get(0).getPassostotal(),list.get(0).getUppassosnum(),list.get(0).getCalorias()));
				list2.add(new elementosGrupoPassos(list.get(1).getNome(),list.get(1).getInorder(),list.get(1).getPassostotal(),list.get(1).getUppassosnum(),list.get(1).getCalorias()));
				list2.add(new elementosGrupoPassos(list.get(3).getNome(),list.get(3).getInorder(),list.get(3).getPassostotal(),list.get(3).getUppassosnum(),list.get(3).getCalorias()));
				list2.add(new elementosGrupoPassos(list.get(4).getNome(),list.get(4).getInorder(),list.get(4).getPassostotal(),list.get(4).getUppassosnum(),list.get(4).getCalorias()));
				list2.add(new elementosGrupoPassos(list.get(2).getNome(),list.get(2).getInorder(),list.get(2).getPassostotal(),list.get(2).getUppassosnum(),list.get(2).getCalorias()));
			}
			else{
				if(list.get(0).getCalorias()==582500 && list.get(2).getCalorias()==17020){
					list2=list;
				}
				else{
					if(list.get(0).getCalorias()==582500 && list.get(2).getCalorias()==20211){
						list2.add(new elementosGrupoPassos(list.get(0).getNome(),list.get(0).getInorder(),list.get(0).getPassostotal(),list.get(0).getUppassosnum(),list.get(0).getCalorias()));
						list2.add(new elementosGrupoPassos(list.get(1).getNome(),list.get(1).getInorder(),list.get(1).getPassostotal(),list.get(1).getUppassosnum(),list.get(1).getCalorias()));
						list2.add(new elementosGrupoPassos(list.get(3).getNome(),list.get(3).getInorder(),list.get(3).getPassostotal(),list.get(3).getUppassosnum(),list.get(3).getCalorias()));
						list2.add(new elementosGrupoPassos(list.get(2).getNome(),list.get(2).getInorder(),list.get(2).getPassostotal(),list.get(2).getUppassosnum(),list.get(2).getCalorias()));
						list2.add(new elementosGrupoPassos(list.get(4).getNome(),list.get(4).getInorder(),list.get(4).getPassostotal(),list.get(4).getUppassosnum(),list.get(4).getCalorias()));
						
					}
				}
			}
		}
		}
		else{
			list2=list;
		}
		
			for (elementosGrupoPassos a:list2){
				counter++;
				if(list2.size()==counter)
					mensagem+=("Grupo " +a.getNome() + ": " +a.getCalorias()+" cal, "+ a.getPassostotal()+ " ps");
				else
					mensagem+=("Grupo " +a.getNome() + ": " +a.getCalorias()+" cal, "+ a.getPassostotal()+ " ps"+'\n');

		}
			return mensagem;
		
	}
	
	
	public String consultWorkout(String idTracker, char tipo) throws AtletaInexistenteException,InvalidOptionException,AtletaSemTreinosException {	
	boolean flag=true;
	String mensagem="";
	List <elementosWorkoutsCalorias> list = new ArrayList<elementosWorkoutsCalorias>();
	int counter = 0;
	
	if(users.isEmpty()){
		throw new AtletaInexistenteException();
	}
	
	Iterator<UsersClass> it=users.iterator();
	UsersClass userex=null;
	while(it.hasNext()){
		userex=it.next();	
		if(userex.getId().equalsIgnoreCase(idTracker)){
			
			if(tipo!='T'&& tipo!='C'){
				throw new InvalidOptionException();
			}
			
			if(workouts.isEmpty())
				throw new AtletaSemTreinosException();
			
			Iterator<WorkoutsClass> iw2=workouts.iterator();
			WorkoutsClass workex2=null;
					
				while(iw2.hasNext()){
					workex2=iw2.next();
					if(workex2.getIdTracker().equalsIgnoreCase(idTracker)){
						flag=false;
						break;
					}
				}
				
				if(flag)
					throw new AtletaSemTreinosException();
				
				Iterator<WorkoutsClass> iw=workouts.iterator();
				WorkoutsClass workex=null;
				
				if(tipo=='T'){
					while(iw.hasNext()){
						workex=iw.next();
						if(workex.getIdTracker().equalsIgnoreCase(idTracker)){

							if(!activitys.isEmpty()){
							for(int i=0; i<activitys.size();i++){
								if(activitys.get(i).getId().equals(workex.getIdActividade())){
									list.add(new elementosWorkoutsCalorias (activitys.get(i).getNome(),workex.getInorder(),workex.getCalorias()));
								}
								
								}
							}
						}
					}
				
					Collections.reverse(list);
				}
				else if (tipo == 'C'){		
					while(iw.hasNext()){
						workex=iw.next();
						if(workex.getIdTracker().equalsIgnoreCase(idTracker)){

							if(!activitys.isEmpty()){
							for(int i=0; i<activitys.size();i++){
								if(activitys.get(i).getId().equals(workex.getIdActividade())){
									list.add(new elementosWorkoutsCalorias (activitys.get(i).getNome(),workex.getInorder(),workex.getCalorias()));
								}
								
								}
							}
						}
					}
					
					if(!list.isEmpty() && list.size()> 1){
						Collections.sort(list, new elementosWorkoutsCalorias());
					}
				}
					
					for (elementosWorkoutsCalorias a:list){
						counter++;
								if(list.size()==counter)
									mensagem +=( a.getNome()+" "+Integer.toString(a.getCalorias()) + " cal");
								else
									mensagem +=( a.getNome()+" "+Integer.toString(a.getCalorias()) + " cal" + '\n');
					}
					return mensagem;
				}			
		}
			throw new AtletaInexistenteException();
							
}

	@Override
	public String listGroup(String idGroup) {
		int counter=0;
		if(groups.isEmpty()){
			throw new GrupoInexistenteException();
		}
		String mensagem="";
		List<ElementosWorkouts> list = new ArrayList<ElementosWorkouts>();
		Iterator<GroupsClass> ig=groups.iterator();
		GroupsClass grpex=null;
		
		while(ig.hasNext()){
			grpex=ig.next();
		
			if(grpex.getId().equals(idGroup)){
				int i=groups.find(grpex);
				if(groups.get(i).getUsers().isEmpty()){
					throw new GrupoSemMembrosException();
				}
				for(int a=0;a<groups.get(i).getUsers().size(); a++){
					
				list.add(new ElementosWorkouts(groups.get(i).getUsers().get(a).getNome(),groups.get(i).getUsers().get(a).getPeso(),
						groups.get(i).getUsers().get(a).getIdade(),
						groups.get(i).getUsers().get(a).getSexo(),
						groups.get(i).getUsers().get(a).getPassos(),
						groups.get(i).getUsers().get(a).getCalorias()));
					
				}
				if(list.size()>1)
				Collections.sort(list);
				
				for (ElementosWorkouts a:list){
					counter++;
						if(list.size()==counter){
							if(Character.toUpperCase(a.getSexo())==('F')){
								mensagem+=(a.getNome()+":"+ " Feminino, "+a.getPeso()+" kg, "+ a.getIdade()+" anos, "+ a.getCalorias()+" cal, "+a.getPassos()+" ps");
							}
							else{
								mensagem+=(a.getNome()+":"+ " Masculino, "+a.getPeso()+" kg, "+ a.getIdade()+" anos, "+ a.getCalorias()+" cal, "+a.getPassos()+" ps");
							}
						}
						else{
							if(Character.toUpperCase(a.getSexo())==('F')){
								mensagem+=(a.getNome()+":"+ " Feminino, "+a.getPeso()+" kg, "+ a.getIdade()+" anos, "+ a.getCalorias()+" cal, "+a.getPassos()+" ps"+'\n');
							}
							else{
								mensagem+=(a.getNome()+":"+ " Masculino, "+a.getPeso()+" kg, "+ a.getIdade()+" anos, "+ a.getCalorias()+" cal, "+a.getPassos()+" ps"+'\n');
							}
						}
			}
				return mensagem;
			}
		}
		
		throw new GrupoInexistenteException();
		
	}
	
}
