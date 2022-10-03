package edu.pica.microservices.retocrudmicro.domain.service;

import edu.pica.microservices.retocrudmicro.application.port.CreateUserOutputPort;
import edu.pica.microservices.retocrudmicro.application.useCase.CreateUserUseCase;
import edu.pica.microservices.retocrudmicro.domain.model.User;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateUserService implements CreateUserUseCase {

    private final CreateUserOutputPort createUserOutputPort;

    @Override
    public User createUser(User user) {
        user = createUserOutputPort.createUser(user);
        return user;
    }
}
