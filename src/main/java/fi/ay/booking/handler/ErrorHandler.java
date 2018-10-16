package fi.ay.booking.handler;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerResponse;

import fi.ay.booking.exceptions.GeneralException;
import fi.ay.booking.exceptions.MainException;
import fi.ay.booking.exceptions.NotFoundException;
import fi.ay.booking.response.ErrorResponse;

@Slf4j
@Component
public class ErrorHandler {

    public Mono<ServerResponse> generalError(final Throwable error) {
        log.error(error.getMessage());
        return Mono.just(new GeneralException(error)).transform(this::getResponse);
    }

    public Mono<ServerResponse> notFound(final String error) {
        log.error(error);
        return Mono.just(new NotFoundException(error)).transform(this::getResponse);
    }

    private <T extends MainException> Mono<ServerResponse> getResponse(final Mono<T> monoError) {
        return monoError.flatMap(error -> ServerResponse.status(error.getHttpStatus())
                .body(Mono.just(new ErrorResponse(error.getMessage())), ErrorResponse.class));
    }
}
