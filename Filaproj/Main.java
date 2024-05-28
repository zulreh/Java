import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import dataStructures.*;

public class Main {

	private static final String CREATE = "CREATE";
	private static final String ENQUEUE = "ENQ";
	private static final String DEQUEUE = "DEQ";
	private static final String DEQUEUE_ALL = "DEQ-ALL";
	private static final String INVERT = "INVERT";
	private static final String EXIT = "XS";

	private static final String CREATE_OK = "Fila criada com sucesso.";
	private static final String ENQUEUE_OK = "Enqueue efectuado com sucesso.";
	private static final String DEQUEUE_OK = "Dequeue efectuado com sucesso.";
	private static final String EMPTY_QUEUE = "Fila vazia.";
	private static final String DEQUEUE_ALL_OK = "Dequeue de todos os elementos da fila:";
	private static final String INVERT_OK = "Inversao da fila efectuada com sucesso.";


	private static final String DATA_FILE = "queue.dat";

	
	private static InvertibleQueue<Integer> iq;
	/**
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException,
	IOException, ClassNotFoundException {
		InvertibleQueue<Integer> queue = load();
		Scanner in = new Scanner(System.in);
		String cmd = in.next().toUpperCase();
		while (!cmd.equals(EXIT)) {
			switch (cmd) {
			case CREATE :
				create(in, queue);
				break;
			case ENQUEUE :
				enqueue(in, queue);
				break;
			case DEQUEUE :
				dequeue(in, queue);
				break;
			case INVERT:
				invert(in, queue);
				break;
			case DEQUEUE_ALL : 
				dequeueAll(in, queue);
			default: 
				break;
			}
			System.out.println();
			cmd = in.next().toUpperCase();
		}
		save(queue);
	}

	private static void create(Scanner in, InvertibleQueue<Integer> queue) {
		queue = new InvertibleQueueInList<Integer>();
		System.out.println(CREATE_OK);
	}

	private static void enqueue(Scanner in, InvertibleQueue<Integer> queue) {
		int element = in.nextInt(); 
		in.nextLine();
		queue.enqueue(element);
		System.out.println(ENQUEUE_OK);
	}

	private static void dequeue(Scanner in, InvertibleQueue<Integer> queue) {
		try {
			int element = queue.dequeue();
			System.out.println(element);
			System.out.println(DEQUEUE_OK);
		}
		catch (EmptyQueueException E) {
			System.out.println(EMPTY_QUEUE);
		}
	}

	private static void invert(Scanner in, InvertibleQueue<Integer> queue) {
		queue.invert();
		System.out.println(INVERT_OK);
	}

	private static void dequeueAll(Scanner in, InvertibleQueue<Integer> queue) {
		if (queue.isEmpty())
			System.out.println(EMPTY_QUEUE);
		else {
			System.out.println(DEQUEUE_ALL_OK);
			while (!queue.isEmpty())
				System.out.println(queue.dequeue());
		}
	}

	
	private static void save(InvertibleQueue<Integer> queue) throws IOException {
		try{
			ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(DATA_FILE));
			file.writeObject(iq);
			file.flush();
			file.close();
			}
			catch ( IOException e )
			{}
	}


	@SuppressWarnings("unchecked")
	private static InvertibleQueue<Integer> load() throws FileNotFoundException, IOException,
	ClassNotFoundException {
		try{
			ObjectInputStream file = new ObjectInputStream(new FileInputStream(DATA_FILE));
			// Compiler gives a warning.
			iq =  (InvertibleQueue<Integer>) file.readObject();
			file.close();
			}
			catch ( IOException e )
			{}
			catch ( ClassNotFoundException e )
			{}
		return null;
	}
}