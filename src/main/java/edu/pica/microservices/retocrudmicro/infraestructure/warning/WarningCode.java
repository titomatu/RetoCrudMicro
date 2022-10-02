package edu.pica.microservices.retocrudmicro.infraestructure.warning;

public enum WarningCode {
    WARNING_REQUEST_INFORMATION("USER-004", "WARNING_REQUEST_INFORMATION");

    private String code;
    private String type;

    WarningCode(String code, String type) {
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
