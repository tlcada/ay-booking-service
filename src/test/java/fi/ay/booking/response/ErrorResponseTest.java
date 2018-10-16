package fi.ay.booking.response;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ErrorResponseTest {

    @Test
    public void testErrorResponseFormat() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        assertEquals("{\"error\":\"test\"}", objectMapper.writeValueAsString(new ErrorResponse("test")));
    }
}