package fi.ay.booking.repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import fi.ay.booking.exceptions.NotFoundException;
import fi.ay.booking.model.Booking;
import fi.ay.booking.model.BookingDetail;

@Repository
public class BookingRepository {

    public Flux<Booking> getBookings(String uid) throws NotFoundException {
        final Map<String, List<Booking>> dummyData = MockDatabase.generateDummyBookingData();

        if (!dummyData.containsKey(uid)) {
            throw new NotFoundException("Passenger id: " + uid + " not found");
        }

        return Flux.fromIterable(dummyData.get(uid));
    }

    public Mono<BookingDetail> getBookingDetail(String bookingId) throws NotFoundException {
        final Map<String, BookingDetail> dummyData = MockDatabase.generateDummyBookingDetailData();

        if (!dummyData.containsKey(bookingId)) {
            throw new NotFoundException("Booking detail did not find with booking id: " + bookingId);
        }

        return Mono.just(dummyData.get(bookingId));
    }
}
