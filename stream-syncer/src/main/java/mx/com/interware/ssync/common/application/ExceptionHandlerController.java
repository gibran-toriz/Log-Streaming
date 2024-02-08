package mx.com.interware.ssync.common.application;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;
import mx.com.interware.ssync.common.application.model.ErrorResponseDTO;

/**
 * It is used to handle exceptions thrown in the application layer.
 * 
 * @author Interware
 *
 */
@Slf4j
public class ExceptionHandlerController {

    /**
     * Handle controller exceptions.
     * 
     * @param exception the exception.
     * @return Error response.
     */
    @ExceptionHandler(ControllerException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<ErrorResponseDTO> handleControllerException(final ControllerException exception) {
        log.warn("An error occurred in the controller.", exception);

        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(ErrorResponseDTO.builder()
                        .code("" + HttpStatus.FORBIDDEN.value())
                        .message(exception.getMessage())
                        .build());
    }

}
