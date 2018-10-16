package fi.ay.booking;

import reactor.core.publisher.Flux;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import fi.ay.booking.model.Booking;
import fi.ay.booking.model.BookingDetail;

@SpringBootApplication
public class AyBookingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AyBookingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			WebClient webClient = WebClient.create("http://localhost:8080/api/v1/bookings");

			final Flux<Booking> bookingFlux = webClient
					.get()
					.uri(builder -> builder.queryParam("uid", "XzPZhxJ2qOlt").build())
					.retrieve()
					.bodyToFlux(Booking.class);
			System.out.println("\n --------------------- GET /bookings?uid={passenger-id} ---------------------");
			bookingFlux.subscribe(bookingDetail -> System.out.println(bookingDetail.toString()), Throwable::printStackTrace);

			bookingFlux.flatMap(booking -> webClient.get()
					.uri("/{bookingId}", booking.getBookingId())
					.retrieve()
					.bodyToFlux(BookingDetail.class)
			).subscribe(bookingDetail -> {
				System.out.println("\n --------------------- GET /bookings/{booking-id}  ---------------------");
				// bookingDetail.toString() prints information only one flight. See BookingDetail class > toString method.
				System.out.println(bookingDetail.toString());
			}, Throwable::printStackTrace);
		};
	}
}
