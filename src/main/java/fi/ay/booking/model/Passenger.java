package fi.ay.booking.model;

import lombok.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Passenger {

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("email")
    private String email;
}
