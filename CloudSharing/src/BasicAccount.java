/**
 * 
 */
package poo;

/**
 * @author Hernani
 *
 */

public class BasicAccount extends AbstractAccount{

	String mail;
	static final String TYPE = "Basic";
	static final int totalCap = 2048; //2G
	
	public BasicAccount(String mail) {
		super(mail,TYPE);
		this.mail = mail;
		this.type = TYPE;
		accountSize = 0;
		
	}

	public void setAccount(String mail) {
		this.mail = mail;
	}

	public String getAccount() {
		return mail;
	}

	public String getType() {
		return type;
	}

	public String listAllAccounts() {
		return null;
	}

	public void addFile(String filename) {
		;		
	}

	public int getSize(){
		return accountSize;
	}
	
	public int subSize(int fileSize){
		return accountSize += fileSize;
	}
}