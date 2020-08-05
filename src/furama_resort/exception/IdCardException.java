package furama_resort.exception;

public class IdCardException extends Exception {
    String message;
    public IdCardException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
