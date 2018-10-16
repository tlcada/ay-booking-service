package fi.ay.booking.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends MainException {

    public NotFoundException(final String error) {
        super(error);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
