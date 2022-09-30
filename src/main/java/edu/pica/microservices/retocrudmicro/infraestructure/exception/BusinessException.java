package edu.pica.microservices.retocrudmicro.infraestructure.exception;

public abstract class BusinessException extends BaseException {
    private static final long serialVersionUID = 1L;
    protected BusinessException(ExceptionCode codigoException, String message) {
        super(codigoException, message);
    }
}
