/**
 * 
 */
package poo;

/**
 * @author Hernani
 *
 */
public class FilesClass implements Files{

	String filename;
	String mail;
	int size;
	
	public FilesClass(String mail,String filename, int size){
		this.mail = mail;
		this.filename= filename;
		this.size = size;
	}
	
	public String getFileName(){
		return filename;
	}
	public void upload(String mail, String filename, int size) {
		// TODO Auto-generated method stub
		
	}

	
	public void share(String mail1, String mail2, String filename) {
		// TODO Auto-generated method stub
		
	}

	
	public void update(String mail1, String mail2, String filename) {
		// TODO Auto-generated method stub
		
	}

	
	public String listAllFiles(String mail) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String lastUpdate(String mail, String filename) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
