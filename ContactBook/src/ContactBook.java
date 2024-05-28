
public class ContactBook {
		
		// Constantes
		public static final int MAX_CONTACTS = 50;
		
		// Variaveis
		private Contact[] contacts;
		private int counter;
		private int currentContact;
		
		
		/* Construtor da classe Contact */
		public ContactBook() {
			counter = 0;
			contacts = new Contact[MAX_CONTACTS];
			currentContact = -1;
		}
		
		
		/* Metodos auxiliares */
		private void resize() {
			Contact temp[] = new Contact[2*contacts.length];
			int i=0;
			while (i < counter) {
				temp[i] = contacts[i];
				i++;
				}
			contacts = temp;
		}
		private int searchIndex(String name) {

			int i = 0;
			int result = -1;
			boolean find = false;
			while ((i < counter) && (!find))
				if (contacts[i].getName().equals(name))
					find = true;
				else i++;
			if (find)
				result = i;
			return result;
		}
		
		
		/* Metodos da classe Contact */
		public void addContact(String name, int phone, String email) {
			if (counter == contacts.length)
				resize();
			contacts[counter++] = new Contact(name, phone, email);
		}
		public void delContact(String name) {
			contacts[searchIndex(name)] = contacts[counter-1];
			counter--;
		}
		public boolean hasContact(String name) {
			return (searchIndex(name) >= 0);
		}
		public int getPhone(String name) {
			return contacts[searchIndex(name)].getPhone();
		}
		public String getEmail(String name) {
			return contacts[searchIndex(name)].getEmail();
		}
		public void setPhone(String name, int phone) {
			contacts[searchIndex(name)].setPhone(phone);
		}
		public void setEmail(String name, String email) {
			contacts[searchIndex(name)].setEmail(email);
		}
		public int getNumberOfContacts() {
			return counter;
		}
		public void initializeIterator() {
			currentContact = 0;
		}
		public boolean hasNext() {
			return ((currentContact >= 0) && (currentContact < counter));
		}
		public Contact next() {
			return contacts[currentContact++];
		}

}
