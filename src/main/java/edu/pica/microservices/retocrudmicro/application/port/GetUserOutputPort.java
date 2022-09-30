package edu.pica.microservices.retocrudmicro.application.port;

import edu.pica.microservices.retocrudmicro.domain.model.User;
import java.util.List;

public interface GetUserOutputPort {
    List<User> getUser();
}
