package edu.pica.microservices.retocrudmicro.infraestructure.adapters.output;

import edu.pica.microservices.retocrudmicro.application.port.GetUserOutputPortById;
import edu.pica.microservices.retocrudmicro.domain.model.User;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.entity.UserEntity;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.mapper.UserPersinstenceMapper;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.repository.UserRepository;
import edu.pica.microservices.retocrudmicro.infraestructure.exception.UserPersistenceErrorException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;

import java.util.Optional;

@RequiredArgsConstructor
public class GetUserPersistenceAdapterById implements GetUserOutputPortById {

    private final UserRepository userRepository;
    private final UserPersinstenceMapper userPersinstenceMapper;


    @Override
    public Optional<User> getUserById(Long id) {
        User user = new User();
       try{
           Optional<UserEntity>  userEntity = userRepository.findById(id);
           if (userEntity.isEmpty()){
               return Optional.empty();
           }
           user  = userPersinstenceMapper.toUser(userEntity.get());
       }catch (DataAccessException e){
           throw new UserPersistenceErrorException(e);
       }
        return Optional.of(user);
    }
}
