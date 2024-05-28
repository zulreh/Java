/**
 * 
 */
package poo;

/**
 * @author Hernani
 *
 */
public class PremiumAccount extends AbstractAccount {

	private static final String TYPE = "Premium";
	static final int totalCap = 5120; //5G
	
	public PremiumAccount(String mail) {
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

	public void shareFile(String mail1, String filename) {
		;		
	}

	public int getSize(){
		return accountSize;
	}
	
	public int subSize(int fileSize){
		return accountSize += fileSize;
	}
	
}
