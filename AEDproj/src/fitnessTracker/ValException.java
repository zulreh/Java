package fitnessTracker;

public class ValException extends RuntimeException{


    static final long serialVersionUID = 0L;


    public ValException( )
    {
        super();
    }

    public ValException( String message )
    {
        super(message);
    }

}