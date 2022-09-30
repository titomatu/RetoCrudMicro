package edu.pica.microservices.retocrudmicro.application.useCase;


import edu.pica.microservices.retocrudmicro.domain.model.User;

public interface DeleteUserUseCase {
    User deleteUser(User user);
}
