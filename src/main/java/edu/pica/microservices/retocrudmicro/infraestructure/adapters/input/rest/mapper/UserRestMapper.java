package edu.pica.microservices.retocrudmicro.infraestructure.adapters.input.rest.mapper;

import edu.pica.microservices.retocrudmicro.domain.model.User;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.input.rest.data.request.UserRequest;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.input.rest.data.response.UserResponse;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper
public interface UserRestMapper {

    User toUser(UserRequest userRequest);
    UserResponse toUserResponse(User user);

    List<UserResponse> toUserResponses(List<User> users);

}
