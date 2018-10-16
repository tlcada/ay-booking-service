package fi.ay.booking.model;

import lombok.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Booking {

    @JsonProperty("bookingId")
    private String bookingId;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("departure")
    private String departure;
}
