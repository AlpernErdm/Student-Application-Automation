package codeDev.io.ogrenciBasvuru.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

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
    public ProblemDetails handleApplicationNotFoundException(ApplicationNotFoundException applicationNotFoundException) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMessage(applicationNotFoundException.getMessage());
        return problemDetails;
    }
    @ExceptionHandler
    @ResponseStatus(code=HttpStatus.BAD_REQUEST)
    public ProblemDetails handleEmailAlreadyExistsException(EmailAlreadyExistsException emailAlreadyExistsException){
        ProblemDetails problemDetails=new ProblemDetails();
        problemDetails.setMessage(emailAlreadyExistsException.getMessage());
        return problemDetails;
    }
    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ProblemDetails handleNoPersonWithThisId( NoPersonWithThisId noPersonWithThisId) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMessage(noPersonWithThisId.getMessage());
        return problemDetails;
    }
    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ProblemDetails handleTheUserHasAnApplicationException( TheUserHasAnApplicationException theUserHasAnApplicationException ) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMessage(theUserHasAnApplicationException.getMessage());
        return problemDetails;
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
        ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
        validationProblemDetails.setMessage("VALIDATION.EXCEPTION");
        validationProblemDetails.setValidationErrors(new HashMap<>());

        for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
            validationProblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return validationProblemDetails;
    }
    @ExceptionHandler
    @ResponseStatus(code=HttpStatus.NOT_FOUND)
    public ProblemDetails handleResultDocumentNotFound(ResultDocumentNotFound resultDocumentNotFound )
    {
        ProblemDetails problemDetails=new ProblemDetails();
        problemDetails.setMessage(resultDocumentNotFound.getMessage());
        return problemDetails;
    }
}
