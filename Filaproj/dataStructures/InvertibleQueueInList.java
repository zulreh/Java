package dataStructures;

public class InvertibleQueueInList <E> extends QueueInList<E> implements InvertibleQueue<E> {

	private boolean inverted;
	
    public InvertibleQueueInList( )
    {
        super();
        inverted = false;
    }
    
	public void invert() {
		if(inverted)
			inverted=false;
		else 
			inverted= true;
	}
	
	public void enqueue(E element){
		if(inverted)
			list.addFirst(element);
		else
			list.addLast(element);
	}

	public E dequeue() throws EmptyQueueException{
		
		if ( list.isEmpty() )
	            throw new EmptyQueueException("Queue is empty.");

		if(inverted)
	        return list.removeLast();
		else
			return list.removeFirst();
	}
	

}
