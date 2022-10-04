package edu.pica.microservices.retocrudmicro.infraestructure.adapters.output;

import edu.pica.microservices.retocrudmicro.application.port.GetUserOutputPort;
import edu.pica.microservices.retocrudmicro.domain.model.User;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.entity.UserEntity;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.mapper.UserPersinstenceMapper;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.repository.UserRepository;
import edu.pica.microservices.retocrudmicro.infraestructure.exception.UserPersistenceException;
import edu.pica.microservices.retocrudmicro.infraestructure.warning.UserRequestWarning;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@RequiredArgsConstructor
public class GetUserPersistenceAdapter implements GetUserOutputPort {

    private final UserRepository userRepository;
    private final UserPersinstenceMapper userPersinstenceMapper;

    @Override
    public List<User> getUser() {
        List<UserEntity> userEntities = new ArrayList<UserEntity>();
        List<User> users = new ArrayList<User>();
       try {
           userEntities = userRepository.findAll();
           log.info("Lista De Usuarios Obtenida " );
           users = userPersinstenceMapper.toUsers(userEntities);
       }catch (DataAccessException e){
           throw new UserPersistenceException(e);
       }

        return users;
    }
}
