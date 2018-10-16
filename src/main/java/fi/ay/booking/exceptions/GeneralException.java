package fi.ay.booking.exceptions;

import org.springframework.http.HttpStatus;

public class GeneralException extends MainException {

    public GeneralException(final Throwable error) {
        super(error);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
