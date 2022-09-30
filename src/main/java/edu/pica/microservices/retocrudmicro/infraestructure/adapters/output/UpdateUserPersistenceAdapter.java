package edu.pica.microservices.retocrudmicro.infraestructure.adapters.output;

import edu.pica.microservices.retocrudmicro.application.port.UpdateUserOutputPort;
import edu.pica.microservices.retocrudmicro.domain.model.User;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.entity.UserEntity;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.mapper.UserPersinstenceMapper;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.repository.UserRepository;
import edu.pica.microservices.retocrudmicro.infraestructure.exception.UserPersistenceErrorException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;

@RequiredArgsConstructor
public class UpdateUserPersistenceAdapter implements UpdateUserOutputPort {

    private final UserRepository userRepository;
    private final UserPersinstenceMapper userPersinstenceMapper;

    @Override
    public User updateUser(User user) {
        UserEntity userEntity = new UserEntity();
        try{
        userPersinstenceMapper.toUserEntity(user);
        userEntity = userRepository.save(userEntity);
        }catch (DataAccessException e){
        throw new UserPersistenceErrorException(e);
        }
        return userPersinstenceMapper.toUser(userEntity);
    }
}
