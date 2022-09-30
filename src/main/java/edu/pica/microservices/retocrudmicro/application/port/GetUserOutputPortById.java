package edu.pica.microservices.retocrudmicro.application.port;
import edu.pica.microservices.retocrudmicro.domain.model.User;

import java.util.Optional;

public interface GetUserOutputPortById {
    Optional<User> getUserById(Long id);
}
