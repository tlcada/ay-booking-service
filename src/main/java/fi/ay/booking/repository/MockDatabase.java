package fi.ay.booking.repository;

import java.util.*;

import fi.ay.booking.model.Booking;
import fi.ay.booking.model.BookingDetail;
import fi.ay.booking.model.Flights;
import fi.ay.booking.model.Passenger;

public class MockDatabase {

    public static Map<String, List<Booking>> generateDummyBookingData() {
        Map<String, List<Booking>> bookings = new HashMap<>();

        List<Booking> person1 = new ArrayList<>();
        person1.add(new Booking("AN4703", "Aho", "HEL"));
        person1.add(new Booking("U8OVKB", "Aho", "JFK"));
        bookings.put("XzPZhxJ2qOlt", person1);

        List<Booking> person2 = new ArrayList<>();
        person2.add(new Booking("TIZSAL", "Harkio", "CPH"));
        bookings.put("zeZI7rj8AQkq", person2);

        return bookings;
    }

    public static Map<String, BookingDetail> generateDummyBookingDetailData() {
        Map<String, BookingDetail> bookingDetail = new HashMap<>();

        Passenger passenger1 = new Passenger("Petteri", "Aho", "aho.petteri@gmail.com");
        Passenger passenger2 = new Passenger("Jukka", "Harkio", "jukka.harkio@gmail.com");

        List<Flights> flight1 = new ArrayList<>();
        flight1.add(new Flights("HEL", "JFK", "2018-12-06T12:00:42Z", "2018-12-06T15:00:42Z"));
        flight1.add(new Flights("JFK", "HEL", "2018-12-09T05:00:42Z", "2018-12-09T09:00:42Z"));
        bookingDetail.put("AN4703", new BookingDetail("1", passenger1, flight1));

        Flights flight2 = new Flights("JFK", "HEL", "2018-12-14T12:00:42Z", "2018-12-14T15:00:42Z");
        bookingDetail.put("U8OVKB", new BookingDetail("2", passenger1, Arrays.asList(flight2)));

        List<Flights> flight3 = new ArrayList<>();
        flight3.add(new Flights("CPH", "JFK", "2018-11-06T12:00:42Z", "2018-11-06T15:00:42Z"));
        flight3.add(new Flights("JFK", "CPH", "2018-11-09T05:00:42Z", "2018-11-09T09:00:42Z"));
        bookingDetail.put("TIZSAL", new BookingDetail("3", passenger2, flight3));

        return bookingDetail;
    }
}
