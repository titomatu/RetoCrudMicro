package edu.pica.microservices.retocrudmicro.domain.service;

import edu.pica.microservices.retocrudmicro.application.port.GetUserOutputPortById;
import edu.pica.microservices.retocrudmicro.application.useCase.GetUserUseCaseById;
import edu.pica.microservices.retocrudmicro.domain.model.User;
import edu.pica.microservices.retocrudmicro.infraestructure.exception.UserNotFound;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class GetUserServiceById implements GetUserUseCaseById {

    private final GetUserOutputPortById getUserOutputPortById;

    @Override
    public User getUserById(Long id) {
        return getUserOutputPortById.getUserById(id).orElseThrow(()-> new UserNotFound("User not Found" + id));
    }
}
