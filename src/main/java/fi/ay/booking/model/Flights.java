package fi.ay.booking.model;

import lombok.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Flights {

    @JsonProperty("departure")
    private String departure;

    @JsonProperty("arrival")
    private String arrival;

    @JsonProperty("departureDate")
    private String departureDate;

    @JsonProperty("arrivalDate")
    private String arrivalDate;
}
