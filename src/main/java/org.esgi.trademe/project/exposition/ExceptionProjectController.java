package org.esgi.trademe.project.exposition;

import org.esgi.trademe.kernel.exceptions.InvalidChoiceException;
import org.esgi.trademe.kernel.exceptions.InvalidEntryException;
import org.esgi.trademe.kernel.exceptions.InvalidParameterException;
import org.esgi.trademe.kernel.exceptions.NoSuchEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public final class ExceptionProjectController {

    @ExceptionHandler(value = NoSuchEntityException.class)
    public ResponseEntity<Object> noSuchEntityException(NoSuchEntityException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = InvalidEntryException.class)
    public ResponseEntity<Object> invalidEntryException(InvalidEntryException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(value = InvalidChoiceException.class)
    public ResponseEntity<Object> invalidChoiceException(InvalidChoiceException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = InvalidParameterException.class)
    public ResponseEntity<Object> invalidParameterException(InvalidParameterException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
