package edu.pica.microservices.retocrudmicro.domain.service;

import edu.pica.microservices.retocrudmicro.application.port.GetUserOutputPort;
import edu.pica.microservices.retocrudmicro.application.useCase.GetUserUseCase;
import edu.pica.microservices.retocrudmicro.domain.model.User;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class GetUserService implements GetUserUseCase {

    private final GetUserOutputPort getUserOutputPort;

    @Override
    public List<User> getUser() {
        List<User> users = getUserOutputPort.getUser();
        return users;
    }
}
