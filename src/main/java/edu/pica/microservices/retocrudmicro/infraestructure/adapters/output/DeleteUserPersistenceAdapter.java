package edu.pica.microservices.retocrudmicro.infraestructure.adapters.output;
import edu.pica.microservices.retocrudmicro.application.port.DeleteUserOutputPortById;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.repository.UserRepository;
import edu.pica.microservices.retocrudmicro.infraestructure.exception.UserPersistenceErrorException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;

@RequiredArgsConstructor
public class DeleteUserPersistenceAdapter implements DeleteUserOutputPortById {

    private final UserRepository userRepository;

    @Override
    public Void deleteUser(Long id) {
        try{
            userRepository.deleteById(id);
        }catch (DataAccessException e){
            throw new UserPersistenceErrorException(e);
        }

        return null;
    }
}
