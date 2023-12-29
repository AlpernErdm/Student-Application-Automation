package codeDev.io.ogrenciBasvuru.core.utilities.mappers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ProblemDetails handleUserNotFoundException(UserNotFoundException userNotFoundException) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMessage(userNotFoundException.getMessage());
        return problemDetails;
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleUserNameExistException(UserNameExistException userNameExistException) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMessage(userNameExistException.getMessage());
        return problemDetails;
    }
    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleUserCannotBeApplyException(UserCannotBeApplyException userCannotBeApplyException) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMessage(userCannotBeApplyException.getMessage());
        return problemDetails;
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ProblemDetails handleResultNotFoundException( ResultNotFoundException resultNotFoundException) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMessage(resultNotFoundException.getMessage());
        return problemDetails;
    }
    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ProblemDetails handleApplicationNotFoundException(ApplicationNotFoundException applicationNotFoundException) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMessage(applicationNotFoundException.getMessage());
        return problemDetails;
    }
    @ExceptionHandler
    @ResponseStatus(code=HttpStatus.BAD_REQUEST)
    public ProblemDetails problemDetails(EmailAlreadyExistsException emailAlreadyExistsException){
        ProblemDetails problemDetails=new ProblemDetails();
        problemDetails.setMessage(emailAlreadyExistsException.getMessage());
        return problemDetails;
    }

}
