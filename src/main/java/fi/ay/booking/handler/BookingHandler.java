package fi.ay.booking.handler;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import fi.ay.booking.exceptions.NotFoundException;
import fi.ay.booking.model.Booking;
import fi.ay.booking.model.BookingDetail;
import fi.ay.booking.repository.BookingRepository;

@Component
public class BookingHandler {

    private BookingRepository bookingRepository;
    private ErrorHandler errorHandler;

    public BookingHandler(BookingRepository bookingRepository, ErrorHandler errorHandler) {
        this.bookingRepository = bookingRepository;
        this.errorHandler = errorHandler;
    }

    public Mono<ServerResponse> getBookings(ServerRequest request) {
        return request.queryParam("uid").map(uid -> {
            final Flux<Booking> bookings;
            try {
                bookings = bookingRepository.getBookings(uid);
            } catch (NotFoundException ex) {
                return errorHandler.notFound(ex.getMessage());
            }

            try {
                return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(bookings, Booking.class);
            } catch (IllegalArgumentException ex) {
                return errorHandler.generalError(ex);
            }
        }).orElseGet(() -> ServerResponse.status(HttpStatus.BAD_REQUEST).build());
    }

    public Mono<ServerResponse> getBookingDetail(ServerRequest request) {
        final String bookingId = request.pathVariable("bookingId");

        final Mono<BookingDetail> bookingDetail;
        try {
            bookingDetail = bookingRepository.getBookingDetail(bookingId);
        } catch (NotFoundException ex) {
            return errorHandler.notFound(ex.getMessage());
        }

        try {
            return ServerResponse.ok().body(bookingDetail, BookingDetail.class);
        } catch (IllegalArgumentException ex) {
            return errorHandler.generalError(ex);
        }
    }
}
