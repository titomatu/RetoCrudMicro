package edu.pica.microservices.retocrudmicro.infraestructure.exception;

public class UserNotFound extends RuntimeException {
    public UserNotFound(String message){
        super(message);
    }

}
