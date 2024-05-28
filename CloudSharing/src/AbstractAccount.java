package poo;

/**
 * @author Hernani
 *
 */

public abstract class AbstractAccount implements Account {

	protected int accountSize;
	protected String mail;
	protected String type;
	private Files[] files;
	private  int counter;
	private int current;
	
	protected AbstractAccount(String mail, String type){
		this.mail = mail;
		this.type = type;
		counter = 0;
		current = 0;
	}
	
	public void setAccount(String mail){
		this.mail = mail;
	}

	public String getAccount(){
		return mail;
	}
	
	public String getType(){
		return type;
	}
	
	public String listAllAccounts(){
		return mail;
	}
	
	public void addFile(String mail, String filename, int filesize){
		files[counter++] = new FilesClass(mail,filename,filesize);
	}
	
	public int getSize(){
		return accountSize;
	}
}
