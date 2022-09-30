package edu.pica.microservices.retocrudmicro.infraestructure.adapters.output;
import edu.pica.microservices.retocrudmicro.application.port.DeleteUserOutputPortById;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteUserPersistenceAdapter implements DeleteUserOutputPortById {

    private final UserRepository userRepository;

    @Override
    public Void deleteUser(Long id) {
        userRepository.deleteById(id);
        return null;
    }
}
