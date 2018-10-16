package fi.ay.booking.exceptions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainExceptionTest {

    @Test
    public void testMainException() {
        MainException exception = Mockito.mock(MainException.class);
        Mockito.when(exception.getHttpStatus()).thenReturn(HttpStatus.INTERNAL_SERVER_ERROR);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, exception.getHttpStatus());
        assertNull(exception.getMessage());
    }
}
