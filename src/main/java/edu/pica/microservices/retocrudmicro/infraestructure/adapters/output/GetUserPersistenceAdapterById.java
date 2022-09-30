package edu.pica.microservices.retocrudmicro.infraestructure.adapters.output;

import edu.pica.microservices.retocrudmicro.application.port.GetUserOutputPortById;
import edu.pica.microservices.retocrudmicro.domain.model.User;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.entity.UserEntity;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.mapper.UserPersinstenceMapper;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import java.util.Optional;

@RequiredArgsConstructor
public class GetUserPersistenceAdapterById implements GetUserOutputPortById {

    private final UserRepository userRepository;
    private final UserPersinstenceMapper userPersinstenceMapper;


    @Override
    public Optional<User> getUserById(Long id) {
       Optional<UserEntity>  userEntity = userRepository.findById(id);
        if (userEntity.isEmpty()){
            return Optional.empty();
        }
       User user = userPersinstenceMapper.toUser(userEntity.get());
        return Optional.of(user);
    }
}
