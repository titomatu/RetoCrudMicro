package edu.pica.microservices.retocrudmicro.infraestructure.warning;


public abstract class TechnicalWarning extends BaseWarning {
    private static final long serialVersionUID = -8946415577270136466L;
    public TechnicalWarning(WarningCode warningCode, Throwable message) {
        super(warningCode, message);
    }
}

