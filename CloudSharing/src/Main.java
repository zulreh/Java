/**
 * 
 */
package poo;

import java.util.Scanner;

/**
 * @author Hernani
 *
 */
public class Main {

	//COMANDOS
	public static final String ADD = "add";
	public static final String UPLOAD = "upload";
	public static final String SHARE = "share";
	public static final String UPDATE = "update";
	public static final String MINSPACE = "minspace";
	public static final String LISTALL = "list all";
	public static final String LISTFILES = "list files";
	public static final String LISTBASIC = "list basic";
	public static final String LISTPREMIUM = "list premium";
	public static final String LASTUPDATE = "lastupdate";
	public static final String EXIT = "exit";
	
	//MENSAGENS CORRECTAS
	public static final String ACCOUNTADDED = "Account was added.";
	public static final String FILEUPLOADED = "File uploaded into account.";
	public static final String FILESHARED = "File was shared.";
	public static final String FILEUPDATED = "File was updated.";
	public static final String MINSPACESUCESSFUL = "Account with least free space: ";
	public static final String LISTALLSUCESSFUL = "All accounts:";
	public static final String LISTFILESSUCESSFUL = "Account has ";
	public static final String LISTFILESSUCESSFUL2 = " files:";
	public static final String LISTFILESSUCESSFUL3 = " shared files:";
	public static final String LISTBASICSUCESSFUL = "Basic accounts:";
	public static final String LISTPREMIUMSUCESSFUL = "Premium accounts:";
	public static final String LASTUPDATESUCESSFUL= "Last update: ";
	public static final String EXITSUCESSFUL= "Exiting...";

	//MENSAGENS DE ERRO
	public static final String ACCOUNTEXISTS = "Account already exists.";
	public static final String NOACCOUNT = "Account does not exist.";
	public static final String FILEEXISTSACCOUNT = "File already exist in the account.";
	public static final String FILEEXCEEDSCAP = "File size exceeds account capacity.";
	public static final String FILEEXISTS = "File does not exists.";
	public static final String ACCOUNTNOTALLOWSSAHRING = "Account does not allow file sharing.";
	public static final String FILEALREADYSHARED = "File already shared.";
	public static final String WRONG_COMM = "Wrong command!";
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String command = getCommand(in);
		CloudSharing cs = new CloudSharingClass();

		while (!(command.equalsIgnoreCase(EXIT))){
			if (command.equalsIgnoreCase(ADD)){			
				newAccount(in,cs);
				}
			else if (command.equalsIgnoreCase(UPLOAD)){
				uploadFile(in,cs);
				}	
			else if (command.equalsIgnoreCase(SHARE)){
				;
				}
			
			else if (command.equalsIgnoreCase(UPDATE)){
				;
				}
			
			else if (command.equalsIgnoreCase(MINSPACE)){
				;
			}
			
			else if (command.equalsIgnoreCase(LISTALL)){
				listAll(cs);
			}
			
			else if (command.equalsIgnoreCase(LISTFILES)){
				;
			}
			
			else if (command.equalsIgnoreCase(LISTBASIC)){
				;
			}
			
			else if (command.equalsIgnoreCase(LISTPREMIUM)){
				;
			}
			
			else if (command.equalsIgnoreCase(LASTUPDATE)){
				;	
			}
			else 
				System.out.println(WRONG_COMM);
				command = getCommand(in);
		}
			if(command.equalsIgnoreCase(EXIT))
				System.out.println(EXITSUCESSFUL);
				in.close();
	
		
	}
	
	private static String getCommand(Scanner in){
		
		String input = "";
		System.out.print("> ");
		input = in.next().toUpperCase();
		return input;
	}
	
	public static void newAccount(Scanner in,CloudSharing cs){
		
		String mail = in.next();
		String type = in.next();
	
		if (cs.addAccount(mail,type)){
			System.out.println(ACCOUNTADDED);
		}
		else 
			System.out.println(ACCOUNTEXISTS);
	}

	public static void uploadFile(Scanner in,CloudSharing cs){
		String mail = in.next();
		String filename = in.next();
		int filesize = in.nextInt();

		if (!(cs.hasAccount(mail)))//conta nao exitir
				System.out.println(NOACCOUNT);
		else if (cs.exists2Files(mail, filename))//existir um ficheiro com mesmo nome na mesma conta
				System.out.println(FILEEXISTSACCOUNT);
		else if (cs.exceedsCap(mail, filename, filesize))//dimensao exceder a cap da conta)
				System.out.println (FILEEXCEEDSCAP);
		else
			System.out.println(FILEUPLOADED);
	}
		
	public static void listAll(CloudSharing cs){
		
		Iterator i = cs.allAccounts();
		if(i.hasNext()){
			while(i.hasNext()){
			Account ac = (Account) i.next();
			System.out.println(ac.getAccount() + " (" + ac.getType()+")");
			}
		}
	}
}