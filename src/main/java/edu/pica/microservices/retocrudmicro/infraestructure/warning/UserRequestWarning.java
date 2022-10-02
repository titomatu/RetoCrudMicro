package edu.pica.microservices.retocrudmicro.infraestructure.warning;

import edu.pica.microservices.retocrudmicro.infraestructure.exception.ExceptionCode;
import edu.pica.microservices.retocrudmicro.infraestructure.exception.TechnicalException;

public class UserRequestWarning extends TechnicalWarning {
    private static final long serialVersionUID = 1L;

    public UserRequestWarning(Throwable message) {

        super(WarningCode.WARNING_REQUEST_INFORMATION, message);
    }
}
