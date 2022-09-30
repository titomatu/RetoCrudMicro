package edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.mapper;

import edu.pica.microservices.retocrudmicro.domain.model.User;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserPersinstenceMapper {
    UserEntity toUserEntity(User user);
    User toUser(UserEntity userEntity);
    List<User> toUsers(List<UserEntity> userEntities);
}
