package edu.pica.microservices.retocrudmicro.infraestructure.adapters.output;
import edu.pica.microservices.retocrudmicro.application.port.CreateUserOutputPort;
import edu.pica.microservices.retocrudmicro.domain.model.User;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.entity.UserEntity;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.mapper.UserPersinstenceMapper;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.repository.UserRepository;
import edu.pica.microservices.retocrudmicro.infraestructure.exception.UserPersistenceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
@Slf4j
@RequiredArgsConstructor
public class CreateUserPersintenceAdapter implements CreateUserOutputPort {

    private final UserRepository userRepository;
    private final UserPersinstenceMapper userPersinstenceMapper;

    @Override
    public User createUser(User user) {
        UserEntity userEntity = new UserEntity();
        try {
            userEntity =  userPersinstenceMapper.toUserEntity(user);
            userEntity = userRepository.save(userEntity);
            log.info(" USER CREADO: "+ userEntity.getId()  + " CON IDENTIFICACION: " + userEntity.getIdentificacion() );
        }catch (DataAccessException e){
            throw new UserPersistenceException(e);
        }

        return userPersinstenceMapper.toUser(userEntity);
    }
}
