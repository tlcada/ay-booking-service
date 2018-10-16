package fi.ay.booking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import fi.ay.booking.handler.BookingHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RoutingConfig {

    @Bean
    RouterFunction<?> routerFunction(BookingHandler bookingHandler) {
        return route(GET("/api/v1/bookings"), bookingHandler::getBookings)
                .andRoute(GET("/api/v1/bookings/{bookingId}"), bookingHandler::getBookingDetail)
                .andOther(route(RequestPredicates.all(), (x) -> ServerResponse.notFound().build()));
    }
}
