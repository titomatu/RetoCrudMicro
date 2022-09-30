package edu.pica.microservices.retocrudmicro.application.useCase;
import edu.pica.microservices.retocrudmicro.domain.model.User;

import java.util.List;

public interface GetUserUseCase {
    List<User> getUser();
}
