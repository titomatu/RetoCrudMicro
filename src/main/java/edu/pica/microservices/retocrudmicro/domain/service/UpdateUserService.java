package edu.pica.microservices.retocrudmicro.domain.service;

import edu.pica.microservices.retocrudmicro.application.port.UpdateUserOutputPort;
import edu.pica.microservices.retocrudmicro.application.useCase.UpdateUserUseCase;
import edu.pica.microservices.retocrudmicro.domain.model.User;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateUserService implements UpdateUserUseCase {

    private final UpdateUserOutputPort updateUserOutputPort;

    @Override
    public User updateUser(User user) {
        user = updateUserOutputPort.updateUser(user);
        return user;
    }
}
