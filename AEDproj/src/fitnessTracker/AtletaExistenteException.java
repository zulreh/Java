package fitnessTracker;

public class AtletaExistenteException extends RuntimeException{


    static final long serialVersionUID = 0L;


    public AtletaExistenteException( )
    {
        super();
    }

    public AtletaExistenteException( String message )
    {
        super(message);
    }

}

