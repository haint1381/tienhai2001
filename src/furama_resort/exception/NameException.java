package furama_resort.exception;

public class NameException extends Exception {
    String message;
    public NameException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
