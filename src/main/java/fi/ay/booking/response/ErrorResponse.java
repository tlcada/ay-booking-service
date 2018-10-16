package fi.ay.booking.response;

import lombok.Getter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse {

    @Getter
    private String error;

    @JsonCreator
    public ErrorResponse(@JsonProperty("error") String error) {
        this.error = error;
    }
}
