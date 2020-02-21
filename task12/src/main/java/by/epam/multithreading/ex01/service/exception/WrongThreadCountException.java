package by.epam.multithreading.ex01.service.exception;

public class WrongThreadCountException extends Exception{
    public WrongThreadCountException() {
    }

    public WrongThreadCountException(String message) {
        super(message);
    }

    public WrongThreadCountException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongThreadCountException(Throwable cause) {
        super(cause);
    }
}
