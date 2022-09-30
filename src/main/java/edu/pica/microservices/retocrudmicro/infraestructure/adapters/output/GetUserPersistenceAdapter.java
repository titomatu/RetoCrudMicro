package edu.pica.microservices.retocrudmicro.infraestructure.adapters.output;

import edu.pica.microservices.retocrudmicro.application.port.GetUserOutputPort;
import edu.pica.microservices.retocrudmicro.domain.model.User;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.entity.UserEntity;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.mapper.UserPersinstenceMapper;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GetUserPersistenceAdapter implements GetUserOutputPort {

    private final UserRepository userRepository;
    private final UserPersinstenceMapper userPersinstenceMapper;

    @Override
    public List<User> getUser() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<User> users = userPersinstenceMapper.toUsers(userEntities);
        return users;
    }
}
