package edu.pica.microservices.retocrudmicro.application.useCase;
import edu.pica.microservices.retocrudmicro.domain.model.User;

import java.util.Optional;

public interface GetUserUseCaseById {
    User getUserById(Long id);
}
