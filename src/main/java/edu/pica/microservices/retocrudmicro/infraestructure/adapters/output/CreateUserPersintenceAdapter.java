package edu.pica.microservices.retocrudmicro.infraestructure.adapters.output;
import edu.pica.microservices.retocrudmicro.application.port.CreateUserOutputPort;
import edu.pica.microservices.retocrudmicro.domain.model.User;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.entity.UserEntity;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.mapper.UserPersinstenceMapper;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateUserPersintenceAdapter implements CreateUserOutputPort {

    private final UserRepository userRepository;
    private final UserPersinstenceMapper userPersinstenceMapper;


    @Override
    public User createUser(User user) {
        UserEntity userEntity = userPersinstenceMapper.toUserEntity(user);
        userEntity = userRepository.save(userEntity);
        return userPersinstenceMapper.toUser(userEntity);
    }
}
