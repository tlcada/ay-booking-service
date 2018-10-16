package testUtils;

import reactor.core.publisher.Mono;

import org.springframework.web.reactive.function.server.EntityResponse;
import org.springframework.web.reactive.function.server.ServerResponse;

public class HandlersHelper {

    public static <T> T extractEntity(final ServerResponse response, final Class<T> type) {
        EntityResponse<Mono<T>> entityResponse = (EntityResponse<Mono<T>>) response;
        return type.cast(entityResponse.entity().block());
    }

    private HandlersHelper() {
        throw new IllegalStateException("Helper class");
    }
}
