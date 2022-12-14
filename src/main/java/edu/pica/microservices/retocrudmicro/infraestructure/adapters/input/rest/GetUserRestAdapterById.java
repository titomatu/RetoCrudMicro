package edu.pica.microservices.retocrudmicro.infraestructure.adapters.input.rest;

import edu.pica.microservices.retocrudmicro.application.useCase.GetUserUseCaseById;
import edu.pica.microservices.retocrudmicro.domain.model.User;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.input.rest.data.response.UserResponse;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.input.rest.mapper.UserRestMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@Slf4j
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class GetUserRestAdapterById {

    private final GetUserUseCaseById getUserUseCaseById;
    private final UserRestMapper userRestMapper;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable @Valid Long id){
        log.info("Información de Invocación del Servicio de Obtención de  Usuario por Id" );
        User user = getUserUseCaseById.getUserById(id);
        return new ResponseEntity<>(userRestMapper.toUserResponse(user), HttpStatus.OK);
    }

}
