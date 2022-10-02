package edu.pica.microservices.retocrudmicro.infraestructure.exception;

public class UserPersistenceException extends TechnicalException {
    private static final long serialVersionUID = 1L;
    public UserPersistenceException(Throwable message) {
        super(ExceptionCode.ERROR_OF_PERSISTENCE, message);
    }
}
