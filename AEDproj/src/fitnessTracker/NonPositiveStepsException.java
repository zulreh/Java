package fitnessTracker;

public class NonPositiveStepsException extends RuntimeException{


    static final long serialVersionUID = 0L;


    public NonPositiveStepsException( )
    {
        super();
    }

    public NonPositiveStepsException( String message )
    {
        super(message);
    }

}

