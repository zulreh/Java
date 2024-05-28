/**
 * 
 */
package poo;

import cloudsharing.AccountIterator;

/**
 * @author Hernani
 *
 */

public class CloudSharingClass implements CloudSharing {


	// Constantes
	private static final int MAX = 500;
	private static final String BASIC = "Basic";
	private static final String PREMIUM = "Premium";
	
	// Variaveis
	private int counter;
	
	// Vector
	private Account[] accounts;
	private BasicAccount ba;
	private PremiumAccount pa;
	private int current;
	
	public CloudSharingClass(){
		accounts = new Account[MAX];
		counter = 0;
		current = 0;
	}
	
	public boolean addAccount(String mail, String type) {
		if (hasAccount(mail)){
			return false;
		}
		else {
			if(type.equals(BASIC)){
			accounts[counter] = new BasicAccount(mail);
			counter++;
			}
			else if(type.equals(PREMIUM)){
			accounts[counter] = new PremiumAccount(mail);
			counter++;
			}
			return true;
		}
	}
	
	public int uploadFile(String mail, String filename, int size) {
	
	}

	@Override
	public boolean shareFile(String mail1, String mail2, String filename) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateFile(String mail1, String mail2, String filename) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String listAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String listFiles(String mail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String listByTypeOfAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String lastUpdate(String mail, String filename) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean hasAccount(String mail) {
		Iterator ai = new AccountIterator(counter, accounts);
		boolean found = false;
		ai.init();
		while(ai.hasNext() && !found){
			if (((Account) ai.next()).getAccount().equals(mail)){
				found = true;
			}
		}
		return found;
	}




	@Override
	public boolean checkSharingFile(String mail1, String mail2, String filename) {
		// TODO Auto-generated method stub
		return false;
	}
		
	public Iterator AccountIterator(){
		return new AccountIterator(counter, accounts);
	}
	
	public Iterator FilesIterator(){
		return new FilesIterator(counter, accounts[]); //O QUE METER COMO ARGUMENTO??? O indice que esta como return no searchIndexWhoHasFile
	}
	
	public boolean checkSizeFile(String mail, int size){
		boolean found = true;	
		return found;
	}
	
	/**
	 * Procura a posicao do mail que é igual ao mail do argumento
	 * @param mail
	 * @return a posicao do mail
	 */
	private int searchIndexMail(String mail){
		int pos = current;
		int result = -1;
		if (counter == 0)
				result=-1;
		else
			while (((pos >= 0) && (result == -1))){
				if ((accounts[pos].getAccount().equals(mail)))
					result = pos;
				else
					pos--;
			}
		return result;
	}
	/**
	 * Devolve a posicao do mail que tem o ficheiro se existir
	 * @param mail
	 * @param filename
	 * @return
	 */
	private int searchIndex2Files(String mail, String filename){
		int pos = current;
		int result = -1;
		int foundfile =  -1;
		int next = -1;
		if (counter == 0)
				result=-1;
		else
			while (((pos >= 0) && (foundfile == -1))){
				if ((accounts[pos].getAccount().equals(mail))){
					result = pos;
					foundfile = 0;
					if(((Files)accounts[result]).getFileName().equals(filename)){
						foundfile = 1;
						while((pos>result) && next == -1){
							if(((Files)accounts[pos]).getFileName().equals(filename)){
								foundfile = 2;
							}
							else 
								pos--;
						}
					}
				}
				else
					pos--;
			}
		return foundfile;
	}
	
	public boolean exists2Files(String mail, String filename){
		boolean add = false;
		if(searchIndex2Files(mail, filename) == 1)
			add = true;
		if (searchIndex2Files(mail, filename) == 2)
			add = false;
		return add;
	}
	
	private int searchIndexWhoHasFile(String mail, String filename){
		int pos = current;
		int result = -1;
		if (counter == 0)
				result=-1;
		else
			while (((pos >= 0) && (result == -1))){
				if ((accounts[pos].getAccount().equals(mail))){
					result = pos;
				}
				else
					pos--;
			}
		return result;
	}
	
	public boolean exceedsCap(String mail ,String filename,int filesize){
		int pos = -1;
		pos = searchIndexWhoHasFile(mail,filename);
		boolean exceeds = false;
		if(accounts[pos].getType().equals(BASIC)&&((accounts[pos].getSize()+ filesize)> ba.totalCap)){
					exceeds = true;
			}
		else if((accounts[pos].getType().equals(PREMIUM))&&((accounts[pos].getSize()+ filesize)> pa.totalCap)){
				exceeds = true;
			}
		return exceeds;
	}	
		
	public Iterator allAccounts(){
		
		Iterator it;
		it = new AccountIterator(counter,accounts);
		return it;
	}
}