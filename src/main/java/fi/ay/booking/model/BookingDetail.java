package fi.ay.booking.model;

import lombok.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookingDetail {

    @JsonProperty("id")
    private String id;

    @JsonProperty("passenger")
    private Passenger passenger;

    @JsonProperty("flights")
    private List<Flights> flights;

    // Override Lombok @ToString method because we have to use the information of the first
    // flight, if the trip consists of more than one flight.
    @Override
    public String toString() {
        return "BookingDetail{" +
                "id='" + id + '\'' +
                ", passenger=" + passenger +
                ", flights=" + flights.get(0) +
                '}';
    }
}
