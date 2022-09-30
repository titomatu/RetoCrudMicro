package edu.pica.microservices.retocrudmicro.infraestructure.exception;

public class UserPersistenceErrorException extends TechnicalException {
    private static final long serialVersionUID = 1L;

    public UserPersistenceErrorException(Throwable message) {
        super(ExceptionCode.ERROR_OF_PERSISTENCE, message);
    }
}
