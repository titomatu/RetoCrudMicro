package edu.pica.microservices.retocrudmicro.application.port;

import edu.pica.microservices.retocrudmicro.domain.model.User;

public interface CreateUserOutputPort {
    User createUser(User user);
}
