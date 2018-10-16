package fi.ay.booking.exceptions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NotFoundExceptionTest {

    @Test
    public void testPageNotFoundException() {
        try {
            throw new NotFoundException("Test message");
        } catch (NotFoundException e) {
            assertEquals(e.getHttpStatus(), HttpStatus.NOT_FOUND);
            assertEquals(e.getMessage(), "Test message");
        }
    }
}
