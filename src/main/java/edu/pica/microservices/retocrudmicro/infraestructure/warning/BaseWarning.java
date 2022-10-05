package edu.pica.microservices.retocrudmicro.infraestructure.warning;

import lombok.Getter;

import java.util.UUID;

@Getter
public class BaseWarning extends RuntimeException {
    private static final long serialVersionUID = -824690113517284691L;
    private final WarningCode warningCode;
    private final String id = UUID.randomUUID().toString();

    protected BaseWarning(WarningCode exceptionCode) {
        super(exceptionCode.getType());
        this.warningCode = exceptionCode;
    }

    protected BaseWarning(WarningCode exceptionCode, String message) {
        super(message);
        this.warningCode = exceptionCode;
    }

    protected BaseWarning(WarningCode exceptionCode, Throwable message) {
        super(message);
        this.warningCode = exceptionCode;
    }

    public WarningCode getExceptionCode() {
        return warningCode;
    }
}

