import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

public class Main {
	
	public static final String FILE = "contacts.txt";
	
	/* Constantes de comandos */
	public static final String ADD_CONTACT = "AC";
	public static final String REMOVE_CONTACT = "RC";
	public static final String GET_CONTACT = "GC";
	public static final String GET_PHONE = "GP";
	public static final String GET_EMAIL = "GE";
	public static final String SET_PHONE = "SP";
	public static final String SET_EMAIL = "SE";
	public static final String LIST_CONTACTS = "LC";
	public static final String QUIT = "Q";
	
	/* Constantes de mensagens */
	public static final String WRONG_COMM = "Invalid Command.";
	public static final String CONTACT_EXISTS = "Contact already exists.";
	public static final String CANNOT_REMOVE = "Cannot remove contact.";
	public static final String NAME_NOT_EXIST = "Contact does not exist.";
	public static final String CONTACT_ADDED = "Contact added.";
	public static final String BYE = "Goodbye.";
	
	/* Metodos auxiliares */
	public static void read(ContactBook book, String file) throws FileNotFoundException {
		System.out.println("Reading Contacts File...");
		FileReader fernando = new FileReader(file);
		Scanner fernandoin = new Scanner(fernando);
		int cont = fernandoin.nextInt();
		fernandoin.nextLine();
		for(int i = 0; i < cont; i++) {
			addContact(fernandoin, book);
		}
		fernandoin.close();
	}
	public static void write(ContactBook book, String file) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(file);
		Contact c = null;
		pw.println(book.getNumberOfContacts());
		book.initializeIterator();
		while(book.hasNext()) {
			c = book.next();
			pw.println(c.getName());
			pw.println(c.getPhone());
			pw.println(c.getEmail());
		}
		pw.close();
	}
	private static String getCommand(Scanner in) {
		String input = "";
		System.out.print("> ");
		input = in.nextLine().toUpperCase();
		return input;
	}
	private static void addContact(Scanner in, ContactBook book) {
		String name, email = "";
		int phone = 0;
		name = in.nextLine();
		phone = in.nextInt();
		in.nextLine();
		email = in.nextLine();
		if (!book.hasContact(name)) {
			book.addContact(name, phone, email);
			System.out.println(CONTACT_ADDED);
		}
		else System.out.println(CONTACT_EXISTS);
	}

	/* MAIN */
	public static void main(String[] args) throws FileNotFoundException{
	  try {
		Scanner in = new Scanner(System.in);
		ContactBook book = new ContactBook();
		read(book, FILE);
		String comm = getCommand(in);
		
		while(!comm.equals(QUIT)) {
			if (comm.equals(ADD_CONTACT))
				addContact(in, book);
			else System.out.println(WRONG_COMM);
			comm = getCommand(in);
		}
		write(book, FILE);
		System.out.println(BYE);
		in.close();
	  } catch (FileNotFoundException e) {
		  System.out.println("File not found... Press F13 to continue.");
	  }
	}

}
