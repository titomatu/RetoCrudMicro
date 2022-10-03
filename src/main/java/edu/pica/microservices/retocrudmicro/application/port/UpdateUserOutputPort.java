package edu.pica.microservices.retocrudmicro.application.port;
import edu.pica.microservices.retocrudmicro.domain.model.User;

public interface UpdateUserOutputPort {
    User updateUser(User user);
}
