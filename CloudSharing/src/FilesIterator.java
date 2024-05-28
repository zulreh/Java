package poo;

/**
 * @author Hernani
 *
 */

public class FilesIterator implements Iterator {
	
	private static final int MAX = 500;
	public int current;
	public int counter;
	private Files[] files;
	
	
	public FilesIterator(int counter){
		files = new Files[MAX];
		counter = 0;
		this.counter = counter;
		current = 0;
	}
	
	public void init() {
		current = 0;
	}

	public boolean hasNext() {
		return current < counter;
	}
	
	public Files next() {
		return files[current++];
	}
}
