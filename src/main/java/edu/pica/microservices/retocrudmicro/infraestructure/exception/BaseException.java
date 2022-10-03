package edu.pica.microservices.retocrudmicro.infraestructure.exception;

import lombok.Getter;

import java.util.UUID;

@Getter
public class BaseException extends RuntimeException {
    private static final long serialVersionUID = -824690113517284691L;
    private final ExceptionCode exceptionCode;
    private final String id = UUID.randomUUID().toString();

    protected BaseException(ExceptionCode exceptionCode) {
        super(exceptionCode.getType());
        this.exceptionCode = exceptionCode;
    }

    protected BaseException(ExceptionCode exceptionCode, String message) {
        super(message);
        this.exceptionCode = exceptionCode;
    }

    protected BaseException(ExceptionCode exceptionCode, Throwable message) {
        super(message);
        this.exceptionCode = exceptionCode;
    }

    public ExceptionCode getExceptionCode() {
        return exceptionCode;
    }
}

