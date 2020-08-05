package furama_resort.exception;

public class GenderException extends Exception {
    String message;
    public GenderException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
