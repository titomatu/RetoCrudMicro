package edu.pica.microservices.retocrudmicro.infraestructure.exception;

public enum ExceptionCode {

    VALID_NOT_FIELD("USER-001", "VALID_NOT_FIELD"),
    ERROR_OF_PERSISTENCE("USER-002","ERROR_OF_PERSISTENCE"),
    PAYMENT_REQUEST_EXCEPTION("USER-003", "PAYMENT_REQUEST_EXCEPTION");
   // FEIGN_REQUEST_EXCEPTION("USER-004", "FEIGN_REQUEST_EXCEPTION");


    private String code;
    private String type;

    ExceptionCode(String code, String type) {
        this.code = code;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public String getType() {
        return type;
    }
}

