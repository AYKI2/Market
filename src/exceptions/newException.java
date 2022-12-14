package exceptions;

public class newException extends Exception{
    public newException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
