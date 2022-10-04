package edu.pica.microservices.retocrudmicro.infraestructure.adapters.output;

import edu.pica.microservices.retocrudmicro.application.port.GetUserOutputPortById;
import edu.pica.microservices.retocrudmicro.domain.model.User;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.entity.UserEntity;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.mapper.UserPersinstenceMapper;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.repository.UserRepository;
import edu.pica.microservices.retocrudmicro.infraestructure.exception.UserPersistenceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;

import java.util.Optional;
@Slf4j
@RequiredArgsConstructor
public class GetUserPersistenceAdapterById implements GetUserOutputPortById {

    private final UserRepository userRepository;
    private final UserPersinstenceMapper userPersinstenceMapper;


    @Override
    public Optional<User> getUserById(Long id) {
        User user = new User();
        log.info("ID de Usuario Buscado: " + id);
       try{
           Optional<UserEntity>  userEntity = userRepository.findById(id);
           if (userEntity.isEmpty()){
               return Optional.empty();

           }
           log.debug("ID de Usuario Buscado: " + id);
           user  = userPersinstenceMapper.toUser(userEntity.get());
       }catch (DataAccessException e){
           throw new UserPersistenceException(e);
       }
        return Optional.of(user);
    }
}
