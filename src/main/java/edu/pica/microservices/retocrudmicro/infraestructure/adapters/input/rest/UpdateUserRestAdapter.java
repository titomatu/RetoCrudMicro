package edu.pica.microservices.retocrudmicro.infraestructure.adapters.input.rest;

import edu.pica.microservices.retocrudmicro.application.useCase.UpdateUserUseCase;
import edu.pica.microservices.retocrudmicro.domain.model.User;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.input.rest.data.request.UserRequest;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.input.rest.data.response.UserResponse;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.input.rest.mapper.UserRestMapper;
import lombok.AllArgsConstructor;
import org.mapstruct.control.MappingControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UpdateUserRestAdapter {

    private final UpdateUserUseCase updateUserUseCase;
    private final UserRestMapper userRestMapper;
    @PutMapping(value = "/")
    public ResponseEntity<UserResponse>  updateUser(@RequestBody @Valid UserRequest userRequest){
        User user = userRestMapper.toUser(userRequest);
        user = updateUserUseCase.updateUser(user);
        return new ResponseEntity<>(userRestMapper.toUserResponse(user), HttpStatus.ACCEPTED);
    }

}
