package furama_resort.exception;

public class BirthdayException extends Exception{
    String message;
    public BirthdayException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
