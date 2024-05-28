package fitnessTracker;

public class ActividadeInexistenteException extends RuntimeException{


    static final long serialVersionUID = 0L;


    public ActividadeInexistenteException( )
    {
        super();
    }

    public ActividadeInexistenteException( String message )
    {
        super(message);
    }

}

