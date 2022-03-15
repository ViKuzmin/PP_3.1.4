package crud.exceptionhanling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<UserIncorrectData> handleException(UserNotFoundException exc) {

        UserIncorrectData data = new UserIncorrectData();
        data.setInfo(exc.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<UserIncorrectData> handleException(Exception exc) {

        UserIncorrectData data = new UserIncorrectData();
        data.setInfo(exc.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
}
