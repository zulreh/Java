package fitnessTracker;

public class GrupoInexistenteException extends RuntimeException{


    static final long serialVersionUID = 0L;


    public GrupoInexistenteException( )
    {
        super();
    }

    public GrupoInexistenteException( String message )
    {
        super(message);
    }

}

