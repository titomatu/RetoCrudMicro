package edu.pica.microservices.retocrudmicro.domain.service;

import edu.pica.microservices.retocrudmicro.application.port.GetUserOutputPortById;
import edu.pica.microservices.retocrudmicro.application.useCase.GetUserUseCaseById;
import edu.pica.microservices.retocrudmicro.domain.model.User;
import edu.pica.microservices.retocrudmicro.infraestructure.exception.UserNotFound;
import edu.pica.microservices.retocrudmicro.infraestructure.warning.UserRequestWarning;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetUserServiceById implements GetUserUseCaseById {

    private final GetUserOutputPortById getUserOutputPortById;

    @Override
    public User getUserById(Long id) {
        User user = new User();
        try {
            user =  getUserOutputPortById.getUserById(id).orElseThrow(()-> new UserNotFound("User not Found With ID: " + id));
        }catch (Exception e){
            throw new UserRequestWarning(e);
        }
        return user;
    }
}
