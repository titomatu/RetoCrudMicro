package edu.pica.microservices.retocrudmicro.infraestructure.adapters.output;

import edu.pica.microservices.retocrudmicro.application.port.UpdateUserOutputPort;
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
public class UpdateUserPersistenceAdapter implements UpdateUserOutputPort {

    private final UserRepository userRepository;
    private final UserPersinstenceMapper userPersinstenceMapper;

    @Override
    public User updateUser(User user) {
        UserEntity userEntity = new UserEntity();
        try{
        userEntity = userPersinstenceMapper.toUserEntity(user);
        userEntity = userRepository.save(userEntity);
        log.info(" Usuario  Actualizado: "+ userEntity.getId()  + " Con Identificación: " + userEntity.getIdentificacion() );
        log.debug("Persistencia de Información :"+ userEntity.getId()  + " Con Identificación: " + userEntity.getIdentificacion() );
        }catch (DataAccessException e){
        throw new UserPersistenceException(e);
        }
        return userPersinstenceMapper.toUser(userEntity);
    }
}
