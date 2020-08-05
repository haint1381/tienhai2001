package furama_resort.exception;

public class EmailException extends Exception{
    String message;
    public EmailException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;

}
}
