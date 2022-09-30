package edu.pica.microservices.retocrudmicro.domain.service;

import edu.pica.microservices.retocrudmicro.application.port.DeleteUserOutputPortById;
import edu.pica.microservices.retocrudmicro.application.useCase.DeleteUserUseCase;
import edu.pica.microservices.retocrudmicro.domain.model.User;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteUserService implements DeleteUserUseCase {

    private final DeleteUserOutputPortById deleteUserOutputPortById;

    @Override
    public Void deleteUser(Long id) {
        deleteUserOutputPortById.deleteUser(id);
        return null;
    }
}
