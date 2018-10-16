package fi.ay.booking.handler;

import testUtils.HandlersHelper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import fi.ay.booking.exceptions.GeneralException;
import fi.ay.booking.response.ErrorResponse;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ErrorHandlerTest {

    @Autowired
    private ErrorHandler errorHandler;

    @Test
    public void generalErrorThrowableTest() {
        errorHandler.generalError(new GeneralException(new Exception())).subscribe(response -> {
            assertEquals(response.statusCode(), HttpStatus.BAD_REQUEST);
        });
    }

    @Test
    public void notFoundTest_ShouldReturnErrorMsg() {
        errorHandler.notFound("This is the error message").subscribe(response -> {
            assertThat(response.statusCode(), is(HttpStatus.NOT_FOUND));
            assertThat(HandlersHelper.extractEntity(response, ErrorResponse.class).getError(), is("This is the error message"));
        });
    }
}
