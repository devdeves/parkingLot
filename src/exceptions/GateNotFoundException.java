package exceptions;

public class GateNotFoundException extends Exception{
    public GateNotFoundException() {
        super("Gate doesn't found");
    }
}
