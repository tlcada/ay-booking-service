package fi.ay.booking.exceptions;

import org.springframework.http.HttpStatus;

public abstract class MainException extends Exception {

    public MainException(final Throwable error) {
        super(error);
    }

    public MainException(final String message) {
        super(message);
    }

    public abstract HttpStatus getHttpStatus();
}
