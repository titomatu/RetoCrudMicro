package edu.pica.microservices.retocrudmicro.infraestructure.adapters.input.rest;

import edu.pica.microservices.retocrudmicro.application.useCase.CreateUserUseCase;
import edu.pica.microservices.retocrudmicro.domain.model.User;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.input.rest.data.request.UserRequest;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.input.rest.data.response.UserResponse;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.input.rest.mapper.UserRestMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@Slf4j
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class CreateUserRestAdapter {

    private final CreateUserUseCase createUserUseCase;
    private final UserRestMapper userRestMapper;

    @PostMapping(value = "/")
    public ResponseEntity<UserResponse>  createUser(@Valid @RequestBody UserRequest userRequest){
        log.info("Información de Invocación del Servicio de Creacion  Usuario" );
        User user = userRestMapper.toUser(userRequest);
        user = createUserUseCase.createUser(user);
        return new ResponseEntity<>(userRestMapper.toUserResponse(user), HttpStatus.CREATED);
    }
}
