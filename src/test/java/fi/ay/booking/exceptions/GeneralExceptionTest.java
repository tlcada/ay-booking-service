package fi.ay.booking.exceptions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneralExceptionTest {

    @Test
    public void testGeneralExceptionWithThrowable() {
        try {
            throw new GeneralException(new Throwable("Test message"));
        } catch (GeneralException e) {
            assertEquals(e.getHttpStatus(), HttpStatus.BAD_REQUEST);
            assertEquals(e.getCause().getMessage(), "Test message");
        }
    }
}
