package edu.pica.microservices.retocrudmicro.infraestructure.adapters.output;
import edu.pica.microservices.retocrudmicro.application.port.DeleteUserOutputPortById;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.repository.UserRepository;
import edu.pica.microservices.retocrudmicro.infraestructure.exception.UserPersistenceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
@Slf4j
@RequiredArgsConstructor
public class DeleteUserPersistenceAdapter implements DeleteUserOutputPortById {

    private final UserRepository userRepository;

    @Override
    public Void deleteUser(Long id) {
        try{
            userRepository.deleteById(id);
            log.info("Usuario  Eliminado Con ID: "+ id  );
        }catch (DataAccessException e){
            throw new UserPersistenceException(e);
        }

        return null;
    }
}
