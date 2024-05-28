package fitnessTracker;

public class AtletaInexistenteException extends RuntimeException{


    static final long serialVersionUID = 0L;


    public AtletaInexistenteException( )
    {
        super();
    }

    public AtletaInexistenteException( String message )
    {
        super(message);
    }

}

