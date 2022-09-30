package edu.pica.microservices.retocrudmicro.infraestructure.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Builder
@Setter
@Getter
public class ErrorResponse {
    private String message;
    private String errorCode;

    @NotEmpty(message = "Details may not be empty")//@JsonInclude(value= JsonInclude.Include.NON_EMPTY)
    private String details;

    @NotEmpty(message = "Error Id may not be empty")//@JsonInclude(value= JsonInclude.Include.NON_EMPTY)
    private String errorId;

}
