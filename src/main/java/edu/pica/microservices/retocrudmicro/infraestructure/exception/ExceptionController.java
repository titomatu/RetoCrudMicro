package edu.pica.microservices.retocrudmicro.infraestructure.exception;

import edu.pica.microservices.retocrudmicro.infraestructure.warning.BaseWarning;
import edu.pica.microservices.retocrudmicro.infraestructure.warning.TechnicalWarning;
import edu.pica.microservices.retocrudmicro.infraestructure.warning.WarningResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class ExceptionController {

    static final  String LOG_TEMPLATE = "[Error :: {} - {}] :: {}]";
    static final  String LOG_WARN_TEMPLATE = "[Warn :: {} - {}] :: {}]";

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleValidateException(MethodArgumentNotValidException ex){
        Map<String,String> errors = new HashMap<String,String>();
        String code = ExceptionCode.VALID_NOT_FIELD.getCode();
        String fieldCode = "code";
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName,message);

        });
        errors.put(fieldCode,code);
        log.error(LOG_TEMPLATE,code, ex.getMessage());
        return errors;
    }
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException ex) {
        log.error(LOG_TEMPLATE, ex.getExceptionCode(), ex.getId(), ex.getMessage());
        final ErrorResponse response = createResponse(ex);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TechnicalException.class)
    public ResponseEntity<ErrorResponse> handleTechnicalException(TechnicalException ex) {
        log.error(LOG_TEMPLATE,ex.getExceptionCode(), ex.getId(), ex.getMessage());
        final ErrorResponse response = createUnexpectedErrorResponse(ex);
        return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(TechnicalWarning.class)
    public ResponseEntity<WarningResponse> handleTechnicalWarning(TechnicalWarning ex) {
        log.warn(LOG_WARN_TEMPLATE,ex.getExceptionCode(), ex.getId(), ex.getMessage());
        final WarningResponse response = createUnexpectedErrorResponse(ex);
        return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
    }

    private ErrorResponse createUnexpectedErrorResponse(BaseException ex) {
        return ErrorResponse.builder().errorCode(ex.getExceptionCode().getCode())
                .message(ex.getExceptionCode().getType()).errorId(ex.getId()).details(ex.getMessage()).build();
    }

    private ErrorResponse createResponse(BaseException ex) {
        return ErrorResponse.builder().errorCode(ex.getExceptionCode().getCode())
                .message(ex.getMessage()).build();
    }

    private WarningResponse createUnexpectedErrorResponse(BaseWarning ex) {
        return WarningResponse.builder().errorCode(ex.getExceptionCode().getCode())
                .message(ex.getExceptionCode().getType()).errorId(ex.getId()).details(ex.getMessage()).build();
    }
}
