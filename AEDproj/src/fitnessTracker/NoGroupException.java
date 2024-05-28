package fitnessTracker;

public class NoGroupException extends RuntimeException{


    static final long serialVersionUID = 0L;


    public NoGroupException( )
    {
        super();
    }

    public NoGroupException( String message )
    {
        super(message);
    }

}

